
// # BFS-1
// # Problem 1
// Binary Tree Level Order Traversal (https://leetcode.com/problems/binary-tree-level-order-traversal/)


//idea- print at each level

//TO DO## : try with queue 

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
    
    int  heightOfTree( TreeNode* root){
        
        if(root ==NULL){
            return 0;
        }
        return 1 + max( heightOfTree(root->left), heightOfTree(root->right));
    }
    
    void printAtLevel(TreeNode* root, int level,  vector <int> &output){
        
     
        if(root == NULL || level<0){
            return;
        }
        
        if(level==1){
            output.push_back(root->val);
            return;
        }
        else{
            printAtLevel( root->left, level-1, output);
            printAtLevel( root->right, level-1, output);
        }   
    }
    
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int> > output;
        int h = heightOfTree( root);
        for (int i=1; i<=h; i++ ){
            vector<int> levelOutput;
            printAtLevel( root, i, levelOutput);
            output.push_back(levelOutput);
        }
        
      return output;  
        
    }
};