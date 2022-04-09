/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author viny kaur
 */
public class AgeCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
        return;
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userAge = request.getParameter("user");
        
        boolean isNumber;
        int age = 0;
        String message = "";
        
        try{
           age = Integer.parseInt(userAge);
           isNumber = true;
        }catch (NumberFormatException e) {
            isNumber = false;
        }

        if(userAge.equals("")){
            message = "You must give your current age.";
        }
        else if(!isNumber){
            message = "You must enter a number.";
        }
        else if (age < 0){
            message = "Age must not be a negative.";
        }
        else{
            age++;
            message = "Your age next birthday will be " + age;
        }

        request.getSession().setAttribute("message", message);
        
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
        return;
        
    }

}
