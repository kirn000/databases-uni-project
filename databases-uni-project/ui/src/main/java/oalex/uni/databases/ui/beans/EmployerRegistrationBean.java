package oalex.uni.databases.ui.beans;

import oalex.uni.databases.model.Employer;
import oalex.uni.databases.model.Privilege;
import oalex.uni.databases.model.User;
import oalex.uni.databases.service.EmployerService;
import oalex.uni.databases.service.UserService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class EmployerRegistrationBean {

    @ManagedProperty(value = "#{employerService}")
    private EmployerService employerService;

    @ManagedProperty(value = "#{userService}")
    private UserService userService;

    User user;
    Employer employer;

    @PostConstruct
    public void init(){
        user = new User("", "", Privilege.EMPLOYER);
        // String name, String contactPerson, String tel, String email, String address, String city, String country, String description, User user
        employer = new Employer("", "", "", "", "", "", "", "", user);
    }

    public String register(){
        userService.create(user);
        employer.setUser(user);
        employerService.create(employer);

        return "/Login.xhtml";
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public EmployerService getEmployerService() {
        return employerService;
    }

    public void setEmployerService(EmployerService employerService) {
        this.employerService = employerService;
    }
}
