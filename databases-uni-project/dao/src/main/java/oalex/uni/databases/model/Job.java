package oalex.uni.databases.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Job extends BaseObject {

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @Column
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column (name = "posting_date")
    @Temporal(TemporalType.DATE)
    private Date postingDate;

    @Column (name = "starting_date")
    @Temporal(TemporalType.DATE)
    private Date startingDate;

    @Column (name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    public Job(){}

    public Job(Employer employer, String description, Status status, Date postingDate, Date startingDate, Date endDate){
        this.employer = employer;
        this.description = description;
        this.status = status;
        this.postingDate = postingDate;
        this.startingDate = startingDate;
        this.endDate = endDate;
    }

    //Getters and setters ----------------------------------------------------------


    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(Date postingDate) {
        this.postingDate = postingDate;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
