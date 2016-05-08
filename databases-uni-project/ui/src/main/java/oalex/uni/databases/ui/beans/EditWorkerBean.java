package oalex.uni.databases.ui.beans;

import oalex.uni.databases.model.Education;
import oalex.uni.databases.model.User;
import oalex.uni.databases.model.Worker;
import oalex.uni.databases.service.EducationService;
import oalex.uni.databases.service.UserService;
import oalex.uni.databases.service.WorkerService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class EditWorkerBean {

    @ManagedProperty(value = "#{workerService}")
    private WorkerService workerService;

    @ManagedProperty(value = "#{userService}")
    private UserService userService;

    @ManagedProperty(value = "#{educationService}")
    private EducationService educationService;

    private User user;
    private Worker worker;
    private Education education;

    @PostConstruct
    public void init(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        user = userService.findUserByLogin(auth.getName());
        worker = workerService.findWorkerByUserId(user.getId());
        education = educationService.findEducationByWorkerId(worker.getId());
    }

    public String edit(){
        userService.update(user);
        workerService.update(worker);
        educationService.update(education);

        return "/content/StartingPage.xhtml";
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public WorkerService getWorkerService() {
        return workerService;
    }

    public void setWorkerService(WorkerService workerService) {
        this.workerService = workerService;
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

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public EducationService getEducationService() {
        return educationService;
    }

    public void setEducationService(EducationService educationService) {
        this.educationService = educationService;
    }
}
