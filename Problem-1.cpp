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
 Time complexity = O(N)
 Space complexity = O(N)
 Where N is the number of nodes in the tree and h is the height of the tree.
 */
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> result;
        if(root==NULL)
            return result;
        queue <TreeNode*> q;
        q.push(root);
        while(!q.empty())
        {
            vector <int> ans;
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode* temp = q.front();
                q.pop();
                if(temp->left!=NULL)
                    q.push(temp->left);
                if(temp->right!=NULL)
                    q.push(temp->right);
                ans.push_back(temp->val);
            }
            result.push_back(ans);
        }
        return result;
    }
};


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
  Time complexity = O(N)
 Space complexity = O(h)
 Where N is the number of nodes in the tree and h is the height of the tree.
 */
class Solution {
public:
    vector<vector<int>> result;
    vector<vector<int>> levelOrder(TreeNode* root) {
        if(root==NULL)
            return result;
        dfs(root,0);
        return result;
    }
    void dfs(TreeNode *root, int lvl)
    {
        //base
        if(root==NULL)
            return;
        //logic
        if(result.size()==lvl)
        {
            vector<int> ans;
            ans.push_back(root->val);
            result.push_back(ans);
        }
        else
        {
            result[lvl].push_back(root->val);
        }
        dfs(root->left,lvl+1);
        dfs(root->right,lvl+1);
    }
};
