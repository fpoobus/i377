/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homework.hw2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ets
 */
public class SessionCount extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("Total sessions: "+SessionHandler.ACTIVE_SESSION_COUNT);
        
    }

}
