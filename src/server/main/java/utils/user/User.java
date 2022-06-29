package utils.user;

import javax.persistence.*;

@Entity
public class User {
    /**
     * This Class is used to store Users
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;
    private String name;
    private String password;


    public User(String name, String password){
        this.name = name;
        this.password = password;
    }

    public User() {
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
