//Time O(n) n-num of nodes in tree
//Space - O(h) -stack space where h is the height of the tree

class Solution {
public:
    void level(TreeNode* root,int l, vector<vector<int>>& res){
        if(root==NULL) return;
        
        if(res.size()<=l) res.push_back({});
        res[l].push_back(root->val);
        
        level(root->left,l+1,res);
        level(root->right,l+1,res);
        
    }
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> res;
        level(root,0, res);
        return res;
    }
};