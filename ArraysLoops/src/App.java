public class App {
    public static void main(String[] args) throws Exception {
        String[][] alphabets = {
            {"a", "b", "c", "d"},
            {"e", "f", "g", "h"},
            {"h", "h", "i", "i"}
        };

        // access "g"
        String g = alphabets[1][2];

        // access "h"
        String h = alphabets[1][3];

        System.out.println(g);
        System.out.println(h);

        // print everything
        for(int i = 0; i < alphabets.length; i++) {
            for (int j = 0; j < alphabets[i].length; j++) {
                System.out.print(" " + alphabets[i][j] + " ");
            }

            // print a new line after end of the row
            System.out.println();
        }

        int[][][] numbers = {
            {
                {1, 2, 3, 4}, {2, 4, 6, 8}, {3, 6, 9, 12}
            },
            {
                {9, 0, 3, -1}, {2, 90, 6, 78}, {3, 6, 9, 12}
            },
            {
                {9, 0, 3, -1}, {2, 90, 6, 78}, {3, 6, 9, 12}
            },
            {
                {9, 0, 3, -1}, {2, 90, 6, 78}, {3, 6, 9, 12}
            }
        };

        int ninety = numbers[1][1][1];
        int eight = numbers[0][1][3];

        System.out.println(ninety);
        System.out.println(eight);
    }
}
