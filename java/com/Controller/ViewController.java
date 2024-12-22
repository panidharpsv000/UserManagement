package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DAO.StudentDAO;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/view")
public class ViewController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		 response.setContentType("text/html");
		int option=Integer.parseInt(request.getParameter("option"));
		StudentDAO s1=new StudentDAO();
		PrintWriter out=response.getWriter();
		try {
			ResultSet rs=s1.getTableView(option);
			while(rs.next())
			{
				out.println("ID="+rs.getInt("id")+" Name="+rs.getString("name")+" Department="+rs.getString("dept"));
				out.println("<html>");
				out.println("<body>");
				out.println("<br>");
				out.println("<br>");
				out.println("</body>");
				out.println("</html>");
			}
		} catch (SQLException e) {}
	}

}
