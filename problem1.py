#Binary Tree Level Order Traversal
# // Time Complexity :O(N) - Going though every nodes
# // Space Complexity : O(N) as we are using a queue to store the nodes
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no




def levelOrder( root):                          #using bfs
    if root==None: return []
    queue =[root]                               #add root to the queue
    biglist=[]
    
    while(queue):                   
        size=len(queue)
        smalllist=[]
        for i in range(size):                   #iterate through the size of the queue
            node=queue.pop(0)
            smalllist.append(node.val)             #add the value of the node to the queue
            if(node.left):                          #if the node has a left node, add it to the queue
                queue.append(node.left)
            if(node.right):                         #if the node has a right node, add it to the queue
                queue.append(node.right)
        biglist.append(smalllist)                   #add the list of nodes at each level to the big list
    return biglist