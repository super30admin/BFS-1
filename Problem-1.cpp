// Time Complexity : O(N)

// Space Complexity : O(N)

// Did this code successfully run on Leetcode : YES

// Appoarch: Using a queue, finding the size of the queue and then adding 
// nodes level by level into the queue by checking if they have children.

#include <bits/stdc++.h>
using namespace std;

 // Definition for a binary tree node.
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
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> result;
        if(root == NULL) return result;
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty()){
            vector<int> li;
            int Qsize = q.size();
            for(int i=0;i<Qsize;i++){
                TreeNode* curr = q.front();
                q.pop();
                li.push_back(curr->val);
                if(curr->left != NULL){
                    q.push(curr->left);
                }
                if(curr->right != NULL){
                    q.push(curr->right);
                }
            }
            result.push_back(li);    
        }
       return result; 
    }
};