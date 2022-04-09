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
public class ArithmeticCalculator extends HttpServlet {

    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
          String message = "---";
       request.setAttribute("message", message);
       getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
        return;
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fValue = request.getParameter("first");
        String sValue = request.getParameter("second");
        int firstValue = 0;
        int secondValue = 0;
        String message = "";
        
        try{
        firstValue = Integer.parseInt(fValue);
        secondValue = Integer.parseInt(sValue);
        }catch(NumberFormatException e){
            message = "invalid";
        }
        request.setAttribute("firstValue", firstValue);
        request.setAttribute("secondValue", secondValue);

        if(!message.equals("invalid")){
            if(request.getParameter("operation").equals("+")){
                int add = firstValue + secondValue;
                message = Integer.toString(add);
            }
            else if(request.getParameter("operation").equals("-"))
            {
                int sub = firstValue - secondValue;
                message = Integer.toString(sub);
            }
            else if(request.getParameter("operation").equals("*"))
            {
                int mul = firstValue * secondValue;
                message = Integer.toString(mul);
            }
            else if(request.getParameter("operation").equals("%"))
            {
                int mod = firstValue % secondValue;
                message = Integer.toString(mod);
            }
        }
        
        
        request.setAttribute("message", message);
        
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
        return;
    }
    }


