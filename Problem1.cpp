//
// Created by shazm on 7/29/2019.
//

#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

// approach : use queue and bst.

struct TreeNode{
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x) : val(x), left(NULL), right(NULL){}
};

class Solution{
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> retVec;
        if(root==NULL){return retVec;}
        queue<pair<TreeNode*,int>> que;
        que.push(pair<TreeNode*,int>(root,1));

        TreeNode* node; int currLevel;
        while(!que.empty()){
            node = get<0>(que.front());
            currLevel = get<1>(que.front());
            if(currLevel > retVec.size()){
                vector<int> vec;
                vec.push_back(get<0>(que.front())->val);
                retVec.push_back(vec);
            }else{
                retVec[currLevel-1].push_back(node->val);
            }
            que.pop();

            if(node->left!=NULL){
                que.push(pair<TreeNode*,int>(node->left,currLevel+1));
            }

            if(node->right!=NULL){
                que.push(pair<TreeNode*,int>(node->right,currLevel+1));
            }
        }

        return retVec;
    }

    vector<vector<int>> levelOrder(TreeNode* root) { //another solution. Without using level.
        vector<vector<int>> retVec;
        if(root==NULL){return retVec;}
        queue<TreeNode*> que;
        que.push(root);

        TreeNode* node; int size = 0;
        while(!que.empty()){
            vector<int> vec;
            size = que.size();
            for(int x = 0; x<size; x++){
                node = que.front();
                vec.push_back(node->val);
                if(node->left!=NULL){
                    que.push(node->left);
                }
                if(node->right!=NULL){
                    que.push(node->right);
                }
                que.pop();
            }
            retVec.push_back(vec);
        }

        return retVec;
    }
};