# BFS-1
# Problem 1
Binary Tree Level Order Traversal (https://leetcode.com/problems/binary-tree-level-order-traversal/)

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// normal bfs for a tree.  keep traversing the tree level by level. The size variable keeps a track of num of elements
// on a every level.
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
        List<List<Integer>> lst = new ArrayList<>();
        if(root==null) return lst;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> sublst = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode temp = q.poll();
                sublst.add(temp.val);
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
            }
            lst.add(sublst);
        }
     return lst;   
    }
}



# Problem 2
Course Schedule (https://leetcode.com/problems/course-schedule/)
// Time Complexity : O(V+E)
// Space Complexity : O(V)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Data structures required: Hashmap,indegree Array, Queue.  Keep decrementing the count of the indegress array as soon as
// same element occurs in the hashmap    
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        HashMap<Integer, List<Integer>> hmap = new HashMap<>();
        for(int i=0;i<prerequisites.length;i++){
            if(!hmap.containsKey(prerequisites[i][1])){
                hmap.put(prerequisites[i][1], new ArrayList<>());// 
            }
            hmap.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++; // adding indegree of dependent node
        }
        /*System.out.println(Arrays.asList(hmap));
        for(int i=0;i<indegree.length;i++){
            System.out.println(indegree[i]);
        }*/
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0) q.add(i);
        }
        int c=0;
        if(q.isEmpty()) return false;
        while(!q.isEmpty()){
            int curr=q.poll();
            c++;
            List<Integer> edges= hmap.get(curr);
            if(edges!=null){
                for(int i: edges){
                    indegree[i]--;
                    if(indegree[i]==0){
                        q.add(i);
                    }
                }
            }
        }

    if(c==numCourses) return true;
    return false;
    }
}