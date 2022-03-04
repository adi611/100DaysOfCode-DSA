import java.io.*;
import java.util.*;

public class Main {

    public static int precedence(char ch) {
        return ch == '*' || ch == '/' ? 1 : 0;
    }

    public static int calcValue (char ch, int v1, int v2) {
        switch (ch) {
            case '+':
                return v1 + v2;
            
            case '-':
                return v1 - v2;

            case '*':
                return v1 * v2;

            case '/':
                return v1 / v2;
        
            default:
                return 0;
        }
    }

    public static void calc(Stack<Integer> vs, char ch, Stack<String> pre, Stack<String> in) {

        String prefix2 = pre.pop();
        String prefix1 = pre.pop();
        pre.push(ch + prefix1 + prefix2);

        String in2 = in.pop();
        String in1 = in.pop();
        in.push("(" + in1 + ch + in2 + ")");

        int v2 = vs.pop();
        int v1 = vs.pop();
        vs.push(calcValue(ch, v1, v2));

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        int value = 0;

        Stack<String> pre = new Stack<>();
        Stack<String> in = new Stack<>();
        Stack<Integer> vs = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch == '*' || ch == '/' || ch == '-' || ch == '+') {
                calc(vs, ch, pre, in);
            } else if (!Character.isWhitespace(ch)) {
                pre.push(Character.toString(ch));
                in.push(Character.toString(ch));
                vs.push(Character.getNumericValue(ch));
            }
        }

        System.out.println(vs.pop());
        System.out.println(in.pop());
        System.out.println(pre.pop());

    }
}