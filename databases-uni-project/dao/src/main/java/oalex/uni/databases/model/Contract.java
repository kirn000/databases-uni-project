package oalex.uni.databases.model;

import javax.persistence.*;

@Entity(name="CONTRACT")
public class Contract extends BaseObject {

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    @ManyToOne
    @JoinColumn(name = "worker_id")
    private Worker worker;

    @Column(name="contract_status")
    @Enumerated(EnumType.STRING)
    private ContractStatus contractStatus;

    public Contract() {}

    public Contract(Job job, Worker worker, ContractStatus contractStatus){
        this.job = job;
        this.worker = worker;
        this.contractStatus = contractStatus;
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

    public ContractStatus getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(ContractStatus contractStatus) {
        this.contractStatus = contractStatus;
    }
}
