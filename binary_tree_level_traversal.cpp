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

//BFS solution
// Time Complexity : O(n)
// Space Complexity : O(n) worst case O(n/2).
//1. Find root and store left or right root in the queue.
//2. Push the left path elements and then right in the queue till the level is completed.
//3. Store the level array at every level into the result

class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>>  result;
        //edge
        if(root == NULL){
            return result;
        }
        //logic
        queue <TreeNode*> myqueue;
        myqueue.push(root);
        int size;
        while(!myqueue.empty()){
            size = myqueue.size();
            vector<int> temp_result;
            while(size>0){
                TreeNode* temp = myqueue.front();
                myqueue.pop();
                size--;
                temp_result.push_back(temp->val);
                if(size==0){
                    result.push_back(temp_result);
                }
                if(temp->left !=NULL) myqueue.push(temp->left);
                if(temp->right !=NULL) myqueue.push(temp->right);
            }
        }
        
        return result;
    }
};

// DFS solution
// Time Complexity : O(n) //traversal of n nodes
// Space Complexity : O(h) worst case O(n). Recursive stack space
//1. Find root and store the value in the appropriate level of the result.
//2. Push the left path elements and then right in the result till the level is completed.

class Solution {
public:
    vector<vector<int>>  result;
    vector<vector<int>> levelOrder(TreeNode* root) {
        //edge
        if(root == NULL){
            return result;
        }
        //logic
        helper(root, 0);
        return result;
    }
    
    void helper(TreeNode* root, int level){
        //base
        if(root ==NULL){
            return;
        }
        //logic
        if(result.size() > level){
            result[level].push_back(root->val);
        }else{
            vector<int> temp;
            temp.push_back(root->val);
            result.push_back(temp);
        }
        helper(root->left, level+1);
        helper(root->right, level+1);
    }
    
    
};
