package com.collegefest.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

public class CollegeFestServlet extends HttpServlet {

    private static ArrayList<String> events = new ArrayList<>();
    private static ArrayList<String> participants = new ArrayList<>();
    private static ArrayList<String> volunteers = new ArrayList<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action == null) {
            response.sendRedirect("index.html");
            return;
        }

        switch (action) {

            case "addEvent":
                addEvent(request, response);
                break;

            case "addParticipant":
                addParticipant(request, response);
                break;

            case "addVolunteer":
                addVolunteer(request, response);
                break;

            default:
                response.sendRedirect("index.html");
        }
    }

    private void addEvent(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String name = request.getParameter("eventName");
        String venue = request.getParameter("venue");
        String date = request.getParameter("date");

        if (name == null || venue == null || date == null ||
                name.isEmpty() || venue.isEmpty() || date.isEmpty()) {
            response.sendRedirect("events.html?error=1");
            return;
        }

        for (String e : events) {
            if (e.toLowerCase().startsWith(name.toLowerCase() + " |")) {
                response.sendRedirect("events.html?duplicate=1");
                return;
            }
        }

        events.add(name + " | " + venue + " | " + date);
        response.sendRedirect("events.html?success=1");
    }

    private void addParticipant(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String name = request.getParameter("name");
        String year = request.getParameter("year");
        String event = request.getParameter("event");

        if (name == null || year == null || event == null ||
                name.isEmpty() || year.isEmpty() || event.isEmpty()) {
            response.sendRedirect("participants.html?error=1");
            return;
        }

        boolean eventFound = false;
        for (String e : events) {
            if (e.toLowerCase().startsWith(event.toLowerCase() + " |")) {
                eventFound = true;
                break;
            }
        }

        if (!eventFound) {
            response.sendRedirect("participants.html?invalidEvent=1");
            return;
        }

        participants.add(name + " | " + year + " | " + event);
        response.sendRedirect("participants.html?success=1");
    }

    private void addVolunteer(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String name = request.getParameter("name");
        String dept = request.getParameter("department");

        if (name == null || dept == null ||
                name.isEmpty() || dept.isEmpty()) {
            response.sendRedirect("volunteers.html?error=1");
            return;
        }

        volunteers.add(name + " | " + dept);
        response.sendRedirect("volunteers.html?success=1");
    }
}

