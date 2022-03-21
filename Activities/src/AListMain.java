public class AListMain {
    public static void main(String[] args) {
        AList<String> strings = new AList<>();
        strings.add(new String[]{"foo", "bar", "Hello"});
        strings.add(2, "Test");
        // prints if contains nice
        System.out.println(strings.contains("nice!"));
        // print all
        System.out.println(strings);
        // remove an item
        System.out.println("Removed: " + strings.remove(1));
        // print all
        System.out.println(strings);

        AList<Integer> integers = new AList<>();
        integers.add(new Integer[]{1, 2, 4});
        integers.add(2, 3);
        // prints if contains 1
        System.out.println(integers.contains(1));
        // print all
        System.out.println(integers);
        // remove an item
        System.out.println("Removed: " + integers.remove(1));
        // print all
        System.out.println(integers);
    }
}
