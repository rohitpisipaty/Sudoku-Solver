package application;


// solving the sudoku using the recursive backtracking algorithm 

public class Backtracking {

	// the variable that counts the number of Iterations

	public int itr = 0;

	// the object that contains constraints

	public Constraints obj = new Constraints();



	// constructor

	public Backtracking(){

	}

	
	// the principal Method 

	




	// Method that iterate our sudoku in a recusive way

	public  boolean check(int sudoku[][],int pos){

		itr++;

		if(pos == 9*9){

			return true;

		}

		

		int x = pos / 9;

		int y = pos % 9;

		

		if( sudoku[x][y] != 0 ){

			return check(sudoku, pos+1);

		}

		

		for(int z=1;z<=9;z++){

			if(!obj.lineCheck(sudoku, x, z) && !obj.columnCheck(sudoku, y, z) && !obj.blockCheck(sudoku, x, y, z) ){

				sudoku[x][y] = z;

				if( check(sudoku, pos+1) ){

					return true;

				}

			}

		}



		sudoku[x][y] = 0;

		return false;

	}

	
	public int[][] backtrackingSimple(int[][] sudoku){

		int[][] sudokuResolu = sudoku;

		check(sudokuResolu, 0);

		return sudokuResolu;

	}

}
