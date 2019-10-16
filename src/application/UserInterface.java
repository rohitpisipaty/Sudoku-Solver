package application;



import javafx.collections.ObservableList;

import javafx.geometry.Insets;

import javafx.scene.Node;

import javafx.scene.Scene;

import javafx.scene.control.Button;

import javafx.scene.control.Label;

import javafx.scene.layout.BorderPane;

import javafx.scene.layout.GridPane;

import javafx.scene.layout.HBox;

import javafx.stage.Stage;









// this class handle the UI stuffs using javaFX

public class UserInterface {



	

	public Button initialisation, backTracking, forwardChecking, AC3, MRV , fileLoader, simulatedAnnealing; 

	public HBox topMenu, menuBottom ;

	public GridPane sudoku; 

	public Label itr, exec;

	

	

	public  UserInterface(){

		Stage stage = new Stage();

		stage.setTitle("Sudoku puzzle");

		stage.setResizable(false);

		BorderPane layoutPrincipal = new BorderPane();

		

//      Top menu

		topMenu = new HBox();

		topMenu.setPadding(new Insets(10));

		topMenu.setSpacing(10);

		initialisation = new Button("Initialiser");

		backTracking = new Button("Back Tracking Simple");

		forwardChecking = new Button("forward Checking");
		
		AC3 = new Button("AC3");
		
		simulatedAnnealing = new Button("Simulated Annealing");

		MRV = new Button("MRV");

		fileLoader = new Button("Select the problem file");

		topMenu.getChildren().addAll(initialisation,backTracking,forwardChecking,AC3,MRV,simulatedAnnealing,fileLoader);

		

		



		

//		sudoku layout where the sudoku is gonna show .

		sudoku = new GridPane();

		sudoku.setPadding(new Insets(30));

		

		for(int i=0;i< 9 ;i++){

			for(int j=0;j< 9 ;j++){

				Button currentButton = new Button();

				currentButton.setPrefSize(55, 55);

				currentButton.getStyleClass().add("sudoku");



				if(j==2 || j==5){

					currentButton.setStyle(" -fx-border-width : 0.5px 0.5px 2px 0.5px  ");

					if(i == 2 || i ==5){

						currentButton.setStyle(" -fx-border-width : 0.5px 2px 2px 0.5px  ");

					}

				}

				if(i==2 || i==5){

					currentButton.setStyle(" -fx-border-width : 0.5px 2px 0.5px 0.5px  ");

					if(j==2 || j==5){

						currentButton.setStyle(" -fx-border-width : 0.5px 2px 2px 0.5px  ");

					}

				}

				sudoku.add(currentButton, i, j);

			}

		}

		

		

		

		

//		Bottom Menu

		menuBottom = new HBox();

		menuBottom.setPadding(new Insets(10,50,10,70));

		menuBottom.setSpacing(50);

		itr = new Label("");

		itr.setPrefSize(180, 10);

		exec = new Label("");

		exec.setPrefSize(180, 10);

		menuBottom.getChildren().addAll(itr,exec);

		

//      setting each layout in his place

		layoutPrincipal.setTop(topMenu);

		layoutPrincipal.setCenter(sudoku);

		layoutPrincipal.setBottom(menuBottom);

		

// 		initializing the scene

		Scene scene = new Scene(layoutPrincipal);

		scene.getStylesheets().add("application.css");

		stage.setScene(scene);

		stage.show();

		

	}

	

//  initilize the sudoku with value from one of the files in the "sudokuFiles" directory

	public void initialiser(int[][] sudokuTab){

		for(int i=0;i< sudokuTab.length ;i++){

			for(int j=0;j< sudokuTab[i].length ;j++){

				Node currentNode = getNodeByRowColumnIndex(i,j);

				Button currentButton = (Button) currentNode;

				if( sudokuTab[i][j] == 0 ){

					currentButton.setText("");

				}else{

					currentButton.setText(""+sudokuTab[i][j]);

					currentButton.getStyleClass().add("initialisationText");

				}

			}

		}

		

	}

	

//  function that handle result displaying

	public void res(int[][] sudokuTab){

		for(int i=0;i< sudokuTab.length ;i++){

			for(int j=0;j< sudokuTab[i].length ;j++){

				Node currentNode = getNodeByRowColumnIndex(i,j);

				Button currentButton = (Button) currentNode;

				if( sudokuTab[i][j] == 0 ){

				}else{

					currentButton.setText(""+sudokuTab[i][j]);

				}

			}

		}

		

	}

	

	

	

	

	public Node getNodeByRowColumnIndex (final int row, final int column) {

	    Node result = null;

	    ObservableList<Node> childrens = sudoku.getChildren();

	    for (Node node : childrens) {

	        if(GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == column) {

	            result = node;

	            break;

	        }

	    }

	    return result;

	}

}

