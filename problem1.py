# Time Complexity : O(n)
# Space Complexity :O(h)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

# we are doing a recursive dfs with level as a local var send recursively to the dfs function.
# we are storing output in a list of list where the index of each list in ther result is the level of each
class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        # BFS using queue time :O(n), space: O(n/2)
        # myq=[]
        # result=[]
        # if root is not None:
        #     myq.append(root)
        # while( len(myq)>0):
        #     size = len(myq)
        #     li = []
        #     for i in range(0,size):
        #         curr=myq.pop(0)
        #         print(curr.val)
        #         if(curr.val is not None):
        #             li.append(curr.val)
        #         if(curr.left is not None):
        #             myq.append(curr.left)
        #         if(curr.right is not None):
        #             myq.append(curr.right)
        #     result.append(li)
        # return result
        # 
        # optimized time O(n), space:O(h)
        def helper(root, level):
            if not root:
                return
            if(level==len(result)):
                result.append([])
            result[level].append(root.val)
            helper(root.left,level+1)
            helper(root.right, level+1)
        result=[]
        helper(root,0)
        return result