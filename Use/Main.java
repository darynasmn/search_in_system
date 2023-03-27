package Use;
import java.io.IOException;
import Tools.DataInput;

public class Main {

    public static void main(String[] arg) throws IOException {
        General university;
        university = Data();
        workWithUniversity(university);
    }

    public static void workWithUniversity(General university) throws IOException {
        int choice;
        do {
            System.out.print("---Головне меню---");
            System.out.print("\n1-вивести факультет");
            System.out.print("\n2-знайти студента за ім'ям");
            System.out.print("\n3-знайти вчителя за ім'ям");
            System.out.print("\n4-додати факультет");
            System.out.print("\n5-видалити факультет");
            System.out.print("\n6-обрати факультет");
            System.out.println("\n0-Вихід");
            do {
                System.out.print("->");
                choice = DataInput.getInt("");
                if (choice < 0 || choice > 7)
                    System.out.println("Неправильно введено! Будь ласка, спробуйте ще!");
            } while (choice < 0 || choice > 7);
            if (choice == 1)
                System.out.println(university);
            if (choice == 2) {
                if (university.getGeneralAmountOfStudents().getStudents().length == 0)
                    System.out.println("Ви не можете знайти цього студента, бо його не існує!\n");
                else {
                    System.out.println("Введіть повне ім'я студента, щоб знайти його:");
                    String surname = DataInput.getString("Прізвище->");
                    String name = DataInput.getString("Ім'я->");
                    Student student = university.getGeneralAmountOfStudents().findStudentForName(surname, name);
                    if (student == null)
                        System.out.println(surname + " " + name  + " не йснує в базі університету");
                    else
                        System.out.println(student);
                }
                System.out.println();
            }
            if (choice == 3) {
                if (university.getGeneralAmountOfTeachers().getTeachers().length == 0)
                    System.out.println("Ви не можете знайти вчителя, бо не існує ні одного вчителя!\n");
                else {
                    System.out.println("Введіть повне ім'я вчителя:");
                    String surname = DataInput.getString("Прізвище->");
                    String name = DataInput.getString("Ім'я->");
                    Teacher teacher = university.getGeneralAmountOfTeachers().findTeacher(surname, name);
                    if (teacher == null)
                        System.out.println(surname + " " + name + " не існує в базі університету ");
                    else
                        System.out.println(teacher);
                }
                System.out.println();
            }
            if (choice == 4) {
                System.out.println("Введіть назву факультету:");
                String name = DataInput.getString("->");
                int res = university.addFaculty(new Faculty(name));
                if (res == 0)
                    System.out.println("Факультет " + name + " буй доданий!\n");
                else
                    System.out.println("Факультет не був доданий, бо факультет з такою назвою вже існує\n");
            }
            if (choice == 5) {
                System.out.println("Введіть назву факультету:");
                String name = DataInput.getString("->");
                int res = university.deleteFaculty(name);
                if (res == 0)
                    System.out.println("Факультет " + name + " був видалений!\n");
                else
                    System.out.println("Факультет не був видалений, бо факультету з такою назвою не існує!\n");
            }
            if (choice == 6) {
                if (university.getFaculties().length == 0)
                    System.out.println("Ви не можете обрати жоден факультет, бо не існує факультетів\n");
                else {
                    int chosedFacaulty;
                    System.out.println("Оберіть, з яким факультетом будемо працювати:");
                    System.out.print(university.showFaculties());
                    System.out.println("0-повернутися до меню");
                    do {
                        chosedFacaulty = DataInput.getInt("->");


                        if (chosedFacaulty < 0 || chosedFacaulty > university.getFaculties().length)
                            System.out.println("Неправильний номер факультету! Спробуйте ще раз!");
                    } while (chosedFacaulty < 0 || chosedFacaulty > university.getFaculties().length);
                    if (chosedFacaulty != 0)
                        workWithFaculty(university, chosedFacaulty);
                }

            }

        } while (choice != 0);


    }

