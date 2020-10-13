Q1: Level order traversal

Logic: traverse every level and add all the nodes on the level using BFS.Queue will be used
to add element and poll and add to arraylist.
Time Complexity : O(n)
SPace :O(n)

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root); 
        
        while(!q.isEmpty()){
            //for every level
            List<Integer> level  = new ArrayList<>();
            int size = q.size();
            for(int i=0;i<size;i++){
                if(q.peek().left!=null) q.add(q.peek().left);
                if(q.peek().right!=null) q.add(q.peek().right);
                level.add(q.poll().val);
            }
            result.add(level);    
            }
        return result;
         
        }
    
    }




Q2: Course Schedule

Logic : If there exists a cycle then course cannot be taken.Using DFS can traverse and check if 
every node is visited and explored.If it is visited and explored i.e cycle exists.

class Solution {
    List<Integer>[] adj;
    boolean[]visited;
    boolean[]marked;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adj = new ArrayList[numCourses];
        for(int i=0;i< numCourses;i++){
            adj[i] = new ArrayList<>();
            
        }
        
        visited = new boolean[numCourses];
        marked = new boolean[numCourses];
        
        for(int i=0;i< prerequisites.length;i++){
            adj[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        
        for(int i=0;i< numCourses;i++){
            if(!visited[i]){
                if(isCyclic(i)){
                    return false;
                }
            }

        }
        return true;
            
            
    }
    private boolean isCyclic(int i){
        visited[i] = true;
        for(Integer j: adj[i]){
            if(!visited[j]){
                if(isCyclic(j)){
                    return true;
                }
            }
            else if(!marked[j]){
                return true;
            }
         }
    
    
     marked[i] = true;
    return false;
 }
}
