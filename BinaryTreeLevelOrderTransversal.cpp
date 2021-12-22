//Time Complexity O(n)
// Space Complexity O(height of tree)(Due to recursion)
//Problem successfully executed on leetcode
//No problems faced while coading this.



#include<iostream>
#include<vector>
using namespace std;

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
    vector<vector<int> > result;
    vector<vector<int> > levelOrder(TreeNode* root) {
        if (root==NULL) return result;
        
        dfs(root,0);
        return result;
    }
    
    void dfs(TreeNode* root, int level)
    {
        if(root==NULL)
        {
            return;
        }
        if(result.size()==level)
        {
            vector<int> newList;
            result.push_back(newList);
        }
        result[level].push_back(root->val);
        dfs(root->left,level+1);
        dfs(root->right,level+1);
    }
};