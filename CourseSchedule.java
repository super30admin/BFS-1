// BFS solution

// Time complexity: O(V+E)
// Space complexity: O(V+E)
// Run on leetcode: Yes
// Issues faced: forgot to check if queue is empty after the first iteration throught the indegrees array and also forgot to keep a counter to count if all the nodes have been in the queue.

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0)
            return true;
        int [] incoming = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        //adjacency list and indegree array initialization
        for(int i=0; i<prerequisites.length; i++){
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            List<Integer> li = map.getOrDefault(b, new ArrayList<>());
            li.add(a);
            map.put(b, li);
            incoming[a]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        int counter = numCourses;
        for(int i=0; i<incoming.length; i++){
            if(incoming[i] == 0){
                queue.add(i);
                counter--;
            }
        }
        if(queue.isEmpty())
            return false;
        
        while(!queue.isEmpty()){
            int p = queue.poll();
            if(map.get(p) != null){
                for(int m: map.get(p)){
                    incoming[m]--;
                    if(incoming[m]==0){
                        queue.add(m);
                        counter--;
                    }
                    if(incoming[m]<0)
                        return false;
                }
            }
        }
        if(counter == 0)
            return true;
        else
            return false;
    }
}

// DFS solution

// Time complexity: O(V+E)
// Space complexity: O(V+E)
// Run on leetcode: Yes
// Issues faced: Has some isuues with the return res part in the recursion as well as in the canFinish function. The issue was that I was unable to figure out when to return false and when to return true without debugging.

class Solution {
    int[] path;
    int[] visited;
    Map<Integer, List<Integer>> map;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0)
            return true;
        this.path = new int[numCourses];
        this.visited = new int[numCourses];
        this.map = new HashMap<>();
        for(int i=0; i<prerequisites.length; i++){
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            if(map.containsKey(b)){
                List<Integer> li = map.get(b);
                li.add(a);
                map.put(b, li);
            }
            else
                map.put(b, new ArrayList<>(Arrays.asList(a)));
        }
        System.out.println(map);
        
        for(int i=0; i<prerequisites.length; i++){
             boolean res = helper(prerequisites[i][1]);
            if(res == false)
                return false;
        }
        return true;
    }
    
    private boolean helper(int root){
        if(path[root] == 1)
            return false;
        if(visited[root] == 1)
            return true;
        
        path[root] = 1;
        visited[root] = 1;
        
        List<Integer> children = map.get(root);
        if(children != null){
            for(int child: children){
                boolean res = helper(child);
                if(res == false)
                    return false;
            }
        }
        path[root] = 0;
        return true;
    }
}
