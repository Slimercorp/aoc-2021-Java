package Day4;

public class BingoBoard {
	private int[][] board;
	private boolean winned;
	
	BingoBoard(int[][] board) {
		this.board = board;
		this.winned = false;
	}

	public void acceptDigit(int digit) {
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				if (board[i][j] == digit) {
					board[i][j] = -1;
				}
			}
		}
	}
	
	public boolean isWon() {
		// check rows
		for (int i=0; i<5; i++) {
			boolean isWon = true;
			for (int j=0; j<5; j++) {
				if (board[i][j] != -1) {
					isWon = false;
				}
			}
			
			if (isWon) {
				return true;
			}
		}
		
		// check columns
		for (int i=0; i<5; i++) {
			boolean isWon = true;
			for (int j=0; j<5; j++) {
				if (board[j][i] != -1) {
					isWon = false;
				}
			}
			
			if (isWon) {
				return true;
			}
		}
		
		return false;
	}
	
	public int sumOfBoard() {
		int sum = 0;
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				if (board[i][j] != -1) {
					sum += board[i][j];
				}
			}
		}
		
		return sum;
	}

	public boolean isWinned() {
		return winned;
	}

	public void setWinned() {
		this.winned = true;
	}
	
}
