//Time complexity : O(n)
//Space complexity : O(n/2) = O(n)

//Approach :
            //Traverse through the tree using a queue for BFS
            //Create new array for every level of traversal

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
        if(root == nullptr)
            return {};
        vector<vector<int>> result;
        queue<TreeNode*> q;
        
        q.push(root);
        
        while(!q.empty())
        {
            int size = q.size();
            vector<int> res;
            for(int i = 0 ; i < size; i++)
            {
                TreeNode* ptr = q.front();
                q.pop();
                res.push_back(ptr->val);
                if(ptr->left != nullptr)
                    q.push(ptr->left);
                if(ptr->right != nullptr)
                    q.push(ptr->right);
            }
            result.push_back(res);
        }
        
        return result;
    }
};