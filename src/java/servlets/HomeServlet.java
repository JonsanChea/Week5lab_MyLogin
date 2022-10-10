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

/**
 *
 * @author Jonat
 */
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
         
         HttpSession session = request.getSession();
         User user = (User) session.getAttribute("username");
        
         if(user != null){
             //
             session.getAttribute("username");
             //request.setAttribute("username", user);
            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
         } else {
             getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
         }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}
