package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.DAO.StudentDAO;
import com.ModelObject.ModelObject;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/deleteRow")
public class DeleteRowController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException  {
	    int id=Integer.parseInt(request.getParameter("id"));
	    ModelObject m1=new ModelObject();
	    m1.setId(id);
	    StudentDAO s1=new StudentDAO();
	    int deletedRows=s1.delete(m1);
	    PrintWriter out=response.getWriter();
	    out.println(deletedRows+" rows has been deleted");
	}
 
}
