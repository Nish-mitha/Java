public class BinarySearchTree
{
    Node root;
    public class Node
    {
        int data;
        Node right;
        Node left;
        Node(int d)
        {
            data=d;
            right=null;
            left=null;
        }
    }

    // Method to insert data into BST
    public void insert(int value)
    {
        root=insertNode(root,value);
    }

    // Method to create node and insert data into BST
    public Node insertNode(Node root,int data)
    {
        Node new_node= new Node(data);
        if(root==null)
        {
            root=new_node;
            return root;
        }
        else if(new_node.data<=root.data)
            root.left=insertNode(root.left,new_node.data);
        else
            root.right=insertNode(root.right,new_node.data);
        return root;
    }

    // Method to print values in the BST
    public void inorder(Node root)
    {
        Queue<Node> queue= new Queue<Node>();
        if(root== null)
            return;
        queue.add(root);
        while(queue!=)

    }

    public static void main(String args[])
    {
        BinarySearchTree BST=new BinarySearchTree();
        BST.insert(20);
        BST.insert(50);
        BST.insert(2);
    }
}