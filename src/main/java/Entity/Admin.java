package Entity;

public class Admin {
    private int id;
    private String user;
    private String password;

    public Admin(String user, String password) {
        this.user = user;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Admin(int id, String user, String password) {
        this.id = id;
        this.user = user;
        this.password = password;
    }

    public Admin() {
    }
}