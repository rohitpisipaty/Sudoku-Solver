package application;

import java.util.LinkedList;

public class MRV {

	// the variable that counts the number of Iterations

	public int itr=0;

	// the object that contains constraints

	Constraints obj = new Constraints();


	// constructor

	public MRV(){

	}



	// the principal Method 

	public int[][] MRVSolve(int[][] sudoku){

		check(sudoku);

		return sudoku;

	}





	// Method that returns a list of possible values for a cell 

	public LinkedList<Integer> listValues(int sudoku[][], int x,int y){

		LinkedList<Integer> list = new LinkedList<Integer>();



		for(int z=1;z<=9;z++){

			if(!obj.lineCheck(sudoku, x, z) && !obj.columnCheck(sudoku, y, z) && !obj.blockCheck(sudoku, x, y, z) ){

				list.add(z);

			}

		}

		return list;

	}





	// Method that iterate our sudoku

	public  boolean check(int sudoku[][]){

		int x=0,y=0;

		int min=10;

		int tmp;

		for (int z = 0; z < 9; z++) {

			for (int l = 0; l < 9; l++) {

				itr++;

				if(sudoku[z][l]==0){

					tmp=listValues(sudoku, z, l).size();

					if(tmp < min){

						min=tmp;

						x=z;y=l;

					}

				}

			}

		}

		if(min==10){

			return true;

		}

		for(int z : listValues(sudoku,x,y)){

			itr++;

			sudoku[x][y] = z;

			if( check(sudoku) ){

				return true;

			}

			else 

				sudoku[x][y] = 0;

		}

		sudoku[x][y] = 0;

		return false;

	}



}

