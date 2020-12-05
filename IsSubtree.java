
public class IsSubtree
{
	static class Node
	{
		int data;
		Node lChild, rChild;
		
		Node(int val)
		{
			data = val;
			lChild = null;
			rChild = null;
		}
	}
	
	static class BinaryTree
	{
		Node rootT1, rootT2;
		
		boolean isIdentical(Node rootT1, Node rootT2)
		{
			if (rootT1 == null && rootT2 == null)
				return true;
			if (rootT1 == null || rootT2 == null)
				return false;
			return (rootT1.data == rootT2.data && isIdentical(rootT1.lChild, rootT2.lChild)
					&& isIdentical(rootT1.rChild, rootT2.rChild));
		}
		
		boolean isSubtree(Node T1, Node T2)
		{
			if (T2 == null)
				return true;
			if (T1 == null)
				return false;
			if (isIdentical(T1, T2))
				return true;
			return isSubtree(T1.lChild, T2) || isSubtree(T1.rChild, T2);
		}
	}
	
	public static void main(String[] args)
	{
		BinaryTree tree = new BinaryTree();
		tree.rootT1 = new Node(37);
		tree.rootT1.rChild = new Node(4); 
        tree.rootT1.rChild.rChild = new Node(4); 
        tree.rootT1.lChild = new Node(13); 
        tree.rootT1.lChild.lChild = new Node(5); 
        tree.rootT1.lChild.lChild.rChild = new Node(22); 
        tree.rootT1.lChild.rChild = new Node(8);
        
        tree.rootT2 = new Node(13); 
        tree.rootT2.rChild = new Node(8); 
        tree.rootT2.lChild = new Node(5); 
        tree.rootT2.lChild.rChild = new Node(22);
        
        if (tree.isSubtree(tree.rootT1, tree.rootT2)) 
            System.out.println("T2 is subtree of T1 "); 
        else
            System.out.println("T2 is not a subtree of T1");
	}

}
