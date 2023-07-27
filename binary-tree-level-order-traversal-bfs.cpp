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
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        if(root == nullptr){
            return {};
        }
        queue<TreeNode*> bfs;
        vector<vector<int>> result;
        bfs.push(root);
        while(bfs.size() != 0){
            vector<int> temp;
            int qSize = bfs.size();
            for(int i = 0; i < qSize; i++){
                TreeNode* tempNode = bfs.front();
                if(tempNode->left != nullptr){
                    bfs.push(tempNode->left);
                }
                if(tempNode->right != nullptr){
                    bfs.push(tempNode->right);
                }
                bfs.pop();
                temp.push_back(tempNode->val);
            }
            result.push_back(temp);
        }
        return result;
    }
};