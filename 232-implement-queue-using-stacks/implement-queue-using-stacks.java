class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        int top = 1;
        if(!s1.isEmpty()){
            while(!s1.isEmpty()){
                top = s1.pop();
                s2.push(top);
            }
            s1.push(x);
             while(!s2.isEmpty()){
                top = s2.pop();
                s1.push(top);
            }
        }else{
            s1.push(x);
        }
    }
    
    public int pop() {
        if(empty())return -1;
       return s1.pop();
    }
    
    public int peek() {
        if(empty())return -1;
        return s1.peek();
    }
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */