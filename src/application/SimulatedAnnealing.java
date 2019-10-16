package application;

import java.util.*;

public class SimulatedAnnealing

{

	boolean[] filled;

	//for input board, empty squares are = 0

	public void SimulatedAnnealingSolve(int[][] board)

	{

		filled = new boolean[81];

		

		//determine which squares' values cannot be changed

		for(int i = 0; i < 9; i++)

		{

			for(int j = 0; j < 9; j++)

			{

				if(board[i][j] != 0)

					filled[i*9 + j] = true;

			}

		}

		

		//for every 3x3 square, calculate num remaining and fill them in randomly

		ArrayList<Integer> num = new ArrayList<Integer>();

		num = nums(num);

		

		for(int row = 0; row < 3; row++)

			for(int col = 0; col < 3; col++)

			{

				if(board[row][col] != 0)

					num.remove(new Integer(board[row][col]));

			}

		Collections.shuffle(num);

		for(int row = 0; row < 3; row++)

			for(int col = 0; col < 3; col++)

			{

				if(board[row][col] == 0)

					board[row][col] = num.remove(0);

			}

		

		num = nums(num);

		

		for(int row = 0; row < 3; row++)

			for(int col = 3; col < 6; col++)

			{

				if(board[row][col] != 0)

					num.remove(new Integer(board[row][col]));

			}

		Collections.shuffle(num);

		for(int row = 0; row < 3; row++)

			for(int col = 3; col < 6; col++)

			{

				if(board[row][col] == 0)

					board[row][col] = num.remove(0);

			}

		

		num = nums(num);

		

		for(int row = 0; row < 3; row++)

			for(int col = 6; col < 9; col++)

			{

				if(board[row][col] != 0)

					num.remove(new Integer(board[row][col]));

			}

		Collections.shuffle(num);

		for(int row = 0; row < 3; row++)

			for(int col = 6; col < 9; col++)

			{

				if(board[row][col] == 0)

					board[row][col] = num.remove(0);

			}

		

		num = nums(num);

		

		for(int row = 3; row < 6; row++)

			for(int col = 0; col < 3; col++)

			{

				if(board[row][col] != 0)

					num.remove(new Integer(board[row][col]));

			}

		Collections.shuffle(num);

		for(int row = 3; row < 6; row++)

			for(int col = 0; col < 3; col++)

			{

				if(board[row][col] == 0)

					board[row][col] = num.remove(0);

			}

		

		num = nums(num);

		

		for(int row = 3; row < 6; row++)

			for(int col = 3; col < 6; col++)

			{

				if(board[row][col] != 0)

					num.remove(new Integer(board[row][col]));

			}

		Collections.shuffle(num);

		for(int row = 3; row < 6; row++)

			for(int col = 3; col < 6; col++)

			{

				if(board[row][col] == 0)

					board[row][col] = num.remove(0);

			}

		

		num = nums(num);

		

		for(int row = 3; row < 6; row++)

			for(int col = 6; col < 9; col++)

			{

				if(board[row][col] != 0)

					num.remove(new Integer(board[row][col]));

			}

		Collections.shuffle(num);

		for(int row = 3; row < 6; row++)

			for(int col = 6; col < 9; col++)

			{

				if(board[row][col] == 0)

					board[row][col] = num.remove(0);

			}

		

		num = nums(num);

		

		for(int row = 6; row < 9; row++)

			for(int col = 0; col < 3; col++)

			{

				if(board[row][col] != 0)

					num.remove(new Integer(board[row][col]));

			}

		Collections.shuffle(num);

		for(int row = 6; row < 9; row++)

			for(int col = 0; col < 3; col++)

			{

				if(board[row][col] == 0)

					board[row][col] = num.remove(0);

			}

		

		num = nums(num);

		

		for(int row = 6; row < 9; row++)

			for(int col = 3; col < 6; col++)

			{

				if(board[row][col] != 0)

					num.remove(new Integer(board[row][col]));

			}

		Collections.shuffle(num);

		for(int row = 6; row < 9; row++)

			for(int col = 3; col < 6; col++)

			{

				if(board[row][col] == 0)

					board[row][col] = num.remove(0);

			}

		

		num = nums(num);

		

		for(int row = 6; row < 9; row++)

			for(int col = 6; col < 9; col++)

			{

				if(board[row][col] != 0)

					num.remove(new Integer(board[row][col]));

			}

		Collections.shuffle(num);

		for(int row = 6; row < 9; row++)

			for(int col = 6; col < 9; col++)

			{

				if(board[row][col] == 0)

					board[row][col] = num.remove(0);

			}

		/*

		for(int i = 0; i < 9; i++)

		{

			for(int j = 0; j < 9; j++)

			{

				System.out.print(board[i][j] + " ");

			}

			System.out.println();

		}

		*/

	/*	for( int row = 0; row < 9; row++ ){

	    	  System.out.println();

	    	  if(row==0){System.out.println("\n -----------------------");}

	         for( int col = 0; col < 9; col++ )

	            if( board[row][col] != 0 ){

	            	if(col ==0) {System.out.print("| ");}

	            	System.out.print(board[row][col] + " ");

	            	if(col==2 | col == 5 | col ==8){System.out.print("| ");}

	            }

	            else{

	            	if(col ==0) {System.out.print("| ");}

	            	System.out.print("-" + " ");

	            	if(col==2 | col == 5 | col ==8){System.out.print("| ");}

	            }

	         if(row==2 | row == 5 | row ==8){System.out.print("\n -----------------------");}

	      }

	      System.out.println();*/

	      

		

		 solverec(board, .8, 0);
		
		
	      //return a;
	

	}

	
	
