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
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> result;
        if(root==nullptr){
            return result;
        }
        queue<TreeNode*> st;
        st.push(root);
        st.push(NULL);
        vector<int>level_0;
        while(!st.empty()){
            TreeNode* temp = st.front();
            st.pop();
            if(temp==nullptr){
                result.push_back(level_0);
                level_0.resize(0);
                if(st.size()>0) st.push(NULL);
            }
            else{
                level_0.push_back(temp->val);
                if(temp->left!=NULL) st.push(temp->left);
                if(temp->right!=NULL) st.push(temp->right);
            }
        }
        return result;
    }
};