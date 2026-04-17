import java.util.*;
class Node {
	int data;
	Node next;

public  Node(int v) {
	data=v;
	next=null;
}
}
public class Main
{
	Node head;
	public void insertatbeg(int v){
	    	Node newnode=new Node(v);

	    if(head==null){
	        head=newnode;
	        return;
	    }
	    newnode.next=head;
	    head=newnode;
	}
	public void insertatend(int v){
	    Node newnode=new Node(v);
	    if(head==null){
	        head=newnode;
	        return;
	    }Node temp=head;
	    while(temp.next!=null){
	        temp=temp.next;
	    }
	    temp.next=newnode;
	        
	}
	public void insertatpos(int v,int p){
	    Node newnode=new Node(v);
	    if(p==0){
	        insertatbeg(v);
	        return;
	    }Node temp=head;
	    int c=0;
	    while(temp.next!=null && c<p-1){
	        temp=temp.next;
	        c++;
	    }
	    newnode.next=temp.next;
	    temp.next=newnode;
	}
	public void deleteatpos(int p){
	    int c=0;
	    Node temp=head;
	    while(temp.next!=null && c<p-1)
{
    temp=temp.next;
    c++;
}	
	    temp.next=temp.next.next;
	}
	public void deleteatbeg(){
	    head=head.next;
	}
	public void deleteatend(){
		if(head==null){
			System.out.println("List is Empty");
		}
		if(head.next==null){
			head=null;
			return;
		}
	    Node temp=head;
	    while(temp.next.next!=null){
	        temp=temp.next;
	    }
	    temp.next=null;
	        
	}
	public void rev(){
	    Node temp=head;
	    Node next=null;
	    Node prev=null;
	    while(temp!=null){
	        next =temp.next;
	        temp.next=prev;
	        prev=temp;
	        temp=next;
	    }
	    head=prev;
	}
	public void display(){
	    Node temp=head;
	    while(temp!=null){
	        System.out.print(temp.data+"->");
	        temp=temp.next;
	    }
	    System.out.println();
	}
	public static void main(String[] args) {
	    Main ob=new Main();
        ob.insertatbeg(50);
        ob.insertatbeg(60);
        ob.insertatbeg(10);
        ob.display();
        ob.insertatend(70);
        ob.display();
        ob.insertatpos(20,3);
        ob.display();
        ob.deleteatbeg();
        ob.display();
        ob.deleteatpos(2);
        ob.display();
        ob.deleteatend();
        ob.display();
        ob.rev();
        ob.display();
	}
}
