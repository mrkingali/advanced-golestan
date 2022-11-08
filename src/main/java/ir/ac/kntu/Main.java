package ir.ac.kntu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import ir.ac.kntu.Time.DayOfClass;
import ir.ac.kntu.Time.HourOfClass;

public class Main {
    public static String space = "                     ";
    public static ArrayList<Classes> universeClases = new ArrayList<>();
    public static ArrayList<UniversityPerson> peaple = new ArrayList<>();
    public static ArrayList<ClassGroup> universeGroupClases = new ArrayList<>();

    public static ArrayList<Student> stus = new ArrayList<>();
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        universeClases.add(new Classes("1020", "math"));
        universeClases.add(new Classes("1021", "chemistory"));
        universeClases.add(new Classes("1022", "fizik"));
        universeClases.add(new Classes("1023", "workout"));
        universeClases.add(new Classes("1024", "ap"));



        ClassGroup c1=new ClassGroup("1020");
        ClassGroup c2=new ClassGroup("1021");
        ClassGroup c3=new ClassGroup("1022");
        ClassGroup c4=new ClassGroup("1023");

        HashMap<DayOfClass,HourOfClass> d1=new HashMap<>();
        d1.put(DayOfClass.SAT,HourOfClass.FROM_2_T_4);

        c1.setTime(d1);

        universeGroupClases.add(c1);
        universeGroupClases.add(c2);
        universeGroupClases.add(c3);
        universeGroupClases.add(c4);



        peaple.add(new Admin("admin", "1", "admin", "admin"));
        peaple.add(new Admin("admin", "2", "admin2", "admin"));

        peaple.add(new Professor("profesor1", "1", "profesor1", "1234"));
        peaple.add(new Professor("profesor2", "2", "profesor2", "1234"));
        peaple.add(new Professor("profesor3", "3", "profesor3", "1234"));
        peaple.add(new Professor("profesor4", "4", "profesor4", "1234"));
        peaple.add(new Professor("profesor5", "5", "profesor5", "1234"));

        peaple.add(new Student("stu1", "1", "1234", "student1"));
        peaple.add(new Student("stu2", "2", "1234", "student2"));
        peaple.add(new Student("stu3", "3", "1234", "student3"));
        peaple.add(new Student("stu4", "4", "1234", "student4"));
        peaple.add(new Student("stu5", "5", "1234", "student5"));
        peaple.add(new Student("stu6", "6", "1234", "student6"));
        peaple.add(new Student("stu7", "7", "1234", "student7"));
        peaple.add(new Student("stu8", "8", "1234", "student8"));
        peaple.add(new Student("stu9", "9", "1234", "student9"));
        peaple.add(new Student("stu10", "10", "1234", "student10"));
        peaple.add(new Student("stu11", "11", "1234", "student11"));
        peaple.add(new Student("stu12", "12", "1234", "student12"));

        for (UniversityPerson p : peaple) {
            if (p.getClass().getSimpleName().equals("Student")) {
                Student a = (Student) p;
                a.setClassesGroup(universeGroupClases);
                stus.add(a);
            }
        }





        //test print schedule
        Student studentSchedule=new Student("ali", "mardi", "1234", "ali");
        ArrayList<ClassGroup> c=new ArrayList<>();
        ClassGroup class1=new ClassGroup("math");
        HashMap<DayOfClass,HourOfClass> hashMap1=new HashMap<>();
        hashMap1.put(DayOfClass.SAT, HourOfClass.FROM_2_T_4);
        hashMap1.put(DayOfClass.TUE, HourOfClass.FROM_2_T_4);
        hashMap1.put(DayOfClass.MON, HourOfClass.FROM_7_T_9);
        class1.setTime(hashMap1);
        c.add(class1);
        studentSchedule.setClassesGroup(c);
        studentSchedule.printSchedule();


        //test karname
         Student stu1=new Student("stu1", "1", "1234", "1234");
         ArrayList<ClassGroup> fg=new ArrayList<>();
         ClassGroup class2=new ClassGroup("math");
         ClassGroup class3=new ClassGroup("fizik");
         HashMap<Student,Double> mark1=new HashMap<>();
         mark1.put(stu1, 19.5);
         HashMap<Student,Double> mark2=new HashMap<>();
         mark2.put(stu1, 18.5);
         class2.setStudentGrades(mark1);
         class3.setStudentGrades(mark2);
         fg.add(class2);
         fg.add(class3);
         stu1.setClassesGroup(fg);
         stu1.printReportOfMark();
         







































