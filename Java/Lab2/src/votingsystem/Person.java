package votingsystem;
/**
 * Lab2 class person
 *
 * @author G. Lopez
 * Date: 2/16/24
 */
public abstract class Person {

    private int age;
    private char Gender;
    protected String firstName;
    protected String lastName;
    protected String politicalParty;

    public Person(int age, char gender, String firstName, String lastName, String politicalParty) {
        this.age = age;
        Gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.politicalParty = politicalParty;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return Gender;
    }

    public abstract String getFullName();
}
