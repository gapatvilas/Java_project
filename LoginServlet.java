package login;
import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;


/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	Connection con;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","gapat");
		}catch(Exception e){
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
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String s1= request.getParameter("uname");
			String s2= request.getParameter("pword");
			PreparedStatement pstmt =con.prepareStatement("select * from unifo where uname=? & pword=?");
			pstmt.setString(1, s1);
			pstmt.setString(2, s2);
			ResultSet rs =pstmt.executeQuery();
			PrintWriter pw =response.getWriter();
			pw.print("<html><body bgcolor=yellow text=blue><h1>");
			if(rs.next()) {
				pw.println("Welcome"+s1);
			}
			else {
				pw.print("Invalid Username/Password");
			}
			pw.println("</h1></body></html>");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
