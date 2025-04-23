public class Main {
    public static void main(String[] args) {
   
        StudentDAO studentDAO = new StudentDAO();

        Student student = new Student(1, "Aditi", 22);
        Student student1 = new Student(2, "Sumer", 22);
        studentDAO.saveStudent(student);
        studentDAO.saveStudent(student1);

        Student retrievedStudent = studentDAO.getStudent(1);
        System.out.println("Retrieved Student: " + retrievedStudent);

        studentDAO.updateStudent(1, "Aditi Singh");

        Student updatedStudent = studentDAO.getStudent(1);
        System.out.println("Updated Student: " + updatedStudent);

        //studentDAO.deleteStudent(1);

        Student deletedStudent = studentDAO.getStudent(1);
        if (deletedStudent == null) {
            System.out.println("Student with ID 1 not found.");
        }
    }
}
