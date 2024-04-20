package sudukosolver;

import sudukosolver.startgame.GameView;

public class SudokuApp{
    private String appVersion="0.0.1";
    private String name ="--- Sudoku Game ---";
    private static SudokuApp sudokuApp;
    public static SudokuApp getInstance(){
        if(sudokuApp==null){
            sudokuApp=new SudokuApp();
        }
        return sudokuApp;
    }
    public void create(){
        GameView gameView=new GameView();
        gameView.init();
    }

    public String getAppVersion() {
        return appVersion;
    }

    public String getName() {
        return name;
    }
}
