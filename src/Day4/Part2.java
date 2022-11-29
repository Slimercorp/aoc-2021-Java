package Day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Part2 {

	public static void main(String[] args) {	
		File file = new File(".\\src\\Day4\\data.txt");
		
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int[] digits = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
		
		List<BingoBoard> boards = new ArrayList<>();
		while(scanner.hasNext()) {
			int[][] board = new int[5][5];
			for (int i=0; i<5; i++) {
				for (int j=0; j<5; j++) {
					board[i][j] = scanner.nextInt();
				}
			}
			
			boards.add(new BingoBoard(board));
		}
		
		scanner.close();
		
		int counter = 0;
		for (int digit : digits) {
			for (BingoBoard board : boards) {
				
				if (board.isWinned()) {
					continue;
				}
				
				board.acceptDigit(digit);
				
				if (board.isWon()) {
					board.setWinned();
					counter++;
					
					if (counter == boards.size()) {
						System.out.println("Result = " + (digit * board.sumOfBoard()));
						return;
					}
				}
			}
		}
		
		
		
	}

}
