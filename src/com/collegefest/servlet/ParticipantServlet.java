package com.collegefest.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;

public class ParticipantServlet extends HttpServlet {
    
    private static ArrayList<String> participants = new ArrayList<>();
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String name = request.getParameter("name");
        String year = request.getParameter("year");
        String event = request.getParameter("event");
        
        // Null check
        if (name == null || year == null || event == null) {
            response.sendRedirect("participants.html?error=1");
            return;
        }
        
        // Empty check with trim()
        if (name.trim().isEmpty() || year.trim().isEmpty() || event.trim().isEmpty()) {
            response.sendRedirect("participants.html?error=1");
            return;
        }
        
        // Add participant
        participants.add(name + " | " + year + " | " + event);
        response.sendRedirect("participants.html?success=1");
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("<h3>Total Participants: " + participants.size() + "</h3>");
        for (String participant : participants) {
            response.getWriter().println("<p>" + participant + "</p>");
        }
    }
}
