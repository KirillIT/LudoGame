package com.company;

import java.util.*;

public class Board {

    private char[][] board;

    public Board() {
        clearBoard();
    }

    private final char [] bg = new char[]{' ', 'W', 'H'};

    public void clearBoard(){
        board = new char[][] {
                {bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0], bg[1],bg[1], bg[1], bg[1], bg[1],bg[1], bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0], bg[0],bg[0]},
                {bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0], bg[1],bg[1], bg[1], bg[1], bg[1],bg[1], bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0], bg[0],bg[0]},
                {bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0], bg[1],bg[1], bg[2], bg[2], bg[1],bg[1], bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0], bg[0],bg[0]},
                {bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0], bg[1],bg[1], bg[2], bg[2], bg[1],bg[1], bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0], bg[0],bg[0]},
                {bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0], bg[1],bg[1], bg[2], bg[2], bg[1],bg[1], bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0], bg[0],bg[0]},
                {bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0], bg[1],bg[1], bg[2], bg[2], bg[1],bg[1], bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0], bg[0],bg[0]},
                {bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0], bg[1],bg[1], bg[2], bg[2], bg[1],bg[1], bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0], bg[0],bg[0]},
                {bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0], bg[1],bg[1], bg[2], bg[2], bg[1],bg[1], bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0], bg[0],bg[0]},
                {bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0], bg[1],bg[1], bg[2], bg[2], bg[1],bg[1], bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0], bg[0],bg[0]},
                {bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0], bg[1],bg[1], bg[2], bg[2], bg[1],bg[1], bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0], bg[0],bg[0]},
                {bg[1],bg[1],bg[1],bg[1],bg[1],bg[1],bg[1],bg[1],bg[1],bg[1], bg[0],bg[0], bg[0], bg[0], bg[0],bg[0], bg[1],bg[1],bg[1],bg[1],bg[1],bg[1],bg[1],bg[1], bg[1],bg[1]},
                {bg[1],bg[1],bg[1],bg[1],bg[1],bg[1],bg[1],bg[1],bg[1],bg[1], bg[0],bg[0], bg[0], bg[0], bg[0],bg[0], bg[1],bg[1],bg[1],bg[1],bg[1],bg[1],bg[1],bg[1], bg[1],bg[1]},
                {bg[1],bg[1],bg[2],bg[2],bg[2],bg[2],bg[2],bg[2],bg[2],bg[2], bg[0],bg[0], bg[0], bg[0], bg[0],bg[0], bg[2],bg[2],bg[2],bg[2],bg[2],bg[2],bg[2],bg[2], bg[1],bg[1]},
                {bg[1],bg[1],bg[2],bg[2],bg[2],bg[2],bg[2],bg[2],bg[2],bg[2], bg[0],bg[0], bg[0], bg[0], bg[0],bg[0], bg[2],bg[2],bg[2],bg[2],bg[2],bg[2],bg[2],bg[2], bg[1],bg[1]},
                {bg[1],bg[1],bg[1],bg[1],bg[1],bg[1],bg[1],bg[1],bg[1],bg[1], bg[0],bg[0], bg[0], bg[0], bg[0],bg[0], bg[1],bg[1],bg[1],bg[1],bg[1],bg[1],bg[1],bg[1], bg[1],bg[1]},
                {bg[1],bg[1],bg[1],bg[1],bg[1],bg[1],bg[1],bg[1],bg[1],bg[1], bg[0],bg[0], bg[0], bg[0], bg[0],bg[0], bg[1],bg[1],bg[1],bg[1],bg[1],bg[1],bg[1],bg[1], bg[1],bg[1]},
                {bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0], bg[1],bg[1], bg[2], bg[2], bg[1],bg[1], bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0], bg[0],bg[0]},
                {bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0], bg[1],bg[1], bg[2], bg[2], bg[1],bg[1], bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0], bg[0],bg[0]},
                {bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0], bg[1],bg[1], bg[2], bg[2], bg[1],bg[1], bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0], bg[0],bg[0]},
                {bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0], bg[1],bg[1], bg[2], bg[2], bg[1],bg[1], bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0], bg[0],bg[0]},
                {bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0], bg[1],bg[1], bg[2], bg[2], bg[1],bg[1], bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0], bg[0],bg[0]},
                {bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0], bg[1],bg[1], bg[2], bg[2], bg[1],bg[1], bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0], bg[0],bg[0]},
                {bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0], bg[1],bg[1], bg[2], bg[2], bg[1],bg[1], bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0], bg[0],bg[0]},
                {bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0], bg[1],bg[1], bg[2], bg[2], bg[1],bg[1], bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0], bg[0],bg[0]},
                {bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0], bg[1],bg[1], bg[1], bg[1], bg[1],bg[1], bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0], bg[0],bg[0]},
                {bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0], bg[1],bg[1], bg[1], bg[1], bg[1],bg[1], bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0],bg[0], bg[0],bg[0]}
        };
    }

    public void updateBoard(Map<Chip, Integer> chipsOnTheBoard, List<Player> players, BoardHelper boardHelper){
        clearBoard();
        for (Player player : players) {
            for (int i = 0; i < player.getSizeChips(); i++) {
                int key = chipsOnTheBoard.get(player.getChip(i));
                if (player.getChip(i).isAtHome()) {
                    board[boardHelper.getCoordinateMatching(key + 1)[i][0]][boardHelper.getCoordinateMatching(key + 1)[i][1]] = player.getChip(i).getColor();
                    continue;
                }
                if (player.getChip(i).isInTheFirstPlace()) {
                    board[boardHelper.getCoordinateMatching(key)[0][0]][boardHelper.getCoordinateMatching(key)[0][1]] = player.getChip(i).getColor();
                }
                else {
                    board[boardHelper.getCoordinateMatching(key)[1][0]][boardHelper.getCoordinateMatching(key)[1][1]] = player.getChip(i).getColor();
                }
            }
        }
    }

    public void printBoard(){
        final int BOARD_SIZE = 26;
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public char getBG(int index) {
        return bg[index];
    }

    public char getBoardElement(int firstIndex, int secondIndex) {
        return board[firstIndex][secondIndex];
    }
}