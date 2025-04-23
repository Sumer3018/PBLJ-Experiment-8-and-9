<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Attendance Form</title>
    <style>
        body { font-family: Arial; padding: 40px; background: #f4f4f4; }
        form { background: #fff; padding: 20px; border-radius: 8px; max-width: 400px; margin: auto; }
        input, select { width: 100%; padding: 10px; margin-top: 10px; }
        input[type="submit"] { background: #28a745; color: white; border: none; cursor: pointer; }
        input[type="submit"]:hover { background: #218838; }
    </style>
</head>
<body>
    <h2 style="text-align:center;">Student Attendance Form</h2>
    <form action="AttendanceServlet" method="post">
        <label>Student ID:</label>
        <input type="number" name="studentId" required>

        <label>Name:</label>
        <input type="text" name="name" required>

        <label>Date:</label>
        <input type="date" name="date" required>

        <label>Status:</label>
        <select name="status">
            <option value="Present">Present</option>
            <option value="Absent">Absent</option>
        </select>

        <input type="submit" value="Submit Attendance">
    </form>
</body>
</html>
