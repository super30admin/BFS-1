/**
 * // Time Complexity : O(n)
 * // Space Complexity : O(1) stack space O(h)
 * // Did this code successfully run on Leetcode : yes
 * // Any problem you faced while coding this : no
 *
 * // Your code here along with comments explaining your approach
 */
 // BFS
 class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
    
         List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level=0;
        
        while(!q.isEmpty()){
            
            result.add(new ArrayList<Integer>());
            int len = q.size();
            for(int i=0; i<len; i++){
                TreeNode cur = q.poll();
                result.get(level).add(cur.val);
                
                if(cur.left != null) q.add(cur.left);
                if(cur.right != null) q.add(cur.right);
                
            }
            level++;
        }
        
        return result;
    }
}
 //DFS-recursive
 // DFS solution of level order traversal. 
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        helper(root, 0);
        
        return result;
    }
    
    private void helper(TreeNode root, int level){
        //base
        if(root == null) return;
        
        if(level == result.size()){
            result.add(level, new ArrayList<>());   
        }
        //logic
        result.get(level).add(root.val);
        helper(root.left, level+1);
        helper(root.right, level+1);
        
        
    }
}
 // DFS-Iterative
 class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null) return result;
        
        Stack<Pair<TreeNode, Integer>> s = new Stack();
        int level = 0;
        
        while(root != null || !s.isEmpty()){
            // if(root == null) level--;
            while(root != null){
            if(level == result.size()){
                result.add(level, new ArrayList<>());
            }
                level++;
                s.push(new Pair(root, level));
                root = root.left;
                if(root == null) level--;

            }
            
            Pair<TreeNode, Integer> p = s.pop();
            root = (TreeNode)p.getKey();
             level =(Integer) p.getValue();
            
            
            result.get(level-1).add(root.val);
            
            root = root.right;
        }
        
        return result;
    }
}
 /**
 * // Time Complexity : O(v+E) where v is the num of courses and E is the pre-reqs
 * // Space Complexity : O(E) number of pre-reqs to take
 * // Did this code successfully run on Leetcode : yes
 * // Any problem you faced while coding this : no
 *
 * // Your code here along with comments explaining your approach
 */
class Solution {                //numCourse= V     prerequisites=E
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[] inDegree = new int[numCourses]; // array for the all the unique courses in the pre-req array
        
        HashMap<Integer, List<Integer>> map = new HashMap<>(); // to store the pair of the subject and its pre-reqs
        
        for(int i=0; i< prerequisites.length; i++){
            int subject = prerequisites[i][0];
            int preReq =  prerequisites[i][1];
            inDegree[subject]++;
            
            //storing subject and pre-req in map
            if(!map.containsKey(preReq)){
                List<Integer> temp = new ArrayList<>();
                map.put(preReq, temp);
            }
            map.get(preReq).add(subject);

        }
        Queue<Integer> q = new LinkedList<>(); // queue of the subjects(pre-reqs) that I need to process in order to take other subjects
        
        for(int i=0; i< numCourses; i++){
            if(inDegree[i] == 0) q.add(i); // this will the first subject/pre-req to take
        }
        // Now iterate over the pre-req to finish it and take the courses that the current element in queue is the pre-req of
        while(!q.isEmpty()){
            int curPreReq = q.poll();
            
            List<Integer> listOfCourses = map.get(curPreReq);
            //Now that I have take the pre-req (in the queue), I can take all the courses that it was pre-req of
            if(listOfCourses != null){
            for(int course: listOfCourses){
                inDegree[course]--; // taking it out of the courses that needs to be finished
                
                if(inDegree[course]==0) q.add(course); // if I have taken all the pre-reqs relevant to this cur course, I can add it to queue to take those subects that this cur course is pre-req of. 
            }
        }
    }
        
        // now check if there are still any courses left to take, if so, then we cannot finish
        for(int i: inDegree){
            if( i != 0) return false;
        }
        
        return true;
    }
}
 
 /** rightSideView
 * // Time Complexity : O(n)
 * // Space Complexity : O(h)
 * // Did this code successfully run on Leetcode : yes
 * // Any problem you faced while coding this : no
 *
 * // Your code here along with comments explaining your approach
 */
 class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level=0;
        
        while(!q.isEmpty()){
            
            // result.add(new ArrayList<Integer>());
            int len = q.size();
            for(int i=0; i<len; i++){
                TreeNode cur = q.poll();
                if(i == len-1) result.add(cur.val);                
                if(cur.left != null) q.add(cur.left);
                if(cur.right != null) q.add(cur.right);
                
            }
            level++;
        }
        
        return result;
        
    }
}
