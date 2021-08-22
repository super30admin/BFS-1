// Time Complexity : O(N) where N represents the no.of nodes in the binary tree
// Space Complexity : O(H) where H is the height of the binary tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope
// Problem Link: https://leetcode.com/problems/binary-tree-level-order-traversal/
// Submission Link: https://leetcode.com/submissions/detail/540189034/

class Solution {
    vector<vector<int> > ans;
    int maxDepth;
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        if(root == NULL)
            return {};
        
        maxDepth = -1;
        
        helper(root, 0);
        
        return ans;
    }
    
    void helper(TreeNode* root, int depth){
        if(root == NULL)
            return;
        
        if(depth > maxDepth){
            maxDepth = depth;
            ans.push_back({root -> val});
        }
        else
            ans[depth].push_back(root -> val);
        
        helper(root -> left, depth + 1);
        helper(root -> right, depth + 1);
    }
};