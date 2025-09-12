// Time Complexity : O(n), n = number of nodes
// Space Complexity : O(h), h = height of tree, which will be the size of the recursion stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// We pass the current node & the level of the node to DFS helper function
// At each level, we check the size of the 2D result array, if there is no vector allocated for that level, create a new vector
// Once we have allocated the vector, insert the values in the appropriate levels in preorder/postorder/inorder manner. While going to the left and right child, increase level by 1. 

class Solution {
private:
    void dfs(TreeNode* curr, int level, vector<vector<int>>& result) {
        // base case
        if(!curr) return;
        // logic
        if(result.size() == level) { // allocate space for that level if the vector does not exist
            vector<int> newLevelVector;
            result.push_back(newLevelVector);
        }

        dfs(curr->left, level+1, result); // go down the left path and increase level by 1
        result[level].push_back(curr->val); // insert the current node into the appropriate level vector
        dfs(curr->right, level+1, result); // go down the right path and increase level by 1
    }
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> result;
        dfs(root, 0, result);
        return result;
    }
};