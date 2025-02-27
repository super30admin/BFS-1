/*DFS Approach:
Use a recursive DFS traversal to traverse the tree, maintaining a separate vector for each level.
If the vector for a level doesn't exist, create one; otherwise, append the node's value to the existing vector.
Time Complexity: O(N), where N is the number of nodes. 
Space Complexity: O(H), where H is the height of the tree (call stack).

BFS Approach:
Utilize a queue for a level-order traversal, enqueueing nodes at each level and processing them.
For each level, enqueue the children of nodes and record the values in a vector.
Time Complexity: O(N), where N is the number of nodes. 
Space Complexity: O(W), where W is the maximum width of the tree (maximum number of nodes at a level).*/
#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
//dfs
    // vector<vector<int>> ans;
    // vector<vector<int>> levelOrder(TreeNode* root) {
    //     fun(root, 0);
    //     return ans;
    // }

    // void fun(TreeNode* root, int level){
    //     if(!root) return;
    //     if(ans.size()==level)ans.push_back({root->val});
    //     else ans[level].push_back(root->val);
    //     fun(root->left,level+1);
    //     fun(root->right,level+1);
    // }
    //bfs
    vector<vector<int>> levelOrder(TreeNode* root) {
    vector<vector<int>>result;
    queue<TreeNode*>q;
    if (root == NULL) {
        return result;
    }
    q.push(root);
    while(!q.empty()){
        vector<int>level;
        int levelSize=q.size();
        for(int i=0;i<levelSize;i++){
            TreeNode* node=q.front();
            q.pop();
            if(node->left){ q.push(node->left);}
            if(node->right) q.push(node->right);
            level.push_back(node->val);
        }
        result.push_back(level);
    }
    return result;
}
};