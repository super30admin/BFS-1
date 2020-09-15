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
    vector<int> rightSideView(TreeNode* root) {
        vector<int> res;
        if(!root) return res;
        queue<TreeNode*> qu;
        if(root) qu.push(root);
        while(!qu.empty()){
            int si = qu.size();
            for(int i=0 ;i<si; i++){
                TreeNode* x = qu.front(); qu.pop();
                if(i==si-1)
                    res.push_back(x->val);
                
                if(x->left) qu.push(x->left);
                if(x->right) qu.push(x->right);
            }
            //res.push_back(qu.front()->val);
        }
        return res;
        
    }
};