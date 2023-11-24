//1.Level order traversal
//Using DFS
//Time Complexity -> O(n)
//Space Complexity -> O(h)
class Solution {
    //Using Depth First Search
    ;
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        levelOrderHelper(root,0,result);
        return result;
        
    }

    private void levelOrderHelper(TreeNode root,int level,List<List<Integer>> result){
        //Base case
        if(root == null) return;

        //recursive case
        if(result.size()==level){
            result.add(new ArrayList());
        }       
        result.get(level).add(root.val);
        level = level + 1;
        levelOrderHelper(root.left,level,result);
        levelOrderHelper(root.right,level,result);



    }
}

//Using BFS
//Time Complexity -> O(n)
//Space Complexity -> O(n/2) -> O(n) of the queue
class Solution {
    //Level Order Traversal Using Breadth First Search(BFS)
    public List<List<Integer>> levelOrder(TreeNode root) {        
        List<List<Integer>> result = new ArrayList();
        if(root == null){
            return  result;
        }
        Queue<TreeNode> q = new LinkedList(); 
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size(); 
            List<Integer> li = new ArrayList();          
            for(int i=0;i<size;i++){
                 TreeNode curr = q.poll();
                 li.add(curr.val);
                 if(curr.left!=null){
                     q.add(curr.left);                     
                 }
                 if(curr.right!=null){
                     q.add(curr.right);
                 }
            }
            result.add(li);
        }
        return result;

    }
            
}

//2nd Course Schedule
//used topological sorting
//Time Complexity -> O(V+E)
//Space Complexity -> O(V + E) of the map,queue -> O(V) and indegrees -> O(V)
class Solution {
    //Using BFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0) return true;
        //dependent->pr[0] -> indegree and independent -> pr[1] -> outdegree
        Map<Integer,List<Integer>> map = new HashMap();
        int[] inDegrees = new int[numCourses];
        for(int[] pr : prerequisites){
            inDegrees[pr[0]] ++; //adding + 1 to indegrees of vertices on dependent nodes i.e pr[0] 
            if(!map.containsKey(pr[1])){
                map.put(pr[1],new ArrayList());
            }
            map.get(pr[1]).add(pr[0]);
        }

        Queue<Integer> q = new LinkedList();
        int count  = 0;
        for(int i = 0;i< numCourses;i++){
            if(inDegrees[i] == 0){
                q.add(i);
                count++;
            }
        }
        if(q.isEmpty()) return false; //it means there bo independent course at the starting ,hence a deadlock occured therefore return false
        if(count == numCourses) return true;
        while(!q.isEmpty()){
            int course = q.poll();
            List<Integer> children = map.get(course);
            if(children!=null){
                for(int child : children){
                    inDegrees[child]--;
                    if(inDegrees[child] == 0){
                        q.add(child);
                        count ++;
                        if(count == numCourses) return true;
                    }
                }
            }
        }

        return false;
        
    }
}
