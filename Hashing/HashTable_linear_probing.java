class HashTable{
    int n;
    int[] table;
    
    HashTable(int size){
        this.n = size;
        this.table = new int [n];
    }
    
    public int fun(int data){
        return data % n;
    }
    
    public void insert(int data){
        int index = fun(data);
        while(table[index] != 0){
            index = (index+1) % n;
        }
        table[index] = data;
    }
    
    public void display(){
        for(int i=0;i<n;i++){
            System.out.println("Index "+i +" : "+table[i]);
        }
    }
    public static void main(String[] args){
        int list[] = {15, 5, 6, 8, 17, 21};
        HashTable h = new HashTable(7);
        
        for(int i : list){
            h.insert(i);
        }
        h.display();
        
    }
}