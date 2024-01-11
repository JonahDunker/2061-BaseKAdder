import java.util.Scanner;

public class BaseKAdder {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    int base = Integer.parseInt(in.nextLine());
    int num1 = 0, num2 = 0;
    String input1 = "", input2 = "";

    try {
      input1 = in.nextLine();
      input2 = in.nextLine();
      num1 = Integer.parseInt(input1);
      num2 = Integer.parseInt(input2);
    } catch(NumberFormatException e) {
      String error = e.toString();
      error = error.substring(error.indexOf("\"")+1, error.length()-1);
      System.out.printf("ERROR: Invalid number given, %s cannot be a base %d number", error, base);
      return;
    }
    int sum = fromBase10(base, toBase10(base, num1) + toBase10(base, num2));
    System.out.printf("The sum of the base %d numbers %d and %d is %d",
    base, num1, num2, sum);
  }

  public static int fromBase10(int base, int num) {
    String numStr = "";
    int remainder = 0;
    do {
      remainder = num % base;
      num /= base;
      numStr += remainder;
    } while(remainder != 0);

    String reverse = "";
    for(int i = numStr.length()-1; i >= 0; i--) {
      reverse += numStr.charAt(i)+"";
    }
    return Integer.parseInt(reverse);
  }

  public static int toBase10(int base, int num) {
    String numStr = num+"";
    int baseSum = 0;
    String reverse = "";
    for(int i = numStr.length()-1; i >= 0; i--) {
      reverse += numStr.charAt(i)+"";
    }
    for(int i = 0; i < numStr.length(); i++) {
      baseSum += Integer.parseInt(reverse.charAt(i)+"") * ((int) Math.pow(base, i));
    }
    return baseSum;
  }
}