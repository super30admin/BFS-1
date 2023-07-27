// Time Complexity : O(n) total nodes
// Space Complexity : O(m) max nodes
// Did this code successfully run on Leetcode : yes

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
private:
    vector<vector<int>> result;
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        helper(root, 0);
        return result;
    }
    void helper(TreeNode* root, int level){
        if(root == nullptr) return;

        if(level == result.size()){
            result.push_back({root->val});
        }
        else{
            result[level].push_back(root->val);
        }

        helper(root->left, level+1);
        helper(root->right, level+1);
    }
};