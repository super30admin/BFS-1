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
 //DFS Solution
class Solution {
    vector<vector<int>> result;
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        helper(root, 0);
        return result;
    }
private:
    void helper(TreeNode* root, int level){
        if(root==NULL)return;
        if(level==result.size()){
            result.push_back(vector<int>());
        }
        helper(root->left, level+1);
        helper(root->right, level+1);
        result[level].push_back(root->val);
    }    
};




/*

 //bfs Solution
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> result;
        if(root==NULL)return result;
        queue<TreeNode*> q;
        q.push(root);
        
        while(!q.empty()){
            int size = q.size();
            vector<int> list;
            for(int i=0;i<size;i++){
                TreeNode* curr = q.front();
                q.pop();
                list.push_back(curr->val);
                if(curr->left!=NULL){
                    q.push(curr->left);
                }
                if(curr->right!=NULL){
                    q.push(curr->right);
                }
            }
           
            result.push_back(list);
        }
        return result;
    }
   
};


*/
