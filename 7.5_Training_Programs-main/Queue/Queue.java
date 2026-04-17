public class Queue{
    final int size = 5;
    int[] arr = new int[size];
    int front;
    int rear;
    
    Queue(){
        front = -1;
        rear = -1;
    }
    
    void enqueue(int val){
        if(rear == size-1){
            System.out.println("Queue is Full");
        }
        if(front == -1){
            front = 0;
        }
        arr[++rear] = val;
    }
    
    void dequeue(){
        if(front == -1){
            System.out.println("Queue is Empty");
            return;
        }
        System.out.println(arr[front]);
        front++;
    }
    
    void display(){
        for(int i=front; i<=rear;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String [] args){
        Queue q = new Queue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.display();
        q.dequeue();
        q.display();
        
    }
    
}