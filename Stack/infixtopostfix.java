import java.util.*;
class infixtopostfix{
    
    public static int precedence(char choice){
        switch(choice){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
    public static boolean check(char op1,char op2){
        return precedence(op1) >= precedence(op2);
    }
    
    public static String expression(String s){
        StringBuilder postfix=new StringBuilder();
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            
            if(Character.isLetterOrDigit(ch)){
                postfix.append(ch);
            }
            else if(ch=='('){
                st.push(ch);
            } 
            else if(ch==')'){
                 while(!st.isEmpty() && st.peek()!='('){
                     postfix.append(st.pop());
                 }st.pop();
            } 
            else {
                while(!st.isEmpty() && st.peek() !='(' && check(st.peek(),ch)){
                    postfix.append(st.pop());
                }
                st.push(ch);
            }
            
        }
        while(!st.isEmpty()){
            postfix.append(st.pop());
        }
        return postfix.toString();
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine(); 
        
        String result=expression(s);
        System.out.println(result);
    }
    
    
}