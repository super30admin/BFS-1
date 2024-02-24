// 102. Binary Tree Level Order Traversal
// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
    
utilizes a breadth-first search (BFS) approach with a queue to explore nodes level by level. 
At each level, dequeues nodes, adding their values to a temporary vector, and enqueues their 
children if they exist, then appends the temporary vector to the final result representing nodes at that level.







*/

class Solution {
public:
    vector<vector<int>> ans;
    vector<vector<int>> levelOrder(TreeNode* root) {
        if (root == NULL) return ans;
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty())
        {
            int size = q.size();
            vector<int> temp = {};
            for(int i = 0; i < size; i++)
            {
                root = q.front();
                q.pop();
                temp.push_back(root->val);
                if(root->left!=NULL)
                    q.push(root->left);
                if(root->right!=NULL)
                    q.push(root->right);
            }
            ans.push_back(temp);
        }
       
        return ans;
    }
};