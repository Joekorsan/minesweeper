package game;

public class PositionList {

    private Node first;
    private int numOfLinks;

    public PositionList() {
        first = null;
    }

    public PositionList(PositionList original) {
        first = copyNodes(original.first);

    }

    public boolean isEmpty() {
        if (first == null)
            return true;
        else
            return false;
    }

    public int size() {
        Node current = first;

        int size = 0;

        while (current.getNext() != null) {
            current = current.getNext();
            size++;

        }
        return size;
    }// end of size method

    public Position get(int index) {
        Node current = first;
        while(index > 0){
            current = current.getNext();
            index --;
        }
        return current.getPos();
    }
    public void pushFront(Position pos) {
        if (isEmpty()) {
            first = new Node(pos);

        }

        if (numOfLinks >= 1) {
            Node tmp = new Node(pos);
            tmp.setNext(first);
            first = tmp; 
            }
        
        numOfLinks++;

    }

    public void popFront() {
        if(isEmpty())
        {
            System.out.println( "No Link to be deleted!");
            return;
        }
        
        if(numOfLinks == 1){
            first = null;
            
        }
        else
        {
            Node firstTemp = first.getNext();
            first.setNext(null);
            first = firstTemp;
        }
        numOfLinks --;
    }

    // helper method for deep copy
    private Node copyNodes(Node in) {
        if (in == null)
            return null;
        else {
            Node copy = new Node(in.getPos());
            copy.setNext(copyNodes(in.getNext()));
            return copy;
        }
    }

}
 
