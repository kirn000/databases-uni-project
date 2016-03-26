package oalex.uni.databases.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Contract extends BaseObject {

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    @ManyToOne
    @JoinColumn(name = "worker_id")
    private Worker worker;

    public Contract() {}

    public Contract(Job job, Worker worker){
        this.job = job;
        this.worker = worker;
    }

    //Getters and setters ----------------------------------------------------------


    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }
}
