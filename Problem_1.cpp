/*
Time Complexity:
O(N) as we are traversing the tree only once
*/

/*
Space Complexity:
O(N) as we are crating  extra space to store the levels
and those levels are then stored in the resultant vector.
*/

/*
Approach:
Iterative approach is used here. Although the recursive
approach is giving the same time and space complexity.

We are maintaining a queue here.
Then we add the root in the queue to start
the traversal. Then we have keep on adding the 
nodes until the queue becomes empty.

For each level we take the size of the queue
and add the children of the node which is at the
front of the queue and the value of the
root to the temporary array(stores the nodes at a level). 
And when we are done with each level, we store that temporary array
in  the resultant array. Then we check if our queue
is empty or not. If not we have to again check the size of the queue and repeat 
the process. if queue is empty it means we have reached at the end of our tree*/

//The code ran perfectly on leetcode.


class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        
        if(!root) return {};
        vector<vector<int>> result;
        vector<int> store;
        queue<TreeNode*> q;
        q.push(root);
        while(q.empty() == false){
            store = {};
            int qSize = q.size();
            for(int i = 0; i<qSize; i++){
                 root = q.front();
            q.pop();
            if(root->left){
                q.emplace(root->left);
            }
            if(root->right){
                q.emplace(root->right);
            }
                
                store.push_back(root->val);
            }
                result.push_back(store);
            }
           
        
        
        return result;
        
    }
};