//Time Complexity-O(n)
//Space complexity-O(n/2)=O(n)
//Ran successfully on leetcode
//3 point algo-
	//1a)In bfs, we maintain a size for the queue and push the children of a root into the queue.
	//1b)The size of the queue for each set of children will represent the levels.
	//1c)Each element popped out of the queue has to be pushed into the result matrix. Once we finish operating on the size, we enter the next line of the result matrix.
	//2a)In dfs, we push elements recursively for each depth of the tree.
	//2b)If the depth becomes equal to the size of the result, then we create a new line in the result matrix.

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}r
 * };
 */
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        /*Using bfs
        if(root==NULL)
            return {};
        //First we initialize a queue and result vector
        queue<TreeNode*>q;
        vector<vector<int>>result;
        //First push the root into the queue
        q.push(root);
        //Add the 
        while(!q.empty())
        {
            vector<int>temp;
            for(int i=0;i<q.size();i++)
            {
                TreeNode*curr=q.front();
                q.pop();
                temp.push_back(curr->val);
                if(curr->left!=NULL)
                    q.push(curr->left);
                if(curr->right!=NULL)
                    q.push(curr->right);
            }
            result.push_back(temp);
        }
        return result;*/
        
		//Using DFS
		
        if(root==NULL)
            return {};
        vector<vector<int>>result;
        helper(result,0,root);
        return result;
    }
    void helper(vector<vector<int>>&result,int depth,TreeNode* root)
    {
        if(root==NULL)
            return;
        if(depth>=result.size())
            result.push_back({});
        result[depth].push_back(root->val);
        helper(result,depth+1,root->left);
        helper(result,depth+1,root->right);
    }
};