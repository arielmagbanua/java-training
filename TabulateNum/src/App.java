public class App {
    public static void main(String[] args) throws Exception {
        // header
        System.out.println("Number Odd/Even Square Cube");
        
        for (int i = 1; i <= 10; i++) {
            String oddEven = "";
            
            // check if odd or even
            if (i % 2 == 0) {
                oddEven = "Even";
            } else {
                oddEven = "Odd ";
            }

            int square = i * i;
            int cube = i * i * i;

            String formattedText = String.format("%d      %s     %d      %d", i, oddEven, square, cube);
            System.out.println(formattedText);
        }
    }
}
