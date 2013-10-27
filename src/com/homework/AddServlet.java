/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homework;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.homework.model.DbItem;
import com.homework.model.DbAccess;

public class AddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setAttribute("itemlist", DbAccess.getAll());
    	request.getRequestDispatcher("WEB-INF/JSP/hw3/Add.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	DbItem item = new DbItem();
    	
		String name = request.getParameter("name");
		String code = request.getParameter("code");
		String superior_code = request.getParameter("superUnitCode");
		
		List<DbItem> list = DbAccess.getByCode(superior_code);
		if(list.size() > 0) {
			item.setSuperior(list.get(0).getId());
		}
		
		item.setName(name);
		item.setCode(code);
		
		DbAccess.save(item);
    	
        response.sendRedirect("Search");
    }

}