    private static void workWithCathedra(Faculty faculty, int chooserOfCathedra) throws IOException {
        int choice;
        do {
            System.out.print(faculty.getCathedras()[chooserOfCathedra - 1].getName() + ":  ");
            System.out.print("\n1-редагувати назву факультету");
            System.out.print("\n2-вивести факультет");
            System.out.print("\n3-сортирування студентів за курсом");
            System.out.print("\n4-сортирування студентів за повним ім'ям");
            System.out.print("\n5-сортирувати вчителів за почним ім'ям");
            System.out.print("\n6-обрати студентів за курсом");
            System.out.print("\n7-вивести студентів за курсом та сортирувати за повним ім'ям");
            System.out.print("\n8-додати студента");
            System.out.print("\n9-видалити студента");
            System.out.print("\n10-редагувати студента");
            System.out.print("\n11-додати вчителя");
            System.out.print("\n12-видалити вчителя");
            System.out.print("\n13-редагувати вчителя");
            System.out.print("\n14-знайти студента за групою ");
            System.out.print("\n0-закінчити використання програми  ");
            Cathedra cathedra = faculty.getCathedras()[chooserOfCathedra - 1];
            do {
                System.out.print("->");
                choice = DataInput.getInt("");
                if (choice < 0 || choice > 14)
                    System.out.println("Неправильно введено номер методу");
            } while (choice < 0 || choice > 14);
            if (choice == 2)
                System.out.println(cathedra);
            if (choice == 1) {
                String name = DataInput.getString("Ввести нову назву кафедри: ");
                if (faculty.findCathedra(name) == null) {
                    cathedra.setName(name);
                    System.out.println("Стара назва була успішно замінена\n");
                } else
                    System.out.println("Кафедра з такою назвою вже існує!\n");
            }

            if (choice == 3) {
                System.out.println("Студенти посортовані за курсом");
                cathedra.getStudents().sortByCourse();
                System.out.println(cathedra.getStudents());
            }
            if (choice == 4) {
                System.out.println("Студенти посортовані за повним ім'ям");
                cathedra.getStudents().sortByStudentName();
                System.out.println(cathedra.getStudents());
            }
            if (choice == 5) {
                System.out.println("Вчителі посортовані за повним ім'ям");
                cathedra.getTeachers().sortByTeacherName();
                System.out.println(cathedra.getTeachers());
            }
            if (choice == 6) {
                int course;
                do {
                    course = DataInput.getInt("Введіть курс:");
                    if (course < 1 || course > 8)
                        System.out.println("Неправильно введено номер курсу!");
                } while (course < 1 || course > 8);
                System.out.println("Студент на " + course + " курс: ");
                StudentsMethods finderOfStudents = new StudentsMethods();
                finderOfStudents.setStudents(cathedra.getStudents().findByCourse(course));
                System.out.println(finderOfStudents);
            }
            if (choice == 7) {
                int course;
                do {
                    course = DataInput.getInt("Ввести курс:");
                    if (course < 1 || course > 6)
                        System.out.println("Неправильно введено курс!");
                } while (course < 1 || course > 6);
                System.out.println("Студенти на " + course + " курсі і посортовані за ім'ям: ");
                StudentsMethods finderOfStudents = new StudentsMethods();
                finderOfStudents.setStudents(cathedra.getStudents().findByCourse(course));
                finderOfStudents.sortByStudentName();
                System.out.println(finderOfStudents);
            }
            if (choice == 8) {
                System.out.println("Введіть інформацію про нового студента: ");
                Student newStudent = createNewStudent();
                int operation = cathedra.getStudents().addStudent(newStudent);
                if (operation == 0)
                    System.out.println("Студент був доданий!");
                else
                    System.out.println("Студент не був доданий, бо студент з таким ім'ям вже існує!");
            }
            if (choice == 9) {
                if (cathedra.getStudents().getStudents().length > 0) {
                    System.out.println("Введіть повне ім'я студента для того, щоб видалити його");
                    String surname = DataInput.getString("Прізвище->");
                    String name = DataInput.getString("Ім'я->");
                    int operationNumber = cathedra.getStudents().deleteStudent(surname, name);
                    if (operationNumber == 0)
                        System.out.println("Студент був видалений!\n");
                    else
                        System.out.println("Студент не був видалений,бо такого студента не існує!\n");
                }
            }
            if (choice == 10) {
                System.out.println("Введіть повне ім'я для редагування:");
                String surname = DataInput.getString("Прізвище->");
                String name = DataInput.getString("Ім'я->");

                if (cathedra.getStudents().findStudentForName(surname, name) != null) {
                    System.out.println("Введіть нову інформацію для цього студента: ");
                    cathedra.getStudents().editArrayOfStudent(surname, name, createNewStudent());
                    System.out.println("Інформація була змінена!\n");
                } else
                    System.out.println("Цього студента не існує!");
            }
            if (choice == 11) {
                System.out.println("Введіть інформацію про нового вчителя: ");
                Teacher newTeacher = createNewTeacher();
                int operation = cathedra.getTeachers().addTeacher(newTeacher);
                if (operation == 0)
                    System.out.println("Вчитель був доданий!\n");
                else
                    System.out.println("Вчителя не було додано, бо вчитель з цим ім ям вже існує!\n");
            }
            if (choice == 12) {
                System.out.println("Введіть повне ім'я вчителя, щоб видалити його: ");
                String surname = DataInput.getString("Прізвище->");
                String name = DataInput.getString("Ім'я->");
                int operationNumber = cathedra.getTeachers().deleteTeacher(surname, name);
                if (operationNumber == 0)
                    System.out.println("Вчитель був видалений!\n");
                else
                    System.out.println("Вчителя не було видалено, бо його не існує!");
            }
            if (choice == 13) {
                System.out.println("Введіть повне ім'я вчителя, якого ви хочете редагувати:");
                String surname = DataInput.getString("Прізвище->");
                String name = DataInput.getString("Ім'я->");
                if (cathedra.getTeachers().findTeacher(surname, name) != null) {
                    System.out.println("Введіть нову інформацію для вчителя");
                    cathedra.getTeachers().editTeacher(surname, name, createNewTeacher());
                    System.out.println("Інформація про вчителя була змінена!\n");
                } else
                    System.out.println("Цього вчителя не існує!\n");
            }
            if (choice == 14) {
                System.out.println("Введіть номер групи: ");
                int number = DataInput.getInt("");
                StudentsMethods students = new StudentsMethods();
                students.setStudents(cathedra.getStudents().findByGroup(String.valueOf(number)));
                System.out.println("Студенти в групі " + number + ": ");
                System.out.println(students);
            }

        } while (choice != 0);

    }

