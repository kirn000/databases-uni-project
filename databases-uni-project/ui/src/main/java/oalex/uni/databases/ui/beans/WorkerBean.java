package oalex.uni.databases.ui.beans;

import oalex.uni.databases.model.*;
import oalex.uni.databases.service.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.*;

@ManagedBean
@ViewScoped
public class WorkerBean {

    @ManagedProperty(value = "#{workSkillService}")
    private WorkSkillService workSkillService;

    @ManagedProperty(value = "#{educationService}")
    private EducationService educationService;

    @ManagedProperty(value = "#{employerService}")
    private EmployerService employerService;

    @ManagedProperty(value = "#{workerService}")
    private WorkerService workerService;

    @ManagedProperty(value = "#{userService}")
    private UserService userService;

    @ManagedProperty(value = "#{commentaryService}")
    private CommentaryService commentaryService;

    private Worker worker;
    private List<WorkSkill> workSkills;
    private Education education;
    private User user;
    private List<Commentary> comments;
    private Commentary commentary;

    @PostConstruct
    public void init(){

        String workerId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        setWorker(workerService.find(Long.parseLong(workerId)));
        setEducation(educationService.findEducationByWorkerId(getWorker().getId()));
        setWorkSkills(workSkillService.getAllWorkerSkills(Long.parseLong(workerId)));
        Set<String> skillsNames = new HashSet<String>();
        List<WorkSkill> workSkillsToRemove = new ArrayList<WorkSkill>();
        for (WorkSkill skill : workSkills){
            if (skillsNames.contains(skill.getSkill())){
                workSkillsToRemove.add(skill);
            } else {
                skillsNames.add(skill.getSkill());
            }
        }
        getWorkSkills().removeAll(workSkillsToRemove);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        setUser(userService.findUserByLogin(auth.getName()));

        comments = commentaryService.findAllCommentaryForWorker(worker.getId());
        commentary = new Commentary();

    }

    public boolean isOwner(){
        return user.getPrivilege() == Privilege.WORKER && worker.getId().equals(workerService.findWorkerByUserId(user.getId()).getId());
    }

    public String addComment(){
        commentary.setCommentDate(new Date());
        commentary.setWorker(worker);
        if (user.getPrivilege() == Privilege.EMPLOYER){
            commentary.setAuthor(employerService.findEmployerByUserId(user.getId()).getName());
        } else if (user.getPrivilege() == Privilege.WORKER){
            commentary.setAuthor(workerService.findWorkerByUserId(user.getId()).getFirstName() + workerService.findWorkerByUserId(user.getId()).getLastName());
        }
        commentaryService.create(commentary);
        return "/content/StartingPage.xhtml";
    }

    public WorkerService getWorkerService() {
        return workerService;
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

    public List<WorkSkill> getWorkSkills() {
        return workSkills;
    }

    public void setWorkSkills(List<WorkSkill> workSkills) {
        this.workSkills = workSkills;
    }

    public WorkSkillService getWorkSkillService() {
        return workSkillService;
    }

    public void setWorkSkillService(WorkSkillService workSkillService) {
        this.workSkillService = workSkillService;
    }

    public Commentary getCommentary() {
        return commentary;
    }

    public void setCommentary(Commentary commentary) {
        this.commentary = commentary;
    }

    public List<Commentary> getComments() {
        return comments;
    }

    public void setComments(List<Commentary> comments) {
        this.comments = comments;
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

    public CommentaryService getCommentaryService() {
        return commentaryService;
    }

    public void setCommentaryService(CommentaryService commentaryService) {
        this.commentaryService = commentaryService;
    }

    public EmployerService getEmployerService() {
        return employerService;
    }

    public void setEmployerService(EmployerService employerService) {
        this.employerService = employerService;
    }

}
