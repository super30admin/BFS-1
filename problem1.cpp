// Time Complexity : O(N) 
// Space Complexity : O(N) (at any level, queue has atmax of  2^h nodes which is less than N but more than h, so ,we take sc has O(N));
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// we do bfs by taking size variable n to seperate between levels. we add level by level into our result.

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
        if(root==NULL) return {};
        queue<TreeNode*>q;
        q.push(root);
        vector<vector<int>>result;
        while(!q.empty())
        {
            int  n = q.size();
            vector<int>v;
            while(n--)
            {
                TreeNode* curr = q.front();q.pop();
                v.push_back(curr->val);
                if(curr->left!=NULL){
                    q.push(curr->left);
                }
                if(curr->right!=NULL){
                    q.push(curr->right);
                }
            }
            result.push_back(v);
        }
        return result;
        
    }
};