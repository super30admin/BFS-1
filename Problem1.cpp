// Problem Name: level order traversal
// Time Complexity : O(n)
// Space Complexity : O(h) recursive stack space (height of the tree)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// 1. Here we can use any traversal, bfs or dfs
// 2. Here we use dfs traversal, we keep resizing our answer vector to the
// level, if they match
// 3. Process the elements can be done inorder, postorder or preorder
#include <bits/stdc++.h>
using namespace std;

/**
 * Definition for a binary tree node.
 */
struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode() : val(0), left(nullptr), right(nullptr) {}
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
  TreeNode(int x, TreeNode *left, TreeNode *right)
      : val(x), left(left), right(right) {}
};
class Solution {
public:
  vector<vector<int>> levelOrder(TreeNode *root) {
    vector<vector<int>> res;
    if (!root)
      return res;
    dfs(root, res, 0);
    return res;
  }

  void dfs(TreeNode *root, vector<vector<int>> &res, int level) {
    if (!root)
      return;
    if (res.size() == level) {
      res.resize(level + 1);
    }
    dfs(root->left, res, level + 1);
    dfs(root->right, res, level + 1);
    res[level].push_back(root->val);
  }
};
