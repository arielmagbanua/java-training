public class App {
    public static void main(String[] args) throws Exception {
        // a.
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }

        // b.
        for (int i = 10; i >= 0; i--) {
            System.out.print(i);
        }

        // c.
        for (int i = 5; i <= 50; i+=5) {
            System.out.print(i + " ");
        }

        // d.
        String name = "Raychelou Valencia";
        for (int i = 1; i <= 5; i++) {
            // split the first name and last name
            String[] names = name.split(" ");

            // print first name
            System.out.println(names[0]);
            // print last name
            System.out.println(names[1]);
        }

        // e.
        for (int i = -1; i >= -5 ; i--) {
            System.out.println(i);
        }

        // f.
        int firstNum = 6;
        int secondNum = 2;

        for (int i = 1; i <= 3; i++) {
            System.out.println(firstNum);
            System.out.println(secondNum);

            firstNum += 3;
            secondNum += 2;
        }

        // g.
        for (int i = 1; i <= 5; i++) {
            int sum = i + i;
            String sumFormat = String.format("%d + %d = %d", i, i, sum);
            System.out.println(sumFormat);
        }

        // h.
        int row = 6;
        int col = 10;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }

        // i.
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.print(i);
            }

            System.out.println();
        }

        j.
        String text = "cs";

        for (int i = 0; i < 8; i++) {
            System.out.print(text);
        }
    }
}
