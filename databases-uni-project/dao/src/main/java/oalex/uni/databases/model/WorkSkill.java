package oalex.uni.databases.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "WORK_SKILL")
public class WorkSkill extends BaseObject {

    @ManyToOne
    @JoinColumn(name = "worker_id")
    private Worker worker;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    @Column
    private String skill;

    @Column
    private String description;

    public WorkSkill() {}

    public WorkSkill(Worker worker, Employer employer, Job job, String skill, String description){
        this.worker = worker;
        this.employer = employer;
        this.job = job;
        this.skill = skill;
        this.description = description;
    }

    //Getters and setters ----------------------------------------------------------


    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
