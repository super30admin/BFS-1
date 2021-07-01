// Time Complexity : O(n)
// Space Complexity : O(n) size of queue (n/2) if full binary tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 

#include<vector>
#include<iostream>
#include<queue>

using namespace std;
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
  };

// BFS 

class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
     
        vector<vector<int>> res;
        vector<int> temp;
        
        if(root == NULL)
            return {};
        
        TreeNode *curr = NULL;
        queue<TreeNode*> q1;
        
        q1.push(root);
        
        while(!q1.empty()){
            
            int levelsize = q1.size();
            
            while(levelsize > 0){
                curr = q1.front();
                q1.pop();
                temp.push_back(curr->val);
                if(curr->left){
                    q1.push(curr->left);
                }
                if(curr->right){
                    q1.push(curr->right);
                }
                --levelsize;
            }
            res.push_back(temp);
            temp.clear();
        }
        
        return res;
    }
};

// DFS

class Solution {
    vector<vector<int>> result;
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        if(root == NULL)
            return result;
        
        dfs(root, 0);
        return result;
    }
    
    void dfs(TreeNode* root, int level){
        
        if(root == NULL)
            return;
        
        if(level == result.size())  // add new empty list at that level first
            result.push_back({});
        
        result[level].push_back(root->val);
        
        dfs(root->left, level + 1);
        dfs(root->right, level + 1);
    }
};