// Time Complexity : O(n)
// Space Complexity :  Not sure
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this

class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {

        // Queue to track the height and node        
        queue<pair<TreeNode*, int>> q;

        pair<TreeNode*, int> temp;
        
        // Return vector
        vector<vector<int>> ret_vect;
        
        if(root == NULL)
            return ret_vect;
        
        q.push({root, 0});
        
        while(!q.empty())
        {
            temp = q.front();
            q.pop();

            // Check if the vector at the height is already present or not    
            if(ret_vect.size() <= temp.second)
            {
                vector<int> vect;
                vect.push_back(temp.first->val);
                ret_vect.push_back(vect);
            }
            else
            {
                ret_vect[temp.second].push_back(temp.first->val);
            }
            
            if(temp.first->left)
                q.push({temp.first->left, temp.second+1});
            
            if(temp.first->right)
                q.push({temp.first->right, temp.second+1});
        }
        
        return ret_vect;
    }
};