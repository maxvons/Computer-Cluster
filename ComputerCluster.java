import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.Integer;

public class ComputerCluster {
    
    private ArrayList<Rack> racks = new ArrayList<>();
    private int nodesPerRack;

    public ComputerCluster(int nodesPerRack) {
        this.nodesPerRack = nodesPerRack;
    }

    // Alternate constructor for reading data from file.
    public ComputerCluster(String fileName) {
        Scanner scanner = null;
        File file = null;
        
        try {
            file = new File(fileName);
            scanner = new Scanner(file);
        }   catch (FileNotFoundException e) {
            System.out.println("File could not be found.");
        }

        // Get amount of nodes per rack from the first line.
        nodesPerRack = scanner.nextInt();
        scanner.nextLine();

        // Get node amount and specifications from the remaining lines.
        while (scanner.hasNextLine()) {
            String[] lineData = scanner.nextLine().split(" ");
            int numberOfNodes = Integer.parseInt(lineData[0]);
            int memoryPerNode = Integer.parseInt(lineData[1]);
            int processorsPerNode = Integer.parseInt(lineData[2]);

            for (int i = 0; i < numberOfNodes; i++) {
                Node n = new Node(memoryPerNode, processorsPerNode);
                addNode(n);
            }
        }
    }

    // Adds a node to a rack. If all racks are full, creates a new one.
    public void addNode(Node n) {
        
        // If empty cluster.
        if (racks.size() == 0) {
            racks.add(new Rack(nodesPerRack));
        }

        // Get last rack.
        Rack last = racks.get(racks.size() - 1);
        
        // Add a node to the last rack if not full.
        if (!last.isFull()) {
            last.addNodeToRack(n);
            return;
        }

        // If all racks are full.
        Rack newRack = new Rack(nodesPerRack);
        racks.add(newRack);
        newRack.addNodeToRack(n);
    }

    // Returns the amount of nodes with at least as much memory as the argument.
    public int getNodesWithEnoughMemory(int requiredMem) {
        int amount = 0;
        
        for (Rack r: racks) {
            for (Node n: r.getNodes()) {
                if (n != null) {
                    if (n.getMemorySize() >= requiredMem) {
                        amount++;
                    }
                }
            }
        }
        
        return amount;
    }

    // Returns the total number of processors in the cluster.
    public int getNumOfProcessors() {
        int processors = 0;

        for (Rack r: racks) {
            for (Node n: r.getNodes()) {
                if (n != null) {
                    processors += n.getProcessors();
                }
            }
        }

        return processors;
    }

    // Return the total number of racks in the cluster.
    public int getNumOfRacks() {
        return racks.size();
    }

    public int getNodesPerRack() {
        return nodesPerRack;
    }

    public ArrayList<Rack> getRacks() {
        return racks;
    }
}