/* Problem Statement:
Verified on leetcode

199. Binary Tree Right Side View
https://leetcode.com/problems/binary-tree-right-side-view/

Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---


 
Note:
Bonus points if you could solve it both recursively and iteratively.

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
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* rightSideView(struct TreeNode* root, int* returnSize){
    
    struct TreeNode *temp = NULL;
    int *final_arr = NULL;
    queue_t *queue = NULL;
    int idx = 0, curr_size = 0;
    
    /* Initializations */
    *returnSize = 0;
    
    /* create queue */
    queue = createqueue();
    
    if (!queue) {
        printf("Failure to allocate queue\n");
        return final_arr;
    }
    
    final_arr = (int *)calloc(DEFAULT_ELEM, sizeof(int));
    
    if (!final_arr) {
        printf("Failure to allocate queue\n");
        return final_arr;
    }
    enqueue(queue, root);
    
    while (!isEmpty(queue)) {
        /* record size as it will help us identify the last element in the level order traversal */
        curr_size = queue->size;
        for (idx = 0; idx < curr_size; idx++) {
            /* dequeue the element */
            temp = dequeue(queue);  
            /* if it's the last element of that level order, then add it to final_arr*/          
            if (idx == (curr_size - 1)) {

                if (*returnSize == DEFAULT_ELEM) {
                    final_arr = (int *)realloc(final_arr, sizeof(int) * (*returnSize) * 2);
                }
                final_arr[*returnSize] = temp->val;
                *returnSize = *returnSize + 1;
            }
            /* add left and right trees, NULL check happens inside the APIs*/
            enqueue(queue, temp->left);
            enqueue(queue, temp->right);
        }   
    }
    free_queue(queue);
    return final_arr;
}



/* Execute it on LeetCode platform*/

