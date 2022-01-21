// Time Complexity : O(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

class Solution {
public:
    vector<vector<int>> result;
    vector<vector<int>> levelOrder(TreeNode* root) {
        if(root==NULL){
            return result;
        }
        dfs(root,0);
        return result;
    }
    
    void dfs(TreeNode* root, int level){
        
        //base
        if(root == NULL){ return ;}
        
        //logic
        if(level == result.size()){
          result.push_back({});
        }
        result[level].push_back(root->val);
        dfs(root->left, level+1);
        dfs(root->right, level+1);
        
    }
};

