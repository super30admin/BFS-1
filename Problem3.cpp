/*Time Complexity : O(n)
Space Complexity : O(n)
Did it run on LeetCode : No
Any difficulty faced? : No output.aa 
*/
class Solution {
public:
    vector<int> rightSideView(TreeNode* root) {
        vector<int>result;
        if(root==NULL)
        {
            return result;
        }
        
        treeTraversal(root,result,0);
        return result;
    }
    
    void treeTraversal(TreeNode* root, vector<int>res, int level)
    {
        if (root == NULL){
            return;
        }
         if (res.size() == level){
            res.push_back(root->val);
        }
        
        if (root->right != NULL){
            treeTraversal (root->right, res, level + 1);
        }
        if (root->left != NULL){
            treeTraversal (root->left, res, level + 1);
        }
    }
        
      
};