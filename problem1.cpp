//Time Complexity - O(N)
//Space Complexity - O(N)
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>>v;
        if(root==NULL)
            return v;
        queue<TreeNode*>q;
        q.push(root);
        while(!q.empty()){
            vector<int>v1;
            int n=q.size();
            while(n){
                TreeNode* node = q.front();
                q.pop();
                v1.push_back(node->val);
                if(node->left)
                    q.push(node->left);
                if(node->right)
                    q.push(node->right);
                n--;
            }
            v.push_back(v1);
        }
        return v;
    }
};