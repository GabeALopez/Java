import java.util.Scanner;

/**
 * @author : Gabriel Lopez
 * Student Number : 0683
 * @date : 1/29/24
 * This program plays a game of Sudoku where player has to find the correct missing values
 */

public class Driver {


    public static void main(String[] args) {

        //Array initialization
        int[][] sudokuArr = {
                {5, 3, 4, 0, 7, 8, 9, 1, 2},
                {6, 7, 0, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 0, 7},
                {8, 0, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 0, 3, 7, 9, 0},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 0, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 0, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };


        //Variable initialization
        Scanner input = new Scanner(System.in);
        String strInput = "";
        String inputValue = "";

        int row = 0;
        int column = 0;

        boolean boolRow = false;
        boolean boolColumn = false;
        boolean boolInputValue = false;

        Sudoku sudoku = new Sudoku();

        //Main loop
        while (true) {

            sudoku.display(sudokuArr);

            System.out.println("Continue Playing (Y/N)?");

            strInput = input.next();

            //Check if input val is Y or N
            if (strInput != null) {

                if (strInput.equals("N")) {
                    break;
                }
                if (strInput.equals("Y")) {

                    //Ask for row, column, and entry

                    System.out.println("Enter row:");
                    row = input.nextInt();

                    System.out.println("Enter column:");
                    column = input.nextInt();

                    System.out.println("Enter value:");
                    inputValue = input.next();

                    //Verify row, column, and entry
                    boolRow = sudoku.isValueValid(Integer.toString(row));
                    boolColumn = sudoku.isValueValid(Integer.toString((column)));
                    boolInputValue = sudoku.isValueValid(inputValue);

                    //Check if entry is valid and solves the row,column pair
                    if (boolRow && boolColumn && boolInputValue) {

                        if (sudoku.isRowColumnValid(row, column, sudokuArr)) {

                            if (sudoku.isEntryCorrect(row, column, Integer.parseInt(inputValue), sudokuArr)) {

                                System.out.println("Correct!");

                                sudokuArr[row - 1][column - 1] = Integer.parseInt(inputValue);

                                //Check if the full game is solved
                                if (sudoku.isSolved(sudokuArr)) {

                                    System.out.println("Congratulations, You solved it!");
                                    break;

                                }


                            } else {

                                System.out.println("NOT Correct!");

                            }

                        } else {
                            System.out.println("Wrong entry");
                        }


                    } else {
                        System.out.println("Invalid input");

                    }


                } else {
                    System.out.println("Invalid input");
                    System.out.println("Continue Playing (Y/N)?");

                }

            } else {
                System.out.println("Invalid input");
            }


        }

    }
}
