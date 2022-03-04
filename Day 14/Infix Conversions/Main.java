import java.io.*;
import java.util.*;

public class Main {

    public static int precedence(char ch) {
        return ch == '*' || ch == '/' ? 1 : 0;
    }

    public static void calc(Stack<Character> opt, Stack<String> pre, Stack<String> post) {
        char operator = opt.pop();

        String prefix2 = pre.pop();
        String prefix1 = pre.pop();
        pre.push(operator + prefix1 + prefix2);

        String postfix2 = post.pop();
        String postfix1 = post.pop();
        post.push(postfix1 + postfix2 + operator);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        Stack<Character> opt = new Stack<>();
        Stack<String> pre = new Stack<>();
        Stack<String> post = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == '(') {
                opt.push(ch);
            } else if (ch == ')') {
                while (opt.size() > 0 && opt.peek() != '(') {
                    calc(opt, pre, post);
                }
                opt.pop();

            } else if (ch == '*' || ch == '/' || ch == '-' || ch == '+') {
                while (opt.size() > 0 && opt.peek() != '(' && precedence(ch) <= precedence(opt.peek())) {
                    calc(opt, pre, post);
                }
                opt.push(ch);

            } else if (!Character.isWhitespace(ch)) {
                pre.push(Character.toString(ch));
                post.push(Character.toString(ch));
            }
        }

        while (opt.size() > 0) {
            calc(opt, pre, post);
        }

        System.out.println(post.pop());
        System.out.println(pre.pop());

    }
}