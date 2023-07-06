// Time Complexity: O(n)
// Space Complexity: O(n)
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
        if(root == nullptr) return {}; 
        bfs(root); 
        return result; 
    }

    void bfs(TreeNode* node) {
        deque<TreeNode*> q;
        q.push_back(node); 

        while(!q.empty()) {
            int size = q.size(); 
            vector<int> res; 
            while(size > 0) {
                TreeNode* n = q.front(); 
                q.pop_front(); 
                res.push_back(n->val);
                if(n->left != nullptr) q.push_back(n->left);
                if(n->right != nullptr) q.push_back(n->right); 
                size--;  
            }
            result.push_back(res); 
        } 
    }
};