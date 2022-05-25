DFS
O(N) time, O(H) space

class Solution {
public:
    
    vector<vector<int>> result;
    vector<vector<int>> levelOrder(TreeNode* root) {
        if(root==NULL) return result;
        dfs(root,0);
        return result;
    }
    
    void dfs(TreeNode* root, int level){
        if(root == NULL) return;
        if(level == result.size()){
            result.push_back(vector<int>());
        }
        dfs(root->left,level+1);
        result[level].push_back(root->val);
        dfs(root->right,level+1);
    }
};


BFS
O(N) time, O(N) space
space = n/2 = width of tree

class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> result;
        if(root == NULL) return result;
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty()){
            int size = q.size();
            vector<int> level;
            for(int i=0;i<size;i++){
                TreeNode *curr = q.front(); q.pop();
                level.push_back(curr->val);
                if(curr->left!=NULL) q.push(curr->left);
                if(curr->right!=NULL) q.push(curr->right);
            }
            result.push_back(level);
        }
        return result;
    }
};
