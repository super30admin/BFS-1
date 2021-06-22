class Solution {
public:
    //make iterative primary for level order
vector<vector<int>> levelOrder(TreeNode* root) {
        if (!root) return {};
        vector<vector<int>>res;
        queue<TreeNode*>q;
        q.push(root);
        int h = 0;
        while(!q.empty())
        {
            vector<int> Onelevel;
            for(int i = q.size(); i> 0; --i)
            {
                
                TreeNode *t = q.front(); q.pop();
                //if(h==1){
                Onelevel.push_back(t->val);
                //}
                
                if(t->left)q.push(t->left);
                if(t->right)q.push(t->right);
               
            }
            //I could return onelevel if needed
           // if(Onelevel.size()!=0){
            res.push_back(Onelevel);
            //}
            h++;
        }
        return res;
}
};
