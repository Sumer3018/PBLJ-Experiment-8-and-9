

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class AttendanceServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/StudentDB";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "Anshi@3018";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int studentId = Integer.parseInt(request.getParameter("studentId"));
        String name = request.getParameter("name");
        String date = request.getParameter("date");
        String status = request.getParameter("status");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

            String sql = "INSERT INTO Attendance (StudentID, Name, Date, Status) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, studentId);
            stmt.setString(2, name);
            stmt.setDate(3, java.sql.Date.valueOf(date));
            stmt.setString(4, status);

            stmt.executeUpdate();

            stmt.close();
            conn.close();

            // Redirect to success page
            response.sendRedirect("success.jsp");

        } catch (Exception e) {
            throw new ServletException("DB Error: " + e.getMessage(), e);
        }
    }
}
