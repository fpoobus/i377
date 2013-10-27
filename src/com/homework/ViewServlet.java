package com.homework;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.homework.model.DbAccess;
import com.homework.model.DbItem;

public class ViewServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		List<DbItem> list = DbAccess.getById(Long.valueOf(id));
		request.setAttribute("itemlist", list);
		
		//Get parent if any
		if(list.size() == 1) {
			request.setAttribute("parentlist", DbAccess.getById(list.get(0).getSuperior()));
		}
		
		//Get children if any
		List<DbItem> children = DbAccess.getChildren(Long.valueOf(id));
		request.setAttribute("childlist", children);
		
		request.getRequestDispatcher("WEB-INF/JSP/hw3/View.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
