// TC:O(N)
// SC:O(H)

// USING DFS PREORDER

class Solution {
public:
    vector<vector<int>>ans;
    // vector<int>a;

    vector<vector<int>> levelOrder(TreeNode* root) {
      
        func(root,0);  
        return ans;

    }

    void func(TreeNode* root,int lvl)
    {
        if(root==nullptr)
        return;
    // Here adding a new vector each time when lvl ==ans.size
        if(lvl==ans.size())
        {
         vector<int>temp;
         ans.push_back(temp);
        }
        
    // inserting into vector of each level
        ans[lvl].push_back(root->val);

        func(root->left,lvl+1);
        func(root->right,lvl+1);

    }
};



// TC:O(N)
// SC:O(2^H)


//  Level ordertraversal iterative
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        
        queue<TreeNode*>q;
        vector<vector<int>>ans;
        if(root==nullptr)
         return ans;

        q.push(root);
       

        while(q.empty()!=true)
        {
            int temp=q.size();
            vector<int>k;
            while(temp>0)
            {
               TreeNode* g = q.front();
               q.pop();

               k.push_back(g->val);

               if(g->left!=nullptr)
               q.push(g->left);
               if(g->right!=nullptr)
               q.push(g->right);

                temp--;
            }
            ans.push_back(k);
        }

        return ans;
        
    }
};