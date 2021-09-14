public class App {
    public static void main(String[] args) throws Exception {
        String[][] matrix = new String[8][8];

        for (int i = 0; i < matrix.length; i++) {
            int secondNum = matrix.length - i;

            for (int j = 0; j < matrix[i].length; j++) {
                int firstNum = j + 1;
                matrix[i][j] = firstNum + "-" + secondNum;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }
    }
}
