package Mine_sweeper_student.src.game;

public class PositionList {
	
	private Node first;
	
	public PositionList()
	{
		//TODO
	}
	
	public PositionList(PositionList original)
	{
		first = copyNodes(original.first);
	}
	

	public boolean isEmpty()
	{
		//TODO
		return false;
	}
	
	public int size()
	{
		//TODO
		return 0;
	}
	
	public Position get (int index)
	{
		//TODO
		return null;
	}
	
	public void pushFront(Position pos)
	{
		//TODO
	}
	
	public void popFront()
	{
		//TODO
	}
	
	//helper method for deep copy
	private Node copyNodes (Node in)
	{
		if (in == null)
			return null;
		else
		{
			Node copy = new Node(in.getPos());
			copy.setNext(copyNodes(in.getNext()));
			return copy;
		}
	}

}
