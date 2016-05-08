package oalex.uni.databases.ui.beans;

import oalex.uni.databases.model.Employer;
import oalex.uni.databases.model.User;
import oalex.uni.databases.service.EmployerService;
import oalex.uni.databases.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class EditEmployerBean {

    @ManagedProperty(value = "#{employerService}")
    private EmployerService employerService;

    @ManagedProperty(value = "#{userService}")
    private UserService userService;

    private User user;
    private Employer employer;

    @PostConstruct
    public void init(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        user = userService.findUserByLogin(auth.getName());
        employer = employerService.findEmployerByUserId(user.getId());
    }

    public String edit(){
        userService.update(user);
        employerService.update(employer);

        return "/content/StartingPage.xhtml";
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
