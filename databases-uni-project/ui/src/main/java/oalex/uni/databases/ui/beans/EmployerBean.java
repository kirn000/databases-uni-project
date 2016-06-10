package oalex.uni.databases.ui.beans;

import oalex.uni.databases.model.Commentary;
import oalex.uni.databases.model.Employer;
import oalex.uni.databases.model.Privilege;
import oalex.uni.databases.model.User;
import oalex.uni.databases.service.CommentaryService;
import oalex.uni.databases.service.EmployerService;
import oalex.uni.databases.service.UserService;
import oalex.uni.databases.service.WorkerService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.Date;
import java.util.List;

@ManagedBean
@ViewScoped
public class EmployerBean {

    @ManagedProperty(value = "#{employerService}")
    private EmployerService employerService;

    @ManagedProperty(value = "#{workerService}")
    private WorkerService workerService;

    @ManagedProperty(value = "#{userService}")
    private UserService userService;

    @ManagedProperty(value = "#{commentaryService}")
    private CommentaryService commentaryService;

    private Employer employer;
    private User user;
    private List<Commentary> comments;
    private Commentary commentary;

    @PostConstruct
    public void init(){

        String employerId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        setEmployer(employerService.find(Long.parseLong(employerId)));

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        setUser(userService.findUserByLogin(auth.getName()));

        comments = commentaryService.findAllCommentaryForEmployer(employer.getId());
        commentary = new Commentary();
    }

    public boolean isOwner(){
        return user.getPrivilege() == Privilege.EMPLOYER && employer.getId().equals(employerService.findEmployerByUserId(user.getId()).getId());
    }

    public String addComment(){
        commentary.setCommentDate(new Date());
        commentary.setEmployer(employer);
        if (user.getPrivilege() == Privilege.EMPLOYER){
            commentary.setAuthor(employerService.findEmployerByUserId(user.getId()).getName());
        } else if (user.getPrivilege() == Privilege.WORKER){
            commentary.setAuthor(workerService.findWorkerByUserId(user.getId()).getFirstName() + workerService.findWorkerByUserId(user.getId()).getLastName());
        }
        commentaryService.create(commentary);
        return "/content/StartingPage.xhtml";
    }

    public void setEmployerService(EmployerService employerService) {
        this.employerService = employerService;
    }

    public EmployerService getEmployerService() {
        return employerService;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Employer getEmployer() {
        return employer;
    }

    public WorkerService getWorkerService() {
        return workerService;
    }

    public void setWorkerService(WorkerService workerService) {
        this.workerService = workerService;
    }

    public CommentaryService getCommentaryService() {
        return commentaryService;
    }

    public void setCommentaryService(CommentaryService commentaryService) {
        this.commentaryService = commentaryService;
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

    public List<Commentary> getComments() {
        return comments;
    }

    public void setComments(List<Commentary> comments) {
        this.comments = comments;
    }

    public Commentary getCommentary() {
        return commentary;
    }

    public void setCommentary(Commentary commentary) {
        this.commentary = commentary;
    }
}
