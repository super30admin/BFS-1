
// Time Complexity O(v+e)
// Space Complexity O(v+e)

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
        if (root == nullptr) {
            return {};
        }
        vector<vector<int>> result;
        queue<TreeNode*> que;
        que.push(root);
        while (!que.empty()) {
            vector<int> level;
            int n = que.size();
            for (int i = 0; i< n; i++) {
                TreeNode* node = que.front();
                que.pop();
                level.push_back(node->val);
                if (node->left != nullptr) {
                    que.push(node->left);
                }
                if (node->right != nullptr) {
                    que.push(node->right);
                }
            }
            result.push_back(level);
        }
        return result;
    }
};