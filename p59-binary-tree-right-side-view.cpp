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

// Using Breadth First Search (BFS)
// Time complexity is O(n) - n = number of nodes of tree
// Space complexity is O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
class Solution {
public:
    vector<int> rightSideView(TreeNode* root) {
        if(root == nullptr) return {};
        vector<int> res;
        
        queue<TreeNode*> q;
        q.push(root);
        
        while(!q.empty()) {
            int size = q.size();
            TreeNode* currNode;
            for(int i = 0; i < size; i++) {
                currNode = q.front();
                q.pop();
                
                if(currNode->left != nullptr) q.push(currNode->left);
                if(currNode->right != nullptr) q.push(currNode->right);
            }
            res.push_back(currNode->val);
        }
        return res;
    }
};


// Using Depth First Search (DFS)
// Time complexity is O(n) - n = number of nodes of tree
// Space complexity is O(n) - recursive stack size
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
class Solution {
public:
    vector<int> res;
    void dfs(TreeNode* node, int level) {
        //base
        if(node == nullptr) return;
        
        //logic
        if(level == res.size()) {
            res.push_back(node->val);
        }
        else {
            res[level] = node->val;
        }
        dfs(node->left, level+1);
        dfs(node->right, level+1);
    }
    vector<int> rightSideView(TreeNode* root) {
        if(root == nullptr) return {};
        dfs(root, 0);
        return res;
    }
};
