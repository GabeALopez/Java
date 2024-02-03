public class Sudoku {

    public Sudoku() {

    }

    /**
     * This method displays the current Sudoku array
     *
     * @param arr
     */
    public void display(int[][] arr) {

        int row = 9;
        int column = 9;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {

                if ((j % 3 == 0) && (j != 0)) {

                    System.out.print(" | ");

                }

                System.out.print(arr[i][j] + " ");

            }

            if ((i + 1) % 3 == 0) {

                System.out.println();
                System.out.print("-------+--------+------");

            }

            System.out.println();


        }

        return;
    }

    /**
     * This determines whether the game has been solved
     *
     * @param arr
     * @return true if there are no "0"'s left, otherwise return false
     */
    public boolean isSolved(int[][] arr) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (arr[i][j] == 0) {
                    return false;
                }

            }
        }

        return true;
    }

    /**
     * This method determines whether any input values are valid
     *
     * @param inputVal
     * @return true if the value the player inputs is a valid number, otherwise return false
     */
    public boolean isValueValid(String inputVal) {

        if (inputVal != null) {

            try {

                int valHold = Integer.parseInt(inputVal);

                if (1 <= valHold && valHold <= 9) {

                    return true;

                }


            } catch (NumberFormatException nfe) {
                return false;
            }

        }

        return false;
    }

    /**
     * This method determines if the row,column pair the player inputs is valid
     *
     * @param row
     * @param column
     * @param arr
     * @return true is the row,column pair is valid, otherwise return false
     */
    public boolean isRowColumnValid(int row, int column, int[][] arr) {


        if (arr[row - 1][column - 1] == 0) {
            return true;

        } else {
            return false;
        }


    }

    /**
     * This method determines whether the entry the player inputted was correct
     *
     * @param row
     * @param column
     * @param choosenNum
     * @param arr
     * @return true if the entry is correct, otherwise return false
     */
    public boolean isEntryCorrect(int row, int column, int choosenNum, int[][] arr) {

        //variable initialization
        int columnSum = 0;
        int rowSum = 0;
        int quadrantSum = 0;

        //Add all digits in column and then add to the entry from the player
        for (int i = 0; i < 9; i++) {

            columnSum += arr[i][column - 1];

        }

        columnSum += choosenNum;

        //Add all digits in column and then add to the entry from the player
        for (int i = 0; i < 9; i++) {

            rowSum += arr[row - 1][i];

        }

        rowSum += choosenNum;

        /*
            Starting from the top left of the sudoku puzzle,
            the if statements are to check which quadrant the player is in.

            This is each quadrant's number:

            1|2|3
            4|5|6
            7|8|9
        */

        //Check for quadrants 1, 4, or 7 then add all numbers in quadrant and then add player entry
        if (1 <= row && row <= 3) {

            //Quadrant 1
            if (1 <= column && column <= 3) {

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {

                        quadrantSum += arr[i][j];

                    }

                }

                quadrantSum += choosenNum;

                //Quadrant 4
            } else if (4 <= column && column <= 6) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 3; j < 6; j++) {

                        quadrantSum += arr[i][j];

                    }

                }

                quadrantSum += choosenNum;

                //Quadrant 7
            } else {

                for (int i = 0; i < 3; i++) {
                    for (int j = 6; j < 9; j++) {

                        quadrantSum += arr[i][j];

                    }
                }

                quadrantSum += choosenNum;

            }

            //Check for quadrants 2, 5, or 8 then add all numbers in quadrant and then add player entry
        } else if (4 <= row && row <= 6) {
            //Quadrant 2
            if (1 <= column && column <= 3) {

                for (int i = 3; i < 6; i++) {
                    for (int j = 0; j < 3; j++) {

                        quadrantSum += arr[i][j];

                    }

                }

                quadrantSum += choosenNum;

                //Quadrant 5
            } else if (4 <= column && column <= 6) {

                for (int i = 3; i < 6; i++) {
                    for (int j = 3; j < 6; j++) {

                        quadrantSum += arr[i][j];

                    }

                }

                quadrantSum += choosenNum;

                //Quadrant 8
            } else {

                for (int i = 3; i < 6; i++) {
                    for (int j = 6; j < 9; j++) {

                        quadrantSum += arr[i][j];

                    }

                }

                quadrantSum += choosenNum;

            }

            //Check for Quadrants 3, 6, or 9 then add all numbers in quadrant and then add player entry
        } else if (7 <= row && row <= 9) {
            //Quadrant 3
            if (1 <= column && column <= 3) {

                for (int i = 6; i < 9; i++) {
                    for (int j = 0; j < 3; j++) {

                        quadrantSum += arr[i][j];

                    }
                }

                //Quadrant 6
            } else if (4 <= column && column <= 6) {

                for (int i = 6; i < 9; i++) {
                    for (int j = 3; j < 6; j++) {

                        quadrantSum += arr[i][j];

                    }
                }

                //Quadrant 9
            } else {

                for (int i = 6; i < 9; i++) {
                    for (int j = 6; j < 9; j++) {

                        quadrantSum += arr[i][j];

                    }
                }

            }

        }


        //If column and row correct or the quadrant is correct return true
        if (((columnSum == 45) && (rowSum == 45)) || (quadrantSum == 45)) {

            return true;

        }

        return false;
    }


}
