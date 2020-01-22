Time Complexity-O(n)
Space Complexity-O(1) if recursive stack space is not considered or else it will be O(h)
Did the code run on Leetcode? yes

class Solution {
public:
    int depth=0;
    void rightmostnodes(TreeNode* root,vector<int>&k,int currentdepth)
    {
        if(root==NULL)
        {
            return;
        }
        if(currentdepth>=depth)
        {
            k.push_back(root->val);
            depth++;
        }
        rightmostnodes(root->right,k,currentdepth+1);
        rightmostnodes(root->left,k,currentdepth+1);
    }
    vector<int> rightSideView(TreeNode* root) {
        vector<int>k={};
        int currentdepth=0;
        rightmostnodes(root,k,currentdepth);
        return k;
    }
};