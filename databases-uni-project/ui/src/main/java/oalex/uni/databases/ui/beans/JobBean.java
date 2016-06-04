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
import java.util.List;
import java.util.Map;

@ManagedBean
@ViewScoped
public class JobBean {

    @ManagedProperty(value = "#{userService}")
    private UserService userService;

    @ManagedProperty(value = "#{jobService}")
    private JobService jobService;

    @ManagedProperty(value = "#{workSkillService}")
    private WorkSkillService workSkillService;

    @ManagedProperty(value = "#{employerService}")
    private EmployerService employerService;

    @ManagedProperty(value = "#{workerService}")
    private WorkerService workerService;

    @ManagedProperty(value = "#{contractService}")
    private ContractService contractService;

    private User user;
    private Job job;
    private WorkSkill workSkill;
    private Employer employer;
    private Worker worker;
    private Contract contract;
    private List<Worker> applicantsList;

    @PostConstruct
    public void init(){

        String jobId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        setUser(userService.findUserByLogin(auth.getName()));
        setJob(jobService.find(Long.parseLong(jobId)));
        setWorkSkill(workSkillService.findWorkSkillForJob(job.getEmployer().getId(), job.getId()));
        if (isWorkerPrivilege()){
            worker = workerService.findWorkerByUserId(user.getId());
        }
        if (isEmployerPrivilege()){
            employer = employerService.findEmployerByUserId(user.getId());
        }
        applicantsList = workerService.findWorkersListForJob(job.getId());

    }

    public String applyForJob(){
        contract = new Contract(job, worker, ContractStatus.APPLIED);
        contractService.create(contract);
        return "/content/JobList.xhtml";
    }

    public String acceptApplication(){
        String workerId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("workerNumber");
        long idLong = Long.parseLong(workerId);
        contract = contractService.findContractByWorkerAndJob(job.getId(), idLong);
        if (contract != null){
            contract.setContractStatus(ContractStatus.ACCEPTED);
            contractService.update(contract);
            WorkSkill workerWorkSkill = new WorkSkill(workerService.find(idLong), employer, job, workSkill.getSkill(), workSkill.getDescription());
            workSkillService.create(workerWorkSkill);
        }
        return "/content/JobList.xhtml";
    }

    public boolean isEmployerPrivilege() {
        return user.getPrivilege().equals(Privilege.EMPLOYER);
    }

    public boolean isWorkerPrivilege() {
        return user.getPrivilege().equals(Privilege.WORKER);
    }

    public boolean isAvailableToApply(){
        return (isWorkerPrivilege() && contractService.findContractByWorkerAndJob(job.getId(), worker.getId()) == null);
    }

    public boolean isOwnerOfJob(){
        return (isEmployerPrivilege() && employer.getId() == job.getEmployer().getId());
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

    public Contract getContract() {
        return contract;
    }

    public void setWorkerService(WorkerService workerService) {
        this.workerService = workerService;
    }

    public ContractService getContractService() {
        return contractService;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setContractService(ContractService contractService) {
        this.contractService = contractService;
    }

    public WorkerService getWorkerService() {
        return workerService;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public List<Worker> getApplicantsList() {
        return applicantsList;
    }

    public void setApplicantsList(List<Worker> applicantsList) {
        this.applicantsList = applicantsList;
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
