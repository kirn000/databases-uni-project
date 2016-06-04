package oalex.uni.databases.ui.beans;

import oalex.uni.databases.model.Worker;
import oalex.uni.databases.service.WorkerService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean
@ViewScoped
public class WorkerListBean {

    @ManagedProperty(value = "#{workerService}")
    private WorkerService workerService;

    private List<Worker> workers;

    @PostConstruct
    public void init() {
        workers = workerService.getAllWorkers();
    }

    public WorkerService getWorkerService() {
        return workerService;
    }

    public void setWorkerService(WorkerService workerService) {
        this.workerService = workerService;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }
}
