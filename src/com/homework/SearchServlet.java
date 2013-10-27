/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homework;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.homework.model.DbAccess;
import com.homework.model.DbItem;

public class SearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	if(request.getParameter("do") != null) {
    		if(request.getParameter("do").equals("delete")) {
    			if(request.getParameter("id") != null) {
    				String id = request.getParameter("id");
    				DbAccess.delete(Long.valueOf(id));
    			}
    		}
    	}
    	if(request.getParameter("searchString") != null) {
    		//Return ArrayList containing items of DbItem type
    		String key = (String) request.getParameter("searchString");
    		request.setAttribute("itemlist", DbAccess.getByLike(key));
    	}
    	else {
    		//Return ArrayList containing items of DbItem type
    		//DbItemlist list = new DbItemlist();
    		request.setAttribute("itemlist", DbAccess.getAll());
    	}
    	
    	request.getRequestDispatcher("WEB-INF/JSP/hw3/Search.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }
}
