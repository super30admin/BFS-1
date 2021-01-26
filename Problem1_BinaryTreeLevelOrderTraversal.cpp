
// Time Complexity : O(n) where n is number of elements
// Space Complexity : O(1) we are not using extra space
// Did this code successfully run on Leetcode :yes
// Did this code successfully run on Home system :No i got errors
//          Problem1_BinaryTreeLevelOrderTraversal.cpp:120:30: error: use of undeclared identifier 'levelOrder'
//                  vector<vector<int>> res =levelOrder(root); 


//          Problem1_BinaryTreeLevelOrderTraversal.cpp:122:14: error: invalid operands to binary expression ('std::__1::ostream'
    //   (aka 'basic_ostream<char>') and 'std::__1::__vector_base<std::__1::vector<int, std::__1::allocator<int> >,
    //   std::__1::allocator<std::__1::vector<int, std::__1::allocator<int> > > >::value_type' (aka 'std::__1::vector<int,
    //   std::__1::allocator<int> >'))
    //     cout << res[i] << " "; 

// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach


#include<vector>
#include<bits/stdc++.h>
#include<stdlib.h>
#include<cmath>
#include<time.h>
#include<iostream>

using namespace std;

 //* Definition for a binary tree node.
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 };

class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        
        vector<vector<int>> result;
        if(root==NULL) return result;
        
        queue<TreeNode*> q;
        q.push(root);
        
        while(!q.empty()){
            int count = q.size();
            vector<int> temp;
            for(int i=0;i<count;i++){
                TreeNode* curr= q.front(); 
                q.pop();
                temp.push_back(curr->val);
                if(curr->left != NULL) q.push(curr->left);
                if(curr->right != NULL) q.push(curr->right);
            }
            result.push_back(temp);
        }
        
        return result;
        
    }
};


//Below is DFS solution

// class Solution {
//     vector<vector<int>> result;
// public:
//     vector<vector<int>> levelOrder(TreeNode* root) {
        
        
//         if(root==NULL) return result;
        
//         // queue<TreeNode*> q;
//         // q.push(root);
//         // while(!q.empty()){
//         //     int size = q.size();
//         //     vector<int> temp;
//         //     for(int i=0;i<size;i++){
//         //         TreeNode* curr= q.front(); 
//         //         temp.push_back(curr->val);
//         //         if(curr->left != NULL) q.push(curr->left);
//         //         if(curr->right != NULL) q.push(curr->left);
//         //     }
//         //     result.push_back(temp);
//         // }
//         dfs(root,0);
//         return result;
        
//     }
// private:
//     void dfs(TreeNode* root, int level){
//         //base
//         if(root==NULL) return;
        
        
//         //logic
//         if(level==result.size()){
//             result.push_back(vector<int>());
//         }
//         result.at(level).push_back(root->val);
//         dfs(root->left,level+1);
//         //st.pop()
//         dfs(root->right,level+1);
//     }
// };

int main() 
{ 
    /* Let us construct a Binary Tree 
        4 
       / \ 
      9   2 
     / \   \ 
    3   5   7 */
  
    TreeNode* root = NULL; 
    root = new TreeNode(4); 
    root->left = new TreeNode(9); 
    root->right = new TreeNode(2); 
    root->left->left = new TreeNode(3); 
    root->left->right = new TreeNode(5); 
    root->right->right = new TreeNode(7); 
      
    vector<vector<int>> res =levelOrder(root); 
    for (int i = 0; i < res.size(); i++) 
        cout << res[i] << " "; 
          
    return 0; 
} 