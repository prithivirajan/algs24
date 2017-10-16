package learn.algorithm.symboltable;


public class BinarySearchTreeST<Key extends Comparable<Key>, Value> {
	
	private Node root;
	
	private class Node{
		private Key key;
		private Value value;
		private Node left;
		private Node right;
		private int count;
		
		public Node(Key key, Value value, Node left, Node right){
			this.key=key;
			this.value=value;
			this.left=left;
			this.right=right;
			this.count=1;		
		}
	}

	public void put(Key key, Value value) {
		root = add(root, key, value);		
	}
	
	private Node add(Node node, Key key, Value value){
		
		if(node == null) return new Node(key, value, null, null);				
	
		int cmp = key.compareTo(node.key);
		
		if(cmp>0) 
			node.right = add(node.right, key, value);
		else if(cmp<0) 
			node.left = add(node.left, key, value);
		else node.value=value;
		
		node.count = 1 + size(node.left) + size(node.right);
		return node;
	}

	private int size(Node x) {
		if(x==null) return 0;
		return x.count;
	}

	public int size() {
		return size(root);
	}

	public void remove(Key key) {
		root = remove(key, root);
	}

	private Node remove(Key key, Node x) {
		
		if(x==null) return x;
		int cmp = key.compareTo(x.key);
		
		if(cmp<0) x.left = remove(key, x.left);
		else if(cmp>0) x.right = remove(key, x.right);
		else{
			if(x.right==null) return x.left;
			
			Node t=x;
			x=min(t.right);
			x.right=deleteMin(t.right);
			x.left=t.left;
		}
		return x;
	}

	private Node deleteMin(Node x) {
		if(x.left==null)return x.right;
		x.left = deleteMin(x.right);
		x.count = size(x.left)+size(x.right)+1;
		return x;
	}

	private Node min(Node x) {
		if(x == null) return x;
		while(x.left != null)
			x = x.left;
			
		return x;
	}

	public Value min() {
		Node node = root;
		
		while(node.left !=null ){
				node=node.left;
		}
		return node.value;
	}

	public Value floor(Key key) {
		return floor(root, key).value;
	}

	private Node floor(Node x, Key key) {
		
		if(x==null) return x;
		
		int cmp = key.compareTo(x.key);
		if(cmp == 0) return x;
		
		if(cmp < 0) return floor(x.left, key);
		
		Node t = floor(x.right, key);
		if(t != null) return t;
		else return x;
	}

	public int rank(Key key) {
		return rank(key, root);
	}

	private int rank(Key key, Node x) {
		if(x==null) return 0;
		
		int cmp = key.compareTo(x.key);			
		if(cmp ==0) return 1+x.left.count+x.right.count;
		
		if(cmp < 0) return rank(key, x.left);
		else return rank(key, x.right);
	}
}