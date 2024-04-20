package sudukosolver.play;

import sudukosolver.startgame.GameView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PlayView {
    private PlayModel playModel;

    static int count = 0;

    public PlayView() {
        playModel = new PlayModel(this);
    }

    public void letsPlay(String[][] matrix) {
        try {
            if (count == 43) {
                System.out.println("You won !......");
                new GameView().display(matrix);
            }
            Scanner sc = new Scanner(System.in);
            System.out.println("**********************");
            System.out.println("Enter index row : ");
            int row = sc.nextInt();
            System.out.println("Enter column : ");
            int column = sc.nextInt();
            if (row >= 0 && row < 9) {
//            System.out.println("row");
                if (column >= 0 && column < 9) {
//                System.out.println("col");
                    if (playModel.checkRowColumn(row, column, matrix)) {
//                System.out.println("nu");
//                sc.nextLine();
                        System.out.println("Enter the number : ");
                        int num = sc.nextInt();
                        if (num > 0 && num <= 9) {
                            if (playModel.valid(num, matrix, row, column)) {
                                matrix[row][column] = String.valueOf(num);
                                playModel.addindex(row, column);
                                new GameView().display(matrix);
                                count++;
                                if (toBeContinue(sc, matrix)) {
                                    letsPlay(matrix);
                                } else {
                                    System.out.println("Exiting......");

                                    System.exit(0);
                                }
                            } else {
                                System.out.println("Number is already exist!....");
                                new GameView().display(matrix);
                                letsPlay(matrix);
                            }

                        } else {
                            System.out.println("Invalid number (number range should be 1 ..9)");
                            letsPlay(matrix);
                        }

                    } else {
                        System.out.println("Invalid row and column selected !.... " + "\nAlready value is there....");
                        letsPlay(matrix);
                    }
                } else {
                    System.out.println("Invalid column selected!...");
                    letsPlay(matrix);
                }
            } else {
                System.out.println("Invalid row Selected!... ");
                letsPlay(matrix);
            }
        } catch (InputMismatchException e) {
            System.out.println("Input Mismatch...");
            letsPlay(matrix);
        }
    }

    private boolean toBeContinue(Scanner sc, String[][] matrix) {
        System.out.println("Enter yes - > continue \nchange - > Change the value \nNo - > Exit ");
        String choice = sc.next();
        if (choice.equalsIgnoreCase("yes")) {
            letsPlay(matrix);
        } else if (choice.equalsIgnoreCase("change")) {
            changeValue(sc, matrix);
        } else if (choice.equalsIgnoreCase("No")) {
            return false;
        } else {
            System.out.println("Invalid selection...");
            toBeContinue(sc, matrix);
        }
        return false;
    }

    private void changeValue(Scanner sc, String[][] matrix) {
        try {

            System.out.println("Enter row : ");
            int row = sc.nextInt();
            System.out.println("Enter the column : ");
            int column = sc.nextInt();
            if (row >= 0 && row < 9) {
                if (column >= 0 && column < 9) {
                    if (playModel.isIndexAvailable(row, column)) {
                        System.out.println("Enter new number : ");
                        int num = sc.nextInt();
                        if (num > 0 && num <= 9) {
                            if (playModel.valid(num, matrix, row, column)) {
                                matrix[row][column] = String.valueOf(num);
                                new GameView().display(matrix);
                                toBeContinue(sc, matrix);
                            } else {
                                System.out.println("Number already exist...");
                                toBeContinue(sc, matrix);
                            }
                        } else {
                            System.out.println("Invalid number (number range should be 1 ..9)");
                            changeValue(sc, matrix);
                        }
                    } else {
                        System.out.println("System value cannot change...");
                        System.out.println("*******************************");
                        toBeContinue(sc, matrix);
                    }


                } else {
                    System.out.println("Invalid column...");
                    changeValue(sc, matrix);
                }

            } else {
                System.out.println("Invalid row ...");
                changeValue(sc, matrix);
            }
        } catch (InputMismatchException e) {
            System.out.println("Input mismatch...");
            sc.nextLine();
            changeValue(sc, matrix);

        }
    }
}
