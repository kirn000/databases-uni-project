package oalex.uni.databases.model;

public enum ContractStatus {
    APPLIED("Applied"),
    REJECTED("Rejected"),
    ACCEPTED("Accepted");

    private final String name;

    ContractStatus(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}