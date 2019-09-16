"""
The approach here is to use a stack and keep of poping the entire tree. after poping the entire tree,
append the root element to the output array, now check if there are left and right childs to the particular
root if they are then add the nodes to another array and do this unitl you reach the leaf. now again we have
the tree with root element excluded. now check again with the same condtion add the current root to the
result array check if has childs,if so add those values to the temp array and append the temp array to
the main array.

Time complexity - O(N)
space comlexity - O(N^2)
"""
def BTLevelOrderTraversal(self,root):
    sink = [[root]]
    result = []

    if root is None:
        return []
    if root.left is None and root.right is None:
        return [[root.val]]
    
    while sink:

        accumulator = sink.pop()
            
        parent = [node.val for node in accumulator]
        result.append(parent)
            
        temp = []

        for node in accumulator:

            if node.left:
                temp.append(node.left)
            if node.right:
                temp.append(node.right)

        if len(temp) > 0:
            sink.append(temp)
        
    return result


