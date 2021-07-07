//Right side view
// time o(n)
// space o(h) (because of hashmap)
class Solution {
    List<Integer> res;
    HashMap<Integer,Integer> map;
    public List<Integer> rightSideView(TreeNode root) {
        res = new ArrayList<>();
        map = new HashMap<>();
        if(root == null)
            return res;
        helper(root, 0);
        
        for(int i=0;i<map.size();i++){
            res.add(map.get(i));
        }
        return res;
    }
    private void helper(TreeNode root, int level) {
        //base case
        if(root == null)
            return;
        //logic
        map.put(level,root.val);
        helper(root.left,level+1);
        helper(root.right,level+1);
    }
}