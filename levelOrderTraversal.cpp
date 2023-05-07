/**
 * TC - O(n)
 * SC - S(n)
 * 
*/
class Solution {
public:
    vector<vector<int>> result;
    vector<vector<int>> levelOrder(TreeNode* root) {
         levelOrderTraversal(root, 0);
         return result;       
    }
    void levelOrderTraversal(TreeNode* root, int depth){
        if(root == NULL) return ;
        if(result.size()< depth+1) result.resize(depth+1);
        result[depth].push_back(root->val);
        levelOrderTraversal(root->left,depth+1);
        levelOrderTraversal(root->right,depth+1);
        return;
    }
};