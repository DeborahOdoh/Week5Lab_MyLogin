/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                    //request.setAttribute("result", "");

        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
                String userName = request.getParameter("username");
                String password = request.getParameter("password");
                String user1 = "abe";
                String user2 = "barb";

                request.setAttribute("username", userName);
                request.setAttribute("password", password);

        
              
        if (!(userName.equals(user1) || userName.equals(user2))) {
            request.setAttribute("result", "Failed authentication");
            
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(request, response);
            return;
        }
        
        
        request.setAttribute("result", "");
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(request, response);
        
       
    }
}
