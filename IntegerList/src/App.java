public class App {
    public static void main(String[] args) {
        IntegerList list = new IntegerList();

        list.insert(0,1);
        list.insert(1,2);
        list.insert(2,3);
        list.insert(3,4);
        list.insert(4,5);

        list.add(45);

        list.insert(2, 16);

        list.remove(2);
        System.out.println(list);
    }
}
