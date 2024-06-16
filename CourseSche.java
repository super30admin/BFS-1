import java.util.*;
public class CourseSche {
    public boolean canFinish(int numCourses, int[][] prerequisites)
    {
        if(numCourses==0)
        {
            return true;
        }
        int[] indegree= new int[numCourses];
        Queue<Integer> q=new LinkedList<>();
        HashMap<Integer, List<Integer>> map= new HashMap<>();
        int count=0;
        for(int[] pre : prerequisites)
        {
            int from=pre[1];
            int to= pre[0];
            indegree[to]++;
            if(!map.containsKey(from))
            {
                map.put(from,new ArrayList<>());
            }
            map.get(from).add(to);
        }
        for(int i = 0; i < indegree.length; i++)
        {
            if(indegree[i] == 0)
            {
                count++;
                q.add(i);
            }
        }
        while(!q.isEmpty()){

            int course = q.poll();
            List <Integer> edges = map.get(course);
            if(edges == null)
            {
                continue;
            }
            for(Integer edge : edges)
            {
                indegree[edge]--;
                if(indegree[edge] == 0)
                {
                    q.add(edge);
                    count++;
                }
            }
        }
        return count== numCourses;
    }
    public static void main(String[] args) {
        CourseSche cs = new CourseSche();
        int numCourses = 2;
        int[][]prerequisites = {{1,0},{0,1}};
        System.out.println(cs.canFinish(numCourses, prerequisites));
    }
}
