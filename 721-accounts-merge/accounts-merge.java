class Solution {
   static  List<List<String>>ll;
     static   String[][]account;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
         account = new String[accounts.size()][];

for(int i = 0; i < accounts.size(); i++) {
    account[i] = accounts.get(i).toArray(new String[0]);
}     
solve();
return ll;
    }
    public static void solve() {
	// String[][]accounts = {{"John","johnsmith@mail.com","john_newyork@mail.com"},{"John","johnsmith@mail.com","john00@mail.com"},{"Mary","mary@mail.com"},{"John","johnnybravo@mail.com"}};
	DisjointSet dj=new DisjointSet();
	for(String []s:account) {
		for(int i=1;i<s.length;i++) {
			dj.createSet(s[0], s[i]);
		}
	}
	for(String s[]:account)
	for(int i=1;i<s.length-1;i++) {
		if(dj.find(s[i])!=dj.find(s[i+1])) {
			dj.union(s[i], s[i+1]);
		}
	}
	ll=new ArrayList<>();
	HashMap<String, List<String>> groups = new HashMap<>();
//	for(String []s:accounts) {
//		
//	for(int i=1;i<s.length;i++) {
//		String email=s[i];
//	String root = dj.find(email);
//
//	groups.putIfAbsent(root, new ArrayList<>());
//	groups.get(root).add(email);
//}
//}
	for(String email : dj.map.keySet()) {

	    String root = dj.find(email);

	    groups.putIfAbsent(root,new ArrayList<>());

	    groups.get(root).add(email);
	}
	for(String root : groups.keySet()) {

	    List<String> emails = groups.get(root);

	    Collections.sort(emails);

	    List<String> account = new ArrayList<>();

	    String name = dj.map.get(root).p;

	    account.add(name);

	    account.addAll(emails);

	    ll.add(account);
	}
	// for(int i=0;i<ll.size();i++) {
	// 	for(int j=0;j<ll.get(i).size();j++) {
	// 		System.out.print(ll.get(i).get(j)+" ");
	// 	}
	// }
}
public  static class DisjointSet{
	
	public class Node{
		String val;
		int rank=0;
		Node parent;
		String p;
	}
	HashMap<String,Node>map=new HashMap<>();
	public void createSet(String p,String v) {
		if(!map.containsKey(v)) {
		    Node nn = new Node();
		    nn.val = v;
		    nn.rank = 1;
		    nn.p = p;
		    nn.parent = nn;
		    map.put(v, nn);
		}
	}
	public String find(String v) {
		Node nn=map.get(v);
		return find(nn).val;
	}
	public Node find(Node nn) {
		if(nn==nn.parent) {
			return nn;
		}
		Node rn=find(nn.parent);
		nn.parent=rn;
		return rn;
	}
	public void union(String v1,String v2) {
		Node n1=map.get(v1);
		Node n2=map.get(v2);
		Node rn1=find(n1);
		Node rn2=find(n2);
		if(rn1==rn2) {
			return ;
		}
		if(rn1.rank==rn2.rank) {
			rn2.parent=rn1;
			rn1.rank++;
		}
		if(rn1.rank>rn2.rank) {
			rn2.parent=rn1;
			
		}
		else {
			rn1.parent=rn2;
		}
	}
	
}

}