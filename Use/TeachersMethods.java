package Use;

public class TeachersMethods {

    private Teacher teachers[];
    private int count;

    public Teacher[] getTeachers() {
        return teachers;
    }
    public void setTeachers(Teacher[] teachers){
        this.teachers= teachers;
    }
    public TeachersMethods() {
        count = 0;
        teachers = new Teacher[count];
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Teacher findTeacher(String surname, String name) {
        for (int i = 0; i < teachers.length; i++) {
            if (name.equals(teachers[i].getName()) && surname.equals(teachers[i].getSurname())) {
                return teachers[i];
            }
        }
        return null;
    }

    private int findToDeleteAndEdit(String surname, String name) {
        for (int i = 0; i < teachers.length; i++) {
            if (name.equals(teachers[i].getName()) && surname.equals(teachers[i].getSurname())) {
                return i;
            }
        }
        return -1;
    }
    public int addTeacher(Teacher teacher) {
        if (findTeacher(teacher.surname, teacher.name) == null) {
            Teacher[] arrayAdditional = new Teacher[teachers.length + 1];
            System.arraycopy(teachers, 0, arrayAdditional, 0, teachers.length);
            arrayAdditional[teachers.length] = teacher;
            count++;
            setTeachers(arrayAdditional);
            return 0;
        }
        return 1;
    }
    public void sortByTeacherName() {
        for (int i = 1; i < teachers.length; i++) {
            Teacher s = teachers[i];
            int j;
            for (j = i - 1; j >= 0 && s.getFullName().compareToIgnoreCase(teachers[j].getFullName()) < 0; j--) {
                teachers[j + 1] = teachers[j];
            }
            teachers[j + 1] = s;
        }

    }
    public int deleteTeacher(String surname, String name) {
        int n = findToDeleteAndEdit(surname, name);
        if (n >= 0) {
            Teacher[] location = new Teacher[teachers.length - 1];
            int remain = teachers.length - (n + 1);
            System.arraycopy(teachers, 0, location, 0, n);
            System.arraycopy(teachers, n + 1, location, n, remain);
            count--;
            teachers = location;
            return 0;
        }
        return 1;
    }
    public int editTeacher(String surname, String name, Teacher newTeacher) {
        int n = findToDeleteAndEdit(surname, name);
        if (n != -1) {
            teachers[n] = newTeacher;
            return 0;
        }
        return 1;
    }
    public String toString() {
        StringBuilder res=new StringBuilder();
        if (teachers.length == 0)
            res.append("(Вчителі не знайдені!)\n");
        else {
            for(int i=0;i<teachers.length;i++) {
                res.append((i + 1) + ". " + teachers[i]);
                res.append("\n\n");
            }
        }
        return res.toString();
    }
}