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
    public boolean isSolved(){ return true;}
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
    // public boolean isRowColumnValid(){ return true;}
    public boolean isEntryCorrect(){ return true;}


}
