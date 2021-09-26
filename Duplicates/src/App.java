public class App {
    public static void main(String[] args) throws Exception {
        int[] numberList = {1,7,7,1,0,3};

        for (int i = 0; i < numberList.length; i++) {
            for (int j = 0; j < numberList.length; j++) {
                if (i != j) {
                    if (numberList[i] == numberList[j]) {
                        System.out.println(numberList[i]);
                        break;
                    }
                }
            }
        }
    }
}
