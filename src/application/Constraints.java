package application;

//  class that contains all the constraints to respect in our sudoku

public class Constraints {


	// Method for testing if a value exsist in the line "x"

	





	// Method for testing if a value exsist in the column "y"

	public  boolean columnCheck(int sudoku[][], int y, int num) {

		for (int x = 0; x < sudoku.length; x++) {

			if (sudoku[x][y] == num) {

				return true;

			}

		}

		return false;

	}



	// Method for testing if a value exsist in the bloc "x,y"

	public  boolean blockCheck(int sudoku[][], int x, int y, int num) {

		int sudokuBloc = (int) Math.sqrt(sudoku.length);

		int iBloc = sudokuBloc * (x / sudokuBloc);

		int jBloc = sudokuBloc * (y / sudokuBloc);



		for (x = iBloc; x < iBloc + sudokuBloc; x++) {

			for (y = jBloc; y < jBloc + sudokuBloc; y++) {

				if (sudoku[x][y] == num) {

					return true;

				}

			}

		}

		return false;



	}

	public  boolean lineCheck(int[][] sudoku, int x, int num) {

		for (int y = 0; y < sudoku[x].length; y++) {

			if (sudoku[x][y] == num) {

				return true;

			}

		}

		return false;

	}

}
