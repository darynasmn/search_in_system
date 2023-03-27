package Use;

public class Person {
    public String name;
    public String secondName;
    public String surname;
    public int age;


    public Person(String surname,String name, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getFullName() {
        return surname+" "+name+" "+secondName;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public String toString(){
        return  surname + " "+ name+"\nAge: "+age;
    }

}


