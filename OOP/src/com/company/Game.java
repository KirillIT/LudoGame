package com.company;

import java.util.*;

public class Game {

    private Player movingPlayer;
    private final Board board = new Board();
    private final BoardHelper boardHelper = new BoardHelper();
    private boolean gameOver = false;
    private final int N_PLAYERS = 4;
    private int whoDrives = 0;
    private int totalNumberOfSteps = 0;
    private final List<Player> players = new ArrayList<>(N_PLAYERS);
    private final Map<Chip, Integer> chipsOnTheBoard;

    public Game() {
        final int N_CHIPS = 16;
        chipsOnTheBoard = new HashMap<>(N_CHIPS);

        players.add(new Player(Player.getColors(0)));
        players.add(new Player(Player.getColors(1)));
        players.add(new Player(Player.getColors(2)));
        players.add(new Player(Player.getColors(3)));

        for (int i = 0; i < N_CHIPS; i++) {
            Chip temp = new Chip(i, players.get(i / N_PLAYERS).getColor(), true);
            players.get(i / N_PLAYERS).addChip(temp);
            chipsOnTheBoard.put(temp, i / N_PLAYERS);
        }

        movingPlayer = players.get(whoDrives++);
    }

    public void cutChipOff(int chipIndex, char mainBoardElement){

        if (mainBoardElement != movingPlayer.getColor()){
            boolean flag = false;

            int index2 = chipsOnTheBoard.get(movingPlayer.getChip(chipIndex));

            for (Player player : players) {
                if (flag) {break;}

                for (int i = 0; i < player.getSizeChips(); i++) {
                    if (flag) {break;}

                    if (chipsOnTheBoard.get(player.getChip(i)) == index2 && player.getChip(i).getColor() != movingPlayer.getColor()) {

                        int startIndex = 1;

                        if (player.getChip(i).getColor() == Player.getColors(0))
                            startIndex += Colors.RED.ordinal();
                        else if (player.getChip(i).getColor() == Player.getColors(1))
                            startIndex += Colors.BLUE.ordinal();
                        else if (player.getChip(i).getColor() == Player.getColors(2))
                            startIndex += Colors.GREEN.ordinal();
                        else
                            startIndex += Colors.YELLOW.ordinal();

                        for (int j = 0; j < player.getSizeChips(); j++) {
                            if (board.getBoardElement(boardHelper.getCoordinateMatching(startIndex)[j][0], boardHelper.getCoordinateMatching(startIndex)[j][1]) == board.getBG(0)) {
                                chipsOnTheBoard.put(player.getChip(i), startIndex - 1);
                                player.getChip(i).setIsAtHome(true);
                                player.setNumberOfChipsAtHome(player.getNumberOfChipsAtHome() + 1);
                                flag = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public void moveChip(int numberOfCells){

        final int TOTAL_SELLS = 44;
        final int TOTAL_REAL_CELLS = 48;
        for (int i = 0; i < movingPlayer.getSizeChips(); i++){

            if (!movingPlayer.getChip(i).isAtHome()) { //если фишка не в доме

                int cheapIndex = chipsOnTheBoard.get(movingPlayer.getChip(i)); //нормализация индексов
                cheapIndex += numberOfCells;
                if (cheapIndex > TOTAL_REAL_CELLS) {
                    cheapIndex -=TOTAL_SELLS;
                }

                if (movingPlayer.getChip(i).getNumberOfSteps() + numberOfCells > TOTAL_SELLS) {//если фишка уже в домике, теоретически может туда попасть

                    int stepIncrement = numberOfCells - TOTAL_SELLS + movingPlayer.getChip(i).getNumberOfSteps() - 1;

                    if(stepIncrement > N_PLAYERS){continue;}
                    if(stepIncrement == N_PLAYERS){
                        movingPlayer.setNumberOfChipsInTheGame(movingPlayer.getNumberOfChipsInTheGame() - 1);
                        chipsOnTheBoard.remove(movingPlayer.getChip(i));
                        movingPlayer.removeChips(i);
                        break;

                    }
                    System.out.println(cheapIndex);
                    cheapIndex = TOTAL_REAL_CELLS + movingPlayer.getChip(i).getId() - movingPlayer.getChip(i).getId() % N_PLAYERS + stepIncrement + 1;
                    System.out.println(cheapIndex);

                }

                int[][] key = boardHelper.getCoordinateMatching(cheapIndex);
                char mainBoardElement = board.getBoardElement(key[0][0], key[0][1]);
                char secondaryBoardElement = board.getBoardElement(key[1][0], key[1][1]);

                if (mainBoardElement == board.getBG(1) || mainBoardElement == board.getBG(2)) {
                    chipsOnTheBoard.put(movingPlayer.getChip(i), cheapIndex);//если всё свободно
                    movingPlayer.getChip(i).setInTheFirstPlace(true);
                    movingPlayer.getChip(i).setNumberOfSteps(movingPlayer.getChip(i).getNumberOfSteps() + numberOfCells);
                    cutChipOff(i, secondaryBoardElement);
                    break;

                }
                else if (secondaryBoardElement == board.getBG(1) || secondaryBoardElement == board.getBG(2)){//если уже первое место занято и если второе место свободно
                    chipsOnTheBoard.put(movingPlayer.getChip(i), cheapIndex);//если всё свободно
                    movingPlayer.getChip(i).setInTheFirstPlace(false);
                    movingPlayer.getChip(i).setNumberOfSteps(movingPlayer.getChip(i).getNumberOfSteps() + numberOfCells);
                    cutChipOff(i, mainBoardElement);
                    break;
                }
            }
        }
    }

    public void makeMoveFromHome(int numberOfCells){

        boolean moveWasMade = false;

        for (int i = 0; i < movingPlayer.getSizeChips(); i++){

            if (movingPlayer.getChip(i).isAtHome()) { //если фишка в доме

                List<Integer> neighbor = boardHelper.getNeighboringVertexes(movingPlayer.getChip(i).getId() / N_PLAYERS + 1);

                int[][] key = boardHelper.getCoordinateMatching(neighbor.get(0));
                char mainBoardElement = board.getBoardElement(key[0][0], key[0][1]);
                char secondaryBoardElement = board.getBoardElement(key[1][0], key[1][1]);

                if (mainBoardElement == board.getBG(1)) { //если первое место свободно
                    chipsOnTheBoard.put(movingPlayer.getChip(i), neighbor.get(0));
                    movingPlayer.getChip(i).setIsAtHome(false);
                    movingPlayer.setNumberOfChipsAtHome(movingPlayer.getNumberOfChipsAtHome() - 1);
                    movingPlayer.getChip(i).setNumberOfSteps(1);
                    movingPlayer.getChip(i).setInTheFirstPlace(true);
                    moveWasMade = true;
                    break;
                }

                else if (secondaryBoardElement == board.getBG(1)){  //и если второе место свободно
                    chipsOnTheBoard.put(movingPlayer.getChip(i), neighbor.get(0));
                    movingPlayer.getChip(i).setIsAtHome(false);
                    movingPlayer.setNumberOfChipsAtHome(movingPlayer.getNumberOfChipsAtHome()- 1);
                    movingPlayer.getChip(i).setNumberOfSteps(1);
                    movingPlayer.getChip(i).setInTheFirstPlace(false);
                    cutChipOff(i, mainBoardElement);
                    moveWasMade = true;
                    break;
                }
            }
        }
        if (!moveWasMade){
            moveChip(numberOfCells);
        }
    }

    public void makeMove(){
        totalNumberOfSteps++;
        int numberOfCells = (int)((Math.random() * 6) + 1);

        if (totalNumberOfSteps <= 4) {
            numberOfCells = 6;
        }

        System.out.println("'"+ movingPlayer.getColor() + "'" + " ходит на " + numberOfCells + " клеток вперёд");
        System.out.println();

        if (numberOfCells == 6 && movingPlayer.getNumberOfChipsAtHome() != 0){
            makeMoveFromHome(numberOfCells);
        }
        else {
            moveChip(numberOfCells);
        }
        if (movingPlayer.getNumberOfChipsInTheGame() == 0){
            gameOver = true;
            return;
        }
        movingPlayer = players.get(whoDrives++);
        if (whoDrives == N_PLAYERS) {
            whoDrives = 0;
        }
    }


    public void startGame(){

        while (!gameOver) {
            makeMove();
            board.updateBoard(chipsOnTheBoard, players, boardHelper);
            board.printBoard();
            System.out.println();
        }
        System.out.println("Победил " + "'" + movingPlayer.getColor() + "'");
        System.out.println("Игра закончилась за " + totalNumberOfSteps + " ходов");
    }
}