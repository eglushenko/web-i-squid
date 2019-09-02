package com.github.webisquid.enums;

public enum RoleUser {
    ADMIN("admin"),
    USER("user"),
    GUEST("guest");
    
    
    private String typeOfStatus;


    RoleUser(String user) {
    }

    public String getTypeOfStatus() {
        return typeOfStatus;
    }

    public void setTypeOfStatus(String typeOfStatus) {
        this.typeOfStatus = typeOfStatus;
    }
}
