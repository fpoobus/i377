/**
 * @source http://www.mkyong.com/servlet/what-is-listener-servletcontextlistener-example/
 */
package com.homework;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.homework.model.JpaUtil;

public class AppServletContextListener implements ServletContextListener{
 
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("ServletContextListener destroyed");
		JpaUtil.closeFactory();
	}
 
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("ServletContextListener started");	
		JpaUtil.initFactory();
	}
}
