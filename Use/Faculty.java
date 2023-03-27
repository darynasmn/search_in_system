package Use;

public class Faculty {
    private String name;
    private Cathedra[] cathedras;
    public Faculty(String name)
    {
        this.name=name;
        cathedras =new Cathedra[0];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cathedra[] getCathedras() {
        return cathedras;
    }

    public void setCathedras(Cathedra[] cathedras) {
        this.cathedras = cathedras;
    }

    public StudentsMethods getAllStudents()
    {
        StudentsMethods students=new StudentsMethods();
        for(Cathedra cathedra:cathedras)
        {
            for(Student student:cathedra.getStudents().getStudents())
                students.addStudent(student);
        }
        return students;
    }

    public TeachersMethods getAllTeachers()
    {
        TeachersMethods teachers = new TeachersMethods();
        for(Cathedra cathedra: cathedras)
        {
            for(Teacher teacher:cathedra.getTeachers().getTeachers())
                teachers.addTeacher(teacher);
        }
        return teachers;
    }
    public int deleteCathedra(String name)
    {
        int n=findN(name);
        if(n>=0)
        {
            Cathedra[] location = new Cathedra[cathedras.length - 1];
            int remain = cathedras.length - (n + 1);
            System.arraycopy(cathedras, 0, location, 0, n);
            System.arraycopy(cathedras, n + 1, location, n, remain);
            cathedras=location;
            return 0;
        }
        return 1;
    }
    public StudentsMethods getSortAllStudents()
    {
        StudentsMethods students=getAllStudents();
        students.sortByStudentName();
        return students;
    }
    public TeachersMethods getSortAllTeachers()
    {
        TeachersMethods teachers=getAllTeachers();
        teachers.sortByTeacherName();
        return teachers;
    }

    public String showCathedra()
    {
        StringBuilder res = new StringBuilder();
        if (cathedras.length == 0)
            res.append("(не існує жодної кафедри в цьому факультеті)");
        else {
            for (int i = 0; i < cathedras.length; i++)
                res.append((i + 1) + "-" + cathedras[i].getName()+"\n");
        }
        return res.toString();
    }

    public int addCathedra(Cathedra cathedra) {
        if(findCathedra(cathedra.getName())==null)
        {
            Cathedra[] arrayAdditional = new Cathedra[cathedras.length + 1];
            System.arraycopy(cathedras, 0, arrayAdditional, 0, cathedras.length);
            arrayAdditional[cathedras.length] = cathedra;
            setCathedras(arrayAdditional);
            return 0;
        }
        return  1;
    }

    public Cathedra findCathedra(String name) {
        for(int i=0;i<cathedras.length;i++)
        {
            if(cathedras[i].getName().equals(name))
                return cathedras[i];
        }
        return null;
    }
    public int findN(String name)
    {
        for(int i=0;i<cathedras.length;i++)
        {
            if(cathedras[i].getName().equals(name))
                return i;
        }
        return -1;

    }

    public String toString()
    {
        StringBuilder res=new StringBuilder();
        res.append("Факультет " + name + "\n");
        if(cathedras.length==0)
            res.append("немає ні одної кафедри в факультеті\n");
        else {

            for (int i = 0; i < cathedras.length; i++) {
                res.append(cathedras[i]);
            }
        }
        return res.toString();
    }
}
