// custom stack class for string only
public class CustomStack {

    private String[] customStack;
    private int last;

    //  custom stack constructor
    public CustomStack(int initialSize) {
        customStack = new String[initialSize];
        last = 0;
    }

    // pop
    public String pop() {
        if(isEmpty()) {
            return null;
        } else {
            String poppedItem = customStack[last-1];
            customStack[last-1] = null;
            last--;
            return poppedItem;
        }
    }

    // peek
    public String peek() {
        if(isEmpty()) {
            return null;
        } else {
            return customStack[last-1];
        }
    }

    // push
    public void push(String item) {
        if(last == customStack.length) {
            String[] largeCustomStack = new String[customStack.length * 2];
            for(int i = 0; i < customStack.length; i++) {
                largeCustomStack[i] = customStack[i];
            }
            customStack = largeCustomStack;
        }
            customStack[last] = item;
            last++;
    }

    // size 
    public int size() {
        return last;
    }
    
    // isEmpty
    public Boolean isEmpty() {
        return last == 0;
    }

    // getLength (capacity)
    public int getLength() {
        return customStack.length;
    }
}
