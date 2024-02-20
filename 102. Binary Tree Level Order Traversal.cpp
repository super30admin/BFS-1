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
    /*
    Time: O(N)
    Space: O(N)

    Run dfs in pre-order/inorder/postorder (in each, left comes before right) while maintaining levels (depth)
    Level represents which nested array the current node's value will go to
    */
    void dfs(TreeNode* root, int level, vector<vector<int>>& v){
      if(root==nullptr)  return;
      if(v.size()==level)  v.push_back({});

      //v[level].push_back(root->val);
      dfs(root->left, level+1, v);
      dfs(root->right, level+1, v);
      v[level].push_back(root->val);
    }

    vector<vector<int>> levelOrder(TreeNode* root) {
      vector<vector<int>> v;
      dfs(root,0,v);
      return v;
    }
};
