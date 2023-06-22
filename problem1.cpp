/*

Using BFS 

// Time Complexity : O(N)
// Space Complexity : O(N/2) -> length of the queue number of leaaves node
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
Take a queue enter the root. Run a loop until queue is empty inside it run a loop to go through all the elements in the current
level. Go through each element store the value in the arr of the current level and append it into the result array when all nodes
of the current are traversed
Do this until no nodes are left.

*/

#include<vector>
#include<queue>

using namespace std;

struct TreeNode{
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(): val(0),left(nullptr),right(nullptr){}
    TreeNode(int x): val(x),left(nullptr),right(nullptr){}
    TreeNode(int x, TreeNode* left,TreeNode* right):val(x),left(left),right(right){}
};

class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> res;
        if(root == NULL) return res;

        queue<TreeNode* > gg;
        gg.push(root);
        while(!gg.empty()){
            int l = gg.size();
            vector<int> arr;
            for(int i{};i<l;++i){
                TreeNode* node = gg.front();
                if(node->left) gg.push(node->left);
                if(node->right) gg.push(node->right);
                arr.push_back(node->val);
                gg.pop();
            }
            res.push_back(arr);
        }
        return res;
    }
};

/*

Using DFS

// Time Complexity : O(N)
// Space Complexity : O(H) height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
Traverese through the tree. At each recursion store the level of the tree
if the level is greater than the size of the result add a vector to the 2d vector
While traversing the whole tree , store the node values in the corresponding level vectors.

*/

class Solution_2 {
public:
    vector<vector<int>> res;
    void helper(TreeNode* root,int level){
        if(root == NULL) return;
        if(level > res.size()){
            res.push_back(vector<int>{});
        }
        res.at(level-1).push_back(root->val);
        helper(root->left,level+1);
        helper(root->right,level+1);
    }
    vector<vector<int>> levelOrder(TreeNode* root) {
        if(root == NULL) return res;
        helper(root,1);
        return res;
    }
};

