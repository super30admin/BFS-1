# leetcode: "Time Limit Exceed"
# Explaination:  you are doing a bfd and adding all the elements of a level in the list. every last element will be size -1 element and adding that particular element to the list

# time complexity:O(n)


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        queue = []
        output = []
        print("""hhhh""")
        if root == None:
            return output
        print("""hhhh""")
        queue.append(root.val)

        while (len(queue) != None):
            size = len(queue)
            print(queue)

            for i in range(len(queue)):
                element = TreeNode(queue.pop(0))
                print(element)

                if i == size - 1:
                    output.append(element.val)

                if root.left != None:
                    queue.append(element.left)
                    print("q", queue)

                if root.right != None:
                    queue.append(element.right)
                print(queue)

        return output



