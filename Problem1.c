/* Problem Statement:
Verified on leetcode

102. Binary Tree level order traversal 
https://leetcode.com/problems/binary-tree-level-order-traversal/

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]


 *
 * Time Complexity : O(n) where n is total elements in the tree
 * Space Complexity : O(n) storing in queue
 */

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<stdbool.h>
#include<math.h>
#include<limits.h>

/* No library available, hence adding dynamic queues API first and then the actual function */

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
#define MAX_QUEUE_SIZE 900
#define DEFAULT_ELEM 100

// A structure to represent a queue
typedef struct queue
{
    int front, rear, size;
    unsigned capacity;
    struct TreeNode** array;
}queue_t;

/**** Queue functions start ***/

queue_t* createqueue()
{
    queue_t* q = (queue_t*)calloc(1, sizeof(queue_t));
    q->array = (struct TreeNode **)calloc(MAX_QUEUE_SIZE, sizeof(struct TreeNode*));
    q->capacity = MAX_QUEUE_SIZE;
    q->front = q->size = 0; 
    q->rear = MAX_QUEUE_SIZE - 1;
    return q;
}
 
// queue is full when size becomes equal to the capacity 
int isFull(queue_t* queue)
{  return (queue->size == queue->capacity);  }
 
// queue is empty when size is 0
int isEmpty(queue_t* queue)
{  return (queue->size == 0); }
 
// Function to add an item to the queue.  It changes rear and size
void enqueue(queue_t* queue, struct TreeNode *item)
{
    
    if (isFull(queue)) {
        queue->array = (struct TreeNode **)realloc(queue->array, sizeof(struct TreeNode*) * queue->size * 2);
    }
    if (!item) {
        return;
    }
    queue->rear = (queue->rear + 1) % queue->capacity;
    queue->array[queue->rear] = item;
    queue->size = queue->size + 1;
    //printf("%ld enqueued to queue\n", item->data);
}
 
// Function to remove an item from queue.  It changes front and size
struct TreeNode* dequeue(queue_t* queue)
{
    if (isEmpty(queue))
        return NULL;
    struct TreeNode *item = queue->array[queue->front];
    queue->front = (queue->front + 1) % queue->capacity;
    queue->size = queue->size - 1;
    return item;
}

void free_queue(queue_t* queue) {
    free(queue->array);
    free(queue);
}

/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */
int** levelOrder(struct TreeNode* root, int* returnSize, int** returnColumnSizes){

    struct TreeNode *temp = NULL;
    int **final_arr = NULL;
    int *ret_col = NULL;
    int *level_arr = NULL;
    queue_t *queue = NULL;
    int idx = 0, curr_size = 0;
    
    /* Initializations */
    *returnSize = 0;
    *returnColumnSizes = NULL;
    
    queue = createqueue();
    
    if (!queue) {
        printf("Failure to allocate queue\n");
        return final_arr;
    }
    
    final_arr = (int **)calloc(DEFAULT_ELEM, sizeof(int *));
    
    if (!final_arr) {
        printf("Failure to allocate final array\n");
        return final_arr;
    }

    ret_col = (int *)calloc(DEFAULT_ELEM, sizeof(int));
    
    if (!returnColumnSizes) {
        printf("Failure to allocate returnColumnSizes array\n");
        return final_arr;
    }
    
    enqueue(queue, root);
    
    while (!isEmpty(queue)) {
        /* in case of memory realloc */
        if (*returnSize != 0 && (*returnSize % (DEFAULT_ELEM)) == 0) {
            final_arr = (int **)realloc(final_arr, sizeof(int *) * (*returnSize) * 2);
            ret_col = (int *)realloc(ret_col, sizeof(int) * (*returnSize) * 2);
        }
        /* for each level, allocate mem array */
        curr_size = queue->size;       
        level_arr = (int *)calloc(curr_size, sizeof(int));
        
        for (idx = 0; idx < curr_size; idx++) {
            /* dequeue and add it to the level_arr array. */
            temp = dequeue(queue);
            level_arr[idx] = temp->val;
            enqueue(queue, temp->left);
            enqueue(queue, temp->right);
        }
        /* update final_array , and return size */
        final_arr[*returnSize] = level_arr;
        ret_col[*returnSize] = curr_size;
        *returnSize = *returnSize + 1;
    }
    /* free queue and update return Col sizes array */
    free_queue(queue);
    *returnColumnSizes = ret_col;
    return final_arr;
}



/* Execute it on LeetCode platform*/

