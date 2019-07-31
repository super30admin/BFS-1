//
// Created by shazm on 7/29/2019.
//

#include <iostream>
#include <algorithm>
#include <vector>

// approach: use queue and bst.

using namespace std;

struct TreeNode{
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x): val(x), left(NULL), right(NULL){}
};

class Solution{
public:
    vector<int> rightSideView(TreeNode* root) {
        vector<int> retVec;
        if(root==NULL){
            return retVec;
        }

        queue<pair<TreeNode*,int>> que;
        que.push(pair<TreeNode*,int>(root,1));

        TreeNode* node; int currLevel;
        while(!que.empty()){
            node = get<0>(que.front());
            currLevel = get<1>(que.front());
            if(currLevel > retVec.size()){
                retVec.push_back(node->val);
            }else{
                retVec[currLevel-1] = (node->val);
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

    vector<int> rightSideView(TreeNode* root) { //Second method without using pair.
        vector<int> retVec;
        if(root==NULL){
            return retVec;
        }

        queue<TreeNode*> que;
        que.push(root);

        TreeNode* node; int size = 0;
        while(!que.empty()){
            size = que.size();
            for(int x = 0; x<size; x++){
                node = que.front();
                if(x==size-1){
                    retVec.push_back(node->val);
                }
                if(node->left!=NULL){
                    que.push(node->left);
                }
                if(node->right!=NULL){
                    que.push(node->right);
                }
                que.pop();
            }
        }
        return retVec;
    }
};