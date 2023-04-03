
public class App {
    public static void main(String[] args) throws Exception {
        CustomStack cStack = new CustomStack(10);
        System.out.println(cStack.isEmpty());
        System.out.println(cStack.peek());
        System.out.println(cStack.size());
        cStack.push("first");
        System.out.println(cStack.size());
        cStack.push("second");
        System.out.println(cStack.peek());
        System.out.println(cStack.size());
        cStack.push("third");
        cStack.push("fourth");
        cStack.push("fifth");
        cStack.push("sixth");
        cStack.push("seventh");
        cStack.push("eighth");
        cStack.push("ninth");
        cStack.push("tenth");
        System.out.println(cStack.size());
        cStack.push("eleventh");
        System.out.println(cStack.size());
        System.out.println(cStack.getLength());
        System.out.println(cStack.pop());
        System.out.println(cStack.peek());
        System.out.println(cStack.size());
        System.out.println(cStack.getLength());
    }
}
