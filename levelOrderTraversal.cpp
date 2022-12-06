// Time Complexity : O(n) where n is the number of nodes
// Space Complexity : O(n) for BFS and O(h) for DFS
// Did this code successfully run on Leetcode : Yes 

//Approach 1: BFS

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
        if(root == NULL) return vector<vector<int>> ();
        vector<vector<int>> result;
        queue<TreeNode*> q;
        q.push(root);

        while(!q.empty()){
            int size = q.size();
            vector<int> level_nodes;
            for(int i=0; i<size; i++){
                TreeNode* node = q.front();
                q.pop();
                level_nodes.push_back(node->val);
                if(node->left) q.push(node->left);
                if(node->right) q.push(node->right);
            }
            result.push_back(level_nodes);
        }

        return result;
    }
};

//Approach 2: DFS

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
vector<vector<int>> result;
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        if(root == NULL) return vector<vector<int>> ();
        dfs(root, 0);
        return result;
    }
private:
    void dfs(TreeNode* root, int level){
        if(root == NULL) return;

        if(level == result.size())
            result.push_back(vector<int>());
        result[level].push_back(root->val);

        dfs(root->left, level+1);
        dfs(root->right, level+1);
    }
};