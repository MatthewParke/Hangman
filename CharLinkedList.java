package hangman;

public class CharLinkedList {
	
	private LLCharacterNode head;	//LIST #: 1
	private LLCharacterNode tail;
	private int numNodes;
	
	
	public CharLinkedList()
	{
		numNodes=0;		
	}
	public LLCharacterNode getHead()
	{
		return head;
	}
	public LLCharacterNode getTail()
	{
		return tail;
	}
	public int getSize()
	{
		return numNodes;
	}
	public void addCharNode(char element)
	{
		LLCharacterNode cn = new LLCharacterNode(element);
		
		if(numNodes ==0)
		{
			head= cn;
			tail = head;
		}
		else 
		{
			tail.setLink(cn);
			tail = cn;	
		}
			
		numNodes++;
		
	}
	public void printList()
	{
		LLCharacterNode currNode = head;
		while(currNode != null)
		{
			System.out.print(currNode.getInfo());
			currNode = currNode.getLink();
		}
		
	}
}
