package com.collegefest.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;

public class EventServlet extends HttpServlet {
    
    private static ArrayList<String> events = new ArrayList<>();
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String eventName = request.getParameter("eventName");
        String venue = request.getParameter("venue");
        String date = request.getParameter("date");
        
        // Null check
        if (eventName == null || venue == null || date == null) {
            response.sendRedirect("events.html?error=1");
            return;
        }
        
        // Empty check
        if (eventName.trim().isEmpty() || venue.trim().isEmpty() || date.trim().isEmpty()) {
            response.sendRedirect("events.html?error=1");
            return;
        }
        
        // Duplicate check
        for (String event : events) {
            if (event.toLowerCase().startsWith(eventName.toLowerCase() + " |")) {
                response.sendRedirect("events.html?duplicate=1");
                return;
            }
        }
        
        // Add event
        events.add(eventName + " | " + venue + " | " + date);
        response.sendRedirect("events.html?success=1");
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("<h3>Total Events: " + events.size() + "</h3>");
        for (String event : events) {
            response.getWriter().println("<p>" + event + "</p>");
        }
    }
}
