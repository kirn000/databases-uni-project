package oalex.uni.databases.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity(name="USERS")
public class User extends BaseObject{

    @Column
    private String login;

    @Column
    private String password;

    @Enumerated(EnumType.STRING)
    private Privilege privilege;

    public User(){}

    public User(String login, String password, Privilege privilege){
        this.login = login;
        this.password = password;
        this.privilege = privilege;
    }

    //Getters and setters ----------------------------------------------------------


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Privilege getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Privilege privilege) {
        this.privilege = privilege;
    }
}
