//time complexity: o(n)

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int [] indegrees = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int [] edge: prerequisites){
            int in = edge[0];
            int out = edge[1];
            if(!map.containsKey(out)){
                map.put(out, new ArrayList<>());
            }
            map.get(out).add(in);
            indegrees[in]++;
            
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < indegrees.length; i++){
            if(indegrees[i] == 0){
                q.add(i);
            }
        }
        if(q.isEmpty()) return false;
        while(!q.isEmpty()){
            int curr = q.poll();
            if(map.get(curr) == null) continue;
            for(int c: map.get(curr)){
                indegrees[c]--;
                if(indegrees[c] == 0){
                    q.add(c);
                }
            }
        }
        for(int i = 0; i < indegrees.length; i++){
            if(indegrees[i] > 0) return false;
        }
        return true;
      
            
            
        }
        
    }
