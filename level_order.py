
'''
Approach:
get the root in the queue.

Keep track of the size of the queue.

If left and right of the current node is not null, keep adding to the queue.

Maintain a list of lists, to capture the each level order traversal


# Time complexity: O(n) --> The  number of nodes, as we go over every single node.
# Space complecity O(n) --> Just to maintain the queue,

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

'''

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:

        queue = deque()

        if root is None:
            return []

        final_res = []

        queue.append(root)

        while(queue):

            int_res = []

            k = len(queue)

            for i in range(k):

                node = queue.popleft()

                int_res.append(node.val)


                if (node.left!=None):
                    queue.append(node.left)
                if(node.right!=None):
                    queue.append(node.right)

            final_res.append(int_res)

        return final_res









