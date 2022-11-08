package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Arrays;

import ir.ac.kntu.Time.DayOfClass;

public class Professor extends UniversityPerson {
    ArrayList<ClassGroup> courseInTerm;

    /**
     * constructor
     * 
     * @param name
     * @param lastName
     * @param id
     * @param pass
     * @param courseInTerm
     */

    public Professor(String name, String lastName, String id, String pass, ArrayList<ClassGroup> courseInTerm) {
        super(name, lastName, pass, id);
        this.courseInTerm = courseInTerm;

    }

    public Professor(String name, String lastName, String id, String pass) {
        super(name, lastName, pass, id);
        this.courseInTerm = new ArrayList<>();

    }

    public Professor() {
    }

    /**
     * getter and setter
     * 
     * @return
     */
    public ArrayList<ClassGroup> getCourseInTerm() {
        return courseInTerm;
    }

    public void setCourseInTerm(ArrayList<ClassGroup> courseInTerm) {
        this.courseInTerm = courseInTerm;
    }

    @Override
    public String toString() {
        return "Professor [ name=" + super.getName() + ", lastName=" + super.getLastName() + "]";
    }

    /**
     * function to print the professor schedule in weak
     */
    public void printSchedule() {
        String[] schedule = new String[30];
        schedule[0] = "SAT";
        schedule[6] = "SUN";
        schedule[12] = "MOM";
        schedule[18] = "WEN";
        schedule[24] = "TUE";
        for (ClassGroup c : courseInTerm) {
            for (DayOfClass d : c.getTime().keySet()) {
                int index = Arrays.asList(schedule).indexOf(d);
                String hour = c.getTime().get(d).toString();
                switch (hour.charAt(hour.length() - 1)) {
                    case 9:
                        schedule[index + 1] = c.getClassName();
                        break;
                    case 11:
                        schedule[index + 2] = c.getClassName();
                        break;
                    case 1:
                        schedule[index + 3] = c.getClassName();
                        break;
                    case 4:
                        schedule[index + 4] = c.getClassName();
                        break;
                    case 6:
                        schedule[index + 5] = c.getClassName();
                        break;
                }

            }

        }
        System.out.print(Main.space);
        System.out.println(String.format("%15s%15s%15s%15s%15s%15s", "Day \\ hour |",
                Time.HourOfClass.FROM_7_T_9 + " |",
                Time.HourOfClass.FROM_9_T_11 + " |",
                Time.HourOfClass.FROM_11_T_1 + " |",
                Time.HourOfClass.FROM_2_T_4 + " |",
                Time.HourOfClass.FROM_4_T_6 + " |"));
        System.out
                .println(Main.space
                        + "__________________________________________________________________________________________");
        for (int i = 0; i < 30; i += 6) {
            System.out.print(Main.space);
            for (int j = i; j < i + 6; j++) {
                if (schedule[j] == (null)) {
                    System.out.print(String.format("%15s", "free |"));
                } else {
                    System.out.print(String.format("%15s", schedule[j] + " |"));
                }

            }
            System.out.print("\n");
            System.out.println(
                    Main.space
                            + "__________________________________________________________________________________________");
        }
    }

    /**
     * function to print the professors studetn
     */
    public void getStudentInfo() {
        for (ClassGroup c : courseInTerm) {
            for (Student s : c.getClassStudents()) {
                System.out.println(s.toString());
            }
        }
    }
}
