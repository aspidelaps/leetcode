class MyQueue {

    private Stack<Integer> firstStack;
    private Stack<Integer> secondStack;

    public MyQueue() {
        this.firstStack = new Stack<>();
        this.secondStack = new Stack<>();
    }

    public void push(int x) {
        firstStack.push(x);
    }

    public int pop() {
        while (!firstStack.isEmpty()) {
            secondStack.push(firstStack.pop());
        }
        Integer popped = secondStack.pop();
        while (!secondStack.isEmpty()) {
            firstStack.add(secondStack.pop());
        }
        return popped;
    }

    public int peek() {
        while (!firstStack.isEmpty()) {
            secondStack.push(firstStack.pop());
        }
        Integer peeked = secondStack.peek();
        while (!secondStack.isEmpty()) {
            firstStack.add(secondStack.pop());
        }
        return peeked;
    }

    public boolean empty() {
        return firstStack.isEmpty();
    }
}