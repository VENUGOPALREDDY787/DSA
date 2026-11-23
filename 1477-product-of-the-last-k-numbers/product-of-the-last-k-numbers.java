class ProductOfNumbers {
    public ArrayList<Integer>al;
    public ProductOfNumbers() {
        al = new ArrayList<>();
    }
    
    public void add(int num) {
        al.add(num);
    }
    
    public int getProduct(int k) {
        int n = al.size();
        int product = 1;
        for(int i = n-k;i<n;i++){
            product*=al.get(i);
        }
        return product;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */