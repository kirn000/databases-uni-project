package oalex.uni.databases.model;

public enum Privilege {
    ADMIN("ADMIN"),
    EMPLOYER("EMPLOYER"),
    WORKER("WORKER");

    private final String name;

    Privilege(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
