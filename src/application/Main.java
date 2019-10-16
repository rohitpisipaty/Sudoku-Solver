package application;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application
{
UserInterface UI = new UserInterface();
Backtracking BTObj = new Backtracking();
ForwardChecking FCObj = new ForwardChecking();
SimulatedAnnealing SAObj = new SimulatedAnnealing();
MRV MRVObj = new MRV();
//AC3Solver AC3Obj=new AC3Solver();

// choosing sudoko files from file system
public int[][] filesudoko(int[][] sudoku)
{
 JFileChooser fs = new JFileChooser(new File("./src/sudokuFiles"));
 fs.setDialogTitle("Select the problem file");
 int result = fs.showOpenDialog(null);
 if(result == JFileChooser.APPROVE_OPTION)
 {
  try 
  {
	File fi = fs.getSelectedFile();
	BufferedReader br = new BufferedReader(new FileReader(fi.getPath()));
	StringBuilder sb= new StringBuilder();
	String puzzlefile=br.readLine();
	System.out.println(puzzlefile);
	for(int i = 0; i < puzzlefile.length(); i++)
	{
	 char c = puzzlefile.charAt(i);
	 if(c == '.')
	  c = '0';
	 sudoku[i/9][i%9] = Character.digit(c, 10);				
	 }
   }
  catch (Exception ex)
  {
	System.out.println("error in selecting file");
	JOptionPane.showMessageDialog(null, ex.getMessage());
  }
 }
 return sudoku;
}
// label hiding
public void labelHide()
{
UI.itr.setVisible(false);
UI.exec.setVisible(false);
}

// showing labels
public void labelShow()
{
UI.itr.setVisible(true);
UI.exec.setVisible(true);
}

@Override
public void start(Stage primaryStage)
{
inactivate();
  // handling button click
UI.fileLoader.setOnAction(e -> {
filesudoko(initialsudoko);
UI.initialiser(initialsudoko);
activates();
});


// handling initialization button click
UI.initialisation.setOnAction(e -> {
labelHide();
activates();
reintialiser();
UI.initialisation.setText("reinitialiser");
});

// handling the backtracking button click
UI.backTracking.setOnAction(e -> {
labelShow();
long start = System.currentTimeMillis();
int[][] sudokuResolu = BTObj.backtrackingSimple(initialsudoko);
UI.res(sudokuResolu);
long time = System.currentTimeMillis() - start;
UI.itr.setText(" itr :  " + BTObj.itr);
UI.exec.setText("Execution Time : " + time + " MilliS");
});
// handling simulatedAnnealing button click
UI.simulatedAnnealing.setOnAction(e -> {
labelShow();
JOptionPane.showMessageDialog(null,"Go to console for output");
System.out.println("Set the problem file path for Simulated Annealing in line 106 of Main.java");
FileReader fileReader = null;
try 
{
 fileReader = new FileReader("C:\\Users\\rohit\\Desktop\\e1.txt");
}
catch (FileNotFoundException e1) 
{
 e1.printStackTrace();
}
int[][] board = new int[9][9];
BufferedReader br = new BufferedReader(fileReader);
StringBuilder sb= new StringBuilder();
String puzzlefile = null;
try 
{
 puzzlefile = br.readLine();
}
catch (IOException e1) 
{
 e1.printStackTrace();
}
System.out.println(puzzlefile);
for(int i = 0; i < puzzlefile.length(); i++)
{
 char c = puzzlefile.charAt(i);
 if(c == '.')
  c = '0';
 board[i/9][i%9] = Character.digit(c, 10);				
}
long start = System.currentTimeMillis();
SAObj.SimulatedAnnealingSolve(board);
long time = System.currentTimeMillis() - start;
UI.exec.setText("Execution Time : " + time + " MilliS");
});

// handling AC3 button click
UI.AC3.setOnAction(e -> {
labelShow();
JOptionPane.showMessageDialog(null,"Go to console for output");
System.out.println("Set the problem file path for AC3 in line 146 of Main.java");
FileReader fileReader = null;
try 
{
 fileReader = new FileReader("C:\\Users\\rohit\\Desktop\\e1.txt");
}
catch (FileNotFoundException e1) 
{
 e1.printStackTrace();
}
int[][] board = new int[9][9];
BufferedReader br = new BufferedReader(fileReader);
StringBuilder sb= new StringBuilder();
SolverInterface s;
String puzzlefile = null;
try 
{
 puzzlefile = br.readLine();
}
catch (IOException e1) 
{
 e1.printStackTrace();
}
System.out.println(puzzlefile);
for(int i = 0; i < puzzlefile.length(); i++)
{
 char c = puzzlefile.charAt(i);
 if(c == '.')
  c = '0';
 board[i/9][i%9] = Character.digit(c, 10);				
}

long start = System.currentTimeMillis();
s=new AC3Solver(board);
s.solve();

long time = System.currentTimeMillis() - start;
//UI.itr.setText(" itr :  " + SAObj.itr);
UI.exec.setText("Execution Time : " + time + " MilliS");
});
// handling forwardChecking button click
UI.forwardChecking.setOnAction(e ->{
labelShow();
long start = System.currentTimeMillis();
int[][] sudokuResolu = FCObj.forwardChecking(initialsudoko);
UI.res(sudokuResolu);
long time = System.currentTimeMillis() - start;
UI.itr.setText(" itr :  " + FCObj.itr);
UI.exec.setText("Execution Time: " + time + " MilliS");
});

// handling MRV button click
UI.MRV.setOnAction(e -> {
labelShow();
long start = System.currentTimeMillis();
int[][] sudokuResolu = MRVObj.MRVSolve(initialsudoko);
UI.res(sudokuResolu);
long time = System.currentTimeMillis() - start;
UI.itr.setText(" itr :  " + MRVObj.itr);
UI.exec.setText("Execution Time : " + time + " MilliS");
});
}

//activating buttons when sudoko file is choosen
public void activates()
{
UI.backTracking.setDisable(false);
UI.forwardChecking.setDisable(false);
UI.MRV.setDisable(false);
UI.simulatedAnnealing.setDisable(false);
UI.AC3.setDisable(false);
}

//inactivating buttons when sudoko file is not choosen
public void inactivate()
{
UI.backTracking.setDisable(true);
UI.forwardChecking.setDisable(true);
UI.MRV.setDisable(true);
UI.simulatedAnnealing.setDisable(false);
UI.AC3.setDisable(false);
}

int[][] initialsudoko =  { { 9, 0, 0, 1, 0, 0, 0, 0, 5 }, { 0, 0, 5,
0, 9, 0, 2, 0, 1 }, { 8, 0, 0, 0, 4, 0, 0, 0, 0 },
{ 0, 0, 0, 0, 8, 0, 0, 0, 0 }, { 0, 0, 0, 7, 0, 0, 0, 0, 0 }, { 0, 0,
0, 0, 2, 6, 0, 0, 9 },
{ 2, 0, 0, 3, 0, 0, 0, 0, 6 }, { 0, 0, 0, 2, 0, 0, 9, 0, 0 }, { 0, 0,
1, 9, 0, 4, 5, 7, 0 } };

// reinitializing the sudoku
public void reintialiser()
{
labelHide();
int sudoku[][] = { { 9, 0, 0, 1, 0, 0, 0, 0, 5 }, { 0, 0, 5, 0, 9, 0,
2, 0, 1 }, { 8, 0, 0, 0, 4, 0, 0, 0, 0 },
{ 0, 0, 0, 0, 8, 0, 0, 0, 0 }, { 0, 0, 0, 7, 0, 0, 0, 0, 0 }, { 0, 0,
0, 0, 2, 6, 0, 0, 9 },
{ 2, 0, 0, 3, 0, 0, 0, 0, 6 }, { 0, 0, 0, 2, 0, 0, 9, 0, 0 }, { 0, 0,
1, 9, 0, 4, 5, 7, 0 } };
initialsudoko = sudoku;
UI.initialiser(initialsudoko);
}
public static void main(String[] args)
{
launch(args);
}
}
