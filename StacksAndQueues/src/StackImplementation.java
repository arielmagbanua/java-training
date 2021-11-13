public class StackImplementation {
    public static void main(String[] args) {
        Stack ourFirstStack = new Stack(4);
        System.out.println(ourFirstStack);
        ourFirstStack.push("Alex");
        ourFirstStack.push("Paolo");
        ourFirstStack.push("Drake");
        ourFirstStack.push("Julia");
        ourFirstStack.push("Juan");

        // test peek and utilization
        System.out.println(ourFirstStack);
        System.out.println(ourFirstStack.peek());
        System.out.println(ourFirstStack.utilization() + "%");

        ourFirstStack.pop();
        ourFirstStack.pop();
        ourFirstStack.pop();
        System.out.println(ourFirstStack.pop());
        System.out.println(ourFirstStack.pop());
        System.out.println(ourFirstStack);

        // test peek and utilization
        System.out.println(ourFirstStack.peek());
        System.out.println(ourFirstStack.utilization() + "%");
    }
}
