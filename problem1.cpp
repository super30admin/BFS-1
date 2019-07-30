// Time Complexity  : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes	
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

  //Definition for a binary tree node.
  struct TreeNode {
      int val;
      TreeNode *left;
      TreeNode *right;
      TreeNode(int x) : val(x), left(NULL), right(NULL) {}
  };
 
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
    
        vector<vector<int>> result;
        
        if(root == NULL) return result;

        queue<TreeNode*> s;
        vector<int> level;
        queue<TreeNode*> nodes;
        s.push(root);
        
        //starting from root node, traverse downwards
        while(!s.empty())
        {
            TreeNode* n = s.front(); //store the value in the queue before popping
            s.pop();
            level.push_back(n->val); //push the previous root into the level vector
            if(n->left) //if left/right child exists, push it into the queue 
                nodes.push(n->left);
            if(n->right)
                nodes.push(n->right);

            if(s.empty())
            {
                s.swap(nodes);
                result.push_back(level);
                level.clear();
            }
        }

        return result;
    }

};