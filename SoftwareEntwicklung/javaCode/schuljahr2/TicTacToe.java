package schuljahr2;

import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {
		char [] spielfeld = {'1','2','3','4','5','6','7','8','9'};
		Scanner keyboardIn = new Scanner(System.in);
		boolean victory = false;
		int turnNumber = 1;

		ausgabeSpielfeld(spielfeld);

		while(!victory) {
			char currentPlayer = turnNumber%2==0 ? 'X' : 'O';
			System.out.println("Markiere ein Feld mit: " + (turnNumber%2==0 ? "X" : "O"));
			boolean inputValid= false;

			int fieldIndex = -1;
			while(!inputValid) {
				fieldIndex = keyboardIn.nextInt()-1;
				inputValid = isInputValid(fieldIndex, spielfeld);
			}
			
			spielfeld[fieldIndex] = currentPlayer;
			turnNumber++;
			ausgabeSpielfeld(spielfeld);
			
			victory = checkVictory(spielfeld, currentPlayer);
			if(victory) {
				System.out.println(currentPlayer + " Victory!");
				break;
			}
			if(checkDraw(spielfeld)) {
				System.out.println("Draw!");
				break;
			}
		}
		
		keyboardIn.close();
	}
	
	public static boolean checkDraw(char[] spielfeld) {
		boolean ret = true;
		for(char c : spielfeld) {
			ret = ret && (c == 'X' || c == 'O');
		}
		return ret;
	}
	
	public static boolean checkVictory(char[] spielfeld, char player) {
		int[][] lines = {
				{0,1,2},{3,4,5},{6,7,8}, // rows
				{0,3,6},{1,4,7},{2,5,8}, // cols
				{0,4,8},{2,4,6} // diag
					};
		for(int[] line : lines) {
			boolean ret = true;
			for(int i=0; i<line.length; i++) {
				ret = ret && (spielfeld[line[i]] == player);
			}
			if(ret) return ret;
		}
		return false;
	}

	public static boolean isInputValid(int fieldIndex, char[] spielfeld) {
		if(fieldIndex < 0 || fieldIndex >= spielfeld.length || spielfeld[fieldIndex] == 'O' || spielfeld[fieldIndex] == 'X') {
			System.out.println("Ungültiger Input!");
			return false;
		}
		return true;
	}

	public static void ausgabeSpielfeld(char[] spielfeld) {
		System.out.println();
		for(int i=0; i<spielfeld.length; i++) {
			System.out.print(spielfeld[i] + " ");
			if(i%3 == 2) {
				System.out.println();
			}
		}
		System.out.println();
	}
}
