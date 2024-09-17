// time: O(n)
// space: O(n)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] course=new int[numCourses];
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<prerequisites.length;i++)
        {
            course[prerequisites[i][0]]++;
            if(!map.containsKey(prerequisites[i][1]))
            {
                map.put(prerequisites[i][1],new ArrayList<Integer>());
            }
            map.get(prerequisites[i][1]).add(prerequisites[i][0]); 
        }
        // ading 1st level
        for(int i=0;i<course.length;i++)
        {
            if(course[i]==0) queue.add(i);
        }
        while(!queue.isEmpty())
        {
            int c=queue.poll();
            List<Integer> children=map.get(c);
            if(children!=null){
            for(int child:children)
            {
                course[child]--;
                if(course[child]==0) queue.add(child); // if dependecny is not there thn add
            }
            }    
        }
        for(int i=0;i<course.length;i++)
        {
            if(course[i]>0) return false;
        }
        return true;
    }
}