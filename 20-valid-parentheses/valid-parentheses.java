class Solution {
    public boolean isValid(String s) {
        final String opens = "({[";
        final String closers = ")}]";

        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (stack.isEmpty() || opens.contains(c.toString())) {
                stack.push(c);
            } else {
                Character prev = stack.peek();
                if (c == ']') {
                    if (prev == '[') {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
                if (c == '}') {
                    if (prev == '{') {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
                if (c == ')') {
                    if (prev == '(') {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}