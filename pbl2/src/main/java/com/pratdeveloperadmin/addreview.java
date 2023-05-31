package com.pratdeveloperadmin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addreview")
public class addreview extends HttpServlet {
	private final static String query = "insert into reviews (mName,mUname,mReview) values(?,?,?)";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		get  PrintWritter
		PrintWriter pw =res.getWriter();
		// Set Content Type
		res.setContentType("text/html");
		// get the Values
		String mName = req.getParameter("mName");
		String mUname = req.getParameter("mUname");
		String mReview = req.getParameter("mReview");
		

		Connection con=null;
		try {
			   Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","12680");
			

		     PreparedStatement ps=con.prepareStatement(query);
		     
//		     Set the values 
		     ps.setString(1, mName);
		     ps.setString(2, mUname);
		     ps.setString(3, mReview);
		    

//		     Execute the query 
		     int count = ps.executeUpdate();
		     
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
}
}	
