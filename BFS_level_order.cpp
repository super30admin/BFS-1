 //Time O(n)
 //Space O(n)
 //Leetcode: yes
 // Issue seen : none
 
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        queue<TreeNode*> q;
        vector<vector<int>> ans;
        if (!root)
            return ans;

        q.push(root);
        while (!q.empty()) {
            int n = q.size();
            vector<int> res;
            while (n) {
                TreeNode* node = q.front();
                q.pop();
                res.push_back(node->val);
                if (node->left)
                    q.push(node->left);
                if (node->right)
                    q.push(node->right);
                n--;    
            }
            ans.push_back(res);
            res.clear();
        }
        return ans;
    }
};
