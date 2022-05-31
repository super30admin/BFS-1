//https://leetcode.com/problems/course-schedule/

// Time Complexity :O(n) 
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree=new int[numCourses];
        calculate_indegree(indegree,prerequisites);
        System.out.println(Arrays.toString(indegree));
        HashMap<Integer,ArrayList<Integer>> adjlist=new HashMap<>();
        calculate_adj(adjlist,prerequisites);
        Queue<Integer> iq=new LinkedList<>();
        //traverse through indegree array and get independent nodes
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0)
                iq.add(i);
        }
        if(iq.isEmpty())
            return false;
        while(!iq.isEmpty())
        {
            int node=iq.poll();
            ArrayList<Integer> temp=adjlist.get(node);
            if(temp!=null)
            for(int i=0;i<temp.size();i++)
            {
                indegree[temp.get(i)]-=1;
                if(indegree[temp.get(i)]==0)
                    iq.add(temp.get(i));
            }
            adjlist.remove(node);
        }
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]!=0)
                return false;
        }

        System.out.println(adjlist);
        return true;
    }
    private void calculate_indegree(int[] indegree,int[][] prerequisites)
    {
        for(int[] i: prerequisites)
        {
            indegree[i[0]]+=1;
        }
    }
    private void calculate_adj(HashMap<Integer,ArrayList<Integer>> adjlist,int[][] prerequisites)
    {
        for(int[] i: prerequisites)
        {
            if(adjlist.containsKey(i[1]))
            {
                ArrayList<Integer> temp=adjlist.get(i[1]);
                temp.add(i[0]);
                adjlist.put(i[1],temp);
            }
            else
            {
                ArrayList<Integer> temp=new ArrayList<>();
                temp.add(i[0]);
                adjlist.put(i[1],temp);
            }
        }
    }

}