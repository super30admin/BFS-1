Time Complexity-O(n)
Space Complexity-O(n)
Did the code run on Leetcode? Yes

class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>>m;
        if(root==NULL)
        {
            return m;
        }
        queue<TreeNode*>k;
        k.push(root);
        while(!k.empty())
        {
            int s=k.size();
            vector<int>z;
            for(int i=0;i<s;i++)
            {
                TreeNode *a=k.front();
                z.push_back(a->val);
                k.pop();
                if(a->left!=NULL)
                {
                    k.push(a->left);
                }
                if(a->right!=NULL)
                {
                    k.push(a->right);
                }
            }
            m.push_back(z);
        }
        return m;
    }
};