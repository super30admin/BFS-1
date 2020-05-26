//Time complexity : O(n) (n for preparing indegree array and hashmap + n for queue operation)
//Space Complexity : O(n) (indegree array and hashmap)
//Runs successfully on leetcode
//No Problem

//Here we will be maintaining a hashmap with courses with arraylist of courses which are dependent on current course
//We will also be maintaing an array with values as number of courses it's dependent upon
//If a course is independent we will be putting it in the queue and try to make each course independent
//if all the courses get independent, we will return true and false otherwise



import java.util.*;

public class BFS_1_Problem_2_courseSchedulee {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0) return true;

        int indeg[] = new int[numCourses];
        Arrays.fill(indeg,0);
        HashMap<Integer,ArrayList<Integer>> hm = new HashMap<>();
        for(int i = 0 ; i < prerequisites.length ; i ++)
        {
            indeg[prerequisites[i][0]]++;
            ArrayList<Integer> arr = hm.getOrDefault(prerequisites[i][1],new ArrayList<>());
            arr.add(prerequisites[i][0]);
            hm.put(prerequisites[i][1],arr);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < indeg.length ; i++)
        {
            if(indeg[i] == 0)
            {
                q.add(i);
            }
        }

        while(!q.isEmpty())
        {
            int curr = q.poll();
            for(Integer e : hm.getOrDefault(curr,new ArrayList<Integer>()))
            {
                indeg[e]--;
                if(indeg[e] == 0)
                {
                    q.add(e);
                }
            }
        }

        for(int i = 0 ; i < indeg.length ; i ++)
        {
            if(indeg[i] != 0)
            {
                return false;
            }
        }
        return true;


    }
}
