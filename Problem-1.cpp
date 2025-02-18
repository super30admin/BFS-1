// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Store the root in the queue, add it's children and pop the root out.
// Recursively do the above step, keep a size to store the elements in each level.

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
            if(root == NULL) return {};
            vector<vector<int>> ans;
            queue<TreeNode*> q;
            q.push(root);
            while(!q.empty()){
                vector<int> res;
                for(int i=q.size(); i>0; i--){
                    TreeNode* curr = q.front();
                    q.pop();
                    res.push_back(curr->val);
                    if(curr->left) q.push(curr->left);
                    if(curr->right) q.push(curr->right);
    
                }
                ans.push_back(res);
            }
            return ans;
        }
    };