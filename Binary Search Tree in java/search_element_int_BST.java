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
    public static boolean findElement(Node root,int key)
    {
        if(root == null)
        return false;
        if(root.data == key)
        return true;
        if(findElement(root.left, key)||findElement(root.right, key))
        return true; 
        return false; 
    }
    static void Postorder(Node root)
    {
        if(root != null)
        {
            Postorder(root.left);
            Postorder(root.right);
            System.out.print(root.data+" ");
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
        System.out.println("Enter the element to be searched: ");
        int key=sc.nextInt();
        if(findElement(root,key))
        System.out.print("Element found");
        else
        System.out.print("Element not found");
    }
}