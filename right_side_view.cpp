//Time Complexity-O(n)
//Space complexity-O(n/2)=O(n)
//Ran successfully on leetcode
//3 point algo-
	//1a)In DFS, just process the right side first
	//1b)If the size of the result vector is the same as level, then we add it to the result vector. That makes it the right most
	//2a)In bfs, iterate for a particular level by kepping track using the queue
	//2b)We track the last element in a particular level. Last always gets overwritten by the last node we traverse in that level
	//2c)Pop the node whose children have been added

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
    vector<int>result;
public:
    /*vector<int> rightSideView(TreeNode* root) {
        if(root==NULL)
            return {};
        dfs(root,0);
        return result;
    }
    void dfs(TreeNode* root,int level)
    {
        if(root==NULL)
            return;
        if(level==result.size())
            result.push_back(root->val);
        dfs(root->right,level+1);
        dfs(root->left,level+1);
    }*/
    //bfs method
    vector<int> rightSideView(TreeNode* root) {
        if(root==NULL)
            return {};
        queue<TreeNode*>q;
        int last;
        q.push(root);
        while(!q.empty())
        {
            int n=q.size();
            for(int i=0;i<n;i++)
            {
                TreeNode*curr=q.front();
                last=curr->val;
                //add children of the node
                if(curr->left!=NULL)
                    q.push(curr->left);
                if(curr->right!=NULL)
                    q.push(curr->right);
                q.pop();
            }
            result.push_back(last);
        }
        return result;
    }
};