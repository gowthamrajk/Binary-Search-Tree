import java.util.Scanner;
class Node
{
    int data;
    Node left = null;
    Node right = null;
    Node(int data)
    {
        this.data=data;
    }
}
public class Main
{
    public static Node creatNewNode(int data)
    {
        Node newNode = new Node(data);
        newNode.left = null;
        newNode.right = null;
        return newNode;
    }
    public static Node insertNode(Node root,int data)
    {
        if(root == null)
        {
            root = creatNewNode(data);
            return root;
        }
        if(data <= root.data)
        root.left = insertNode(root.left,data);
        else if(data > root.data)
        root.right = insertNode(root.right,data);
        return root;
    }
    static void print(Node root)
    {
        if(root != null)
        {
            System.out.print(root.data+" ");
            print(root.left);
            print(root.right);
        }
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        Node root = null;
        System.out.println("Enter the number of Nodes to be inserted: ");
        int N = sc.nextInt();
        System.out.println("Enter the value of Nodes: ");
        for(int index=1;index<=N;index++)
        {
            root = insertNode(root,sc.nextInt());
        }
        System.out.println("Values in Nodes are: ");
        print(root);
    }
}