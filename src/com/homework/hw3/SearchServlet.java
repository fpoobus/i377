/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homework.hw3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.homework.hw3.hsql.DbAccess;
import com.homework.hw3.hsql.DbItem;
import com.homework.hw3.hsql.DbItemlist;

public class SearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	if(request.getParameter("do") != null) {
    		if(request.getParameter("do").equals("delete")) {
    			if(request.getParameter("id") != null) {
    				String id = request.getParameter("id");
    				DbAccess db = new DbAccess();
    				db.deleteItem(id);
    			}
    		}
    	}
    	if(request.getParameter("searchString") != null) {
    		//Return ArrayList containing items of DbItem type
    		String key = (String) request.getParameter("searchString");
    		DbItemlist list = new DbItemlist();
    		request.setAttribute("itemlist", list.getLike(key));
    	}
    	else {
    		//Return ArrayList containing items of DbItem type
    		DbItemlist list = new DbItemlist();
    		request.setAttribute("itemlist", list.getAllItems());
    	}
    	
    	request.getRequestDispatcher("WEB-INF/JSP/hw3/Search.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }
}
