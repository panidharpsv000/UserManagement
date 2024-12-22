package com.DAO;

import java.sql.*;

import com.ModelObject.ModelObject;

public class StudentDAO {
    String url="jdbc:mysql://localhost:3306/clg";
    String user="root";
    String password="301112";
    Connection con=null;
    private Connection generateCon() {
    	if(con==null)
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(url,user,password);
		} catch (Exception e) {	return null; }
    	else return con;
	}
    public int insert(ModelObject m1) 
    {
    	try {
			 Connection con=generateCon();
	    	 String query="INSERT INTO student VALUES(?,?,?)";
	    	 PreparedStatement st=con.prepareStatement(query);
	    	 st.setInt(1, m1.getId());
	    	 st.setString(2, m1.getName());
	    	 st.setString(3, m1.getDept());
	    	 int x=st.executeUpdate();
	    	 return x;
		} catch (Exception e) {
			return 0;
		}
    }
	public int delete(ModelObject m1) {
		try {
			 Connection con=generateCon();
	    	 String query="DELETE FROM student WHERE id=?";
	    	 PreparedStatement st=con.prepareStatement(query);
	    	 st.setInt(1, m1.getId());
	    	 int x=st.executeUpdate();
	    	 return x;
		} catch (Exception e) {
			return 0;
		}
	}
	public ResultSet getTableView(int option) {
		try {
			 Connection con=generateCon();
	    	 String query="SELECT * FROM student WHERE id="+option;
	    	 if(option==0)
	    	 {
	    		 query="SELECT * FROM student";
	    	 }
	    	 Statement st=con.createStatement();
	    	 ResultSet rs= st.executeQuery(query);
	    	 return rs;
		} catch (Exception e) {
			return null;
		}
	}
	public int updateTable(int id, ModelObject m1) {
		try {
			 Connection con=generateCon();
	    	 String query="UPDATE student SET ";
	    	 int f=0;
	    	 if(m1.getId()!=0)
	    	 {
	    		 query+="id="+m1.getId();
	    		 f=1;
	    	 }
	    	 if(!m1.getName().equals("0"))
	    	 {
	    		 if(f==1) query+=",";
	    		 query+=" name='"+m1.getName()+"'";
	    		 f=1;
	    	 }
	    	 if(!m1.getDept().equals("0"))
	    	 {
	    		 if(f==1) query+=",";
	    		 query+=" dept='"+m1.getDept()+"'";
	    	 }
	    	 query+=" WHERE id="+id;
	    	 Statement st=con.createStatement();
	    	 int x= st.executeUpdate(query);
	    	 return x;
		} catch (Exception e) { return 0;}
		
	}
}
