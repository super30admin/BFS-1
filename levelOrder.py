#Time Complexity: O(n)
#Space Complexity : maximum Breadth of tree- O(n)
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        result = []
        stack = []
        level = 0
        while(root != None or len(stack)):
            while(root):
                stack.append(root)
                stack.append(level)
                if(level == len(result)):
                    currLevel = []
                    currLevel.append(root.val)
                    result.append(currLevel)
                else:
                    result[level].append(root.val)
                
                root = root.left
                level += 1
            level = stack.pop()
            root = stack.pop()
            root = root.right
            level += 1
        return result
