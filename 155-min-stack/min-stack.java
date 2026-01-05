class MinStack {
    Stack<Integer> s;
    Stack<Integer> sm;
    public MinStack() {
       s = new Stack<>();
       sm = new Stack<>();
    }
    
    public void push(int val) {
    s.push(val);

    if (sm.isEmpty()) {
        sm.push(val);
    } else if (sm.peek() > val) {
        sm.push(val);
    } else {
        sm.push(sm.peek());
    }
}

    
    public void pop() {
        s.pop();
        sm.pop();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return sm.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */