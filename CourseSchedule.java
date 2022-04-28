//time - O(V+E)
//space - O(V+E)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites==null || prerequisites.length==0) return true;

        int[] inDegree = new int[numCourses];
        Map<Integer,List<Integer>> map = new HashMap<>();
        int completedCourses = 0;
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<numCourses; i++){
            map.put(i, new ArrayList<>());
        }

        for(int[] edge : prerequisites){
            map.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }

        for(int i=0 ; i<inDegree.length; i++){
            if(inDegree[i]==0){
                q.add(i);
                completedCourses++;
            }
        }

        while(!q.isEmpty()){
            int currCourse = q.poll();
            for(Integer dependantCourse : map.get(currCourse)){
                inDegree[dependantCourse]--;
                System.out.print(inDegree[dependantCourse]+" ");
                if(inDegree[dependantCourse]==0){
                    q.add(dependantCourse);
                    completedCourses++;
                }
            }
        }

        return completedCourses==numCourses;

    }
}
