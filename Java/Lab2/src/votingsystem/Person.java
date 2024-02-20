package votingsystem;
/**
 * Lab2 class person
 *
 * @author G. Lopez
 * Date: 2/19/24
 */
public abstract class Person {

    private int age;
    private char Gender;
    protected String firstName;
    protected String lastName;
    protected String politicalParty;

    /**
     *
     * @param age
     * @param gender
     * @param firstName
     * @param lastName
     * @param politicalParty
     *
     * Person constructor and gets basic information
     * This is also the main parent class
     */
    public Person(int age, char gender, String firstName, String lastName, String politicalParty) {
        this.age = age;
        Gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.politicalParty = politicalParty;
    }

    /**
     *
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     *
     * @return Gender
     */
    public char getGender() {
        return Gender;
    }

    /**
     *
     * @return firstName & lastName
     */
    public abstract String getFullName();
}
