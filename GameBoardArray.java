package hangman;

/**
 * The Array implementation of the GameBoard interface.
 */
public class GameBoardArray implements GameBoard, HangManConstants {
	/** The number of characters (lower/upper). */
	private static int ALPHABET_COUNT = 26*2;
	private int numGuess=0;
	/** hung state */
	private int		state;
	private char[] prevGuess = new char[ALPHABET_COUNT];
	private char[] guessWord;
	private char[] gameBoard;

	/**
	 * Creates a new GameBoardArray object.
	 * 
	 *  guessWord the word to guess
	 */
	public GameBoardArray(String guessWord) {
		this.guessWord = guessWord.toCharArray();
		gameBoard = new char[this.guessWord.length];
		for(char c: gameBoard)
			c = 0;
		for(char c: prevGuess)
			c = 0;
		state    = STARTING_STATE;
	}
		
	public boolean isPriorGuess(char guess) {		
			
		for(char c: prevGuess)
			if(c == guess){
				return true;
			}
		
		return false;
	}
	
	public int numberOfGuesses() {
		
		return numGuess;
	}
	
	public boolean isCorrectGuess(char guess) {
		
		numGuess++;
		
		for(char c: guessWord)
			if(c == guess)
				return true;
		
		state++;
		return false;
	}
	
	public boolean doMove(char guess) {
		if(!isPriorGuess(guess))
		{
			prevGuess[numberOfGuesses()] = guess;
			if(isCorrectGuess(guess))
			{
				for(int i=0; i<guessWord.length;i++)
				{
					if(guessWord[i] == guess)
						gameBoard[i] = guess;
				}
				return true;
			}
		}
		
		return false;
	}

	public boolean inWinningState()	{
		for(char c: gameBoard)
			if(c == 0)
				return false;
		
		return true;
	}

	public boolean inLosingState() {
		for(char c: gameBoard)
			if(c==0 && currentHungState()==10)
				return true;
		 
		return false;
	}
	
	public String toString() {
		String s = "";
		
		for(int i=0; i<gameBoard.length; i++)
		{
			if(gameBoard[i]!=0)
				s+= gameBoard[i];
			else if(gameBoard[i]==0)
				s+="_";
			
			if(i < gameBoard.length-1)
				s+= " ";
		}
		
		return s;
	}

	public String previousGuessString() {
		String s = "";
		 s+= "[";
		for(int i=0; i<prevGuess.length;i++)
			if(prevGuess[i] != 0)
			{
				if(prevGuess[i+1] == 0)
					s += prevGuess[i] +"]";
				else
					s += prevGuess[i]+ ", "; 
			} 
		
		return s;
	}
	
	public int currentHungState() {
		if(state <= 10)
			return state;
		return 10;
	}

}
