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
    List<List<Integer>> res=new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        int level=0;
        dfs(root, 0);
        return res;
        
        
    }
    public void dfs(TreeNode root, int level){
        //base 
        if(root==null){
            return;
        }
        //logic
        if(res.size()-1<level){
            res.add(new ArrayList<Integer>());
            
        }
        res.get(level).add(root.val);
        
        dfs(root.left,level+1);
        dfs(root.right,level+1);
        
        
        
        
        
    }
}






class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if( prerequisites.length==0 || prerequisites==null){
            return true;
        }
        int[] in_deg=new int[numCourses];
        HashMap<Integer,List<Integer>> hash=new HashMap<>();
        for(int[] edge:prerequisites){
            in_deg[edge[0]]++;
            if(!hash.containsKey(edge[1])){
                hash.put(edge[1],new ArrayList<Integer>());
            }
                hash.get(edge[1]).add(edge[0]);
            
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(in_deg[i]==0){
                q.add(i);
            }
        }
        int count=0;
        while(q.isEmpty()!=true){
            int temp=q.poll();
            count++;
            List<Integer> arr=hash.get(temp);
            if(arr!=null){
            for(int i: arr){
                in_deg[i]--;
                if(in_deg[i]==0){
                    q.add(i);
                }
            }
            }
            
        }
        System.out.println(count);
        
        if(count==numCourses){
            return true;
        }else{
            return false;
        }
        
    }
}

