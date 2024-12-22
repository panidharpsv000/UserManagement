package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.DAO.StudentDAO;
import com.ModelObject.ModelObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/updateTable")
public class UpdateTableController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
		 int id=Integer.parseInt(request.getParameter("id"));
		 int newId=Integer.parseInt(request.getParameter("newId"));
		 String newName=request.getParameter("newName");
		 String newDept=request.getParameter("newDept");
		 ModelObject m1=new ModelObject();
		 m1.setId(newId);
		 m1.setDept(newDept);
		 m1.setName(newName);
		 StudentDAO s1=new StudentDAO();
		 PrintWriter out=response.getWriter();
		 out.println(s1.updateTable(id,m1)+" Has Been Updated");
	}

}
