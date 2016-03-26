package oalex.uni.databases.model;

public enum Privilege {
    ADMIN("Admin"),
    EMPLOYER("Employer"),
    WORKER("Worker");

    private final String name;

    Privilege(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