	// cooling constant = .7

	public int[][] solverec(int[][] board, double temperature, int iteration)

	{

		int errstart = errnum(board);

		int square = (int)(Math.random()*9);

		int xOffset = 0;

		int yOffset = 0;

		

		if(errstart == 0)

		{

			System.out.println("Solution found!");
				for( int row = 0; row < 9; row++ ){

	    	  System.out.println();

	    	  if(row==0){System.out.println("\n -----------------------");}

	         for( int col = 0; col < 9; col++ )

	            if( board[row][col] != 0 ){

	            	if(col ==0) {System.out.print("| ");}

	            	System.out.print(board[row][col] + " ");

	            	if(col==2 | col == 5 | col ==8){System.out.print("| ");}

	            }

	            else{

	            	if(col ==0) {System.out.print("| ");}

	            	System.out.print("-" + " ");

	            	if(col==2 | col == 5 | col ==8){System.out.print("| ");}

	            }

	         if(row==2 | row == 5 | row ==8){System.out.print("\n -----------------------");}

	      }

	      System.out.println();

			return board;

		}			

		

		switch(square)

		{

			case 0:

				xOffset = 0;

				yOffset = 0;

				break;

			case 1:

				xOffset = 0;

				yOffset = 3;

				break;

			case 2:

				xOffset = 0;

				yOffset = 6;

				break;

			case 3:

				xOffset = 3;

				yOffset = 0;

				break;

			case 4:

				xOffset = 3;

				yOffset = 3;

				break;

			case 5:

				xOffset = 3;

				yOffset = 6;

				break;

			case 6:

				xOffset = 6;

				yOffset = 0;

				break;

			case 7:

				xOffset = 6;

				yOffset = 3;

				break;

			case 8:

				xOffset = 6;

				yOffset = 6;

				break;

		}

		

		int x1, y1, x2, y2;		

		do {

			x1 = (int)(Math.random()*3);

			y1 = (int)(Math.random()*3);

			x2 = (int)(Math.random()*3);

			y2 = (int)(Math.random()*3);

		} while(filled[(xOffset+x1)*9+(yOffset+y1)] || filled[(xOffset+x2)*9+(yOffset+y2)]);

		

		System.out.println("x1: "+(xOffset+x1)+" y1: "+(yOffset+y1));

		System.out.println("x2: "+(xOffset+x2)+" y2: "+(yOffset+y2));

		System.out.println("iteration number: "+ iteration);

		iteration++;

		

		int[][] board1 = new int[9][9];

		multiArrayCopy(board, board1);

		board1[xOffset+x1][yOffset+y1] = board[xOffset+x2][yOffset+y2];

		board1[xOffset+x2][yOffset+y2] = board[xOffset+x1][yOffset+y1];

		

		int errnew = errnum(board1);

		

		if(errnew < errstart)

			multiArrayCopy(board1, board);

		else

		{

			double probability = Math.exp((errstart - errnew)/temperature);

			double random = Math.random();

			if(random <= probability)

				multiArrayCopy(board1, board);

		}

		/*

		for(int i = 0; i < 9; i++) //print out the new board

		{

			for(int j = 0; j < 9; j++)

			{

				System.out.print(board[i][j] + " ");

			}

			System.out.println();

		}

		System.out.println();

		*/

	/*	for( int row = 0; row < 9; row++ ){

	    	  System.out.println();

	    	  if(row==0){System.out.println("\n -----------------------");}

	         for( int col = 0; col < 9; col++ )

	            if( board[row][col] != 0 ){

	            	if(col ==0) {System.out.print("| ");}

	            	System.out.print(board[row][col] + " ");

	            	if(col==2 | col == 5 | col ==8){System.out.print("| ");}

	            }

	            else{

	            	if(col ==0) {System.out.print("| ");}

	            	System.out.print("-" + " ");

	            	if(col==2 | col == 5 | col ==8){System.out.print("| ");}

	            }

	         if(row==2 | row == 5 | row ==8){System.out.print("\n -----------------------");}

	      }

	      System.out.println();*/

	      

	      

		

		if(iteration > 4450) //added. 20000 before, 4450

			return board;

		

		double nextTemperature = updateTemp(temperature);

		int[][] b= solverec(board, nextTemperature, iteration);
		return b;

	}

