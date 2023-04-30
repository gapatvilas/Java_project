package login;
import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
	

/**
 * Servlet implementation class RegServlet
 */
public class RegServlet extends HttpServlet {
	Connection con;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","gapat");
	
		}catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
			
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		try {
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
	
		String s1 =request.getParameter("fname");
		String s2 =request.getParameter("lname");
		String s3 =request.getParameter("lname");
		String s4 =request.getParameter("uname");
		String s5 =request.getParameter("pword");
		PreparedStatement pstmt =con.prepareStatement("insert into unifo value(?,?,?,?,?)");
	
		pstmt.setString(1, s1);
		pstmt.setString(2, s2);
		pstmt.setString(3, s3);
		pstmt.setString(4, s4);
		pstmt.setString(5, s5);
		pstmt.executeUpdate();
		PrintWriter pw=response.getWriter();
		pw.println("<html><body bgcolor=cyan text=blue><center>");
		pw.println("<h1>You Have Registred Successfully</h1>");
		pw.println("<a href=login.html>Login</a>");
		pw.println("<center><body><html>");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
