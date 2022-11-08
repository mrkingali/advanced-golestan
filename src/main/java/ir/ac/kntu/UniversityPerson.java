package ir.ac.kntu;

public class UniversityPerson {
    String name;
    String lastName;
    String pass;
    String id;

    /**
     * constructor
     * 
     * @param name
     * @param lastName
     * @param pass
     * @param id
     */
    public UniversityPerson(String name, String lastName, String pass, String id) {
        this.name = name;
        this.lastName = lastName;
        this.pass = pass;
        this.id = id;
    }

    public UniversityPerson() {
    }

    /**
     * getter and setter
     * 
     * @return
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UniversityPerson [id=" + id + ", name=" + name + ", lastName=" + lastName + "]";
    }

}
