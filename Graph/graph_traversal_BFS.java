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
  
  void bfs(int v){
      int k = list.size();
      boolean visited[] = new boolean[k];
      Queue<Integer> q = new LinkedList<>();
      q.add(v);
      visited[v] = true;
      System.out.println("BFS: ");
      while(!q.isEmpty()){
          int m = q.remove();
          System.out.println(m+" ");
          for(int i=0; i<list.get(m).size(); i++){
              int h = list.get(m).get(i);
              if(!visited[h]){
                  q.add(h);
                  visited[h] = true;
              }
          }
      }
  }

    public static void main(String[] args) {
      Scanner in=new Scanner(System.in);
      System.out.print("Enter Number of Vertices: ");
      int k=in.nextInt();
      System.out.print("\nEnter Number of Edges: ");
      int e = in.nextInt();
      graph g=new graph(k);
      for(int i=0;i<e;i++)
      {
        int u=in.nextInt();
        int v=in.nextInt();
        g.push(u, v);
      }
        g.display();
        g.bfs(0);
      
    }
      
    
}