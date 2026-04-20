import java.util.*;

class HashTable{
    private int n;
    private List<List<Integer>> table ;
    
    HashTable(int n){
        this.n = n;
        this.table = new ArrayList<>();
        for(int i =0;i<n;i++){
            table.add(new ArrayList<Integer>());
        }
    }
    
    public int create(int data){
        return data % n;
    }
    
    public void insert(int data){
        int loc = create(data);
        table.get(loc).add(data);
    }
    public void display(){
        for(int i =0;i<table.size() ;i++){
            System.out.println("Index : "+ i + " : "+ table.get(i));
        }
    }
    
    public boolean search(int key){
        int k=create(key);
        for(int m:table.get(k)){
            if(m==key){
                return true;
            }
        }return false;
    }
    
    public static void main(String args[]){
        int [] list = {12, 2, 4, 32, 66};
        HashTable h = new HashTable(7);
        
        for(int i : list){
            h.insert(i);
        }
        
        h.display();
        if(h.search(2)){
            System.out.println("Found");
        }
        else{
            System.out.println("Not Found");
        }
    }
    
}