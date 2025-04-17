// Time Complexity : O(N) N is #of nodes in tree
// Space Complexity : O(N)  
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach:
// 1. Traverse tree using DFS while taking level variable globally which will increase while traversing left than right and decrease after completing traversal.
// 2. If given element is not visited add it to array with index as level of DFS. 
// 3. Return array.

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
    int currl=-1;
    void preordertra(TreeNode* t,vector<vector<int>> &ans){
        if(t==nullptr){
            return;
        }
        int maxh=ans.size();currl++;
        if(t->val != 1001){
            if(maxh>currl){
                (ans[currl]).push_back(t->val);(t->val)=1001;
            }else{
                vector<int> tt;
                tt.push_back(t->val);ans.push_back(tt);
            }
        }
        preordertra(t->left,ans);
        preordertra(t->right,ans);
        currl--;
    }
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> ans;
        preordertra(root,ans);
        return ans;
    }
};