    public static void workWithFaculty(General university, int facultyNumber) throws IOException {
        int choice;
        do {
            System.out.print("\nФакультет " + university.getFaculties()[facultyNumber - 1].getName() + ": ");
            System.out.print("\n1-редагувати назву факультету");
            System.out.print("\n2-вивести факультет");
            System.out.print("\n3-вивести студентів факультету сортированих за повним ім'ям ");
            System.out.print("\n4-вивести вчителів факультету сортированих за повним ім'ям");
            System.out.print("\n5-додати кафедру");
            System.out.print("\n6-видалити кафедру");
            System.out.print("\n7-обрати кафедру");
            System.out.print("\n0-завершити програму");
            do {

                System.out.print("->");
                choice = DataInput.getInt("");
                if (choice < 0 || choice > 7)
                    System.out.println("Неправильно введено номер методу!");
            } while (choice < 0 || choice > 7);
            if (choice == 2)
                System.out.println(university.getFaculties()[facultyNumber - 1]);
            if (choice == 1) {
                String name = DataInput.getString("Введіть нову назву факультету: ");
                if (university.findFaculty(name) == null) {
                    university.getFaculties()[facultyNumber - 1].setName(name);
                    System.out.println("Назва факультету була змінена! \n");
                } else
                    System.out.println("Назва не змінена, тому що факультет з такою назвою вже існує!\n");
            }
            if (choice == 3) {
                System.out.println("\nПосортовані студенти за ім'ям: ");
                System.out.println(university.getFaculties()[facultyNumber - 1].getSortAllStudents());
            }
            if (choice == 4) {
                System.out.println("\nПосортовані вчителі факультету за повним ім'ям: ");
                System.out.println(university.getFaculties()[facultyNumber - 1].getSortAllTeachers());
            }
            if (choice == 5) {
                String name = DataInput.getString("Введіть назву нової кафедри: ");
                int operationNumber = university.getFaculties()[facultyNumber - 1].addCathedra(new Cathedra(name));
                if (operationNumber == 0)
                    System.out.println(name + " була додана!\n");
                else
                    System.out.println("Кафедра не була додана, бо кафедра з такою назвою вже існує!\n");
            }
            if (choice == 6) {
                if (university.getFaculties()[facultyNumber - 1].getCathedras().length > 0) {
                    System.out.println("Введіть назву факультету, якого ви хочете видалити:");
                    System.out.print("->");
                    String name = DataInput.getString("");
                    int operationNumber = university.getFaculties()[facultyNumber - 1].deleteCathedra(name);
                    if (operationNumber == 0)
                        System.out.println(name + " була видалена!\n");
                    else
                        System.out.println("Кафедра не була видалена, бо такої кафедри не існує!\n ");
                } else
                    System.out.println("Не існує кафедр в цьому факультеті\n");
            }
            if (choice == 7) {
                if (university.getFaculties()[facultyNumber - 1].getCathedras().length == 0)
                    System.out.println("Ви не можете обрати факультет, бо їх не існує.\n");
                else {
                    int choserOfCathedra;
                    System.out.println("Оберіть кафедру, з якою хочете працювати:");
                    System.out.print(university.getFaculties()[facultyNumber - 1].showCathedra());
                    System.out.println("0-завершити використання програми");
                    do {
                        System.out.print("->");
                        choserOfCathedra = DataInput.getInt("");


                        if (choserOfCathedra < 0 || choserOfCathedra > university.getFaculties().length)
                            System.out.println("Неправильний номер кафедри!");
                    } while (choserOfCathedra < 0 || choserOfCathedra > university.getFaculties().length);
                    if (choserOfCathedra != 0)
                        workWithCathedra(university.getFaculties()[facultyNumber - 1], choserOfCathedra);
                }

            }
        } while (choice != 0);
    }

