package oalex.uni.databases.ui.beans;

import oalex.uni.databases.model.Education;
import oalex.uni.databases.model.WorkSkill;
import oalex.uni.databases.model.Worker;
import oalex.uni.databases.service.EducationService;
import oalex.uni.databases.service.WorkSkillService;
import oalex.uni.databases.service.WorkerService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ManagedBean
@ViewScoped
public class WorkerBean {

    @ManagedProperty(value = "#{workerService}")
    private WorkerService workerService;

    @ManagedProperty(value = "#{workSkillService}")
    private WorkSkillService workSkillService;

    @ManagedProperty(value = "#{educationService}")
    private EducationService educationService;

    private Worker worker;
    private List<WorkSkill> workSkills;
    private Education education;

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
}
