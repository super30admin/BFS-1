// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// Idea here is to use a queue to store nodes and a size variable to track nodes
// in a particular level.


#include <vector>
#include <queue>
//Definition for a binary tree node.
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
    std::vector<std::vector<int>> levelOrder(TreeNode* root) {
        std::vector<std::vector<int>> result;
        if(root == nullptr)
        {
            return result;
        }
        std::queue<TreeNode*> q;
        q.push(root);
        while(!q.empty())
        {
            int size = q.size();
            std::vector<int> tmpList;
            for(int i = 0; i < size; i++)
            {
                TreeNode* curr = q.front();
                q.pop();
                tmpList.push_back(curr->val);
                if(curr->left != nullptr)
                {
                    q.push(curr->left);
                }
                if(curr->right != nullptr)
                {
                    q.push(curr->right);
                }
            }
            result.push_back(tmpList);
        }
        return result;
    }
};