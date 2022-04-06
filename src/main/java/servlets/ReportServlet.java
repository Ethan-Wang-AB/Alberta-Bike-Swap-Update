/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import services.AccountService;
import services.ReportService;

/**
 *
 * @author 845593
 */
public class ReportServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String path = getServletContext().getRealPath("/WEB-INF");
           // System.out.println(path);
//                 
            String filename = path + "\\report" + ".xlsx";
            //System.out.println(filename);
            File file = new File(filename);
            if (!file.exists()) {
                file.createNewFile();
            }
            OutputStream out = new FileOutputStream(file);
            ReportService reportService = new ReportService();
            List<String[]> data = reportService.userReport();
            System.out.println(data.size());
            System.out.println(data.get(0)[0]);
            System.out.println(data.get(1)[0]);
            System.out.println(data.get(2)[0]);
            try {
                XSSFWorkbook workbook = new XSSFWorkbook();
                XSSFSheet sheet = workbook.createSheet();
                for (int i = 0; i < data.size(); i++) {
                    XSSFRow excelRow = sheet.createRow(i);
                    String[] dbRow = data.get(i);
                    for (int j = 0; j < dbRow.length; j++) {
                        XSSFCell cell = excelRow.createCell(j);
                        cell.setCellValue(dbRow[j]);

                    }
                }
                ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
                workbook.write(outByteStream);
                byte[] outArray = outByteStream.toByteArray();

                response.setContentType("application/vnd.ms-excel");
                response.setContentLength(outArray.length);
                response.setHeader("Content-Disposition", "attachment; filename=\""
                        + filename + "\"");

                OutputStream outStream = response.getOutputStream();
                outStream.write(outArray);

                outStream.flush();
                outStream.close();

            } catch (IOException ignore) {
                ignore.printStackTrace();
            } catch (Exception ex) {
                Logger.getLogger(ReportServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
     
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
