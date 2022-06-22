//Time Complexity- O(n)
//Space Complexity- O(n)

class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        
        if(root==NULL){
            return vector<vector<int>>();
        }
        
        vector<vector<int>> ans;
        queue<TreeNode*> q;
        q.push(root);
        
        while(!q.empty()){
            
            vector<int> temp;
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode* curr=q.front();
                q.pop();
                temp.push_back(curr->val);
                
                if(curr->left){
                    q.push(curr->left);
                }
                if(curr->right){
                    q.push(curr->right);
                }
            }
            ans.push_back(temp);
        }
        return ans;
    }
};