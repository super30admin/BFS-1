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
 //T: O(n)
 //S: O(max(diameter))
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> res;
        queue<TreeNode*> qu;
        if(!root) return res;
        
        else qu.push(root);
        while(!qu.empty()){
            int siz = qu.size();
            vector<int> r;
            for(int i=0; i< siz;i++){
                TreeNode* x = qu.front(); qu.pop();
                r.push_back(x->val);
                if(x->left) qu.push(x->left);
                if(x->right) qu.push(x->right);
            }
            res.push_back(r);
        }
        return res;
    }
};