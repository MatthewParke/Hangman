package hangman;

public class LLCharacterNode 
{
	private char info;
	private LLCharacterNode link;
	
	public LLCharacterNode(char newInfo)
	{
		info = newInfo;
		link = null;
	}
	public char getInfo()
	{
		return info;
	}
	public LLCharacterNode getLink()
	{
		return link;
	}
	public void setInfo(char newInfo)
	{
		info = newInfo;
	}
	public void setLink(LLCharacterNode newLink)
	{
		link = newLink;
	}
	
	
	
}
