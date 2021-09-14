// Time Complexity :  O(n)
// Space Complexity : O(n) (BFS-max n/2 nodes in queue) O(h) (max calls in recursive stack = h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Minor, nothing too tough


// Your code here along with comments explaining your approach

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
  
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> result;
        dfs(result, root, 0); // call the dfs
        return result; // return result

        /*  BFS APPROACH
        if(root == NULL) return {};
        vector<vector<int>> result;
        queue<TreeNode*> q;
        q.push(root); // push root
        int count; // count to get the size of the queue
        TreeNode* p; 
        while(! q.empty() ){
            count = q.size();
            vector<int> v;
            for(int i = 0; i<count; i++){
                p = q.front(); // get the queue front
                q.pop();
                v.push_back(p->val);  // push value into array
                if(p->left) q.push(p->left);
                if(p->right) q.push(p->right);
            }
            result.push_back(v); // push into result vector
        }
        return result;
        */
    }
    
    void dfs(vector<vector<int>> &result ,TreeNode* root, int level){
       if(root == NULL) return;  // null case
        if(level == result.size()) result.push_back(vector<int>());  
        result[level].push_back(root->val); // push root val
        dfs(result, root->left, level+1);  // recursive call
        dfs(result, root->right, level+1);  // recursive call
    }
};
