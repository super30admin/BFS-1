Time Complexity-O(n)
Space Complexity-O(n)
Did the code run on Leetcode? Yes

class Solution {
public:
    vector<int> rightSideView(TreeNode* root) {
        vector<int>result;
        if(root==NULL)
        {
            return result;
        }
        queue<TreeNode*>m;
        m.push(root);
        while(!m.empty())
        {
            int queuesize=m.size();
            while(queuesize!=0)
            {
                TreeNode* a=m.front();
                m.pop();
                if(queuesize==1)
                {
                    result.push_back(a->val);
                }
                if(a->left!=NULL)
                {
                    m.push(a->left);
                }
                if(a->right!=NULL)
                {
                    m.push(a->right);
                }
                queuesize--;
            }
        }
        return result;
    }
};