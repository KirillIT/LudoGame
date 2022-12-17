package com.company;
import java.util.List;

public class BoardHelper {

    private final UndirectedGraph<Integer, int[][]> coordMatch = new UndirectedGraph<>();

    private void fillAllPositions() {
        /*сначала создаём вершины*/
        //стартовые поля
        coordMatch.addVertex(1,new int[][]{{1,1},{1,8},{8,1},{8,8}});//R
        coordMatch.addVertex(2,new int[][]{{1,17},{1,24},{8,17},{8,24}});//B
        coordMatch.addVertex(3,new int[][]{{17,1},{17,8},{24,1},{24,8}}); //G
        coordMatch.addVertex(4,new int[][]{{17,17},{17,24},{24,17},{24,24}}); //Y
        //игровые поля
        coordMatch.addVertex(5,new int[][]{{24,15},{24,14}});
        coordMatch.addVertex(6,new int[][]{{22,15},{22,14}});
        coordMatch.addVertex(7,new int[][]{{20,15},{20,14}});
        coordMatch.addVertex(8,new int[][]{{18,15},{18,14}});
        coordMatch.addVertex(9,new int[][]{{16,15},{16,14}});
        coordMatch.addVertex(10,new int[][]{{14,17},{14,16}});
        coordMatch.addVertex(11,new int[][]{{14,19},{14,18}});
        coordMatch.addVertex(12,new int[][]{{14,21},{14,20}});
        coordMatch.addVertex(13,new int[][]{{14,23},{14,22}});
        coordMatch.addVertex(14,new int[][]{{14,25},{14,24}});
        coordMatch.addVertex(15,new int[][]{{12,25},{12,24}});
        coordMatch.addVertex(16,new int[][]{{10,25},{10,24}});
        coordMatch.addVertex(17,new int[][]{{10,23},{10,22}});
        coordMatch.addVertex(18,new int[][]{{10,21},{10,20}});
        coordMatch.addVertex(19,new int[][]{{10,19},{10,18}});
        coordMatch.addVertex(20,new int[][]{{10,17},{10,16}});
        coordMatch.addVertex(21,new int[][]{{8,15},{8,14}});
        coordMatch.addVertex(22,new int[][]{{6,15},{6,14}});
        coordMatch.addVertex(23,new int[][]{{4,15},{4,14}});
        coordMatch.addVertex(24,new int[][]{{2,15},{2,14}});
        coordMatch.addVertex(25,new int[][]{{0,15},{0,14}});
        coordMatch.addVertex(26,new int[][]{{0,13},{0,12}});
        coordMatch.addVertex(27,new int[][]{{0,11},{0,10}});
        coordMatch.addVertex(28,new int[][]{{2,11},{2,10}});
        coordMatch.addVertex(29,new int[][]{{4,11},{4,10}});
        coordMatch.addVertex(30,new int[][]{{6,11},{6,10}});
        coordMatch.addVertex(31,new int[][]{{8,11},{8,10}});
        coordMatch.addVertex(32,new int[][]{{10,9},{10,8}});
        coordMatch.addVertex(33,new int[][]{{10,7},{10,6}});
        coordMatch.addVertex(34,new int[][]{{10,5},{10,4}});
        coordMatch.addVertex(35,new int[][]{{10,3},{10,2}});
        coordMatch.addVertex(36,new int[][]{{10,1},{10,0}});
        coordMatch.addVertex(37,new int[][]{{12,1},{12,0}});
        coordMatch.addVertex(38,new int[][]{{14,1},{14,0}});
        coordMatch.addVertex(39,new int[][]{{14,3},{14,2}});
        coordMatch.addVertex(40,new int[][]{{14,5},{14,4}});
        coordMatch.addVertex(41,new int[][]{{14,7},{14,6}});
        coordMatch.addVertex(42,new int[][]{{14,9},{14,8}});
        coordMatch.addVertex(43,new int[][]{{16,11},{16,10}});
        coordMatch.addVertex(44,new int[][]{{18,11},{18,10}});
        coordMatch.addVertex(45,new int[][]{{20,11},{20,10}});
        coordMatch.addVertex(46,new int[][]{{22,11},{22,10}});
        coordMatch.addVertex(47,new int[][]{{24,11},{24,10}});
        coordMatch.addVertex(48,new int[][]{{24,13},{24,12}});
        //Поля-дома
        coordMatch.addVertex(49,new int[][]{{2,13},{2,12}});
        coordMatch.addVertex(50,new int[][]{{4,13},{4,12}});
        coordMatch.addVertex(51,new int[][]{{6,13},{6,12}});
        coordMatch.addVertex(52,new int[][]{{8,13},{8,12}});
        coordMatch.addVertex(53,new int[][]{{12,23},{12,22}});
        coordMatch.addVertex(54,new int[][]{{12,21},{12,20}});
        coordMatch.addVertex(55,new int[][]{{12,19},{12,18}});
        coordMatch.addVertex(56,new int[][]{{12,17},{12,16}});
        coordMatch.addVertex(57,new int[][]{{12,3},{12,2}});
        coordMatch.addVertex(58,new int[][]{{12,5},{12,4}});
        coordMatch.addVertex(59,new int[][]{{12,7},{12,6}});
        coordMatch.addVertex(60,new int[][]{{12,9},{12,8}});
        coordMatch.addVertex(61,new int[][]{{22,13},{22,12}});
        coordMatch.addVertex(62,new int[][]{{20,13},{20,12}});
        coordMatch.addVertex(63,new int[][]{{18,13},{18,12}});
        coordMatch.addVertex(64,new int[][]{{16,13},{16,12}});

        /*а теперь связываем их*/
        //главная дорога
        for (int i = 5; i < 48; i++) {
            coordMatch.addEdge(i, i + 1);
        }
        //поля главной дороги с ответвлениями (поля-дома)
        coordMatch.addEdge(26, 49);//R
        coordMatch.addEdge(49, 50);
        coordMatch.addEdge(50, 51);
        coordMatch.addEdge(51, 52);
        coordMatch.addEdge(15, 53);//B
        coordMatch.addEdge(53, 54);
        coordMatch.addEdge(54, 55);
        coordMatch.addEdge(55, 56);
        coordMatch.addEdge(37, 57);//G
        coordMatch.addEdge(57, 58);
        coordMatch.addEdge(58, 59);
        coordMatch.addEdge(59, 60);
        coordMatch.addEdge(48, 61);//Y
        coordMatch.addEdge(61, 62);
        coordMatch.addEdge(62, 63);
        coordMatch.addEdge(63, 64);
        //стартовые поля с начальными позициями на главной дороге
        coordMatch.addEdge(1, 27);
        coordMatch.addEdge(2, 16);
        coordMatch.addEdge(3, 38);
        coordMatch.addEdge(4, 5);

    }

    public BoardHelper() {
        fillAllPositions();
    }

    public List<Integer> getNeighboringVertexes(Integer key){
        return coordMatch.getNeighboringVertexes(key);
    }

    public int[][] getCoordinateMatching(Integer key) {
        return coordMatch.getValue(key);
    }
}