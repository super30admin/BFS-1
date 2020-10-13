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
    vector<int> rightSideView(TreeNode* root) {
        
        vector<int> v;
        
        if(root==NULL)
        return v;
        
        queue<TreeNode*> q;
        q.push(root);
        
        while(!q.empty())
        {
            int siz=q.size();
            for(int i=0;i<siz;i++)
            {
                TreeNode *temp=q.front();
                q.pop();
                if(i==siz-1)
                {
                    v.push_back(temp->val);
                }
                
                if(temp->left!=NULL)
                {
                    q.push(temp->left);
                }
                if(temp->right!=NULL)
                {
                    q.push(temp->right);
                }
            }
        }
        return v;
    }
};