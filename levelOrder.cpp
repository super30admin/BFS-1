// Time Complexity :O(N) where n in the number of nodes
// Space Complexity : O(N)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
        vector<vector<int>> ans;
        vector<int> level;
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty()){
            level.clear();
            int size = q.size();
            while(size--){
                TreeNode* first = q.front();
                if(first){
                    cout<<first->val<<endl;
                    level.push_back(first->val);
                    q.push(first->left);
                    q.push(first->right); 
                }              
                q.pop();
            }
            if(level.size()>0)
                ans.push_back(level);
        }
        return ans;
    }
};