//Runtime Complexity - O(∣E∣+∣V∣) 
//Space Complexity - O(∣E∣+∣V∣) 

class Solution {

  public boolean canFinish(int numCourses, int[][] prerequisites) {
      if(numCourses==0)
          return true;
      HashMap<Integer,List<Integer>> map=new HashMap<>();
      int[] path=new int[numCourses];
      for(int[] prerequisite : prerequisites)
      {
          if(!map.containsKey(prerequisite[1]))
          {
              map.put(prerequisite[1],new ArrayList<>());
          }
          map.get(prerequisite[1]).add(prerequisite[0]);
          path[prerequisite[0]]++;
      }
      Queue<Integer> q1=new LinkedList<>();
      for(int i=0;i<numCourses;i++)
      {
          if(path[i]==0)
              q1.add(i);
      }
      
      int count=0;
      while(!q1.isEmpty())
      {
          int complete=q1.poll();
          count++;
          System.out.println(complete);
          if(map.containsKey(complete))
          {
              for(int course:map.get(complete))
              {
                  int curr=path[course];
                  curr--;
                  if(curr==0)
                  {
                      q1.add(course);
                  }
                  path[course]=curr;
              }   
          }
      }
      
      return count==numCourses;
  }   
}
