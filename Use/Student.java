package Use;

public class Student extends Person {
    public int course;
    public int group;

    public Student(String surname, String name, int age, int course,int group ) {
        super(surname, name, age);
        this.course = course;
        this.group = group;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public String toString() {
        return super.toString() + "\nКурс: " + course + "\nГрупа: " + group;
    }
}


