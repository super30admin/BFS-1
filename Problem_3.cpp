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
class Solution {
public:
    vector<int> rightSideView(TreeNode* root) {
        if(root == NULL) return {};
        vector<int> result;
        int levelLength = 0;
        queue<TreeNode*> Q;
        Q.push(root);
        while(!Q.empty()){
            levelLength = Q.size();
            for(int i = 0; i<levelLength; i++){
                TreeNode* temp = Q.front();
                Q.pop();
                if(i==levelLength-1) result.push_back(temp->val);
                if(temp->left != NULL) Q.push(temp->left);
                if(temp->right != NULL) Q.push(temp->right);
            }
        }
        return result;
    }
};