import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class EmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/CompanyDB";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Anshi@3018";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int empId = Integer.parseInt(request.getParameter("empId"));

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String sql = "SELECT * FROM Employee1 WHERE EmployeeID = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, empId);

            ResultSet rs = stmt.executeQuery();

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            out.println("<html><body>");
            if (rs.next()) {
                out.println("<h2>Employee Details</h2>");
                out.println("<p>Employee ID: " + rs.getInt("EmployeeID") + "</p>");
                out.println("<p>Name: " + rs.getString("Name") + "</p>");
                out.println("<p>Department: " + rs.getString("Department") + "</p>");
                out.println("<p>Salary: " + rs.getDouble("Salary") + "</p>");
            } else {
                out.println("<h3>No Employee found with ID: " + empId + "</h3>");
            }
            out.println("</body></html>");

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            throw new ServletException("Database error", e);
        }
    }
}
