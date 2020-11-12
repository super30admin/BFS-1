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

// Using Depth First Search (DFS)
// Time complexity is O(n) - n = number of nodes of tree
// Space complexity is O(n) - recursive stack size
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

// Your code here along with comments explaining your approach:

/*
    1. By comparing the size of result and the value of level, we can determine
        if the current node belongs to a previous level or it belongs to a new level.
    2. If it belongs to a new level, we create a new list(temp vector),
        add the current node's value(root->val), and push it in the result 2-D vector.
 */

class Solution {
public:
    vector<vector<int>> res;
    
    void helper(TreeNode* root, int level) {
        //base
        if(root == nullptr) return;
        //logic
        if(level == res.size()) {
            vector<int> temp;
            temp.push_back(root->val);
            res.push_back(temp);
        }
        else {
            res[level].push_back(root->val);
        }
        helper(root->left, level+1);
        helper(root->right, level+1);
    }
    vector<vector<int>> levelOrder(TreeNode* root) {
        if(root == nullptr) return {};
        helper(root, 0);
        return res;
    }
};


// Using Breadth First Search (BFS)
// Time complexity is O(n) - n = number of nodes of tree
// Space complexity is O(n) - recursive stack size
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

// Your code here along with comments explaining your approach:

/*
    1. We add the root to the queue and keep track of size of the queue.
    2. Here, the queue size will determine the number of treenodes in each level.
    3. We pop an element from the queue and add it's children to the queue.
    4. The inner for loop will pop all nodes belonging to same level and their values are
       added to a list(nodesAtEachLevel vector). 
 */

class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        if(root == nullptr) return {};
        vector<vector<int>> res;
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty()) {
            int size = q.size();
            vector<int> nodesAtEachLevel;
            for(int i = 0; i < size; i++) {
                TreeNode* node = q.front();
                q.pop();
                if(node->left) q.push(node->left);
                if(node->right) q.push(node->right);
                nodesAtEachLevel.push_back(node->val);
            }
            res.push_back(nodesAtEachLevel);
        }
        return res;
    }
};
