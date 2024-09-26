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
using namespace std;
class Solution {
public:
    vector<int> rightSideView(TreeNode* root) {
        
        queue<pair<TreeNode *,int>> tqueue;
        
        tqueue.push(make_pair(root,0));
        vector<vector<int>> result_structure;
        vector<int> result;
        if (!root) {
            return result;
        }
        while (tqueue.size() != 0) {
            TreeNode * node = tqueue.front().first;
            int height = tqueue.front().second;
            tqueue.pop();
            if (result.size() > height) {
                result_structure[height].push_back(node->val);
            } 
            else {
                vector<int> tmp;
                result_structure.push_back(tmp);
                result_structure[height].push_back(node->val);
            }
            if (node->left) {
                tqueue.push(make_pair(node->left,height+1));
            }
            if (node->right) {
                tqueue.push(make_pair(node->right,height+1));
            }
            
        }
        

        for(int i = 0; i < result_structure.size(); i++) {
            if ((result_structure[i].size() > 0)) {
                result.push_back(result_structure[i][result_structure[i].size()-1]);
            }
            
        }
        return result;
    }
};

// Time complexity: O(n)
// Space complexity: O(n)