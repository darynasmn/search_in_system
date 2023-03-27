package Use;

public class Cathedra {
    private String name;
    private StudentsMethods students;
    private TeachersMethods teachers;

    public Cathedra(String name) {
        this.name = name;
        students = new StudentsMethods();
        teachers = new TeachersMethods();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StudentsMethods getStudents() {
        return students;
    }

    public void setStudents(StudentsMethods students) {
        this.students = students;
    }

    public TeachersMethods getTeachers() {
        return teachers;
    }

    public void setTeachers(TeachersMethods teachers) {
        this.teachers = teachers;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(name+"\n\n");
        res.append("Вчителі:\n");
        res.append(teachers);
        res.append("\n\n");
        res.append("Студенти:\n");
        res.append(students);
        res.append("\n");
        return res.toString();
    }
}
