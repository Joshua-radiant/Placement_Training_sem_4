import java.util.*;
class Node{
    int data;
    int height;
    Node left;
    Node right;
    
    public Node(int val){
        data = val;
        left  = null;
        right = null;
    }
}

class Tree {
    
    Node create(int val){
        return new Node(val);
    }
    
    Node insert(Node root, int val){
        if(root == null){
            return create(val);
        }
        if(val < root.data){
            root.left = insert(root.left, val);
        }
        else{
            root.right = insert(root.right, val);
        }
        return root;
    }
    
    public void inorder(Node root){
        if(root != null){
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
    
    public void preorder(Node root){
        if(root != null){
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    
    public void postorder(Node root){
        if(root != null){
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }
    
    public void levelorder(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node curr = q.poll();
            System.out.print(curr.data + " ");
            if(curr.left != null){
                q.add(curr.left);
            }
            if(curr.right != null){
                q.add(curr.right);
            }
        }
    } 
    
    public void topview(Node root){
        TreeMap<Integer, Integer> m = new TreeMap<>();
        Queue<Node> que = new LinkedList<>();
        
        que.add(root);
        while(!que.isEmpty()){                
            
            Node cur = que.poll();
            int h = cur.height;
                
            if(!m.containsKey(h)){
                m.put(h, cur.data); 
            }
            if(cur.left != null){
                que.add(cur.left);
                cur.left.height = h - 1;
            }
            if(cur.right != null){
                    que.add(cur.right);
                    cur.right.height = h + 1;
            }
        }
        for(Integer i : m.values()){
            System.out.print(i+" ");
        }
    }
    
    public void leftview(Node root){
        Queue<Node> q1 = new LinkedList<>();
        q1.add(root);
        
        while(!q1.isEmpty()){
            int size = q1.size();
            for(int i=0;i<size;i++){
                Node c = q1.poll();
                
                if(i == 0){
                    System.out.print(c.data + " ");
                }
                
                if(c.left != null){
                    q1.add(c.left);
                }
                if(c.right != null){
                    q1.add(c.right);
                }
            }
        }
    }
    
    public void rightview(Node root){
        Queue<Node> q1 = new LinkedList<>();
        q1.add(root);
        
        while(!q1.isEmpty()){
            int size = q1.size();
            for(int i=0;i<size;i++){
                Node c = q1.poll();
                
                if(i == size-1){
                    System.out.print(c.data + " ");
                }
                
                if(c.left != null){
                    q1.add(c.left);
                }
                if(c.right != null){
                    q1.add(c.right);
                }
            }
        }
    }
    
    public Node findmin(Node root){
        while(root.left !=null){
            root=root.left;
        }
        return root;
    }
    
    public Node findmax(Node root){
        while(root.right !=null){
            root=root.right;
        }
        return root;
    }
    
    public Node delete(Node root,int key){
        if(root==null){
            return null;
        }
        if(key<root.data){
            root.left=delete(root.left,key);
        }
        else if(key>root.data){
            root.right=delete(root.right,key);
        }
        else{
            if(root.left==null){
                return root.right;
            }
            if(root.right==null){
                return root.left;
            }
            
            Node temp=findmin(root.right);
            root.data = temp.data;
            root.right=delete(root.right,temp.data);
        }
        return root;
    }
    
    public boolean search(Node root, int key){
        if(root == null){
            return false;
        }
        if(root.data == key){
            return true;
        }
        else if(key < root.data){
            return search(root.left, key);
        }
        else if(key > root.data){
            return search(root.right, key);
        }
        else{
            return false;
        }
    }
    
    public int leafcount(Node root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        return leafcount(root.left) + leafcount(root.right);
    }
    
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        Tree t1 = new Tree();
        int k = sc.nextInt();
        
        Node root = t1.create(k);
        while(true){
            int data = sc.nextInt();
            if(data == -1){
                break;
            }
            t1.insert(root,data);
        }
        
        System.out.print("Inorder Traversal: ");
        t1.inorder(root);
        System.out.println();
        System.out.print("Preorder Traversal: ");
        t1.preorder(root);
        System.out.println();
        System.out.print("Postorder Traversal: ");
        t1.postorder(root);
        System.out.println();
        System.out.print("LevelOrder traversal: ");
        t1.levelorder(root);
        System.out.println();
        System.out.print("Topview of tree: ");
        t1.topview(root);
        System.out.println();
        System.out.print("Leftview of tree: ");
        t1.leftview(root);
        System.out.println();
        System.out.print("Rightview of tree: ");
        t1.rightview(root);
        System.out.println();
        System.out.print("Minimum Value: " + t1.findmin(root).data);
        System.out.println();
        System.out.print("Maximam Value: " + t1.findmax(root).data);
        System.out.println();
        System.out.print("Enter value to Search: ");
        int z = sc.nextInt();
        System.out.print("Searching " + z + " in Tree :" + t1.search(root, z));
        System.out.println();
        System.out.println("Leaf Node Count: " + t1.leafcount(root));
        System.out.print("Enter value to delete from Tree: ");
        int b = sc.nextInt();
        System.out.print("Tree after Deleting "+ b + " : ");
        root = t1.delete(root,b);
        t1.inorder(root);
        System.out.println();
        
    }
}
