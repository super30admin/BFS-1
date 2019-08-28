
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        
        vector<vector<int>> result;
        vector<int>elements;
        // Create a vector to store the result that will be returned at the end of the function.

	if(root==NULL)
    {
		return result;  // If the root value is null, return the result vector as it is. 
	}
        queue<TreeNode*> q;
        q.push(root);// Insert the root element in the queue.
        
        while(q.size()!=0){

		int size=q.size(); // In the first case, queue size is 1. Increases with iterations as elements are added.
            
		vector<int>elements;    // Create a vector of elements to store them in another vector as we have to return a vector of vector as the result.
            
		for (int i = 0; i < size; i++){
			TreeNode* front = q.front();    // Get the front element from queue and traverse the tree.

			if(front->left)
				q.push(front->left);
			if(front->right)
				q.push(front->right);

			q.pop(); // Pop the first element to traverse the next element and it's child nodes.
            
			elements.push_back(front->val);//Get a vector of the parent nodes.
		}
            
           if(elements.size()!=0){  // If the vector is not null, add the vectors to our resultant vector.
			result.push_back(elements); 
		}
        
        }

return result;
        
    
}
};