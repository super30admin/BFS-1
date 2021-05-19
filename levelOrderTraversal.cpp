"""
Intuition: We use a queue to add children at the end of the queue.
A for loop is used to get all elements at a level
#####################################################################
Time Complexity : O(N), N = total number of nodes
Space Complexity : O(N/2),  N/2 = Number of leaf nodes
#####################################################################

"""

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
        
        if (root == NULL){
            vector<vector<int>> a;
            return a;
        }
        vector <vector<int>> result;
        vector <TreeNode*> queue;
        queue.push_back(root);
        while (queue.size() != 0){
            
            int size = queue.size();
            vector<int> partialResult;
            for (int i = 0; i < size; i++){
                TreeNode *node = queue.front();
                queue.erase(queue.begin());
                partialResult.push_back(node->val);
                
                if (node->left != NULL){
                    queue.push_back(node->left);
                }if (node->right != NULL){
                    queue.push_back(node->right);
                }
            }
            result.push_back(partialResult);
        }
        return result;
    }
};