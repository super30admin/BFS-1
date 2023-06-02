class Solution {
    HashMap<Integer,List<Integer>> map;
    List<List<Integer>> result;
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        map = new HashMap<>();
        if(root == null) return result;
        DFS(root,0);
        for(List<Integer> list : map.values()){
            result.add(list);
        }
        return result;
    }
    
    private void DFS(TreeNode root,int level){
        //base
        if(root == null) return;
        
        if(!map.containsKey(level)){
            map.put(level, new ArrayList<>());
        }
        map.get(level).add(root.val);       
        
        //logic
        DFS(root.left,level + 1);        
        
        DFS(root.right,level + 1);
    }
}


class Solution {
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        int [] indegrees = new int[numCourses];
        
        //Data pre-processing creating Ajecency list and indegrees array
        for(int[] arr: prerequisites){
            if(!map.containsKey(arr[1])){
                map.put(arr[1],new ArrayList<>());
            }
            map.get(arr[1]).add(arr[0]);
            indegrees[arr[0]]++;
        }
        
        int count = 0;
        Queue<Integer> que = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegrees[i] == 0){
                que.add(i);
                count++;
            }
        }
        if(que.isEmpty()) return false;
        
        while(!que.isEmpty()){
            int taken = que.poll();
            List<Integer> temp = map.get(taken);
            if(temp != null){
                for(int course : temp){
                indegrees[course]--;
                if(indegrees[course] == 0){
                    que.add(course);
                    count++;
                }
            }
            }
            
        }
        if(count == numCourses) return true;
        return false;        
    }
}
