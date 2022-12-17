package com.company;

public class Chip {

    private final int id;
    private final char color;
    private boolean isAtHome;
    private int numberOfSteps;
    private boolean isInTheFirstPlace;

    public Chip(int id, char color, boolean isAtHome) {
        this.isAtHome = isAtHome;
        this.color = color;
        this.id = id;
        numberOfSteps = 0;
        isInTheFirstPlace=true;
    }

    public boolean isInTheFirstPlace() {
        return isInTheFirstPlace;
    }

    public void setInTheFirstPlace(boolean isInTheFirstPlace) {
        this.isInTheFirstPlace = isInTheFirstPlace;
    }

    public int getNumberOfSteps() {
        return numberOfSteps;
    }

    public void setNumberOfSteps(int numberOfSteps) {
        this.numberOfSteps = numberOfSteps;
    }

    public int getId() {
        return id;
    }

    public char getColor() {
        return color;
    }

    public boolean isAtHome() {
        return isAtHome;
    }

    public void setIsAtHome(boolean atHome) {
        isAtHome = atHome;
    }
}