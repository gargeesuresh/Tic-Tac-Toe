package tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

	static ArrayList<Integer> playerPos=new ArrayList<Integer>();
	static ArrayList<Integer> cpuPos=new ArrayList<Integer>();
	public static void main(String[] args) {
		char [][] gameBoard = { {' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '}};
		printGameBoard(gameBoard);
		while(true) {
			Scanner scan=new Scanner(System.in);
			System.out.println("Enter your placement (1-9):");
			int ppos =scan.nextInt();
			while(playerPos.contains(ppos)||cpuPos.contains(ppos)) {
				System.out.println("Position taken, enter correct position");
				ppos=scan.nextInt();
;			}
			placePiece(gameBoard,ppos,"player");
			Random rand=new Random();
			int cpos=rand.nextInt(9)+1;
			while(playerPos.contains(cpos)||cpuPos.contains(cpos)) {
				 cpos=rand.nextInt(9)+1;
;			}
			placePiece(gameBoard,cpos,"cpu");
			printGameBoard(gameBoard);
			String r=checkWinner();
			if(r.length()>0) {
				System.out.println(r);
				break;
			}
			
		}
		
		
	}
	public static void printGameBoard(char[][] gameBoard) {
			for(char[] row: gameBoard) {
				for(char c: row) {
					System.out.print(c);
				}
				System.out.println();
			}

		}
	
	public static void placePiece(char[][] gameBoard,int pos, String user) {
			char symbol=' ';
			if(user.equals("player")) {
				symbol='X';
				playerPos.add(pos);
			}
			else if(user.equals("cpu")) {
				symbol='O';
				cpuPos.add(pos);
			}
			switch(pos) {
			case 1:
				gameBoard[0][0]=symbol;
				break;
			case 2:
				gameBoard[0][2]=symbol;
				break;
			case 3:
				gameBoard[0][4]=symbol;
				break;
			case 4:
				gameBoard[2][0]=symbol;
				break;
			case 5:
				gameBoard[2][2]=symbol;
				break;
			case 6:
				gameBoard[2][4]=symbol;
				break;
			case 7:
				gameBoard[4][0]=symbol;
				break;
			case 8:
				gameBoard[4][2]=symbol;
				break;
			case 9:
				gameBoard[4][4]=symbol;
				break;
			default:
				break;
		}
			
		}
	
	public static String checkWinner() {
		List<Integer> topRow=Arrays.asList(1,2,3);
		List<Integer> middleRow=Arrays.asList(4,5,6);
		List<Integer> bottomRow=Arrays.asList(7,8,9);
		List<Integer> leftCol=Arrays.asList(1,4,7);
		List<Integer> midCol=Arrays.asList(2,5,8);
		List<Integer> rightCol=Arrays.asList(2,6,9);
		List<Integer> cross1=Arrays.asList(1,5,9);
		List<Integer> cross2=Arrays.asList(7,5,3);
		
		List<List> winning=new ArrayList<List>();
		winning.add(topRow);
		winning.add(middleRow);
		winning.add(bottomRow);
		winning.add(leftCol);
		winning.add(midCol);
		winning.add(rightCol);
		winning.add(cross1);
		winning.add(cross2);
		
		for (List l: winning) {
			if(playerPos.containsAll(l)) {
				return "Congratulations you won!";
			}else if(cpuPos.containsAll(l)) {
				return "CPU wins sorry :(";
			}
			else if(playerPos.size()+cpuPos.size()==9) {
				return "tie";
			}
		}
		
		return "";
	}

		
}
