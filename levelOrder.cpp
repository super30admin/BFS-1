// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// we need to track every new level. so store depth in addition to the node
// whenever we encounter the start of a new level, emplace the previous level vector in res and clear the vector for this level. if the node is not the start of a new level then simply continue emplacing in the level vector.
// the last level would never have been emplaced since if(curr.second>prev_depth) would never have been satisified as there is no level beyond the last. so place it separately

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {

        queue<pair<TreeNode*,int>> q;
        vector<vector<int>> res;
        if(!root)
            return res;
        vector<int> level;
        q.push({root,0});
        int prev_depth=0;
        while(!q.empty()){
            auto curr = q.front(); q.pop();            
            if(curr.first){
                if(curr.second>prev_depth){
                    res.emplace_back(level);
                    level.clear();
                }
                level.emplace_back(curr.first->val);

                q.push({curr.first->left, curr.second+1});
                q.push({curr.first->right, curr.second+1});
                prev_depth=curr.second;
            }
        }
        
        res.emplace_back(level);
        return res;
    }
};