// Time Complexity :O(N) N-> Number of nodes in the tree
// Space Complexity :O(D) D->Diameter of the tree.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//BFS approach

class Solution {
public:
    vector<int> rightSideView(TreeNode* root) {
        vector<int> res;
        if(root==NULL)
            return res;

        queue<TreeNode*> q;
        q.push(root);

        while(!q.empty()){
            int size = q.size();
            TreeNode* curr;
            for(int i=0;i<size;i++){
                curr = q.front();
                q.pop();
                if(curr->left!=NULL)
                    q.push(curr->left);
                if(curr->right!=NULL)
                    q.push(curr->right);
            }
            res.push_back(curr->val);
        }
        return res;
    }
};
