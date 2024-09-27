class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Sample {
    // Time Complexity : O(N) N is number nodes in the tree
    // Space Complexity : O(N) (N/2 or maximum number of nodes present in a level)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No


    // Problem 1
    /*
    1. Visit all children of node first.
    2. For adding elements level wise, maintain queue size.
    */

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int sz = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<sz; i++){
                TreeNode t = q.poll();
                if(t.left!=null){
                    q.offer(t.left);
                }
                if(t.right!=null){
                    q.offer(t.right);
                }
                list.add(t.val);
            }
            res.add(list);
        }
        return res;
    }

    // Time Complexity : O(V+E) V is vertices of the graph (numCourses) and E is the edges (prerequisites length)
    // Space Complexity : O(V+E) 
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No


    // Problem 2
    /*
    1. we can construct it as a graph (directed graph)
    2. Each course has incoming edge from its prerequisite course. and for this problem we have to check 
    if there is cycle in the graph.
    */

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[] indegrees = new int[numCourses];
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int[] p: prerequisites) {
            indegrees[p[0]]++;
            if(!map.containsKey(p[1])) {
                map.put(p[1], new ArrayList<>());
            }
            map.get(p[1]).add(p[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<indegrees.length; i++) {
            if(indegrees[i] == 0)
                q.add(i);
        }
        
        while(!q.isEmpty()) {
            int prereq = q.poll();
            List<Integer> list = map.get(prereq);
            
            if(list != null) {
                for(int course: list) {
                    indegrees[course]--;

                    if(indegrees[course] == 0)
                        q.add(course);
                }
            }
        }
        
        for(int i : indegrees) {
            if(i != 0)
                return false;
        }
        
        return true;
    }


    // Time Complexity : O(N) N is number nodes in the tree
    // Space Complexity : O(N) (N/2 or maximum number of nodes present in a level)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No


    // Problem 1
    /*
    1. Visit all children of node first.
    2. Traverse all the childrens of the nodes from left to right and add rightmost node in the list 
    for each level
    */

    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> list = new ArrayList<>();
        
        if(root == null)
            return list;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            for(int i=0; i<size; i++) {
                TreeNode node = q.poll();
                if(i == size-1)
                    list.add(node.val);
                
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
                    
            }

        }
        
        return list;
        
    }
}