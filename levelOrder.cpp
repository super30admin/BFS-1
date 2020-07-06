/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */


// Time Complexity : O(n)
// Space Complexity : O(h); h is height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// 1. DFS solution. Maintain reference to result vector and level in recursive stack
// 2. If the recursion level is same as result size then we create a new subarray in result
// 3. Place the node at the recursion level and recurse for left and right child

// Improved solution DFS
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> result;
        dfs(root,result,0);
        return result;
    }
    
    void dfs(TreeNode* root, vector<vector<int>>& result, int level){
        // base
        if(root == nullptr)
            return;
        // logic
        if(level == result.size()){
            vector<int> temp;
            result.emplace_back(temp);
        }
        result[level].emplace_back(root->val);
        dfs(root->left, result, level+1);
        dfs(root->right, result, level+1);
    }
};

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// 1. BFS iteration by maintaining queue size since we need to process tree element in distinct groups
// 2. Add root to queue and iterate till queue is not empty. Iterate over size of queue and add all children to queue
// 3. Place vector into result

// Improved solution: BFS
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> result;
        if(root==nullptr)
            return result;
        queue<TreeNode*> q;
        int size = 0;
        q.push(root);
        while(!q.empty()){
            cout<<q.size()<<endl;
            vector<int> level;
            size=q.size();
            for(int i=0; i<size; i++){
                TreeNode* curr = q.front(); q.pop();
                level.emplace_back(curr->val);
                if(curr->left != nullptr) q.push(curr->left);
                if(curr->right!= nullptr) q.push(curr->right);
            }
            result.emplace_back(level);
        }
        return result;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// we need to track every new level. so store depth in addition to the node
// whenever we encounter the start of a new level, emplace the previous level vector in res and clear the vector for this level. if the node is not the start of a new level then simply continue emplacing in the level vector.
// the last level would never have been emplaced since if(curr.second>prev_depth) would never have been satisified as there is no level beyond the last. so place it separately

// Original solution BFS
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