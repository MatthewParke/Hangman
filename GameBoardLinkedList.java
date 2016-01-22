package hangman;

public class GameBoardLinkedList implements GameBoard, HangManConstants 
{

	private int state = STARTING_STATE;
	private CharLinkedList guessWord = new CharLinkedList();
	private CharLinkedList gameBoard = new CharLinkedList();
	private CharLinkedList prevGuess = new CharLinkedList();
	
	public GameBoardLinkedList(String guess)
	{
		for(int i=0; i<guess.length();i++)
		{
			guessWord.addCharNode(guess.charAt(i));
			gameBoard.addCharNode('0');
		}
	
	}
	public boolean isPriorGuess(char guess)
	{
		LLCharacterNode currNode = prevGuess.getHead();
		while(currNode != null)
		{
			if(currNode.getInfo() == guess)
				return true;
			currNode = currNode.getLink();
		}
		
		return false;
	}
	
	
	public int numberOfGuesses()
	{
		return prevGuess.getSize();
	}
	
	public boolean isCorrectGuess(char guess)
	{
		LLCharacterNode currNode = guessWord.getHead();
		while(currNode != null)
		{
			if(currNode.getInfo() == guess)
				return true;
			currNode = currNode.getLink();
		}
		state++;
		return false;
	}
	
	public boolean doMove(char guess)
	{
		if(!isPriorGuess(guess))
		{
			prevGuess.addCharNode(guess);
			
			if(isCorrectGuess(guess))
			{
				LLCharacterNode currNode = guessWord.getHead();
				LLCharacterNode currNode2 = gameBoard.getHead();
				
				while(currNode != null)
				{
					if(currNode.getInfo() == guess)
						currNode2.setInfo(guess);
					
					currNode  = currNode.getLink();
					currNode2 = currNode2.getLink();
				}

				return true;
			}
		}
		
		return false;
	}
	
	public boolean inWinningState()
	{
		LLCharacterNode currNode = gameBoard.getHead();
		while(currNode != null)
		{
			if(currNode.getInfo() == '0')
				return false;
			currNode = currNode.getLink();
		}
		
		return true;
	}
	
	public boolean inLosingState()
	{
		LLCharacterNode currNode = gameBoard.getHead();
		while(currNode != null)
		{
			if(currNode.getInfo() == '0' && currentHungState() == 10)
				return true;
			currNode = currNode.getLink();
		}
		 
		return false;
	}
	
	public int currentHungState()
	{
		if(state <= 10)
			return state;
		return 10;
	}
	
	public String toString()
	{
		String s = "";
		LLCharacterNode currNode = gameBoard.getHead();
		while(currNode != null)
		{
			if(currNode.getLink() != null)
			{
				if(currNode.getInfo() == '0')	
					s += "_ ";				
				else
					s += currNode.getInfo()+" ";
			}
			else 
			{
				if(currNode.getInfo() == '0')	
					s += "_";				
				else
					s += currNode.getInfo();
			}
			
			currNode = currNode.getLink();
		}
		return s;
	}
	
	public String previousGuessString()
	{

		String s = "[";
		LLCharacterNode currNode = prevGuess.getHead();
		while(currNode != null)
		{
			if(currNode.getLink() != null)	
				s += currNode.getInfo()+", ";
			else
				s += currNode.getInfo();
			
			currNode = currNode.getLink();
		}
		
		return s+"]";
	}
	
}
