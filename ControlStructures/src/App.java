public class App {
    public static void main(String[] args) throws Exception {
        int num = 1;

        if (num >= 10) {
            // do something
            System.out.println("Number!!!");
        }

        if (num < 3) {
            // do something
            System.out.println("Not below!!!");
        } else {
            // do something
            System.out.println("Above!!!");
        }

        if (num < 3) {

        } else if (num > 4) {

        } else {

        }

        switch(num) {
            case 1:
            case 2:
                System.out.println("This is One or Ten!");
                break;
            case 6:
                System.out.println("This is case 2");
                break;
            default:
               System.out.println("Default"); 
        }
    }
}
