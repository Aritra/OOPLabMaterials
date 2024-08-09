public class Main {
    public static void main(String[] args) {
        String op = args[0];
        double num1 = Double.parseDouble(args[1]);
        double num2 = Double.parseDouble(args[2]);
        switch (op) {
            case "add":
                System.out.println("Answer: " + (num1 + num2));
                break;
            case "sub":
                System.out.println("Answer: " + (num1 - num2));
                break;
            case "mul":
                System.out.println("Answer: " + (num1 * num2));
                break;
            case "div":
                System.out.println("Answer: " + (num1 / num2));
                break;
            default:
                break;
        }
    }
}