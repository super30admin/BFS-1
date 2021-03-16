//TC: O(n) where n is number of nodes
//SC: O(1). O(n) extra space is considered for the output vector

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
        
        //result vector
        vector<vector<int>> ans;
        queue<TreeNode *> q;
        
        if(root!=NULL)
            q.push(root);
        
        while(!q.empty()){
            
            int size = q.size();
            //empty list
            ans.push_back(vector<int>());
            TreeNode *cur;
            
            for(int i=0; i<size; i++){
                
                cur = q.front();
                q.pop();
                //add the last value to the back of the queue
                ans.back().push_back(cur->val);
                
                if(cur->left!=NULL)
                    q.push(cur->left);
                
                if(cur->right!=NULL)
                    q.push(cur->right);
                
            }
            
            
        }
        
        return ans;
        
    }
};