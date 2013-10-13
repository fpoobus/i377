package com.homework.hw3;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.homework.hw3.hsql.DbAccess;


public class AdminServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("do") != null) {
    		if(request.getParameter("do").equals("clear_data")) {
    				try {
						DbAccess db = new DbAccess();
						db.clearTable();
					} catch (SQLException ignored) {
					}
    		}
    	}
		if(request.getParameter("do") != null) {
    		if(request.getParameter("do").equals("insert_data")) {
    				DbAccess db = new DbAccess();
    				db.insertDummyData();
    		}
    	}
		
		response.sendRedirect("Search");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
