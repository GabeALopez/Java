public class Sudoku {

    public Sudoku(){

    }
    public void display(int[][] arr){

        int row = 9;
        int column = 9;

       for(int i = 0; i < row; i++) {
           for(int j = 0; j < column;j++){

                   if((j % 3 == 0) && (j != 0)){

                       System.out.print(" | ");

                   }

               System.out.print(arr[i][j] + " ");

           }

           if((i+1) % 3 == 0){

               System.out.println();
               System.out.print("-------+--------+------");

           }

           System.out.println();


       }

        return;
    }
    public boolean isSolved(int[][] arr){

       for (int i = 0; i < 9; i++){
           for (int j = 0; j < 9; j++){

               if (arr[i][j] == 0){
                  return false;
               }

           }
       }

        return true;
    }
    public boolean isValueValid(String inputVal){

        if(inputVal != null){

           try {

               int valHold = Integer.parseInt(inputVal);

               if(1 <= valHold && valHold <= 9){

                  return true;

               }


           }catch (NumberFormatException nfe){
               return false;
           }

        }

        return false;
    }
    public boolean isRowColumnValid(int row, int column, int[][] arr){

        if(isValueValid(Integer.toString(row)) && isValueValid(Integer.toString(column))){

            return arr[row][column] == 0;

        }

        return false;
    }
    public boolean isEntryCorrect(int row, int column, int choosenNum, int[][]arr){

       int rowSum = 0;
       int columnSum = 0;
       int quadrantSum = 0;

       //check for row
       for(int i = 0; i < 9; i++){

           rowSum += arr[i][column];

       }

       rowSum += choosenNum;

       for (int i = 0; i < 9; i++){

          columnSum += arr[row][i];

       }

       columnSum += choosenNum;

        /*
            Starting from the top left of the sudoku puzzle, the if statements are to check which quadrant the player asked.

            This is each quadrant's number:

            1|2|3
            4|5|6
            7|8|9
        */

        //Deals with quadrants 1, 4, 7
        if(1 <= row && row <= 3){

            //Quadrant 1
           if(1 <= column && column <= 3){

               for (int i = 0; i < 3; i++){
                   for (int j = 0; j < 3; j++){

                      quadrantSum += arr[i][j];

                   }

               }

               //Quadrant 4
           } else if (4 <= column && column <= 6) {
               for (int i = 0; i < 3; i++){
                   for (int j = 3; j < 6; j++){

                      quadrantSum += arr[i][j];

                   }

               }

               //Quadrant 7
           } else {

              for (int i = 0; i < 3; i++){
                 for (int j = 6; j < 9; j++){

                    quadrantSum += arr[i][j];

                 }
              }

           }

           //Deals with quadrants 2, 5, and 8
        } else if (4 <= row && row <= 6) {
            //Quadrant 2
            if (1 <= column && column <= 3){

               for (int i = 3; i < 6; i++){
                   for (int j = 0; j < 3; j++){

                       quadrantSum += arr[i][j];

                   }

               }

               //Quadrant 5
            } else if (4 <= column && column <= 6){

                for (int i = 3; i < 6; i++){
                    for (int j = 3; j < 6; j++){

                        quadrantSum += arr[i][j];

                    }

                }

                //Quadrant 8
            } else {

                for (int i = 3; i < 6; i++){
                    for (int j = 6; j < 9; j++){

                        quadrantSum += arr[i][j];

                    }

                }

            }

            //Deals with Quadrants 3, 6, and 9
        } else if (7 <= row && row <= 9){
            //Quadrant 3
            if (1 <= column && column <= 3){

               for (int i = 6; i < 9; i++){
                   for (int j = 0; j < 3; j++){

                      quadrantSum += arr[i][j];

                   }
               }

               //Quadrant 6
            } else if (4 <= column && column <= 6) {

                for (int i = 6; i < 9; i++){
                    for (int j = 3; j < 6; j++){

                        quadrantSum += arr[i][j];

                    }
                }

                //Quadrant 9
            } else {

                for (int i = 6; i < 9; i++){
                    for (int j = 6; j < 9; j++){

                        quadrantSum += arr[i][j];

                    }
                }

            }

        }
            


        if ((rowSum == 45) && (columnSum == 45) && (quadrantSum == 45)){

          return true;

       }

        return false;
    }


}
