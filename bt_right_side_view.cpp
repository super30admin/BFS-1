// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach
//Recursive solution
// Time Complexity : O(n)
// Space Complexity : O(h) in worst case then O(n).
//DFS solution
//Recursive Part-1: left root call left root first and then replace
//1. Call recursion on the left node of the root till null condition is met and save the result at each level
//2. Check whether the right root is present and then replace
//3. Call recursion on the right node of the root and repeat
//Recursive Part-2: right root call right root first and then replacement
//1. Call recursion on the right node of the root till null condition is met and save the result at each level
//2. Call recursion on the left node of the root and add the level if not present
//BFS
// Time Complexity : O(n)
// Space Complexity :O(n/2).
//1.Create a queue and add elements level by level
//2.Save the last element of the level in the result and return. Inorder to do that size variable is required.
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
    vector<int> result;
    vector<int> rightSideView(TreeNode* root) {
        //edge case
        if(root==NULL){
            return result;
        }
        int level = 0;
       // get_right_elements_dfs_right_entry_first(root, 0);
       // get_right_elements_dfs_left_entry_first (root, 0);
        
        //iterative
        // stack<TreeNode *> tree_stack;
        // stack<int> level_stack;
        // bool first_flag = false;
        // while(root !=NULL || !tree_stack.empty()){
        //     if(tree_stack.empty() && result.size()!=0) level++;
        //     while(root!=NULL){
        //         tree_stack.push(root);
        //         if(result.size() == level){
        //           result.push_back(root->val);
        //           level_stack.push(level);
        //         }
        //         cout<<level<<endl;
        //         level++;
        //         root = root->right;
        //     }
        //     root = tree_stack.top();
        //     tree_stack.pop();
        //     level=level_stack.top();
        //     level_stack.pop();
        //     root = root->left;
        // }
        
        //BFS solution
        
        queue<TreeNode*> myqueue; 
        myqueue.push(root);
        //result.push_back(root->val);
       // TreeNode * temp= new TreeNode();
        while(!myqueue.empty()){
           // TreeNode * temp= ;
            result.push_back(myqueue.back()->val);
            int size = myqueue.size();
            while(size>0){
                TreeNode * temp = myqueue.front();
                myqueue.pop();
                size--;
                if(temp->left != NULL) myqueue.push(temp->left);
                if(temp->right != NULL) myqueue.push(temp->right);
            }
            
        }
        
        return result;
    }

private:
    void get_right_elements_dfs_right_entry_first (TreeNode* root, int level){
        //returning condition
        if(root==NULL){
            return;
        }
        if(result.size()==level){
            result.push_back(root->val);
        }
        get_right_elements_dfs_right_entry_first(root->right, level+1);
        // internal pop operation
        get_right_elements_dfs_right_entry_first(root->left, level+1);
    }
    
    void get_right_elements_dfs_left_entry_first (TreeNode* root, int level){
        //returning condition
        if(root==NULL){
            return;
        }
        if(result.size()==level){
            result.push_back(root->val);
        }else{
            result[level] = root->val;
        }
        get_right_elements_dfs_left_entry_first(root->left, level+1);
        // internal pop operation
        get_right_elements_dfs_left_entry_first(root->right, level+1);
    }
};
