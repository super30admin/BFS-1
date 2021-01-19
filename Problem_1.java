// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach

//Below is the method using the recursion and a static variable treemap to store the element level wise.

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
    TreeMap<Integer,List<Integer>> tree;
    public List<List<Integer>> levelOrder(TreeNode root) {
        tree=new TreeMap<Integer,List<Integer>>();
        List<List<Integer>> list=new ArrayList<>();
        calculateOrder(root,1);
        for(int i:tree.keySet()){
           // System.out.println(tree.get(i));
            list.add(tree.get(i));
        }
        return list;
    }
    
    public void calculateOrder(TreeNode root,int level){
        if(root==null){
            return;
        }
        if(tree.containsKey(level)){
            tree.get(level).add(root.val);
        }else{
            List<Integer> arr=new ArrayList<Integer>();
            arr.add(root.val);
            tree.put(level,arr);
        }
        
        calculateOrder(root.left,level+1);
        calculateOrder(root.right,level+1);     
    }
}

// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach

//Below is the where we use the queue to do the BFS.



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
        List<List<Integer>> list=new ArrayList<>();
        if(root==null) return list;
        Queue<TreeNode> qu=new LinkedList();
        qu.add(root);
        int size=0;
        while(!qu.isEmpty()){
            size=qu.size();
            List<Integer> li=new ArrayList<>();
            while(size>0){
                TreeNode temp=qu.remove();
                li.add(temp.val);
                if(temp.left!=null){
                    qu.add(temp.left);
                }
                if(temp.right!=null){
                    qu.add(temp.right);
                }
                size=size-1;
            }
            list.add(li);
        }
        
        return list;
    }
}
