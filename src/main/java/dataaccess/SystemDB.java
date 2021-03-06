/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.io.FileInputStream;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.io.FileOutputStream;
import java.io.*;

/**
 *
 * @author 845593
 */
public class SystemDB {

    private final static SystemDB systemDB = new SystemDB();
    //database name
    private final String DATABASE_NAME = "absdb";
    //path and file name of the back up address, for windows it has a default path and only name needed.
    private final String PATH = "c:/temp/absRestore.sql";
    private final String SERVERPATH="C:/Program Files/MySQL/MySQL Server 5.7/bin/mysqldump";
    private final String SERVERPATHRESTORE="C:/Program Files/MySQL/MySQL Server 5.7/bin";
    //private final String BATCH="C:\\Program Files\\MySQL\\MySQL Workbench 8.0 CE\\backup.bat";
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

        System.out.println("start backup");
        try {
            
            ProcessBuilder pb=new ProcessBuilder();
            Process p=Runtime.getRuntime().exec(
             SERVERPATH+ " -u"+USERNAME+ " -p"+PASSWORD+ " absdb -r"+PATH
            );

      BufferedReader reader =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
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
        try {
            System.out.println("restore start");

        File files=new File("c:/temp/restore.bat");//("/WEB-INF/backup/restore.bat");//
        files.createNewFile();
        PrintWriter p=new PrintWriter(files);
        p.write("cd "+SERVERPATHRESTORE);
        p.write("\n");
        p.write("mysql -u"+USERNAME+" -p"+PASSWORD+" "+DATABASE_NAME+"<"+file.getAbsolutePath());
        p.flush();
        p.close();
        Runtime.getRuntime().exec("cmd /c start "+files.getAbsolutePath());
        System.out.println("run restore finished");
        
     

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("restore problem");
            return false;
        }

    }

    /**
     * Sets up a scheduler / trigger in MySql to see if it works Trade_table and event_date table would be archived every five year. If user and bike also need to be archived, a last_login attribute and a up-to-date deal time would be as attributes DROP EVENT IF EXISTS `archiveEvent`; delimiter $$ CREATE EVENT `archiveEvent` ON SCHEDULE EVERY 5 YEAR STARTS '2022-03-02 00:00:00' ON COMPLETION PRESERVE ENABLE DO
     * @return boolean
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
