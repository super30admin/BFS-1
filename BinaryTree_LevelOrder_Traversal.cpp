#include<iostream>
#include<vector>
#include<queue>
using namespace std;
struct TreeNode {
      int val;
      TreeNode *left;
      TreeNode *right;
      TreeNode() : val(0), left(nullptr), right(nullptr) {}
      TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
      TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
  };
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>>ans;
        if(root == nullptr)
            return ans;
        queue<TreeNode*>q;
        q.push(root);
        while(!q.empty()){
            int s = q.size();
            vector<int>temp;
            for(int i=0;i<s;i++){
                TreeNode* ptr = q.front();
                q.pop();
                if(ptr -> left)
                    q.push(ptr->left);
                if(ptr -> right)
                    q.push(ptr->right);
                temp.push_back(ptr->val);
            }
            ans.push_back(temp);
        }
        return ans;
    }
};