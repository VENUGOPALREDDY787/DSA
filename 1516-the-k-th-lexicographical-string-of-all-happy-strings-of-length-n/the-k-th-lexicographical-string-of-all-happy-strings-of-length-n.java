class Solution {
    static int count =0;
     static String ans = "";
    public String getHappyString(int n, int k) { 
         count = 0;
        ans = "";

        getthekthString(n,k,'a',"");
        getthekthString(n, k, 'b', "");
        getthekthString(n, k, 'c', "");
        return ans;
    }
    public static void getthekthString(int n,int k ,char curr,String str){
        str+=curr;
        if(str.length() == n){
           count++;
           if(count == k){
            ans = str;
            } 
            return;
        }
        char[] values ={'a','b','c'};
        for(char ch : values){
            if(ch == curr){
                continue;
            }
             getthekthString(n,k,ch,str);
        }
        // if(curr == 'a'){
        //     getthekthString(n,k,'b',str);
        //     getthekthString(n,k,'c',str);
        // }else if(curr =='b'){
        //     getthekthString(n,k,'a',str);
        //     getthekthString(n,k,'c',str); 
        // }else{
        //      getthekthString(n,k,'a',str);
        //       getthekthString(n,k,'b',str);
        // }
        
    }
}