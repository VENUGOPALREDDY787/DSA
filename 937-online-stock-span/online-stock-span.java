class StockSpanner {
    Stack<Integer> S1 ;
    Stack<Integer> Span;
    public StockSpanner() {
        S1 = new Stack<>();
        Span = new Stack<>();
    }
    
    public int next(int price) {
        int span =1;
       while(!S1.isEmpty()&&S1.peek()<=price){
        span+=Span.pop();
        S1.pop();
       }
       Span.push(span);
       S1.push(price);
       return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */