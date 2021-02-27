"""
102. Binary Tree Level Order Traversal
#Time Complexity - O(n) n indicates all elements in Tree
#Space Complexity - O(m) m is maximum nodes in a level
Check if root is none return 
push root in queue and run a loop until queue is not empty
size = len(queue) i.e. gives information about elements in each level
run a for loop with size of queue as upper limit and pop element and push its left and right elements in queue if they are not none
append element in temp list and finally append it to main list
"""
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if root == None:
            return 
        queue = []
        output = []
        
        queue.append(root)
        while(queue):
            size = len(queue)
            temp = []
            for i in range(size):
                pop_element = queue.pop(0)
                if pop_element.left != None:
                    queue.append(pop_element.left)
                if pop_element.right != None:
                    queue.append(pop_element.right)  
                temp.append(pop_element.val)
            output.append(temp)
        return output
        