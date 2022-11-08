package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import ir.ac.kntu.Time.DayOfClass;

public class Student extends UniversityPerson {
    final int sAGFMOJAZ = 20;
    HashMap<Classes, Double> passedClasses;
    ArrayList<ClassGroup> classesGroup;

    public Student(String name, String lastName, String pass, String id, HashMap<Classes, Double> passedClasses,
            ArrayList<ClassGroup> classesGroup) {
        super(name, lastName, pass, id);
        this.passedClasses = passedClasses;
        this.classesGroup = classesGroup;

    }

    public Student(String name, String lastName, String pass, String id,
            ArrayList<ClassGroup> classesGroup) {
        super(name, lastName, pass, id);
        this.passedClasses = new HashMap<>();
        this.classesGroup = classesGroup;

    }

    public Student(String name, String lastName, String pass, String id) {
        super(name, lastName, pass, id);
        this.passedClasses = new HashMap<>();
        this.classesGroup = new ArrayList<>();

    }

    /**
     * getter and setter
     * 
     * @return
     */

    public HashMap<Classes, Double> getPassedClasses() {
        return passedClasses;
    }

    public void setPassedClasses(HashMap<Classes, Double> passedClasses) {
        this.passedClasses = passedClasses;
    }

    public ArrayList<ClassGroup> getClassesGroup() {
        return classesGroup;
    }

    public void setClassesGroup(ArrayList<ClassGroup> classesGroup) {
        this.classesGroup = classesGroup;
    }

    @Override
    public String toString() {
        return "Student [ name=" + super.getName() + ", lastName=" + super.getLastName()
                + "]";
    }

    /**
     * function to print the schedule of student
     */
    public void printSchedule() {
        ArrayList<String> schedule1 = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            schedule1.add(null);
        }
        schedule1.set(0, "sat");
        schedule1.set(6, "sun");
        schedule1.set(12, "mon");
        schedule1.set(18, "wen");
        schedule1.set(24, "tue");

        for (ClassGroup c : classesGroup) {
            for (DayOfClass d : c.getTime().keySet()) {
                
                int index = schedule1.indexOf(d.toString());
                String hour = c.getTime().get(d).toString();
                System.out.println(index + "" + d);
                switch (hour.charAt(hour.length() - 1)) {
                    case '9':
                        schedule1.set(index+1 , c.getClassName());
                        break;
                    case '3':
                        schedule1.set(index + 3, c.getClassName());
                        break;
                    case '1':
                        schedule1.set(index + 2, c.getClassName());
                        break;
                    case '6':
                        schedule1.set(index + 4, c.getClassName());
                        break;
                    case '8':
                        schedule1.set(index + 5, c.getClassName());
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
                if (schedule1.get(j) == (null)) {
                    System.out.print(String.format("%15s", "free |"));
                } else {
                    System.out.print(String.format("%15s", schedule1.get(j) + " |"));
                }

            }
            System.out.print("\n");
            System.out.println(
                    Main.space
                            + "__________________________________________________________________________________________");
        }
        System.out.println("\n\n");
    }

    /**
     * function to print karname
     */
    public void printReportOfMark() {
        int count = 0;
        double sum = 0;
        System.out.println(Main.space + String.format("%15s %1s %15s", "Course ", "|", " Mark"));
        System.out.println(Main.space + "________________________________");
        for (ClassGroup c : classesGroup) {
            if (c.getStudentGrades().get(this) != null) {
                double mark = c.getStudentGrades().get(this);
                count++;
                sum += mark;
                System.out.println(Main.space + String.format("%15s %1s %15f", c.getClassName(), "|", mark));
                System.out.println(Main.space + "________________________________");

            }
        }
        System.out.println(Main.space + String.format("%15s %1s %15f \n\n", "mean ", "|", sum / count));

    }

}
