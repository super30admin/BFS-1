//time complexity:O(n)
//space complexity:O(n)
//executed on leetcode: yes
//approach: bfs
//any issues faced? no

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
        vector<vector<int>> res;
        vector<int> clevel;
        queue<TreeNode*>q;
        queue<TreeNode*>nq;
        if(root==NULL)
            return res;
        if(root)
        {
            q.push(root);
        }
        while(!q.empty())
        {
            TreeNode* curr=q.front();
            q.pop();
            clevel.push_back(curr->val);
            if(curr->left)
                nq.push(curr->left);
            if(curr->right)
                nq.push(curr->right);
            if(q.empty())
            {
                res.push_back(move(clevel));
                nq.swap(q);
            }
        }
        return res;
    }
};