package oalex.uni.databases.ui.beans;

import oalex.uni.databases.model.Education;
import oalex.uni.databases.model.Privilege;
import oalex.uni.databases.model.User;
import oalex.uni.databases.model.Worker;
import oalex.uni.databases.service.EducationService;
import oalex.uni.databases.service.UserService;
import oalex.uni.databases.service.WorkerService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class WorkerRegistrationBean {

    @ManagedProperty(value = "#{userService}")
    private UserService userService;

    @ManagedProperty(value = "#{workerService}")
    private WorkerService workerService;

    @ManagedProperty(value = "#{educationService}")
    private EducationService educationService;

    private User user;
    private Worker worker;
    private Education education;

    @PostConstruct
    public void init(){
        user = new User("", "", Privilege.WORKER);
        // String name, String contactPerson, String tel, String email, String address, String city, String country, String description, User user
        worker = new Worker("", "", 0, "", "", "", "", "", "", user);
        education = new Education(worker, "", "");
    }

    public String register(){
        userService.create(user);
        worker.setUser(user);
        workerService.create(worker);
        education.setWorker(worker);
        educationService.create(education);

        return "/Login.xhtml";
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducationService(EducationService educationService) {
        this.educationService = educationService;
    }

    public EducationService getEducationService() {
        return educationService;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorkerService(WorkerService workerService) {
        this.workerService = workerService;
    }

    public WorkerService getWorkerService() {
        return workerService;
    }
}
