# BFS-1
# Problem 1
Binary Tree Level Order Traversal (https://leetcode.com/problems/binary-tree-level-order-traversal/)
//Approach 1: BFS Level Order Traversal 
//Space Complexity: O(N)
//Time Complexity: O(N)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result; 
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty())
        {
            List<Integer> temp = new ArrayList<Integer>();
            int size = q.size();
            for(int i=0; i< size; i++)
            {
                TreeNode curr = q.poll();
                if(curr.left != null)
                {
                    q.add(curr.left);
                }
                if(curr.right != null)
                {
                    q.add(curr.right);
                }
                temp.add(curr.val);
            }
            
            result.add(temp);
        }
        
        return result;
        
    }
}

//Approach 2: DFS Traversal 
//Space Complexity: O(N)
//Time Complexity: O(N)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<List<Integer>> result;
    private void dfsHelper(TreeNode root, int level)
    {
        if(root == null) return;
        if (result.size() == level)
        {
            result.add(new ArrayList<Integer>());
        }
        result.get(level).add(root.val);
        dfsHelper(root.left, level +1);
        dfsHelper(root.right, level +1);
        
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) return result;
        dfsHelper(root, 0);
        return result;
    }
}

# Problem 2
Course Schedule (https://leetcode.com/problems/course-schedule/)
//Space Complexity: O(V+E)
//Time Complexity: O(V+E)

//Approach : BFS with indegrees array 

class Solution {
    
    //Time Complexity: O(V+ E)
    //Space Complexity: O(V + E)
    public boolean canFinish(int numCourses, int[][] edges) {
        int[] indegrees = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int[] edge: edges)
        {
            // edge[0] is the dependent node, when we say indegrees -> we mean no of courses that need to be taken before this node
            indegrees[edge[0]]++;
            
            
            //edge[1] is the independent node that will serve as the key in the hashmap for facilitating an O(1) look-up
            if(!map.containsKey(edge[1]))
            {
                map.put(edge[1], new ArrayList<>());
            }
            
            map.get(edge[1]).add(edge[0]);
        }
            int count =0;
            Queue<Integer> queue = new LinkedList<Integer>();
            for(int i=0; i< numCourses; i++)
            {
                if(indegrees[i] == 0)
                {
                    queue.add(i);
                    count++;
                }
            }
            
            if(queue.isEmpty()) return false;
            while(!queue.isEmpty() && count < numCourses)
            {
                int curr = queue.poll();
                List<Integer> children = map.get(curr);
                if(children != null)
                {
                    for(int child: children)
                    {
                        indegrees[child]--;
                        if(indegrees[child] == 0)
                        {
                            queue.add(child);
                            count++;
                        }
                    }
                }
            }
            
            
            
        if(count == numCourses) return true;
        return false;
        
        
        
    }
}


