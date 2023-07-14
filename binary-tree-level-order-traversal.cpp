// Time Complexity : O(n) total nodes
// Space Complexity : O(m) max nodes
// Did this code successfully run on Leetcode : yes

#include <iostream>
#include <vector>
#include <unordered_map>
  
using namespace std;

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

// Definition for a binary tree node
struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> result;
        if (root == nullptr)
            return result;

        queue<TreeNode*> q;
        q.push(root);

        while (!q.empty()) {
            int levelSize = q.size();
            vector<int> levelNodes;

            for (int i = 0; i < levelSize; i++) {
                TreeNode* currNode = q.front();
                q.pop();

                levelNodes.push_back(currNode->val);

                if (currNode->left)
                    q.push(currNode->left);
                if (currNode->right)
                    q.push(currNode->right);
            }

            result.push_back(levelNodes);
        }

        return result;
    }
};