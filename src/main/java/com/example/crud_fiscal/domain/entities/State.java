package com.example.crud_fiscal.domain.entities;

public enum State {
    ACTUAL ("Actual"),
    REVISED ("Revised"),
    ESTIMATED ("Estimated");

    private final String name;
    State(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
