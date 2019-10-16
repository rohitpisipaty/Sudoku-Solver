package application;



import java.util.LinkedList;



// solving the sudoku using the the forward checking algorithm 

public class ForwardChecking {



	// the variable that counts the number of Iterations

	public int itr = 0;

	

	// the object that contains constraints

	public Constraints obj = new Constraints();



	// constructor

	public ForwardChecking(){

	}

		

	

	// the principal Method 

	public int[][] forwardChecking(int[][] sudoku){

		int[][] sudokuResolu = sudoku;

		check(sudokuResolu, 0);

		return sudokuResolu;

	}





	// Method that returns a list of possible values for a cell 

    public LinkedList<Integer> listValues(int sudoku[][], int i,int j){

            LinkedList<Integer> list = new LinkedList<Integer>();

            for(int k=1;k<=9;k++){

				if(!obj.lineCheck(sudoku, i, k) && !obj.columnCheck(sudoku, j, k) && !obj.blockCheck(sudoku, i, j, k) ){

					list.add(k);

				}

            }

            return list;

        }

    

	// Method that iterate our sudoku in a recusive way

	public  boolean check(int sudoku[][],int pos){

             

		if(pos == 9*9){

			return true;

		}

		int i = pos / 9;

		int j = pos % 9;

		

		if( sudoku[i][j] != 0 ){

                       

			return check(sudoku, pos+1);

		}



		for(int k : listValues(sudoku,i,j)){

            itr++;

			sudoku[i][j] = k;

				if( check(sudoku, pos+1) ){

					return true;

				}

		}

		sudoku[i][j] = 0;

		return false;

	}





}

