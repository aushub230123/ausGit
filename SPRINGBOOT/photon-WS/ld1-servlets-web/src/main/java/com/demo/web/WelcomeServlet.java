package com.demo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// WEB COMPONENT
// NOT POJO BASED
public class WelcomeServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest reqest, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String htmlOutputString = "<!DOCTYPE html>";
		htmlOutputString += "<html><head><title>Welcome to the Web</title></head>";
		htmlOutputString += "<body><h1>Traditional Web to Spring Web & Spring Boot in future.......</h1>";
		htmlOutputString += "<h1 style='color:red;font-weight: bold;'>";
		htmlOutputString += "Search Screen : Ensures developer productivity!</h1>";
		htmlOutputString += "Enter text to Search :  <input type'text' value=''/>";
		htmlOutputString += "<input type='submit' value='Search'></body></html>";
		out.print(htmlOutputString);

	}
}
