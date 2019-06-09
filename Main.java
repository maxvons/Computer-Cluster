public class Main {
    public static void main(String[] args) {
        ComputerCluster abel = new ComputerCluster(12);

        // Adds 650 nodes with 64GB memory and 1 processor each.
        for (int i = 0; i < 650; i++) {
            Node n = new Node(64, 1);
            abel.addNode(n);
        }

        // Adds 16 nodes with 1024GB memory and 2 processors each.
        for (int i = 0; i < 16; i++) {
            Node n = new Node(1024, 2);
            abel.addNode(n);
        }

        // Test normal constructor.
        System.out.println("Testing for abel with normal constructor.\n");

        // Check how many nodes with at least 32GB memory.
        System.out.println("Nodes with at least 32GB memory: " + 
        abel.getNodesWithEnoughMemory(32));

        // Check how many nodes with at least 64GB memory.
        System.out.println("Nodes with at least 64GB memory: " + 
        abel.getNodesWithEnoughMemory(64));

        // Check how many nodes with at least 128GB memory.
        System.out.println("Nodes with at least 128GB memory: " + 
        abel.getNodesWithEnoughMemory(128));

        // Number of processors in the cluster.
        System.out.println("\nNumber of processors: " + 
        abel.getNumOfProcessors());

        // Number of racks in the cluster.
        System.out.println("Number of racks: " + abel.getNumOfRacks());




        // Test for alternate constructor with file.
        System.out.println("\n\n\nTesting for fedora with alternate constructor.\n");

        ComputerCluster fedora = new ComputerCluster("regneklynge.txt");

        System.out.println("Nodes with at least 32GB memory: " + 
        fedora.getNodesWithEnoughMemory(32));

        // Check how many nodes with at least 64GB memory.
        System.out.println("Nodes with at least 64GB memory: " + 
        fedora.getNodesWithEnoughMemory(64));

        // Check how many nodes with at least 128GB memory.
        System.out.println("Nodes with at least 128GB memory: " + 
        fedora.getNodesWithEnoughMemory(128));

        // Number of processors in the cluster.
        System.out.println("\nNumber of processors: " + 
        fedora.getNumOfProcessors());

        // Number of racks in the cluster.
        System.out.println("Number of racks: " + fedora.getNumOfRacks());

    }
}