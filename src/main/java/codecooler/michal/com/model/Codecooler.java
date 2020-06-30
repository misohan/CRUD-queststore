package codecooler.michal.com.model;

public class Codecooler {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private CodecoolClass codecolClass;

    public Codecooler() {
    }

    public Codecooler(int id) {
        this.id = id;
    }

    public Codecooler(int id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
