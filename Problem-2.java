//TC:O(N)
//SC:O(N)

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) 
    {
     int a[]=new int[numCourses];
     HashMap<Integer,List<Integer>> map = new HashMap<>();
        
     for(int i=0;i<prerequisites.length;i++)
     {
       a[prerequisites[i][0]]++;
       int l = prerequisites[i][0];
       int r = prerequisites[i][1];
       if(map.containsKey(r))
          map.get(r).add(l);
        else
       {
         List<Integer> p = new ArrayList<>();
         p.add(l);
         map.put(r,p);             
       }
     }
        
     Queue<Integer> q = new LinkedList<>();    
     for(int i=0;i<a.length;i++) 
     {
       if(a[i]==0)  
         q.add(i);
     }
         
     if(q.isEmpty())
         return false;
        
     while(!q.isEmpty())
     {
        int res = q.poll();
        List<Integer> n =map.get(res);
        if(n!=null)
        for(int i=0;i<n.size();i++)
        {
            a[n.get(i)]--;
            if(a[n.get(i)]==0)
                q.add(n.get(i));
        }
  
     }
        
        for(int i=0;i<a.length;i++)
            if(a[i]!=0)
               return false;
        
        return true;
    }
}