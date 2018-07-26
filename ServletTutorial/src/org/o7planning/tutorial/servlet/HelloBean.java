package org.o7planning.tutorial.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloBean
 */

public class HelloBean {
	private String name;
	 
	  // Class is required default constructor.
	   public HelloBean() {
	   }
	 
	   public String getName() {
	       return name;
	   }
	 
	   public void setName(String name) {
	       this.name = name;
	   }
	 
	   public String getHello() {
	       if (name == null) {
	           return "Hello every body";
	       }
	       return "Hello " + name;
	   }
}
