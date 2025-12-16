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

        if (name == null || department == null) {
            response.sendRedirect("volunteers.html");
            return;
        }

        if (name.isEmpty() || department.isEmpty()) {
            response.sendRedirect("volunteers.html");
            return;
        }

        volunteers.add(name + " | " + department);
        response.sendRedirect("volunteers.html");
    }
}

