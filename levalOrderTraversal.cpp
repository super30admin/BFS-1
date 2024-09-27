//Time Complexity-O(n)
//Space complexity-O(n)
//Runs successfully on leetcode

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}r
 * };
 */
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        if(root==NULL)
            return {};
        vector<vector<int>>result;
        helper(result,0,root);
        return result;
    }
    void helper(vector<vector<int>>&result,int depth,TreeNode* root)
    {
        if(root==NULL)
            return;
        if(depth>=result.size())
            result.push_back({});
        result[depth].push_back(root->val);
        helper(result,depth+1,root->left);
        helper(result,depth+1,root->right);
    }
};