package oalex.uni.databases.ui.beans;

import oalex.uni.databases.model.Job;
import oalex.uni.databases.model.Privilege;
import oalex.uni.databases.model.User;
import oalex.uni.databases.model.WorkSkill;
import oalex.uni.databases.service.JobService;
import oalex.uni.databases.service.UserService;
import oalex.uni.databases.service.WorkSkillService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class JobBean {

    @ManagedProperty(value = "#{userService}")
    private UserService userService;

    @ManagedProperty(value = "#{jobService}")
    private JobService jobService;

    @ManagedProperty(value = "#{workSkillService}")
    private WorkSkillService workSkillService;

    private User user;
    private Job job;
    private WorkSkill workSkill;

    @PostConstruct
    public void init(){

        String jobId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        setUser(userService.findUserByLogin(auth.getName()));
        setJob(jobService.find(Long.parseLong(jobId)));
        setWorkSkill(workSkillService.findWorkSkillForJob(job.getEmployer().getId(), job.getId()));

    }

    public boolean isEmployerPrivilege() {
        return user.getPrivilege().equals(Privilege.EMPLOYER);
    }

    public boolean isWorkerPrivilege() {
        return user.getPrivilege().equals(Privilege.WORKER);
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

    public void setJob(Job job) {
        this.job = job;
    }

    public Job getJob() {
        return job;
    }

    public void setJobService(JobService jobService) {
        this.jobService = jobService;
    }

    public JobService getJobService() {
        return jobService;
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
}
