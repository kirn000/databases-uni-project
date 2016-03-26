package oalex.uni.databases.model;

public enum Status {
    POSTED("Posted"),
    TAKEN("Taken"),
    CLOSED("Closed");

    private final String name;

    Status(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}