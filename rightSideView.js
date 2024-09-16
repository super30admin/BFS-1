// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


var rightSideView = function(root) {
    
    let res = [];

    if(root == null) return res;

    dfs(root, 0);
    return res
    function dfs(root, level){

        if(root == null) return 

        if(level == res.length){
            res.push(root.val);
        }
        
        dfs(root.right, level + 1)
        dfs(root.left, level+1);
    }


};