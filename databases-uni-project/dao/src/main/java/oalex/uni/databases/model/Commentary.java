package oalex.uni.databases.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name="COMMENTARY")
public class Commentary extends BaseObject {

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @ManyToOne
    @JoinColumn(name = "worker_id")
    private Worker worker;

    @Column
    private String author;

    @Column
    private String text;

    @Column (name = "comment_date")
    @Temporal(TemporalType.DATE)
    private Date commentDate;

    public Commentary() {}

    public Commentary(Employer employer, Worker worker, String author, String text, Date commentDate){
        this.employer = employer;
        this.worker = worker;
        this.author = author;
        this.text = text;
        this.commentDate = commentDate;
    }

    //Getters and setters ----------------------------------------------------------


    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }
}
