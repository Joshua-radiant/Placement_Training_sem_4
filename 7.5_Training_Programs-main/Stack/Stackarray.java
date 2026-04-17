import java.util.*;
public class Stackarray{
    final int max = 5;
    int arr[] = new int[max];
    int top;
    
    Stackarray(){
        top = -1;
    }
    
    void push(int val){
        if(top >= max){
            System.out.println("Overflow");
            return;
        }
        arr[++top] = val;
    }
    
    void pop(){
        if(top == -1){
            System.out.println("Underflow");
        }
        else{
            System.out.println("Popped: "+arr[top]);
            top--;
        }
    }
    
    void peek(){
        if(top == -1){
            System.out.println("Empty");
        }
        else{
            System.out.println(arr[top]);
        }
    }
    
    void display(){
        if(top == -1){
            System.out.println("Empty");
        }
        else{
            for(int i=top;i>=0;i--){
                System.out.println(arr[i]);
            }
        }
    }
    
    public static void main(String [] args){
        Stackarray s = new Stackarray();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
       // s.push(50);
        System.out.println();
        s.peek();
        s.pop();
        System.out.println();
        s.display();
    }
    
}