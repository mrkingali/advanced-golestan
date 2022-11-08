package ir.ac.kntu;

public class OflineClass extends ClassGroup implements ISignInClass {
    String roomNumber;
    int roomCapacity;

    /***
     * constructor
     * 
     * @param classIdOrName
     * @param roomNumber
     * @param roomCapacity
     */

    public OflineClass(String classIdOrName, String roomNumber, int roomCapacity) {
        super(classIdOrName);
        this.roomNumber = roomNumber;
        this.roomCapacity = roomCapacity;
    }

    public OflineClass(String classIdOrName) {
        super(classIdOrName);
        // TODO Auto-generated constructor stub
    }

    /**
     * getter and setter
     * 
     * @return
     */

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(int roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    public OflineClass() {
    }

    /**
     * funtion to add studetn s1 to the this ofline class by chek the time and
     * prequisit
     */

    @Override
    public boolean signInClass(Student s1) {
        // TODO Auto-generated method stub
        if (roomCapacity >= this.classCapacity && this.getClassStudents().size() < this.classCapacity
                && checkTimeOfClass(s1) && canChooseClass(s1) && !this.classStudents.contains(s1)) {
            classStudents.add(s1);
            s1.classesGroup.add(this);
            System.out.println("sign in succesfully");
            return true;

        }
        return false;
    }

}
