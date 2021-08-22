// Time Complexity : O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        if(root == NULL){
            vector<vector<int>> x;
            return x;
        }
        vector<vector<int>> res;
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty()){
            int size = q.size();
            vector<int> li;
            for(int i=0; i<size; i++){
                TreeNode* curr = q.front();
                q.pop();
                li.push_back(curr->val);
                if(curr->left != NULL)
                    q.push(curr->left);
                if(curr->right != NULL)
                    q.push(curr->right);
            }
            res.push_back(li);
        }
        return res;
    }
};


// Time Complexity : O(N)
// Space Complexity :O(H) where H is the height of the tree.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
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
    vector<vector<int>> result;
    vector<vector<int>> levelOrder(TreeNode* root) {
        if(root == NULL){
            return result;
        }
        dfs(root, 0);
        return result;
    }
    void dfs(TreeNode* root, int level){
        if(root==NULL)
            return;
        
        if(level == result.size()){
            result.push_back({root->val});
        }
        else{
            result[level].push_back(root->val);
        }
        dfs(root->left, level+1);
        dfs(root->right, level+1);
    }
};
