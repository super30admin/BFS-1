#Time complexity: O(n)
#Space complexity: O(n) Consider the maximum width which is n/2 for leaf nodes
#Using Queue and FIFO to achieve BFS traversal

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root is None:
            return
        ref_queue=collections.deque()
        ref_queue.append(root)
        output=[]
        while ref_queue:
            sub_list=[]
            size = len(ref_queue)
            for i in range (0,size):
                temp = ref_queue.popleft()
                if temp:
                    sub_list.append(temp.val)
                    ref_queue.append(temp.left)
                    ref_queue.append(temp.right)
            if sub_list:        
                output.append(sub_list)

        return output



