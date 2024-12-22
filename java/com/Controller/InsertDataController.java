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
@WebServlet("/insertData")
public class InsertDataController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String dept=request.getParameter("dept");
		ModelObject m1=new ModelObject();
		m1.setId(id);
		m1.setName(name);
		m1.setDept(dept);
		StudentDAO s1=new StudentDAO();
		int x=s1.insert(m1);
		PrintWriter out=response.getWriter();
		out.println(x+" rows has been inserted");
	}
    
}
