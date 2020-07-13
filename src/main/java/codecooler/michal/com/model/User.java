package codecooler.michal.com.model;

public class User {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String isAdmin;
    private String role;

    public User(String firstname, String lastname, String email, String password, String isAdmin) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }


    public String setRole() {
        if(isAdmin.equals("y")){
            return "Admin";
        }else{
            return "Mentor";
        }
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String emailAdresse) {
        this.email = emailAdresse;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    //POLA
    //name;
    //surname;
    //boolean isAdmin;
    //pole String role;

    //SQL
    //muszę mieć tabele User z kolumną isAdmin (varchar(1))
    //email
    //hasło
    //wstawić 1 admina i 1 mentora


    //strona z dwoma inputami może byc w index.jsp

}
