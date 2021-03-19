// TC: O(N) where N is the total num of nodes in the binary tree
// SC: O(N) where N is the total num of nodes in the binary tree
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
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        queue<TreeNode*>q;
        vector<vector<int>>result;
        if(root == NULL)return result;
        q.push(root);
        while(!q.empty()){
            vector<int>level;
            int sz = q.size();
            for(int i = 0; i < sz;i++){
            root = q.front();q.pop();
            level.push_back(root->val);
            if(root->left)q.push(root->left);
            if(root->right)q.push(root->right);
            }
            if(level.size()>0)result.push_back(level);
        }
        return result;
        
    }
};