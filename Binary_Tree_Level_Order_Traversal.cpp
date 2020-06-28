// Time Complexity :O(N) N-> Number of nodes in the tree
// Space Complexity :O(D) D->Diameter of the tree.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {

        vector<vector<int>> res;
        if(root==NULL){
            return res;
        }
        queue<TreeNode*> q;
        q.push(root);


        while(!q.empty()){
            int size = q.size();
            vector<int> temp;
            for(int i=0;i<size;i++){
                TreeNode* curr = q.front();
                q.pop();
                if(curr!=NULL){
                    temp.push_back(curr->val);
                    q.push(curr->left);
                    q.push(curr->right);
                }
            }
            if(temp.size()!=0)
                res.push_back(temp);
        }
        return res;

    }
};
