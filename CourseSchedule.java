class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int [] indegree = new int [numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap();
        for (int i = 0; i< prerequisites.length; i++) {
            // (ai,  bi) : bi ->ai
            if(!map.containsKey(prerequisites[i][1])) {
                map.put(prerequisites[i][1], new ArrayList());
            }
            List<Integer> curr = map.get(prerequisites[i][1]);
            curr.add(prerequisites[i][0]);
            map.put(prerequisites[i][1], curr);
            
            indegree[prerequisites[i][0]] += 1;
            
        }
        
        System.out.println("map"+map);
        
        
        Queue<Integer> courseQueue = new LinkedList();
        
//          add all course having zero prequesite
        for(int i = 0;  i < indegree.length;i++) {
            System.out.println(" i "+ i + " indegree : "+indegree[i]);
            if(indegree[i] == 0) {
                courseQueue.add(i);
            }
        }
        
        while(!courseQueue.isEmpty()) {
            Integer coursetaken = courseQueue.poll();
            System.out.println("courseTal"+coursetaken);
            List<Integer> li = map.get(coursetaken);
            if(li != null) {
                for(int j = 0; j< li.size(); j++) {
                    indegree[li.get(j)] -= 1;
                    if(indegree[li.get(j)] == 0) {
                        courseQueue.add(li.get(j));
                    }
                }
                
            }
            
        }
        
        for(int i = 0;  i < indegree.length;i++) {
            if(indegree[i] > 0) {
                return false;
            }
        }
        
        
        
        return true;
    }
}
