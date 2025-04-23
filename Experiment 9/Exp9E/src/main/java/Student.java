public class Student {
    private String name;
    private Course course;

    public Student(String name, Course course) {
        this.name = name;
        this.course = course;
    }

    public void printDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Enrolled Course: " + course.getCourseName());
        System.out.println("Duration: " + course.getDuration() + " weeks");
    }
}