package sudukosolver.startgame;

import sudukosolver.SudokuApp;
import sudukosolver.play.PlayView;

import java.util.Scanner;

public class GameView {
private GameModel gameModel;
private static String[][]matrix;
public GameView(){
    gameModel=new GameModel(this);
}

    public void init() {
        System.out.println( "App Name : "+SudokuApp.getInstance().getName()+
                "Version : "+SudokuApp.getInstance().getAppVersion());
        letsCreate();
    }

    private void letsCreate() {
       // String[][] matrix = gameModel.initialize(9);
      //  String[][] matrix = gameModel.initialize(3);
         matrix = gameModel.initialize(4);
        display(matrix);
        new PlayView().letsPlay(matrix);
    }
    public void display(String [][]matrix){
        gameModel.display(matrix);
    }

    public void sendAlart(String s) {
        System.out.println(s);
    }

    public int getGameWon() {
   return gameModel.getGameWon(matrix);
    }
}
