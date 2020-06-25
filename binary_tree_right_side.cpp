//Time Complexicity = O(n)
//Space Complexicity  =O(n)
//Runs successfully on the leetcode    
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
    vector<int>result;
public:
    vector<int> rightSideView(TreeNode* root) {
        if(root == NULL)
            return{};
        dfs(root,0);
        return result;
        
    }
    void dfs(TreeNode* root, int level)
    {
        if(root == NULL)
            return;
        if(level == result.size())
            result.push_back(root->val);
        dfs(root->right,level+1);
        dfs(root->left,level+1);
    }
};