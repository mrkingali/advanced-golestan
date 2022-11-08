package ir.ac.kntu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import ir.ac.kntu.Time.DayOfClass;
import ir.ac.kntu.Time.HourOfClass;

public class ClassGroup extends Classes {
    String classGroupId;
    ArrayList<Student> classStudents;
    ArrayList<Professor> classProfessors;
    String classYear;
    int classCapacity;
    HashMap<Student, Double> studentGrades;
    HashMap<DayOfClass, HourOfClass> time;

    /**
     * constructor
     * 
     * @param classId
     * @param className
     */

    public ClassGroup(String classId, String className) {
        super(classId, className);

    }

    public ClassGroup(String classIdOrName) {
        if (classIdOrName.matches("[0-9]{1,}")) {
            classId = classIdOrName;
            Random r1 = new Random();
            int randomInt = r1.nextInt(100);
            classGroupId = classId + Integer.toString(randomInt);
        }
        className = classIdOrName;
        classStudents = new ArrayList<>();
        classProfessors = new ArrayList<>();
        studentGrades = new HashMap<>();
        time = new HashMap<>();
    }

    public ClassGroup() {
    }

    /**
     * getter and setter
     */

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassGroupId() {
        return classGroupId;
    }

    public void setClassGroupId(String classGroupId) {
        this.classGroupId = classGroupId;
    }

    public ArrayList<Student> getClassStudents() {
        return classStudents;
    }

    public void setClassStudents(ArrayList<Student> classStudents) {
        if (classStudents.size() <= classCapacity) {
            this.classStudents = classStudents;
        }
    }

    public ArrayList<Professor> getClassProfessors() {
        return classProfessors;
    }

    public void setClassProfessors(ArrayList<Professor> classProfessors) {
        this.classProfessors = classProfessors;
    }

    public String getClassYear() {
        return classYear;
    }

    public void setClassYear(String classYear) {
        this.classYear = classYear;
    }

    public HashMap<Student, Double> getStudentGrades() {
        return studentGrades;
    }

    public void setStudentGrades(HashMap<Student, Double> studentGrades) {
        this.studentGrades = studentGrades;
    }

    public HashMap<DayOfClass, HourOfClass> getTime() {
        return time;
    }

    public void setTime(HashMap<DayOfClass, HourOfClass> time) {
        this.time = time;
    }

    public int getClassCapacity() {
        return classCapacity;
    }

    public void setClassCapacity(int classCapacity) {
        this.classCapacity = classCapacity;
    }

    /**
     * to string to prit the group class
     */

    @Override
    public String toString() {
        return "ClassGroup [classGroupId=" + classGroupId + ", classId=" + classId + ", className=" + className
                + ", classYear=" + classYear + "]";
    }

    /**
     * function to chek the time of class with the student other class
     * 
     * @param student
     * @return
     */

    public boolean checkTimeOfClass(Student student) {

        for (DayOfClass d1 : this.time.keySet()) {
            for (ClassGroup c2 : student.getClassesGroup()) {
                for (DayOfClass d2 : c2.getTime().keySet()) {
                    if (this.time.get(d1).equals(c2.getTime().get(d2))) {
                        System.out.println(this.className + " ba " + c2.className + " tadakhol darad ");
                        return false;
                    }
                }
            }
        }
        return true;

    }

}
