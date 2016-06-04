package oalex.uni.databases.ui.beans;

import oalex.uni.databases.model.Employer;
import oalex.uni.databases.service.EmployerService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class EmployerBean {

    @ManagedProperty(value = "#{employerService}")
    private EmployerService employerService;

    private Employer employer;

    @PostConstruct
    public void init(){

        String employerId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        setEmployer(employerService.find(Long.parseLong(employerId)));

    }

    public void setEmployerService(EmployerService employerService) {
        this.employerService = employerService;
    }

    public EmployerService getEmployerService() {
        return employerService;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Employer getEmployer() {
        return employer;
    }
}
