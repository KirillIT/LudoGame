package com.company;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final char color;
    private int numberOfChipsAtHome;
    private int numberOfChipsInTheGame;
    private final List<Chip> chips;
    static final private char[] COLORS = new char[]{'R', 'B', 'G', 'Y'};

    public Player(char color) {
        this.color = color;
        final int N_CHIPS = 4;
        chips = new ArrayList<>(N_CHIPS);
        numberOfChipsAtHome = N_CHIPS;
        numberOfChipsInTheGame = N_CHIPS;
    }

    public int getNumberOfChipsInTheGame() {
        return numberOfChipsInTheGame;
    }

    public void setNumberOfChipsInTheGame(int numberOfChipsInTheGame) {
        this.numberOfChipsInTheGame = numberOfChipsInTheGame;
    }

    public char getColor() {
        return color;
    }

    public int getNumberOfChipsAtHome() {
        return numberOfChipsAtHome;
    }

    public void setNumberOfChipsAtHome(int numberOfChipsAtHome) {
        this.numberOfChipsAtHome = numberOfChipsAtHome;
    }

    public Chip getChip(int index) {
        return chips.get(index);
    }

    public void addChip(Chip chip) {
        chips.add(chip);
    }

    public int getSizeChips(){
        return chips.size();
    }

    public void removeChips(int index){
        chips.remove(index);
    }

    static public char getColors(int index){ return COLORS[index];}
}