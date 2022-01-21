// Time Complexity : O(n))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

#include <queue>
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {\       
        vector<vector<int>> result;       
        if(root==NULL){
            return result;
        }
        queue<TreeNode*> q1;
        
        q1.push(root);
        
        while(!q1.empty()){            
            int size = q1.size(); 
            vector<int> temp;
            for(int i=0; i< size; i++){
                TreeNode* node = q1.front();
                temp.push_back(node->val);
                q1.pop();
                if(node->left != NULL) q1.push(node->left);
                if(node->right != NULL) q1.push(node->right);
            }
            result.push_back(temp);
            
        }
        return result;
                                                
    }
};

