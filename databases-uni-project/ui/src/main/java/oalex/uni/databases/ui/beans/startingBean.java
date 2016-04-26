package oalex.uni.databases.ui.beans;

import oalex.uni.databases.model.User;
import oalex.uni.databases.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

@ManagedBean
@ViewScoped
public class StartingBean implements Serializable {

    @ManagedProperty(value = "#{userService}")
    private UserService userService;

    private User user;

    @PostConstruct
    public void init(){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        setUser(userService.findUserByLogin(auth.getName()));

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
