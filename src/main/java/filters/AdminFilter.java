/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.AccountService;

/**
 *
 * @author 845593
 */
public class AdminFilter implements Filter {
    
    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;
    
    public AdminFilter() {
    }    
    
  
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain){
 try {
          //  System.out.println("Start admin filter");
            HttpSession session=((HttpServletRequest)request).getSession();
            
            String email=(String) session.getAttribute("email");
            AccountService accountService=AccountService.getInstance();
            if (email!=null && !email.trim().equals("") && accountService.getByEmail(email).getRoleId().getRoleId()==1) {
                           chain.doFilter(request,response);

                
                return;
            }else {
                ((HttpServletResponse)response).sendRedirect("Welcome");
                return;
            }
        } catch (Exception ex) {
                       Logger.getLogger(AdminFilter.class.getName()).log(Level.SEVERE, null, ex);

        }        
   
    }


    
    public void log(String msg) {
        filterConfig.getServletContext().log(msg);        
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
    
}
