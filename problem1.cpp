
// Time Complexity : O(n)
// Space Complexity : O(n/2) which is O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


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
        vector<vector<int>> answer;
        if( root == nullptr ){
            return answer;
        }
        list<TreeNode*>l1;
        l1.push_back( root );
        vector<int>temp { root->val};
        answer.push_back( temp );
        while( l1.size()){
            int size = l1.size();
            vector<int>temp;
            while( size ){
                TreeNode* node = l1.front();
                l1.pop_front();
                if( node->left != nullptr ){
                    l1.push_back( node->left);
                    temp.push_back( node->left->val );
                }
                if( node->right != nullptr ){
                    l1.push_back( node->right );
                    temp.push_back( node->right->val );
                }
                size--;
            }
            if( temp.size()){
               answer.push_back( temp);
            }
        }
     return answer;   
    }
};
