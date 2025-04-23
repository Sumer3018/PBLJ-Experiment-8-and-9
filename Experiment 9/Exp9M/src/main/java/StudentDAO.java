
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentDAO {
    private SessionFactory factory;

    public StudentDAO() {
        factory = new Configuration()
                      .configure("hibernate.cfg.xml")
                      .addAnnotatedClass(Student.class)
                      .buildSessionFactory();
    }

    public void saveStudent(Student student) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
    }

    public Student getStudent(int studentId) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Student student = session.get(Student.class, studentId);
        session.getTransaction().commit();
        return student;
    }

    public void updateStudent(int studentId, String newName) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Student student = session.get(Student.class, studentId);
        student.setName(newName);
        session.getTransaction().commit();
    }

    public void deleteStudent(int studentId) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Student student = session.get(Student.class, studentId);
        session.delete(student);
        session.getTransaction().commit();
    }
}
