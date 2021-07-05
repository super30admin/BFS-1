// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
vector<vector<int>> result;
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        
        if(root == NULL)
            return result;
        
        dfs(root,0);
        return result;
    }
    
    void dfs(TreeNode* root, int level){
        //base 
        if(root == NULL)
            return;
        
        //logic
        if(result.size() == level){
            result.push_back({});
        }
        result[level].push_back(root->val);
        dfs(root->left,level+1);
        dfs(root->right,level+1);
    }
};