    private static Teacher createNewTeacher() {
        String surname=DataInput.getString("Прізвище->");
        String name=DataInput.getString("Ім'я->");
        int age;
        do {
            System.out.print("Вік->");
            age = DataInput.getInt("");
            if (age < 24 || age > 120)
                System.out.println("Неправильно вказаний вік!\n");
        } while (age < 24 || age > 120);
        String studySubject=DataInput.getString("Предмет->");
        return new Teacher(surname,name,age,studySubject);
    }
    private static Student createNewStudent(){
        String surname=DataInput.getString("Прізвище->");
        String name=DataInput.getString("Ім'я->");
        int age;
        do {
            age = DataInput.getInt("Вік->");
            if (age < 14 || age > 120)
                System.out.println("Неправильно вказаний вік!\n");
        } while (age < 14 || age > 120);
        int course;
        do {
            course = DataInput.getInt("Курс->");
            if (course < 1 || course > 6)
                System.out.println("Неправильно введений курс!\n");
        } while (course < 1 || course > 6);
        int group=DataInput.getInt("Група->");
        return new Student(surname,name,age,course,group);
    }

    private static General Data() {
        General university = new General("NaUKMA");
        Faculty informatics = new Faculty("Інформатики");

        Cathedra cathedraOfMath = new Cathedra("Кафедра Математики");
        cathedraOfMath.getStudents().addStudent(new Student("Бачинський", "Віктор", 18,1,4));
        cathedraOfMath.getStudents().addStudent(new Student("Петренко", "Оксана", 19,2,3));
        cathedraOfMath.getStudents().addStudent(new Student("Метрено", "Леонід",  17, 1, 10));

        cathedraOfMath.getTeachers().addTeacher(new Teacher("Жорданова", "Вікторія", 54, "Програмування"));
        cathedraOfMath.getTeachers().addTeacher(new Teacher("Коненко", "Марта",  40, "Програмування"));
        cathedraOfMath.getTeachers().addTeacher(new Teacher("Шевченко", "Анфіса",  29, "Програмування"));

        informatics.addCathedra(cathedraOfMath);

        Cathedra cathedraOfInformatics = new Cathedra("Кафедра інформатики");
        cathedraOfInformatics.getStudents().addStudent(new Student("Павленко", "Сергій",  21, 2, 3));
        cathedraOfInformatics.getStudents().addStudent(new Student("Анатоленко", "Анна", 24, 4, 5));
        cathedraOfInformatics.getStudents().addStudent(new Student("Куценко", "Віктор",  30, 2, 1));

        cathedraOfInformatics.getTeachers().addTeacher(new Teacher("Михайлевська", "Оксана", 32, "ЛААГ"));
        cathedraOfInformatics.getTeachers().addTeacher(new Teacher("Константиновський", "Артур",  40, "ЛААГ"));
        cathedraOfInformatics.getTeachers().addTeacher(new Teacher("Гуйда", "Микола",  59, "ЛААГ"));

        informatics.addCathedra(cathedraOfInformatics);
        university.addFaculty(informatics);

        Faculty law = new Faculty("правничих наук");

        Cathedra cathedraPrivateLaw = new Cathedra("Факультет правничих наук");
        cathedraPrivateLaw.getStudents().addStudent(new Student("Мартинюк", "Віталій",  21,3,4));
        cathedraPrivateLaw.getStudents().addStudent(new Student("Шакалов", "Антон",  18,2,6));
        cathedraPrivateLaw.getStudents().addStudent(new Student("Купрій", "Ілона",  19,3,7));

        cathedraPrivateLaw.getTeachers().addTeacher(new Teacher("Добродій", "Влад",  56, "Політична економіка"));
        cathedraPrivateLaw.getTeachers().addTeacher(new Teacher("Лемченко", "Артем", 41, "Політична економіка"));
        cathedraPrivateLaw.getTeachers().addTeacher(new Teacher("Фарченко", "Ніна",  34, "Політична економіка"));
        law.addCathedra(cathedraPrivateLaw);

        Cathedra cathedraOfInternationalAndEuropeanLaw = new Cathedra("Кафедра міжнародного та європейського права");
        cathedraOfInternationalAndEuropeanLaw.getStudents().addStudent(new Student("Радій", "Марк",  22, 4, 4));
        cathedraOfInternationalAndEuropeanLaw.getStudents().addStudent(new Student("Лінченко", "Катерина",  25, 1, 2));
        cathedraOfInternationalAndEuropeanLaw.getStudents().addStudent(new Student("Вуйко", "Георгій", 17, 1,7 ));

        cathedraOfInternationalAndEuropeanLaw.getTeachers().addTeacher(new Teacher("Шелемей", "Ніна",  29, "Міжнардоне право"));
        cathedraOfInternationalAndEuropeanLaw.getTeachers().addTeacher(new Teacher("Гортай", "Микита",  27, "Міжнардоне право"));
        cathedraOfInternationalAndEuropeanLaw.getTeachers().addTeacher(new Teacher("Никитенко", "Наталія", 32, "Міжнардоне право"));

        law.addCathedra(cathedraOfInternationalAndEuropeanLaw);
        university.addFaculty(law);

        return university;
    }
}