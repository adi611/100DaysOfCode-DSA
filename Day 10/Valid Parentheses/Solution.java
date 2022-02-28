class Solution {
    public boolean isValid(String str) {
        Stack<String> check = new Stack<String>();
        if (str.length() > 0) {
            check.push(Character.toString(str.charAt(0)));
        }

        for (int i = 1; i < str.length(); i++) {
            char ch = str.charAt(i);
            String sch = Character.toString(ch);
            if (check.size() > 0 && (check.peek().equals("(") && ch == ')' || check.peek().equals("{") && ch == '}'
                    || check.peek().equals("[") && ch == ']')) {
                check.pop();

            } else {
                check.push(sch);
            }
        }

        return (check.size() > 0 ? false : true);
    }
}