package sudukosolver.startgame;

public class GameModel {
    private GameView gameView;
    GameModel(GameView gameView){
        this.gameView=gameView;
    }

    public String[][] initialize(int size) {
        String[][]matrix=new String[size][size];
        matrix[0][0]="9";
        matrix[1][0]="4";
        matrix[2][0]="8";
        matrix[5][0]="7";
        matrix[7][0]="3";
        matrix[0][1]="2";
        matrix[1][1]="7";
        matrix[3][1]="8";
        matrix[5][1]="3";
        matrix[7][1]="4";
        matrix[1][2]="3";
        matrix[3][2]="5";
        matrix[4][2]="9";
        matrix[8][2]="7";
        matrix[0][3]="3";
        matrix[1][3]="8";
        matrix[2][3]="7";
        matrix[8][3]="2";
        matrix[0][4]="4";
        matrix[5][4]="6";
        matrix[8][4]="5";
        matrix[1][5]="1";
        matrix[2][5]="6";
        matrix[3][5]="9";
        matrix[8][5]="4";
        matrix[3][6]="2";
        matrix[4][6]="4";
        matrix[5][6]="8";
        matrix[8][6]="3";
        matrix[0][7]="8";
        matrix[2][7]="3";
        matrix[4][7]="7";
        matrix[8][7]="6";
        matrix[1][8]="5";
        matrix[2][8]="4";
        matrix[5][8]="9";
        matrix[6][8]="2";
        matrix[7][8]="1";
        return matrix;
    }

    public void display(String[][]matrix) {

        System.out.println("___________________");

        for (int i=0;i<9;i++){
            System.out.print("|");
            for (int j=0;j<9;j++){
                if(matrix[i][j]==null){
                    System.out.print(" ");
                }else {
                    System.out.print(matrix[i][j]);
                }
                //System.out.print("_");
                if(j<8){
                    System.out.print("|");
                }
            }
            System.out.println("|");
        }
        System.out.print("-------------------");
        System.out.println();
        gameView.sendAlart("--- Let's Play ---");
    }
}