	public int errnum(int[][] board)

	{

		int num1 = 0;

		HashMap<Integer, Integer> num = new HashMap<Integer, Integer>();

		

		//count thru rows

		for(int i = 0; i < 9; i++)

		{

			for(int j = 0; j < 9; j++)

			{

				if(num.get(board[i][j]) == null)

					num.put(board[i][j], 1);

				else

					num.put(board[i][j], num.get(board[i][j]) + 1);

			}



			for(int j = 1; j <= 9; j++)

			{

				if(num.get(j) != null && num.get(j) > 1)

				{

					num1 += num.get(j) - 1;

				}

				num.put(j, null); //reset map for next row

			}

		}

		//count thru columns

		for(int col = 0; col < 9; col++)

		{

			for(int row = 0; row < 9; row++)

			{

				if(num.get(board[row][col]) == null)

					num.put(board[row][col], 1);

				else

					num.put(board[row][col], num.get(board[row][col]) + 1);

			}

			

			for(int j = 1; j <= 9; j++)

			{

				if(num.get(j) != null && num.get(j) > 1)

				{

					num1 += num.get(j) - 1;

				}

				num.put(j, null); //reset map for next column

			}

		}

		return num1;

	}

	

	public ArrayList<Integer> nums(ArrayList<Integer> num)

	{

		num.clear();

		for(int i = 1; i <= 9; i++)

			num.add(i);

		

		return num;

	}


	public void multiArrayCopy(int[][] source, int[][] destination)

	{

		for (int a=0;a<source.length;a++)

		{

			System.arraycopy(source[a],0,destination[a],0,source[a].length);

		}

	}

	

	public double updateTemp(double temperature)

	{

		temperature *= .8; //or .7 or .3

		return temperature;

	}

}
