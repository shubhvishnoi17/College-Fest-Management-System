package com.collegefest.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;

public class VolunteerServlet extends HttpServlet {
    
    private static ArrayList<String> volunteers = new ArrayList<>();
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String name = request.getParameter("name");
        String department = request.getParameter("department");
        
        // Null check
        if (name == null || department == null) {
            response.sendRedirect("volunteers.html?error=1");
            return;
        }
        
        // Empty check with trim()
        if (name.trim().isEmpty() || department.trim().isEmpty()) {
            response.sendRedirect("volunteers.html?error=1");
            return;
        }
        
        // Add volunteer
        volunteers.add(name + " | " + department);
        response.sendRedirect("volunteers.html?success=1");
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("<h3>Total Volunteers: " + volunteers.size() + "</h3>");
        for (String volunteer : volunteers) {
            response.getWriter().println("<p>" + volunteer + "</p>");
        }
    }
}
