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
import javax.servlet.http.HttpSession;
import models.AccountService;
 

public class LoginServlet extends HttpServlet {
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        
        String user = (String)session.getAttribute("username");
        String logout = request.getParameter("logout");
        
        if(logout != null){
            request.setAttribute("message", "You have successful logged out.");
            session.invalidate();
            
           // session = request.getSession();
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
               .forward(request, response);
        }
        
        else if(user != null){
            response.sendRedirect("home");
        }
        
        else{
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
               .forward(request, response);
        }

    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        AccountService user = new AccountService(username, password);

              
        if (username.equals(null) || username == "" || password.equals(null) || password == "") {
            
            request.setAttribute("message", "Password/Username cannot be empty");
            
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(request, response);
        }
        
        else if(user.login(username, password) != null){
            request.setAttribute("message", "You have successfully logged in.");
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            response.sendRedirect("home");
        }
        
        else{
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            request.setAttribute("message", "Failed Authentication");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);

        }
    }
}
