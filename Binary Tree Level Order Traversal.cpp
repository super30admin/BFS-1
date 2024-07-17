// time: O(n)
// space: O(n)

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
        if(root == NULL) {
            return result;
        }
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty()) {
            vector<int> vec;
            int sz = q.size();    
            for(int i = 0; i < sz; i++) {
                
                TreeNode* curr = q.front();
                vec.push_back(curr->val);
                q.pop();
                if(curr->left != NULL) {
                    q.push(curr->left);
                }
                if(curr->right != NULL) {
                    q.push(curr->right);
                }
            }
            result.push_back(vec);
            //vec.clear();
        }
        return result;
    }
};