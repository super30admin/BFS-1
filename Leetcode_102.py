#Space Complexity: O(n)
#Time Complexity: O(n)

class Solution(object):
    def levelOrder(self, root):
        
        if not root:
            return []

        ret = []
        currLevel = [root]

        while currLevel:
            ret.append( [ node.val for node in currLevel ] )

            nextLevel = []
            for node in currLevel:
                if node.left:
                    nextLevel.append( node.left )
                if node.right:
                    nextLevel.append( node.right )

            currLevel = nextLevel

        return ret
