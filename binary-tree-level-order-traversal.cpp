// TC = O(N)
// SC = O(H)
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
// class Solution {
// public:
//     vector<vector<int>> levelOrder(TreeNode* root) {
//         // TC = O(N), SC = O(N / 2) ~ O(N) (as max items in q is leaves ie n/2)
//         vector<vector<int>> result;
//         // null
//         if(root == nullptr) return result;
//         queue<TreeNode*> q;
//         q.push(root);
//         while(!q.empty()) {
//             int size = q.size(); // preserving the size of q to iterate on that level
//             vector<int> v;
//             for(int i = 0; i < size; i++) {
//                 TreeNode* curr = q.front(); // extra for C++
//                 q.pop(); // extra for C++
//                 v.push_back(curr->val); // adding the curr values in the list but children in the q for future iterations
//                 if(curr->left != nullptr) q.push(curr->left);
//                 if(curr->right != nullptr) q.push(curr->right);
//             }
//             result.push_back(v);
//         }
//         return result;
//     }
// };

class Solution {
    // TC = O(N), SC = O(H)
public:
    vector<vector<int>> result; // global
    vector<vector<int>> levelOrder(TreeNode* root) {
        // null
        if(root == nullptr) return result;
        dfs(root, 0);
        return result;
    }
    void dfs(TreeNode* root, int level) {
        // null
        if(root == nullptr) return;
        // logic
        // if res size is = to level ie height of BT, then we need to add a List to res, if not add value to the already present list
        if(result.size() == level) result.push_back(vector<int>());
        result[level].push_back(root->val);
        dfs(root->left, level + 1);
        dfs(root->right, level + 1);
    }
};