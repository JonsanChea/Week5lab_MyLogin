/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.AccountService;


/**
 *
 * @author Jonat
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        User existingUser = (User) session.getAttribute("existingUser");
        String logout = request.getParameter("logout");
        
        if(logout != null){
            session.invalidate();
            request.setAttribute("message", "you have logged out");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        
        } else {
            if (existingUser != null){
                request.setAttribute("username", existingUser);
                response.sendRedirect("home");
               
            }
             getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
             
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       HttpSession session = request.getSession();
       
       String username = request.getParameter("username");
       String password= request.getParameter("password");
       
      
       User user = new User(username, password);
       
       AccountService accountService = new AccountService();
      
       
        
        if(accountService.login(username, password) == null){
          request.setAttribute("message", "invalid username or password"); 
          getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
          return;
        }
          else{
            session.setAttribute("username", user);
            response.sendRedirect("home");
            return;
           
       }
        
        
       
       
        
    }
}
