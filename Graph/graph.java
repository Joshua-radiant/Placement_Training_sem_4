import java.util.*;

class graph
{
  ArrayList<ArrayList<Integer>> list=new ArrayList<>();
  graph(int v)
  {
    for(int i=0;i<v;i++)
    {
      list.add(new ArrayList<Integer>()); 
    }
  }
  void push(int u, int v)
  {
    list.get(u).add(v);
    list.get(v).add(u);
  }
  void display()
  {
    for(int i=0;i<list.size();i++)
    {
      System.out.println("vertex: "+i);
      for(int j=0;j<list.get(i).size();j++)
      {
        System.out.println(" "+list.get(i).get(j));
      }
    }
  }

    public static void main(String[] args) {
      Scanner in=new Scanner(System.in);
      int k=in.nextInt();
      graph g=new graph(k);
      for(int i=0;i<k;i++)
      {
        int u=in.nextInt();
        int v=in.nextInt();
        g.push(u, v);
      }
        g.display();
      
    }
      
    
}