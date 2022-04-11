/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import services.SystemService;

/**
 *
 * @author 845593
 */
@MultipartConfig
public class TestRestore extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SystemService system = new SystemService();
        Boolean restore = system.restore();
        HttpSession session = request.getSession();
        if (restore) {
            session.setAttribute("restoreMessage", "restore is successful");

        } else {
            session.setAttribute("restoreMessage", "restore is unsuccessful");
        }
        response.sendRedirect("admin");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SystemService system = new SystemService();
        Part part = request.getPart("restore");
        String path = getServletContext().getRealPath("WEB-INF/backup/backup.sql");
        System.out.println(path);
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        } else {
            file.delete();
            file.createNewFile();
        }
        InputStream input = part.getInputStream();
        // PrintWriter print = new PrintWriter(file);
        OutputStream output = new FileOutputStream(file);
        byte[] bytes = new byte[input.available()];
        int read = 0;
        while ((read = input.read(bytes)) != -1) {
            output.write(bytes, 0, read);
        }

        system.restore(file);

        //system.restore(file);
    }

}
