import java.util.ArrayList;

public class Rack {
    
    private int size;
    private Node[] nodes;
    private int index = 0;

    public Rack(int size) {
        this.size = size;
        nodes = new Node[size];
    }

    // Adds a node at the next available index.
    public void addNodeToRack(Node n) {
        
        // If full.
        if (index > size - 1) {
            throw new NotEnoughSpaceException();
        }

        nodes[index] = n;
        index++;
    }

    // Checks if rack is full.
    public boolean isFull() {
        return index > (size - 1);
    }
    
    public int getSize() {
        return size;
    }

    public Node[] getNodes() {
        return nodes;
    }
    
}
