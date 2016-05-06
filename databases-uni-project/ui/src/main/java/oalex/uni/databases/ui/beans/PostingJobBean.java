package oalex.uni.databases.ui.beans;

import oalex.uni.databases.model.Employer;
import oalex.uni.databases.model.Job;
import oalex.uni.databases.model.Status;
import oalex.uni.databases.model.WorkSkill;
import oalex.uni.databases.service.EmployerService;
import oalex.uni.databases.service.JobService;
import oalex.uni.databases.service.UserService;
import oalex.uni.databases.service.WorkSkillService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.Date;

@ManagedBean
@ViewScoped
public class PostingJobBean {

    @ManagedProperty(value = "#{employerService}")
    private EmployerService employerService;

    @ManagedProperty(value = "#{userService}")
    private UserService userService;

    @ManagedProperty(value = "#{jobService}")
    private JobService jobService;

    @ManagedProperty(value = "#{workSkillService}")
    private WorkSkillService workSkillService;

    private Job job;
    private WorkSkill workSkill;
    private Employer employer;
    private Date currentDate;

    @PostConstruct
    public void init(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        job = new Job();
        employer = employerService.findEmployerByUserId(userService.findUserByLogin(auth.getName()).getId());
        job.setEmployer(employer);
        workSkill = new WorkSkill();
        workSkill.setEmployer(employer);
        workSkill.setJob(job);

        currentDate = new Date();
    }

    public String postJob(){
        job.setPostingDate(currentDate);
        job.setStatus(Status.POSTED);
        jobService.create(job);
        workSkillService.create(workSkill);

        return "/content/StartingPage.xhtml";
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setEmployerService(EmployerService employerService) {
        this.employerService = employerService;
    }

    public EmployerService getEmployerService() {
        return employerService;
    }

    public void setJobService(JobService jobService) {
        this.jobService = jobService;
    }

    public JobService getJobService() {
        return jobService;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Job getJob() {
        return job;
    }

    public void setWorkSkill(WorkSkill workSkill) {
        this.workSkill = workSkill;
    }

    public WorkSkill getWorkSkill() {
        return workSkill;
    }

    public void setWorkSkillService(WorkSkillService workSkillService) {
        this.workSkillService = workSkillService;
    }

    public WorkSkillService getWorkSkillService() {
        return workSkillService;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }
}
