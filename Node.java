public class Node {

    private int memorySize;
    private int processors;

    public Node(int memorySize, int processors) {
        this.memorySize = memorySize;
        this.processors = processors;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public int getProcessors() {
        return processors;
    }
}