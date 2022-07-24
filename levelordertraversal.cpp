class Solution {
public:
    //TC-O(N)
    //SC-O(H)
    vector<vector<int>>res;
    void inorderFiller(TreeNode* root,int level){
        if(!root)return;
        if(res.size()==level){
            res.push_back({});
            }
        inorderFiller(root->left,level+1);
        res[level].push_back(root->val);
        inorderFiller(root->right,level+1);
    }
       void preorderFiller(TreeNode* root,int level){
        if(!root)return;
        if(res.size()==level){
            res.push_back({});
            }
        res[level].push_back(root->val);
        inorderFiller(root->left,level+1);
       
        inorderFiller(root->right,level+1);
    }
    
    vector<vector<int>> levelOrder(TreeNode* root) {
    queue<TreeNode*> q;
//Initialize a queue with TreeNode because we need to store the nodes themselves to explore their cousins ,this is not possible by storing the integer value
    vector<vector<int>> res;
         if(!root)return res;
        q.push(root);
        while(!q.empty()){
            int k=q.size();
            //size opf each level
            vector<int> level;
//temp variable to store value of each level this should be re-initialized for every level so decalre it here
            while(k--){
          TreeNode* node=q.front();
            q.pop();
            if(node->left){
                q.push(node->left);
            }
            if(node->right){
             q.push(node->right);
            }
                //pushing the cousin nodes
                level.push_back(node->val);
                
            }
            res.push_back(level);
            //pushing the entire level 
        }
       
        return res;
    }
};