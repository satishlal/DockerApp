package com.java;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.dao.InsertDataDao;

@WebServlet("/InsertData")
public class InsertData extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    PrintWriter out = response.getWriter();
		    
		    String studentName =  request.getParameter("studentName");
		    String className =  request.getParameter("className");
		    String fees =  request.getParameter("fees");
		    String fatherName =  request.getParameter("fatherName");
		    InsertDataDao indt = new InsertDataDao();
		    boolean check = indt.insertData(studentName,className,fees,fatherName);
		    if(check){
		    	response.sendRedirect("jsp/dataRetrive.jsp");
		    }else{
		    	out.println("records are not inserted");
		    }
		    
	}

}
