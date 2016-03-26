package oalex.uni.databases.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Education extends BaseObject {

    @OneToOne
    @JoinColumn(name = "worker_id")
    private Worker worker;

    @Column
    private String university;

    @Column
    private String speciality;

    public Education(){}

    public Education(Worker worker, String university, String speciality){
        this.worker = worker;
        this.university = university;
        this.speciality = speciality;
    }

    //Getters and setters ----------------------------------------------------------


    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
