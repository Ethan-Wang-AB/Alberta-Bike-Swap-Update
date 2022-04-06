/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.BikeDB;
import dataaccess.TradeDB;
import dataaccess.UserDB;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import models.Event;
import models.User;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author 845593
 */
public class ReportService{

private UserDB userDB=UserDB.getInstance();
private BikeDB bikeDB=BikeDB.getInstance();
private TradeDB tradeDB=TradeDB.getInstance();
    

  public final List<String[]> bikeReport()
    {
		return null;
        
    }    
    
    
    public final List<String[]> tradeReport()
    {
		return null;
        
    }    
    
    
    public final List<String[]> userReport()
    {
                AccountService accountService=AccountService.getInstance();
		List<User> users=accountService.getAllUserExceptAdmin();
                List<String[]> data = new ArrayList<>();
                String row[]=new String[]{"#","Email","Name","Role","Diet"};
                data.add(row);
                
                for(int i=0;i<users.size();i++){
                    row=new String[5];
                    row[0]=i+1+"";
                    row[1]=users.get(i).getEmail();
                    row[2]=users.get(i).getName();
                    row[3]=users.get(i).getRoleId().getRoleName();
                    row[4]=users.get(i).getDietId().getDietDes();
                    data.add(row);
                   
                }

                return data;
    }  
}
