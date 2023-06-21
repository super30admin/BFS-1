// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        if(root==NULL)
            return {};
        
        vector<vector<int>> ans; 
        queue<TreeNode*> q;
        q.push(root);
        TreeNode *temp;
        int len;

        while(!q.empty())
        {
            len=q.size();
		    vector<int> v;
            for(int i=0;i<len;i++){
                temp=q.front();
                q.pop();
                v.push_back(temp->val);

                if(temp->left) q.push(temp->left);
                if(temp->right) q.push(temp->right);
            }
		    ans.push_back(v);
        }
    return ans;
    }
};