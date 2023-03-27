package Use;

public class StudentsMethods {
    private Student[] students;
    private int count;

    public StudentsMethods() {
        students = new Student[0];
        count = 0;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private int findToDeleteAndEdit(String surname, String name) {
        for (int i = 0; i < students.length; i++) {
            if (name.equals(students[i].getName()) && surname.equals(students[i].getSurname())) {
                return i;
            }
        }
        return -1;
    }

    public int addStudent(Student student) {
        if (findToDeleteAndEdit(student.surname, student.name) == -1) {
            Student[] arrayAdditional = new Student[students.length + 1];
            System.arraycopy(students, 0, arrayAdditional, 0, students.length);
            arrayAdditional[students.length] = student;
            count++;
            setStudents(arrayAdditional);
            return 0;
        }
        return 1;
    }

    void sortByStudentName() {
        for (int i = 1; i < students.length; i++) {
            Student s = students[i];
            int j;
            for (j = i - 1; j >= 0 && s.getFullName().compareToIgnoreCase(students[j].getFullName()) < 0; j--) {
                students[j + 1] = students[j];
            }
            students[j + 1] = s;
        }

    }

    public int deleteStudent(String surname, String name) {
        int n = findToDeleteAndEdit(surname, name);
        if (n != -1) {
            Student[] location = new Student[students.length - 1];
            int remain = students.length - (n + 1);
            System.arraycopy(students, 0, location, 0, n);
            System.arraycopy(students, n + 1, location, n, remain);
            students = location;
            count--;
            return 0;
        }
        return 1;
    }

    public int editArrayOfStudent(String surname, String name, Student newStudent) {
        int studentToEdit = findToDeleteAndEdit(surname, name);
        if (studentToEdit != -1) {
            students[studentToEdit] = newStudent;
            return 0;
        }
        return 1;
    }

    public Student findStudentForName(String surname, String name) {
        for (int i = 0; i < students.length; i++) {
            if (name.equals(students[i].getName()) && surname.equals(students[i].getSurname())) {
                return students[i];
            }
        }
        return null;
    }

    public void sortByCourse() {
        students = sortByCourse(students, 0, students.length - 1);
    }

    public Student[] sortByCourse(Student[] array, int from, int to) {
        if (array.length == 0)
            return array;

        if (from >= to)
            return array;
        int rightindex = to;
        int leftindex = from;
        int middle = from + (to - from) / 2;
        int pivot = (array[middle].getCourse());
        while (leftindex <= rightindex) {
            while (array[leftindex].getCourse() < pivot) {
                leftindex++;
            }
            while (array[rightindex].getCourse() > pivot) {
                rightindex--;
            }
            if (leftindex <= rightindex) {
                Student temp = array[leftindex];
                array[leftindex] = array[rightindex];
                array[rightindex] = temp;
                leftindex++;
                rightindex--;
            }
        }
        if (from < rightindex)
            sortByCourse(array, from, rightindex);
        if (to > leftindex)
            sortByCourse(array, leftindex, to);
        return array;
    }
    public Student[] findByGroup(String group) {
        Student[] groupRes = new Student[0];
        for (int i = 0; i < students.length; i++) {
            if (group.equals(students[i].getGroup())) {
                Student[] arrayAdditional = new Student[groupRes.length + 1];
                System.arraycopy(groupRes, 0, arrayAdditional, 0, groupRes.length);
                arrayAdditional[groupRes.length] = students[i];
                groupRes = arrayAdditional;
            }
        }
        return groupRes;
    }

    public Student[] findByCourse(int course) {
        Student[] courseRes = new Student[0];
        for (int i = 0; i < students.length; i++) {
            if (course == (students[i].getCourse())) {
                Student[] arrayAdditional = new Student[courseRes.length + 1];
                System.arraycopy(courseRes, 0, arrayAdditional, 0, courseRes.length);
                arrayAdditional[courseRes.length] = students[i];
                courseRes = arrayAdditional;
            }
        }
        return courseRes;
    }
    public String toString() {
        StringBuilder res=new StringBuilder();
        if (students.length == 0)
            res.append("Студентів не знайдено\n");
        else
        {
            for(int i=0;i<students.length;i++) {
                res.append((i + 1) + ". " + students[i]);
                res.append("\n\n");
            }
        }
        return res.toString();

    }
    public String toString(Student[] array) {
        StringBuilder res=new StringBuilder();
        if (array.length == 0)
            res.append("Студентів не знайдено\n");
        else
        {
            for(int i=0;i<array.length;i++) {
                res.append((i + 1) + ". " + array[i]);
                res.append("\n\n");
            }
        }
        return res.toString();
    }

}