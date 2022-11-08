package ir.ac.kntu;

public class Admin extends UniversityPerson {
    /**
     * this will generate one admin with its param
     * 
     * @param name
     * @param lastName
     * @param pass
     * @param id
     */

    public Admin(String name, String lastName, String pass, String id) {
        super(name, lastName, pass, id);

    }

    /**
     * it will print the admin with nam and last name
     */

    @Override
    public String toString() {
        return "Admin [ name=" + super.getName() + ", lastName=" + super.getLastName() + "]";
    }

}
