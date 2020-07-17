package codecooler.michal.com.model;


public class User {
    private String email;
    private String password;
    private String isAdmin;

    public User(String email, String password, String isAdmin) {
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public String setRole() {
        if(isAdmin.equals("y")){
            return "Admin";
        }else{
            return "Mentor";
        }
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
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
}
