// Time Complexity                              :  O(N) where N is the number of nodes. 
// Space Complexity                             :  O(N) - in iterative approach we use a queue 
//                                                 and in recursive approach, the function stack stores the values.
// Did this code successfully run on Leetcode   :  Yes
// Any problem you faced while coding this      :  No

#include <bits/stdc++.h> 
using namespace std;  

// https://leetcode.com/problems/binary-tree-level-order-traversal/

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
private: 
    vector<vector<int>> ansR;
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        // return levelOrderIterative;
        levelOrderRecursive(root, 0);
        return ansR;
    }
    
    vector<vector<int>> levelOrderIterative(TreeNode *root) {
        if(!root) return vector<vector<int>>();
        vector<vector<int>> ans;
        
        queue<TreeNode*> q;
        q.push(root);
        vector<int> vec;
        while(!q.empty()) {
            int sz = q.size();
            vec.clear();
            for(int i=0;i<sz;i++) {
                TreeNode *f = q.front();q.pop();
                vec.push_back(f->val);
                if(f->left)
                    q.push(f->left);
                if(f->right)
                    q.push(f->right);
                
            }
            ans.push_back(vec);
        }
        
        return ans;
    }
    
    void levelOrderRecursive(TreeNode *root, int level) {
        if(!root) return;
        
        while(ansR.size() <= level) {
            ansR.push_back(vector<int>());
        }
        
        ansR[level].push_back(root->val);
        
        levelOrderRecursive(root->left,level+1);
        levelOrderRecursive(root->right,level+1);
    }
    
};