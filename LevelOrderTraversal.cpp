// Time Complexity : O(n) or O(V + E)
// Space Complexity : O(n) or O(maximum diameter of tree)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning


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
        
        // base case
        if(root == NULL) return result;
        
        queue<TreeNode* > myqueue;
        
        // adding the tree node to queue to start exploring
        myqueue.push(root);
        
        // iterate throught all the nodes in that level.
        while(!myqueue.empty()){
            int size = myqueue.size();
            
            // temporary array to create the nodes in that level when popping and then add them result.
            vector<int> temp;
            
            for ( int i = 0; i < size; i ++){
                
                TreeNode* front = myqueue.front();
                myqueue.pop();
                temp.push_back(front->val);
                
                // adding the next level nodes to the queue so that we will traverse in the next iteration.
                if(front->left != NULL){
                    myqueue.push(front->left);
                }
                 if(front->right != NULL){
                    myqueue.push(front->right);
                }
            }
            // adding the nodes at this level to result and then moving to the next level or iteration
            result.push_back(temp);
            
        }
        
        
        
        return result;
    }
};