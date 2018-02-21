package Mine_sweeper_student.src.game;

public class Node {
	
	private Position pos;
	private Node next;
	
	public Node(Position p)
	{
		pos = p;
		next = null;
	}

	public Position getPos() {
		return pos;
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
}
