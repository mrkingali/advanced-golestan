package ir.ac.kntu;

import java.util.ArrayList;

public class Classes {
    String classId;
    String className;
    ArrayList<Classes> prerequisitesClass;

    /**
     * these are constructor to make class with its param
     * 
     * @param classId
     * @param className
     * @param prerequisitesClass
     */
    public Classes(String classId, String className, ArrayList<Classes> prerequisitesClass) {
        this.classId = classId;
        this.className = className;
        this.prerequisitesClass = prerequisitesClass;
    }

    /**
     * constructor to generate it with its param
     * 
     * @param classId
     * @param className
     */
    public Classes(String classId, String className) {
        this.classId = classId;
        this.className = className;
        this.prerequisitesClass = new ArrayList<>();
    }

    public Classes() {
    }

    /**
     * getter and setter
     * 
     * @return
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

    public ArrayList<Classes> getPrerequisitesClass() {
        return prerequisitesClass;
    }

    public void setPrerequisitesClass(ArrayList<Classes> prerequisitesClass) {
        this.prerequisitesClass = prerequisitesClass;
    }

    /**
     * tostring is function to print class
     */
    @Override
    public String toString() {
        if (prerequisitesClass.size() > 0) {
            return "Classes [classId=" + String.format("%15s", classId) + ", className="
                    + String.format("%15s", className) + " , has preQuiseities" + "]";
        }
        return "Classes [classId=" + String.format("%15s", classId) + ", className=" + String.format("%15s", className)
                + " , has not preQuiseities" + "]";
    }

    /**
     * function to chek if studetn can choose this class by prequisities
     * 
     * @param student
     * @return
     */

    public boolean canChooseClass(Student student) {
        int z = 0;
        for (Classes o1 : this.prerequisitesClass) {
            boolean result = false;
            for (Classes o2 : student.getPassedClasses().keySet()) {
                if (o1.equals(o2)) {
                    result = true;
                    break;
                }

            }
            if (result == true) {
                z++;
            }
        }
        if (z >= this.prerequisitesClass.size()) {
            return true;
        }
        System.out.println("pishniaz rayat nashode");
        return false;

    }

}