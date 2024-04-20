package sudukosolver.play;

import sudukosolver.datalayer.Database;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PlayModel {
    private PlayView playView;

    public PlayModel(PlayView playView) {
        playView = this.playView;
    }

    boolean checkRowColumn(int row, int column, String[][] matrix) {
       // System.out.println("checkrowcol");
        if(matrix[row][column] == null){
            return true;
        }
        return false;
    }

    public boolean valid(int num, String[][] matrix, int row, int column) {
        Set<String> st = new HashSet<>();
        String[][] matrix1= Arrays.stream(matrix).map(String[]::clone).toArray(String[][]::new);
        matrix1[row][column] = String.valueOf(num);
        if(matrix.length==9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (matrix1[i][j] == null) {
                        continue;
                    }
                    if (!st.add(matrix1[i][j] + "row" + i) || !st.add(matrix1[i][j] + "column" + j) || !st.add(matrix1[i][j] + "3X3" + i / 3 + j / 3)) {
                        //System.out.println(st);
                        return false;
                    }
                }
            }
        }else {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if (matrix1[i][j] == null) {
                        continue;
                    }
                    if (!st.add(matrix1[i][j] + "row" + i) || !st.add(matrix1[i][j] + "column" + j)) {
                        //System.out.println(st);
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void addindex(int row, int column) {
        Database.getInstance().addIndex(row,column);
    }

    public boolean isIndexAvailable(int row, int column) {
        return Database.getInstance().isIndexAvailable(row,column);
    }
}