        start();

    }

    protected static void start() {
        System.out.print(space + "<<< WELCOME TO GOLESTAN >>>");
        UniversityPerson person = checkLogin();
        String personClass = person.getClass().getSimpleName();
        printWelcome(person.getName() + " " + person.getLastName());
        switch (personClass) {
            case "Admin":
                printAdminMenu();
                adminMenu();
                break;
            case "Student":
                printStudentMenu();
                studentMenu((Student) person);

                break;
            case "Professor":
                printProfessorMenu();
                professorMenu((Professor) person);
                break;

        }
    }

    /**
     * this function is our login bar which will check
     * if pass and username was currect
     * then will return the person roll
     * 
     * @return person
     */
    protected static UniversityPerson checkLogin() {
        System.out.println("\n\n\nplease enter your info for login : \n\n");
        System.out.print(space + "ID : ");
        String id = in.nextLine();
        System.out.print(space + "pass : ");
        String pass = in.nextLine();

        for (UniversityPerson p : peaple) {
            if (id.equals(p.getId())) {
                if (pass.equals(p.getPass())) {
                    System.out.println(space + "log in sucessfuly ");
                    return p;

                }
                System.out.print(space + "password was wrong !!\n");
                System.out.print(space + "enter password again : ");
                pass = in.nextLine();
                if (pass.equals(p.getPass())) {
                    return p;
                }
                System.out.print(space + "you enter wrong pass again check your info again ");
                return checkLogin();
            }

        }
        System.out.println(space + "\nuser not found !!");
        return checkLogin();
    }

    /**
     * these are print method wich will print the menu of their
     * person such admin or professor or student
     * 
     * @param name
     */
    public static void printWelcome(String name) {
        System.out.println(space + "welcome " + name + "\n\n");
    }

    public static void printAdminMenu() {
        System.out.println(space + "<< menu of the Admin has showed below >>\n ");
        System.out.println(" 1 >> work on class");
        System.out.println(" 2 >> work on Student");
        System.out.println(" 3 >> work on Professor");
        System.out.println(" 4 >> work on Group of the classes");
        System.out.println(" 5 >> work on Student mail");
        System.out.println(" 6 >> work on selecting units");
        System.out.println("\n0 >> exit");
    }

    public static void printProfessorMenu() {
        System.out.println(space + "<< menu of the Professor has showed below >>\n");
        System.out.println(" 1 >> see the group of the class");
        System.out.println(" 2 >> see the students info");
        System.out.println(" 3 >> see Weekly Schedule");
        System.out.println(" 4 >> add student mark");
        System.out.println("\n0 >> exit");

    }

    public static void printStudentMenu() {
        System.out.println(space + "<< menu of the Student has showed below >>\n");
        System.out.println(" 1 >> select unit ");
        System.out.println(" 2 >> see report of the mark");
        System.out.println(" 3 >> see Weekly Schedule");
        System.out.println(" 4 >> write mail for Admin");
        System.out.println(" 5 >> food");
        System.out.println("\n0 >> exit");

    }

    /**
     * iits our studetn menu wich will reaction to the student input
     * and will work on student work
     * 
     * @param student
     */
    public static void studentMenu(Student student) {
        int index = Integer.parseInt(in.nextLine());
        switch (index) {
            case 1:
                selectUnitStudent(student);
                printStudentMenu();
                studentMenu(student);
                break;
            case 2:
                student.printReportOfMark();
                printStudentMenu();
                studentMenu(student);
                break;
            case 3:
                student.printSchedule();
                printStudentMenu();
                studentMenu(student);
                break;
            case 4:
                writeDeleteClass(student);
                printStudentMenu();
                studentMenu(student);
                break;
            case 5:

                printStudentMenu();
                studentMenu(student);
                break;
            case 0:

                start();
                break;

        }

    }

    /**
     * function to select unit for studetn
     */
    public static void selectUnitStudent(Student student) {
        System.out.println("group classes of the university has shoved below : ");
        for (ClassGroup c : universeGroupClases) {
            if (!student.getPassedClasses().keySet().contains(c)) {
                System.out.println(c);
            }
        }
        System.out.println("how many unit do you want to select ? ");
        int count = Integer.parseInt(in.nextLine());

        for (int i = 0; i < count; i++) {
            System.out.println("enter id of group class : ");
            String courseId = in.nextLine();
            for (ClassGroup c1 : universeGroupClases) {
                if (c1.getClassGroupId().equals(courseId)) {
                    if (c1.getClass().getSimpleName().equals("OnlineClass")) {
                        OnlineClass c1On = (OnlineClass) c1;
                        c1On.signInClass(student);
                    } else if (c1.getClass().getSimpleName().equals("OflineClass")) {
                        OflineClass c1Of = (OflineClass) c1;
                        c1Of.signInClass(student);
                    } else {
                        System.out.println("wron id !");
                    }

                }
                break;
            }

        }
    }

    /**
     * this function will write file to sent it to admin
     * to delelte the course from student course
     * 
     * @param student
     */
    public static void writeDeleteClass(Student student) {
        System.out.println("please enter the id of your classGroup \ncheck it with these if you forgot !");
        for (ClassGroup c : student.getClassesGroup()) {
            if (c != null) {
                System.out.println(c.toString());
            }
        }
        String id = in.nextLine();
        for (ClassGroup c : student.getClassesGroup()) {
            if (c.getClassGroupId().equals(id)) {
                try {
                    FileWriter myWriter = new FileWriter("p2-golestan-plus-plus/mail/mail.txt");
                    myWriter.write(student.getId() + " " + c.getClassGroupId());
                    myWriter.close();
                    System.out.println("Successfully sent to admin.");
                } catch (IOException e) {
                    System.out.println("cant wrote");
                    // e.printStackTrace();
                }
                break;
            }
        }
    }

    /**
     * iits our professor menu wich will reaction to the professor input
     * and will work on professor work
     * 
     * @param professor
     */
    public static void professorMenu(Professor professor) {
        int index = Integer.parseInt(in.nextLine());
        switch (index) {
            case 1:
                for (ClassGroup c : professor.getCourseInTerm()) {
                    System.out.println(c);
                    for (Student s : c.getClassStudents()) {
                        System.out.print(s.getName() + s.getLastName() + "_");
                    }
                    System.out.print("\n");
                }
                printProfessorMenu();
                professorMenu(professor);
                break;
            case 2:
                professor.getStudentInfo();
                printProfessorMenu();
                professorMenu(professor);
                break;
            case 3:
                professor.printSchedule();
                printProfessorMenu();
                professorMenu(professor);
                break;
            case 4:
                System.out.println(
                        "if you want set all mrk of student enter 1 and if you want set the special student mark enter 2 : ");
                int input = Integer.parseInt(in.nextLine());
                if (input == 1) {
                    setMarkOfAllStudent(professor);
                } else if (input == 2) {
                    setMarkOfSpecialStudent(professor);
                } else {
                    System.out.println("wrong input select again : ");
                }
                printProfessorMenu();
                professorMenu(professor);
                break;
            case 0:
                start();
                break;

        }

    }

    /**
     * this is function wich exit in professor menu to set all studetn mark
     * 
     * @param p
     */
    public static void setMarkOfAllStudent(Professor p) {
        System.out.println("wich course do you want set mark ? ");
        int i = 1;
        for (ClassGroup c : p.getCourseInTerm()) {
            System.out.println((i++) + c.getClassName() + ":" + c.getClassId() + "  ");
        }
        String classid = in.nextLine();
        for (ClassGroup c : p.getCourseInTerm()) {
            if (c.getClassId().equals(classid)) {
                System.out.println("now enter the all student mark by their id");
                for (Student s : c.getStudentGrades().keySet()) {
                    System.out.print("mark of " + s.getId() + " >>  ");
                    double mark = Double.parseDouble(in.nextLine());
                    c.getStudentGrades().put(s, mark);
                    break;

                }
                break;
            }
        }

    }

    /**
     * this is function which use to set one studetn mark with his id
     * 
     * @param p
     */
    public static void setMarkOfSpecialStudent(Professor p) {
        System.out.println("please enter the class id : ");
        String courseId = in.nextLine();
        System.out.println("please enter the student id : ");
        String studentid = in.nextLine();
        System.out.println("please enter the student Mark : ");
        double mark = Double.parseDouble(in.nextLine());
        for (ClassGroup c : p.getCourseInTerm()) {
            if (c.getClassId().equals(courseId)) {
                for (Student s : c.getStudentGrades().keySet()) {
                    if (s.getId().equals(studentid)) {
                        c.getStudentGrades().put(s, mark);
                        System.out.println(
                                "in class : " + courseId + "mark of student : " + s.getName() + " set >> " + mark
                                        + " sucesfuly");
                        break;
                    } else {
                        System.out.println("student id was wrong ");
                    }

                }

            } else {
                System.out.println("course id was wrong ");
            }
        }

    }

    /**
     * iits our admin menu wich will reaction to the admin input
     * and will work on admin work
     * 
     *
     */

    public static void adminMenu() {
        int index = Integer.parseInt(in.nextLine());
        switch (index) {
            case 1:
                classFunction();
                printAdminMenu();
                adminMenu();
                break;
            case 2:
                studentFunction();
                printAdminMenu();
                adminMenu();
                break;
            case 3:
                profesorFunction();
                printAdminMenu();
                adminMenu();
                break;
            case 4:
                groupClassFunction();
                printAdminMenu();
                adminMenu();
                break;
            case 5:
                readDeleteClass();
                printAdminMenu();
                adminMenu();
                break;
            case 6:
                selectUnitAdmin();
                printAdminMenu();
                adminMenu();
                break;
            case 0:
                start();
                break;

        }
    }

    /**
     * admin will select unit in this class
     * 
     */
    public static void selectUnitAdmin() {
        System.out.println(
                "for selecting unit firt of all you should choose the Groupclasses you had made .group class has showed below: ");
        for (ClassGroup c : universeGroupClases) {
            System.out.println(c);

        }
        System.out.println("enter the groupclassid : ");
        String classGroupId = in.nextLine();
        for (ClassGroup c : universeGroupClases) {
            if (c.getClassGroupId().equals(classGroupId)) {
                System.out.println("how many student do you want to select ? ");
                int count = Integer.parseInt(in.nextLine());
                System.out.println("now enter the studetn id that you defind to select");
                for (int i = 0; i < count; i++) {
                    System.out.println((i + 1) + " _ id : ");
                    String id = in.nextLine();
                    int index = findStudent(id);
                    if (c.getClass().getSimpleName().equals("OnlineClass")) {
                        OnlineClass c1 = (OnlineClass) c;

                        c1.signInClass((Student) peaple.get(index));

                    } else if (c.getClass().getSimpleName().equals("OflineClass")) {
                        OflineClass c1 = (OflineClass) c;

                        c1.signInClass((Student) peaple.get(index));

                    }

                }
                System.out.println("how many professor need?");
                int count2 = Integer.parseInt(in.nextLine());
                for (int i = 0; i < count2; i++) {
                    System.out.println((i + 1) + " _ id : ");
                    String id = in.nextLine();
                    int index = findProfessor(id);
                    c.getClassProfessors().add((Professor) peaple.get(index));

                }

            }
            break;
        }

    }

    /**
     * this function is for admin
     * and admin can work on class to add delete and change them
     */
    public static void classFunction() {
        System.out.println("what do you want to do?");
        System.out.println("1_add new class   2_edit class   3_delete class");
        int index = Integer.parseInt(in.nextLine());
        switch (index) {
            case 1:
                Classes dars = new Classes();
                System.out.print("enter the class id : ");
                dars.setClassId(in.nextLine());
                System.out.print("enter the class Name : ");
                dars.setClassName(in.nextLine());
                ArrayList<Classes> doros = new ArrayList<>();
                System.out.print("how many prerequisite classes need for this class ? ");
                int tedadDarsPishniaz = Integer.parseInt(in.nextLine());
                for (int i = 0; i < tedadDarsPishniaz; i++) {
                    Classes dars1 = new Classes();
                    System.out.print("enter the class id : ");
                    dars.setClassId(in.nextLine());
                    System.out.print("enter the class Name : ");
                    dars.setClassName(in.nextLine());
                    doros.add(dars1);
                }
                dars.setPrerequisitesClass(doros);
                universeClases.add(dars);
                System.out.println("class created succesfully");
                break;
            case 2:
                System.out.print("enter the class id : ");
                String id = in.nextLine();
                int index1 = findClass(id);
                changeClass(index1);
                break;
            case 3:
                System.out.print("enter the class id : ");
                String id2 = in.nextLine();
                int index2 = findClass(id2);
                universeClases.remove(index2);

                break;
        }
    }

    /**
     * this function is for admin
     * and admin can work on professor to add delete and change them
     */
    public static void profesorFunction() {
        System.out.println("what do you want to do?");
        System.out.println("1_add new Professor   2_edit Professor   3_delete Professor");
        int index = Integer.parseInt(in.nextLine());
        switch (index) {
            case 1:
                UniversityPerson profesor = new Professor();
                System.out.print("enter the professor id : ");
                profesor.setId(in.nextLine());
                System.out.print("enter the professor Name : ");
                profesor.setName(in.nextLine());
                System.out.print("enter the professor Last Name : ");
                profesor.setLastName(in.nextLine());
                System.out.print("enter the professor pass : ");
                profesor.setPass(in.nextLine());
                System.out.println("Professor added succesfully");
                peaple.add(profesor);
                break;
            case 2:
                System.out.print("enter the Professor id : ");
                String id = in.nextLine();
                int index1 = findProfessor(id);
                changeProfessor(index1);
                break;
            case 3:
                System.out.print("enter the Professor id : ");
                String id1 = in.nextLine();
                int index2 = findProfessor(id1);
                peaple.remove(index2);

                break;
        }

    }

    /**
     * this function is for admin
     * to find index of class in arraylist of class
     * 
     * @param id
     */
    public static int findClass(String id) {
        for (int i = 0; i < universeClases.size(); i++) {
            if (universeClases.get(i).getClassId().equals(id)) {
                return i;

            }
        }
        System.out.println("invalid class ");
        adminMenu();
        return -1;
    }

    /**
     * this function is for admin
     * and admin can change class
     * 
     * @param id
     */
    public static void changeClass(int id) {
        System.out.println("which field should be changed ?");
        System.out.println(" 1_id   2_className  3_prerequisite");
        int k = Integer.parseInt(in.nextLine());
        switch (k) {
            case 1:
                System.out.print("enter the class id : ");
                universeClases.get(id).setClassId(in.nextLine());
                break;
            case 2:
                System.out.print("enter the class Name : ");
                universeClases.get(id).setClassName(in.nextLine());
                break;
            case 3:
                ArrayList<Classes> doros = new ArrayList<>();
                System.out.print("how many prerequisite classes need for this class ? ");
                int tedadDarsPishniaz = Integer.parseInt(in.nextLine());
                for (int i = 0; i < tedadDarsPishniaz; i++) {
                    Classes dars1 = new Classes();
                    System.out.print("enter the class id : ");
                    universeClases.get(id).setClassId(in.nextLine());
                    System.out.print("enter the class Name : ");
                    universeClases.get(id).setClassName(in.nextLine());
                    doros.add(dars1);
                }
                universeClases.get(id).setPrerequisitesClass(doros);
                break;

        }

    }

    /**
     * this function is for admin
     * to find index of profesor in arraylist of peaple
     * 
     * @param id
     */
    public static int findProfessor(String id) {
        for (int i = 0; i < peaple.size(); i++) {
            if (peaple.get(i).getId().equals(id)) {
                return i;

            }
        }
        System.out.println("invalid class ");
        adminMenu();
        return -1;
    }

    /**
     * this function is for admin
     * and admin can change professor
     * 
     * @param id
     */
    public static void changeProfessor(int id) {
        System.out.println("which field should be changed ?");
        System.out.println(" 1_id   2_Name  3_LastName  4_pass");
        int k = Integer.parseInt(in.nextLine());
        switch (k) {
            case 1:
                System.out.print("enter the Professsor id : ");
                peaple.get(id).setId(in.nextLine());
                break;
            case 2:
                System.out.print("enter the professor Name : ");
                peaple.get(id).setName(in.nextLine());
                break;
            case 3:
                System.out.print("enter the professor LastName : ");
                peaple.get(id).setName(in.nextLine());
                break;
            case 4:
                System.out.print("enter the professor pass : ");
                peaple.get(id).setPass(in.nextLine());
                break;

        }

    }

    /**
     * this function is for admin
     * and admin can work on studetn to add delete and change student
     * 
     *
     */
    public static void studentFunction() {
        System.out.println("what do you want to do?");
        System.out.println("1_add new Student   2_edit Student   3_delete Student");
        int index = Integer.parseInt(in.nextLine());
        switch (index) {
            case 1:
                String name;
                String lastName;
                String id;
                String pass;
                System.out.print("please enter student name :");
                name = in.nextLine();
                System.out.print("please enter student lastName :");
                lastName = in.nextLine();
                System.out.print("please enter student Id :");
                id = in.nextLine();
                System.out.print("please enter student password :");
                pass = in.nextLine();
                Student d1 = new Student(name, lastName, pass, id);
                ArrayList<Classes> dorosGoazande = new ArrayList<>();
                System.out.print("how many classes student has passed ? ");
                int tedadDarsGozarande = Integer.parseInt(in.nextLine());
                for (int i = 0; i < tedadDarsGozarande; i++) {
                    ClassGroup dars = new ClassGroup();
                    System.out.print("enter the class id : ");
                    dars.setClassId(in.nextLine());
                    System.out.print("enter the class Name : ");
                    dars.setClassName(in.nextLine());
                    System.out.print("enter the class mark : ");
                    d1.getPassedClasses().put(dars, Double.parseDouble(in.nextLine()));
                }

                System.out.println("Student created succesfully");
                break;
            case 2:
                System.out.print("enter the Student id : ");
                String id1 = in.nextLine();
                int index1 = findStudent(id1);
                changeStudent(index1);
                break;
            case 3:
                System.out.print("enter the Student id : ");
                String id2 = in.nextLine();
                int index2 = findStudent(id2);
                peaple.remove(index2);

                break;
        }

    }

    /**
     * with this function we will wind the student index in peaple array
     * 
     * @param id
     * @return
     */
    public static int findStudent(String id) {
        for (int i = 0; i < peaple.size(); i++) {
            if (peaple.get(i).getId().equals(id)) {
                return i;

            }
        }
        System.out.println("invalid class ");
        adminMenu();
        return -1;
    }

    /**
     * this function is for admin
     * and admin can change student
     * 
     * @param id
     */
    public static void changeStudent(int id) {
        System.out.println("which field should be changed ?");
        System.out.println(" 1_id   2_Name  3_LastName  4_pass");
        int k = Integer.parseInt(in.nextLine());
        switch (k) {
            case 1:
                System.out.print("enter the Student id : ");
                peaple.get(id).setId(in.nextLine());
                break;
            case 2:
                System.out.print("enter the Student Name : ");
                peaple.get(id).setName(in.nextLine());
                break;
            case 3:
                System.out.print("enter the Student LastName : ");
                peaple.get(id).setName(in.nextLine());
                break;
            case 4:
                System.out.print("enter the Student pass : ");
                peaple.get(id).setPass(in.nextLine());
                break;

        }

    }

    /**
     * this function is for admin
     * and admin can work on groupclass to add group class
     * 
     *
     */
    public static void groupClassFunction() {
        addGroupClass();
    }

    public static void addGroupClass() {
        System.out.println("we have these class in our university : ");
        int i = 1;
        for (Classes c : universeClases) {
            System.out.println((i++) + " >>> " + c.toString());
        }
        System.out.println("which one would be used in Group of class ? enter the number");
        int index = Integer.parseInt(in.nextLine());
        System.out.println("enter ONLINE if it is online group class or");
        System.out.println("enter OFLINE if it is Ofline group class : ");
        String type = in.nextLine();
        if (type.equals("ONLINE")) {

            creatOnlineClass(index);
        } else {
            creatOflineClass(index);

        }
    }

    /**
     * it will creat online class
     * 
     * @param index
     */
    public static void creatOnlineClass(int index) {
        OnlineClass onClass = new OnlineClass();
        onClass.setClassName(universeClases.get(index).getClassName());
        onClass.setClassId(universeClases.get(index).getClassId());
        onClass.setPrerequisitesClass(universeClases.get(index).getPrerequisitesClass());
        System.out.println("enter the year of group : ");
        onClass.setClassYear(in.nextLine());
        System.out.println("enter the capacity of group : ");
        onClass.setClassCapacity(Integer.parseInt(in.nextLine()));
        System.out.println("now lets check the time of the class : \n ");

        System.out.println("how many  session are in week ? ");
        int sessionInWeek = Integer.parseInt(in.nextLine());
        System.out.println("\nnow enter the day and hour of the class for example \"mon 7to9\" ");
        System.out.println(java.util.Arrays.asList(DayOfClass.values()));
        System.out.println(java.util.Arrays.asList(HourOfClass.values()));
        HashMap<DayOfClass, HourOfClass> time = new HashMap<>();
        A: for (int j = 0; j < sessionInWeek; j++) {
            String[] t = in.nextLine().split(" ");
            for (DayOfClass a : java.util.Arrays.asList(DayOfClass.values())) {
                if (a.toString().equals(t[0])) {
                    for (HourOfClass b : java.util.Arrays.asList(HourOfClass.values())) {
                        if (b.toString().equals(t[1])) {
                            time.put(a, b);
                            continue A;
                        }
                    }
                }

            }
        }
        universeGroupClases.add(onClass);
        System.out.println("class created succesfuly");
    }

    /**
     * it will creat ofline class
     * 
     * @param index
     */
    public static void creatOflineClass(int index) {
        OflineClass ofclass = new OflineClass();
        ofclass.setClassName(universeClases.get(index).getClassName());
        ofclass.setClassId(universeClases.get(index).getClassId());
        ofclass.setPrerequisitesClass(universeClases.get(index).getPrerequisitesClass());
        System.out.println("enter the year of group : ");
        ofclass.setClassYear(in.nextLine());
        System.out.println("enter the capacity of group : ");
        ofclass.setClassCapacity(Integer.parseInt(in.nextLine()));
        System.out.println("enter the capicyty of room");
        ofclass.setRoomCapacity(Integer.parseInt(in.nextLine()));
        System.out.println("enter the number of room");
        ofclass.setRoomNumber((in.nextLine()));
        System.out.println("now lets check the time of the class : \n ");
        System.out.println("how many  session are in week ? ");
        int sessionInWeek = Integer.parseInt(in.nextLine());
        System.out.println("\nnow enter the day and hour of the class for example \"mon 7to9\" ");
        System.out.println(java.util.Arrays.asList(DayOfClass.values()));
        System.out.println(java.util.Arrays.asList(HourOfClass.values()));
        HashMap<DayOfClass, HourOfClass> time = new HashMap<>();
        A: for (int j = 0; j < sessionInWeek; j++) {
            String[] t = in.nextLine().split(" ");
            for (DayOfClass a : java.util.Arrays.asList(DayOfClass.values())) {
                if (a.toString().equals(t[0])) {
                    for (HourOfClass b : java.util.Arrays.asList(HourOfClass.values())) {
                        if (b.toString().equals(t[1])) {
                            time.put(a, b);
                            continue A;
                        }
                    }
                }

            }
        }
        universeGroupClases.add(ofclass);
        System.out.println("class created succesfuly");
    }

    /**
     * its for admin
     * and will show the student main for delete class
     */
    public static void readDeleteClass() {
        System.out.println("we will show the mail one by one and if you are agree type Y other type N");
        try {
            File myObj = new File("p2-golestan-plus-plus/mail/mail.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
                String stuAndClass[] = data.split(" ");
                String adminChoice = in.nextLine();

                for (UniversityPerson s : peaple) {
                    if (s.getId().equals(stuAndClass[0])) {
                        Student s1 = (Student) s;
                        for (int i = 0; i < s1.getClassesGroup().size(); i++) {
                            if (adminChoice.equals("Y")
                                    && s1.getClassesGroup().get(i).getClassGroupId().equals(stuAndClass[1])) {
                                s1.getClassesGroup().get(i).getClassStudents().remove(s1);
                                s1.getClassesGroup().set(i, null);

                            }
                        }
                    }
                }

            }
            myReader.close();
            if (myObj.delete()) {
                System.out.println("now th file is empty");
            } else {
                System.out.println("Failed to delete the file.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("its empty");
            // e.printStackTrace();
        }
    }

}