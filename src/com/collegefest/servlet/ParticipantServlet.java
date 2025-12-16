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

        if (name == null || year == null || event == null) {
            response.sendRedirect("participants.html");
            return;
        }

        if (name.isEmpty() || year.isEmpty() || event.isEmpty()) {
            response.sendRedirect("participants.html");
            return;
        }

        participants.add(name + " | " + year + " | " + event);
        response.sendRedirect("participants.html");
    }
}

