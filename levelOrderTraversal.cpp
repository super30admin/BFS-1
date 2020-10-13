// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        
        vector<vector<int>> answer;
        
        if(root==NULL)
            return answer;
        
        queue<TreeNode*> q;
        q.push(root);
        
        while(!q.empty())
        {
            int x=q.size();
            vector<int> v;
            while(x>0)
            {
            TreeNode *node=q.front();
                v.push_back(node->val);
            q.pop();
                
                if(node->left!=NULL)
                {
                    q.push(node->left);
                }
                if(node->right!=NULL)
                {
                    q.push(node->right);
                }
                x--;
            }
            answer.push_back(v);
        }
        return answer;
    }
};