102. Binary Tree Level Order Traversal

Time complexity:O(n) 
Space complexity:O(n) (BFS uses queue, DFS under the hood uses stack so O(n) both cases) 


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

 //BFS 
/*
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        if (root == NULL) return {};
        vector<vector<int>> result;
        queue<TreeNode*> q;
        
        q.push(root);


        while(!q.empty()) {
            int size = q.size();
            vector<int> tempResult;
            for(int i=0; i< size; i++) {
                TreeNode* temp = q.front();
                q.pop();
                tempResult.push_back(temp->val);
            if (temp->left) q.push(temp->left);
            if (temp->right) q.push(temp->right);                
            }
            result.push_back(tempResult);
            tempResult.clear();
        }
        return result;
    }
};
*/
//DFS
class Solution {
public:
    vector<vector<int>> result;
    vector<vector<int>> levelOrder(TreeNode* root) {
        if (root == NULL) return {};
        dfs(root, 0);
        return result;
    }

    void dfs(TreeNode* root, int level) {
        if (root == NULL) return;
        
        if(level >= result.size())
            result.push_back({});

        result[level].push_back(root->val);

        dfs(root->left, level+1);
        dfs(root->right, level+1);

    }
};
