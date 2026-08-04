//problem1
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
        if(root==null) return new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> temp=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                temp.add(curr.val);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            res.add(temp);
        }
        return res;
    }
}
//problem2
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] depend=new int[numCourses];
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int[] preq:prerequisites){
            int de=preq[0];
            int in=preq[1];
            depend[de]++;
        if(!map.containsKey(in)){
            map.put(in,new ArrayList<>());
        }
        map.get(in).add(de);
    }
    Queue<Integer> q=new LinkedList<>();
    int cnt=0;
    for(int i=0;i<numCourses;i++){
        if(depend[i]==0){
            q.add(i);
        }
    }
    if(q.isEmpty()) return false;
    while(!q.isEmpty()){
        int curr=q.poll();
        cnt++;
            List<Integer> li=map.get(curr);
            if(li!=null){
                for(int l:li){
                    depend[l]--;
                    if(depend[l]==0){
                        q.add(l);
                        
                    }
                }
            }
        }
    return cnt == numCourses;
}
}
