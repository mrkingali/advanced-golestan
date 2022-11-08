package ir.ac.kntu;

public class OnlineClass extends ClassGroup implements ISignInClass {
    /**
     * constructor
     * 
     * @param classId
     * @param className
     */

    public OnlineClass(String classId, String className) {
        super(classId, className);
    }

    public OnlineClass(String classIdOrName) {
        super(classIdOrName);
        // TODO Auto-generated constructor stub
    }

    public OnlineClass() {
    }

    /**
     * function to add studetn to this onlineclass
     */
    public boolean signInClass(Student s1) {
        // TODO Auto-generated method stub
        if (this.getClassStudents().size() < this.classCapacity && checkTimeOfClass(s1) && canChooseClass(s1)) {
            classStudents.add(s1);
            s1.classesGroup.add(this);
            System.out.println("sign in succesfuly !");
            return true;

        }

        return false;
    }

}
