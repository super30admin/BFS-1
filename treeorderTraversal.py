from typing import List
import queue
class TreeNode:
    def __init__(self,val=0,left=None,right=None):
        self.val=val
        self.left=left
        self.right=right

class Solution:
    recresult=[]
    def levelOrderqueue(self, root: TreeNode) -> List[List[int]]:
        if root is None:
            return
        qumanuplation = queue.Queue()
        resultstring = ''
        qumanuplation.put(root)
        while not qumanuplation.empty():
            Node = qumanuplation.get()

            resultstring = resultstring + '' + str(Node.val) + ','
            if Node.left:
                qumanuplation.put(Node.left)
            if Node.right:
                qumanuplation.put(Node.right)
        return resultstring



    def levelOrder_quue(self, root: TreeNode) -> List[List[int]]:
        if root is None:
            return
        qumanuplation = queue.Queue()
        result =[]
        qumanuplation.put(root)
        while not qumanuplation.empty():
            size=qumanuplation.qsize()
            temp=[]
            # process level
            for value in range(0,size):
                Node=qumanuplation.get()
                temp.append(Node.val)
                if Node.left:
                    qumanuplation.put(Node.left)
                if Node.right:
                    qumanuplation.put(Node.right)
            result.append(temp)
        return result

    def levelOrder(self, root: TreeNode) -> List[List[int]]:

        if root is None:return root

        self.reccall(root=root,level=0)

        return self.recresult
    def reccall(self,root:TreeNode,level:int) -> None:

        # base
        if root is None:return
        # logic
        if level == len(self.recresult):
            self.recresult.append([])
        self.recresult[level].append(root.val)
        self.reccall(root.left,level+1)
        self.reccall(root.right,level+1)




# time=O(N)
# Space= O(2*N)




if __name__ == '__main__':
    root=TreeNode(4)
    root.right=TreeNode(12)
    root.right.left=TreeNode(11)
    root.right.right=TreeNode(13)
    root.left=TreeNode(2)
    root.left.left=TreeNode(1)
    root.left.right=TreeNode(3)

    print(Solution().levelOrder(root))
