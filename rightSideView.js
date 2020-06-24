/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */

let result = [];
var rightSideView = function(root) {
    result = [];
    if(root == null) return result;
    dfs(root,0);
    return result;
    
};

var dfs = function(root,level){
    //base
    if(root == null) return;
    //logic
    if(result.length == level){
        result.push(root.val);
    }
    dfs(root.right,level+1);
    dfs(root.left,level+1);
}