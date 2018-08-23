/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EvaluateString;

/**
 *
 * @author 986036
 */
public class StringEvaluation {

    public static void main(String[] args) {
        String[] input = {"1a2b3c", "123ab!45c", "abcdef", "0123.4", "dFD$#23+++12@T1234;/.,10"};
        for (String v : input) {
            System.out.println("Evaluation of " + v + ": " + evaluate(v));
        }

    }

    private static String evaluate(String input) {
        int start = 0;
        int end = input.length();
        if (input.length() == 0) {
            return "0";
        }
        for (int i = 0; i <end; i++) {
            if (input.charAt(i) >= '0' && input.charAt(i) <= '9') {
                start = i;
                break;
            }
        }
        for (int i = 0; i <end; i++) {
            if (input.charAt(end - i - 1) >= '0' && input.charAt(end - i - 1) <= '9' && end > start) {
                end = end - i;
                break;
            }
        }
        int sum = 0;
        StringBuilder output = new StringBuilder();
        output.append("(");

        input = input.substring(start, end);
        input = input.replaceAll("[\\D]+", "+");
        String[] nums = input.split("\\+");

        for (String num : nums) {
            output.append(num + "+");
            sum += Integer.parseInt(num);
            //System.out.println(output);
        }
        output.deleteCharAt(output.length() - 1);

        output.append(")");

        output.insert(0, sum);
        return output.toString();
    }
}
