package oalex.uni.databases.ui.beans;

import oalex.uni.databases.model.Job;
import oalex.uni.databases.service.JobService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean
@ViewScoped
public class JobListBean {

    @ManagedProperty(value = "#{jobService}")
    private JobService jobService;

    private List<Job> jobList;

    @PostConstruct
    public void init() {
        jobList = jobService.getAllJobs();
    }

    public JobService getJobService() {
        return jobService;
    }

    public void setJobService(JobService jobService) {
        this.jobService = jobService;
    }

    public List<Job> getJobList() {
        return jobList;
    }

    public void setJobList(List<Job> jobList) {
        this.jobList = jobList;
    }
}
