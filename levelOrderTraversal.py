# BFS Approach: Process all child nodes
# Time: O(N)
# Space: O(2 ^ Levels) ~= O(N) 

def levelOrder(self, root: TreeNode) -> List[List[int]]:

    # BFS Approach

    result = []

    if root == None:
        return result

    queue = []
    queue.append(root)

    while queue != []:

        size = len(queue)
        temp_list = []

        for i in range(size):
            current = queue.pop(0)
            temp_list.append(current.val)

            if current.left != None:
                queue.append(current.left)

            if current.right != None:
                queue.append(current.right)

        result.append(temp_list)

    return result



# Approach: DFS
# Time : O(N)
# Space: O(H) where height is the nodes in the stack at any time
# This space is under the hood (recursive stack)

def levelOrder(self, root: TreeNode) -> List[List[int]]:

    self.result = []
    
    if root == None:
        return self.result

    self.dfs(root, 0)
    return self.result


def dfs(self, root, level):

    # base
    if root == None:
        return 


    # logic

    if level == len(self.result):
        # whent the depth and resultant array size is same, that means no distinct group is there for this level, create one for this level
        self.result.append([])

    # in the case it is not, add the node to the corresponding level in the result array
    self.result[level].append(root.val)

    # go all the until left node is Null
    self.dfs(root.left, level + 1)

    # pop happens here and we get root val, level = 0, that is why we do level + 1

    self.dfs(root.right, level + 1)

