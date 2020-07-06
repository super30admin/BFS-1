// Time Complexity : O(n)
// Space Complexity : O(n/2) i.e. O(n); 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// 1. Do it similar to level order using BFS
// 2. Traverse each level and maintain size variable
// 3. While popping from queue, check if for loop is at last element of that level, if yes place in result vector 

class Solution {
public:
    vector<int> rightSideView(TreeNode* root) {
        // do it similar to level order; just check if for loop is at last el then add to result
        vector<int> result;
        if(root==nullptr)
            return result;
        int size = 0;
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty()){
            size = q.size();
            for(int i=0;i<size;i++){
                auto curr = q.front(); q.pop();
                if(i==size-1)
                    result.emplace_back(curr->val);
                if(curr->left)
                    q.push(curr->left);
                if(curr->right)
                    q.push(curr->right);
            }
        }
        return result;
    }
};


// Time Complexity : O(n)
// Space Complexity : O(h); h is height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// 1. DFS solution, recurse first on right side then on left
// 2. Pass result as reference and level by value. If level equals size of result, add node value to result
// 3. Recursively call right and left by incrementing level

class Solution {
public:
    vector<int> rightSideView(TreeNode* root) {
        vector<int> result;
        if(root==nullptr)
            return result;
        dfs(root, result, 0);
        return result;
    }
    
    void dfs(TreeNode* root, vector<int>& result, int level){
        // base
        if(root == nullptr)
            return;
        //logic
        if(level == result.size())
            result.emplace_back(root->val);
        dfs(root->right, result, level+1);
        dfs(root->left, result, level+1);        
    }
};