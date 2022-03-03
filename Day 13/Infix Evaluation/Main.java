import java.io.*;
import java.util.*;

public class Main {

    public static int precedence(char ch) {
        return (ch == '*' || ch == '/') ? 1 : 0;
    }

    public static int calc(int v1, int v2, char op) {
        switch (op) {
            case '+':
                return (v1 + v2);
            case '*':
                return v1 * v2;
            case '/':
                return v1 / v2;
            default:
                return v1 - v2;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        Stack<Integer> opd = new Stack<>();
        Stack<Character> opt = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == '(') {
                opt.push(ch);
            } else if (Character.isDigit(ch)) {
                opd.push(Character.getNumericValue(ch));
            } else if (ch == ')') {
                while (opt.size() > 0 && opt.peek() != '(') {
                    char op = opt.pop();
                    int v2 = opd.pop();
                    int v1 = opd.pop();
                    opd.push(calc(v1, v2, op));
                }
                opt.pop();
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (opt.size() > 0 && opt.peek() != '(' && precedence(ch) <= precedence(opt.peek())) {
                    char op = opt.pop();
                    int v2 = opd.pop();
                    int v1 = opd.pop();
                    opd.push(calc(v1, v2, op));
                }
                opt.push(ch);
            }
        }
        while (opt.size() > 0) {
            char op = opt.pop();
            int v2 = opd.pop();
            int v1 = opd.pop();
            opd.push(calc(v1, v2, op));
        }

        System.out.println(opd.pop());
    }
}