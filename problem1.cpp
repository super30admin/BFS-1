/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */


#include<queue>
#include<utility>
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        
        queue<pair<TreeNode *,int>> tqueue;
        
        tqueue.push(make_pair(root,0));
        vector<vector<int>> result;
        if (!root) {
            return result;
        }
        while (tqueue.size() != 0) {
            TreeNode * node = tqueue.front().first;
            int height = tqueue.front().second;
            tqueue.pop();
            if (result.size() > height) {
                result[height].push_back(node->val);
            } 
            else {
                vector<int> tmp;
                result.push_back(tmp);
                result[height].push_back(node->val);
            }
            if (node->left) {
                tqueue.push(make_pair(node->left,height+1));
            }
            if (node->right) {
                tqueue.push(make_pair(node->right,height+1));
            }
            
        }
        return result;
    }
};

// Time complexity: O(n)
// Space complexity: O(n)