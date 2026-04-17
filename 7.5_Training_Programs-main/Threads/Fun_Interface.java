// Functional interface
class data implements Runnable{
    public void run(){
        for(int i=1;i<=5;i++){
            char ch=(char)(96+i);
            System.out.println(ch);
            try{
                Thread.sleep(3000);
            }catch (InterruptedException e){}
        }
    }
}
class Main{
    public void main(String args[]) throws InterruptedException{
        data d1=new data();
        Thread t1=new Thread(d1);
        t1.start();
        //Ananymous function
        Runnable r1=() ->
        {
            for(int i=0;i<7;i++){
                System.out.println("JAVA");
                try{
                    Thread.sleep(3000);
                }catch(InterruptedException e){}
            }
        };
        Thread t2=new Thread(r1);
        t2.start();
        System.out.println("End of Statement");
    }
}