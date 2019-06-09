public class NotEnoughSpaceException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    public NotEnoughSpaceException() {
        super("Not enough space to add another node.");
    }
}