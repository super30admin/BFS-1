// Time Complexity : O(V+E), V stands for Vertices, E stands for edges
// Space Complexity : O(V) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        
        if(prerequisites==null) return true;

        int[] inDegrees = new int[numCourses];//for maintaining the count of dependency for each node//SC:O(V)

        Map<Integer,List<Integer>> map = new HashMap<>();//SC:O(V+E)

        for(int[] edge:prerequisites){
            inDegrees[edge[0]]++;//increase the dependency count, eg: 1 is dependent on how many courses

            if(!map.containsKey(edge[1])){
               map.put(edge[1],new ArrayList<>());//putting the node which are not dependent on that edge
              
            }

            map.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> q = new LinkedList<>();//Worst Case SC: O(V)

        for(int i=0;i<inDegrees.length;i++){
            if(inDegrees[i]==0) q.offer(i);
        }

        int courses = 0;
        int level = 0;
        while(!q.isEmpty()){

            int size = q.size();
            courses += size;

            for(int i=0;i<size;i++){

                int currCourse = q.poll();//means we have taken this course
                List<Integer> edges = map.get(currCourse);
                
                if(edges==null) continue;//if list of edges not available
                for(int edge : edges){
                    inDegrees[edge]--;

                    if(inDegrees[edge]==0) q.offer(edge);
                }

            }
            level++;
        }
        
        System.out.println("Course Completed in "+level+" Semesters");
        return courses==numCourses ;
    }
}