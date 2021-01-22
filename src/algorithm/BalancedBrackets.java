package algorithm;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BalancedBrackets {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        Stack<Character> stck = new Stack<>();

        if(s.length()%2 != 0) return "NO";

        for(int i=0 ; i<s.length() ; i++){
            char bracket = s.charAt(i);

            if(bracket == '{' || bracket == '[' || bracket=='('){
                stck.add(bracket);
            }else if(stck.isEmpty()){
                return "NO";
            }else{
                char cBracket = stck.pop();
                if (bracket == '}' && (cBracket == '(' ||  cBracket == '[')) {
                    return "NO";
                }else if(bracket == ')' && (cBracket == '{' ||  cBracket == '[')){
                    return "NO";
                }else if(bracket == ']' && (cBracket == '{' ||  cBracket == '(')){
                    return "NO";
                }
            }
        }

        if(stck.isEmpty()) return "YES";

        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        /*{[()]}
          {[(])}
          {{[[(())]]}}

          FAILED:
          }][}}(}][))]
          [](){()}
          ()
          ({}([][]))[]()
          {)[](}]}]}))}(())(
          ([[)
         */

        System.out.println(isBalanced("}][}}(}][))]"));

        /*
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();*/
    }
}
