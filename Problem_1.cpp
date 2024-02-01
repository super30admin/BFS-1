/*
 ? Binary Tree Level Order Traversal
 * Time Complexity : O(n)
 * Space Complexity : O(n)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
*/

#include <vector>
#include <queue>

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution {
public:
    std::vector<std::vector<int>> levelOrder(TreeNode* root) {
        std::vector<std::vector<int>> result;

        if(root == nullptr) return result;

        std::queue<TreeNode*> q;
        q.push(root);

        while(!q.empty()) {
            int count = q.size();
            std::vector<int> sublist;

            for(int i = 0; i < count; i++) {
                TreeNode* node = q.front();
                q.pop();

                sublist.push_back(node->val);

                if (node->left != nullptr) q.push(node->left);
                if (node->right != nullptr) q.push(node->right);
            }

            result.push_back(sublist);
        }

        return result;
    }
};