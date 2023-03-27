package Use;

public class General {
        private String name;
        private Faculty[] faculties;
        public StudentsMethods generalAmountOfStudents;

        public General(String name) {
            this.name = name;
            faculties = new Faculty[0];
            generalAmountOfStudents=getGeneralAmountOfStudents();
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Faculty[] getFaculties() {
            return faculties;
        }

        public void setFaculties(Faculty[] faculties) {
            this.faculties = faculties;
        }

        public StudentsMethods getGeneralAmountOfStudents() {
            StudentsMethods students = new StudentsMethods();
            for (Faculty faculty : faculties) {
                for (Student student : faculty.getAllStudents().getStudents())
                    students.addStudent(student);
            }
            return students;
        }

    public TeachersMethods getGeneralAmountOfTeachers() {
            TeachersMethods teachers = new TeachersMethods();
            for (Faculty faculty : faculties) {
                for (Teacher teacher : faculty.getAllTeachers().getTeachers())
                    teachers.addTeacher(teacher);
            }
            return teachers;
        }

        public int deleteFaculty(String name) {
            int n = findN(this.name);
            if (n >= 0) {
                Faculty[] location = new Faculty[faculties.length - 1];
                int remain = faculties.length - (n + 1);
                System.arraycopy(faculties, 0, location, 0, n);
                System.arraycopy(faculties, n + 1, location, n, remain);
                faculties = location;
                return 0;
            }
            return 1;
        }

        public int addFaculty(Faculty faculty) {
            if (findFaculty(faculty.getName()) == null) {
                Faculty[] arrayAdditional = new Faculty[faculties.length + 1];
                System.arraycopy(faculties, 0, arrayAdditional, 0, faculties.length);
                arrayAdditional[faculties.length] = faculty;
                setFaculties(arrayAdditional);
                return 0;
            }
            return 1;
        }

        public Faculty findFaculty(String name) {
            for (int i = 0; i < faculties.length; i++) {
                if (faculties[i].getName().equals(name))
                    return faculties[i];
            }
            return null;

        }

        public int findN(String name) {
            for (int i = 0; i < faculties.length; i++) {
                if (faculties[i].getName().equals(name))
                    return i;
            }
            return -1;

        }

        public String showFaculties() {
            StringBuilder res = new StringBuilder();
            if (faculties.length == 0)
                res.append("(немає факультету в цьому університуті)");
            else {
                for (int i = 0; i < faculties.length; i++)
                    res.append((i + 1) + "-" +" Факультет  "+ faculties[i].getName()+"\n");
            }
            return res.toString();
        }

        public String toString() {
            StringBuilder res = new StringBuilder();
            res.append("------------------------------------------------------------------------------------" +
                    name + "------------------------------------------------------------------------------------\n");
            if (faculties.length == 0)
                res.append("(немає факультету в цьому університуті)\n");

            else {

                for (Faculty faculty : faculties)
                    res.append(faculty);
            }
            return res.toString();
        }


}


