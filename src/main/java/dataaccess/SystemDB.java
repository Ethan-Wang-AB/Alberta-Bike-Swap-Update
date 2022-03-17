/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author 845593
 */
public class SystemDB {

    private final static SystemDB systemDB = new SystemDB();
    //database name
    private final String DATABASE_NAME = "ABS";
    //path and file name of the back up address, for windows it has a default path and only name needed.
    private final String PATH = "c://abs/backup/backup-";
    //use root user to backup
    private final String USERNAME = "root";
    //correct password for the root user
    private final String PASSWORD = "password";

    private SystemDB() {

        super();
    }
//    public final boolean toggleOpenStatus()
//    {
//		return false;
//        
//    }    

    public final boolean backup() throws IOException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        //EntityTransaction trans = em.getTransaction();
        String filename=PATH + new Date().toString() + ".sql";
        File file=new File("c:/temp/temp.sql");
        file.createNewFile();
        String sqlString = "\"mysql --user " + USERNAME + " --" + PASSWORD + " " + DATABASE_NAME + " < " +DATABASE_NAME + ".sql\"";
        sqlString = "mysqldump -uroot -ppassword --all-databases > c:/temp/temp01.sql";
        System.out.println("start backup");
        try {
        
        Process runtimeProcess = Runtime.getRuntime().exec(new String[] { "cmd.exe", "/c", sqlString});
        System.out.println("process backup finished");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("backup problem");
            return false;
        } finally {
            em.close();
        }

    }

    public final boolean restore(File file) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        //EntityTransaction trans = em.getTransaction();

        String sqlString = "mysqldump --user " + USERNAME + " --" + PASSWORD + " " + DATABASE_NAME + " < " + PATH + new Date().toString() + ".sql";
        try {

            em.createNativeQuery(sqlString);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("backup problem");
            return false;
        } finally {
            em.close();
        }

    }

    /**
     * Trying to setup a scheduler / kind of trigger in MySql to see if it works Trade_table and event_date table would be archived every five year. If user and bike also need to be archived, a last_login attribute and a up-to-date deal time would be as attributes DROP EVENT IF EXISTS `archiveEvent`; delimiter $$ CREATE EVENT `archiveEvent` ON SCHEDULE EVERY 5 YEAR STARTS '2022-03-02 00:00:00' ON COMPLETION PRESERVE ENABLE DO
     *
     * BEGIN INSERT INTO archivetable ( id, cs_start_time, cs_time_length ) SELECT MT.id, MT.cs_start_time, MT.cs_time_length FROM maintable MT WHERE MT.cs_start_time + INTERVAL MT.cs_time_length SECOND < NOW() ; * DELETE FROM maintable WHERE cs_start_time + INTERVAL cs_time_length SECOND < NOW() ; END$$
     *
     * delimiter ; @return
     */
    public final boolean archiveData() {

        EntityManager em = DBUtil.getEmFactory().createEntityManager();
         EntityTransaction trans=em.getTransaction();
        String maintable = "";  //table to be archived
        String attributes = "";//attributes of the table to be archived
        String timestamp = "";//time of creation
        String archive_table = "";//archive table

        String insert = "INSERT INTO message_archives (" + attributes + ")\n"
                + "SELECT " + attributes + " \n"
                + "FROM " + archive_table + ";\n"
                + "WHERE " + timestamp + " < DATE_SUB(curdate(), INTERVAL 5 YEAR)";
        String delete = "DELETE FROM " + maintable + " WHERE" + timestamp + " < DATE_SUB(curdate(), INTERVAL 5 YEAR);";
        try {
        
            trans.begin();
            em.createNativeQuery(insert);
            em.createNativeQuery(delete);
            maintable = "";
            attributes = "";
            timestamp = "";
            archive_table = "";
            em.createNativeQuery(insert);
            em.createNativeQuery(delete);
            maintable = "";
            attributes = "";
            timestamp = "";
            archive_table = "";
            em.createNativeQuery(insert);
            em.createNativeQuery(delete);
            trans.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("archive problem");
            trans.rollback();
            return false;
        } finally {
            em.close();
            
        }

        

    }

    public static SystemDB getInstance() {
        return systemDB;

    }

}
