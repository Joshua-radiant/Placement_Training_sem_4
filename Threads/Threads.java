class data extends Thread{
    public void run(){
        for(int i=1;i<=5;i++){
            char ch=(char)(96+i);
            System.out.println(ch);
            try{ Thread.sleep(5000);
             }
             catch (InterruptedException e){};
        }
    }
}
class naturalnum extends Thread{
    public void run(){
        for(int i=1;i<=5;i++){
            System.out.println(i);
            try{ Thread.sleep(3000);
             }
             catch (InterruptedException e){};
        
        }
    }
}
 class Main{
    public static void main(String[] args)throws InterruptedException {
        data d1=new data();
        naturalnum n1=new naturalnum();
         d1.start();
         n1.start();
         if(d1.isAlive()){
             System.out.println("Running");
         }
         d1.join();
         n1.join();
         System.out.println("End of Statement");
         if(n1.isAlive()){
             System.out.println("Running");
             }else{
                 System.out.println("Thread id dead");
             }
    }
}