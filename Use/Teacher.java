package Use;

public class Teacher extends Person{
    public String studySubject;
    public Teacher( String surname,String name, int age, String studySubject){
        super(surname,name,age);
        this.studySubject=studySubject;
    }

    public String getStudySubject() {
        return studySubject;
    }

    public void setStudySubject(String studySubject) {
        this.studySubject = studySubject;
    }
    public String toString(){
        return super.toString()+"\nStudy subject: "+studySubject;
    }
}
