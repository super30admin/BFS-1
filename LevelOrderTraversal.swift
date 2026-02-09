//
//  LevelOrderTraversal.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 1/19/26.
//

/*
 Level order traversal -
 
 Inorder, preorder, postorder -> DFS based algorithm.
 BFS based traversal.
 
 DFS is -> any one child is processed at a time
 BFS -> all children are processed at once.
 
 In DFS, if I want to process all children at once, then we need to process level wise. FIFO. Hence, queue is used. with the vision of processing all children together, maintain FIFO order.
 
 On some BFS solution -> we maintain size. In some, we don't
 siz evariable -> If we need distinction that what all nodes belong to which level, then maintain size variable of the queue.
 *****When level finishes, then take the size of the queue.
 If we are not sure if we should take the size of the queue or not, always take the size of the queue.
 
 Initial size of the queue - -> at level 1, we have 1 node. size = 1
 process all cihldren of the node -> at level 2, 3 and 1 -> current level finished. The take the sizeof the queue.
 process all nodes of a level. then take the size of the queue.  -> these are the number of nodes at the next level.
  
 Time complexity -> O(n) all nodes are touched once and going inside the queue.
 space complexity -> maximum no of leaf nodes - (n/2) 50% of the nodes are at the leaf level.
 1/2 doesn't matter, so n/2
 
 For each data structure -> size(), isEmpty() - these fucntions will always be O(1)
 
 */


class LevelOrderTraversal {
    
    init() {
        let listOfLevels = levelOrderTraversal(root: TreeNode(val: 5, left: TreeNode(val: 4, left: nil, right: nil), right: TreeNode(val: 3, left: nil, right: nil)))
        print("list of levels \(listOfLevels)")
    }
    
    func levelOrderTraversal(root: TreeNode?) -> [[Int]] {
        var result: [[Int]] = [[Int]]()
        guard let root = root else {
            return [[]]
        }
        var queue = QueueUsingLL<TreeNode>()
        queue.enqueue(root)
        
        while (!queue.isEmpty) {
            //maintain size of the queue
            let size = queue.size
            
            var listOfNodesAtALevel: [Int] = []
            //process the level
            
            for i in 0..<size {
                
                let currNode = queue.dequeue()
                if let currNode = currNode {
                    listOfNodesAtALevel.append(currNode.val)
                    //process babies
                    if let leftNode = currNode.left {
                        queue.enqueue(leftNode)
                    }
                    if let rightNode = currNode.right {
                        queue.enqueue(rightNode)
                    }
                }
            }
            result.append(listOfNodesAtALevel)
        }
        return result
    }
    
    func levelOrderTraversalWithoutElementsSegregation(root: TreeNode?) {
        guard let root = root else {
            print("root is nil")
            return
        }
        var queue = QueueUsingLL<TreeNode>()
        queue.enqueue(root)
        var listOfNodes: [Int] = []
        
        while (!queue.isEmpty) {
            let currNode = queue.dequeue()
            if let currNode = currNode {
                listOfNodes.append(currNode.val)
                
                //process babies
                if let leftNode = currNode.left {
                    queue.enqueue(leftNode)
                }
                if let rightNode = currNode.right {
                    queue.enqueue(rightNode)
                }
            }
        }
        print("listOfNodesAtALevel \(listOfNodes)")
    }
}


/*
 => Level order traversal using DFS ->
 send out the level variable as a parameter of recursion,
 Use hash map -> each level numbers as key of dictionary. That level's data as the value of that keys in a n array.
 O(n) - extra space. challenge -> not sorted keys.
 
 
 TreeMap and orderMaps are under the hood self-balanced BST. Time complexity to search for an element - log(n)
 sorting the keys - n log n
 using hashing map with priority queue-  nlogn
 
 => maintain a minimum and maximum depth. I can linearly traverse through it then. -> Bucket sort. O(n) time complexity.
 extra space -> O(n)
 
 build the above hashmap into the result array itself.
 => maintain list of list. [[], [], []]. level 0 items will be added at 0th indexed list, level 1 items will be added to 1st indexed list and so on...
 tmie complexity -. O(n)
 space -> O(h) for recursion call stacks. over the hood - O(1) because only output array.
 
 */
class LevelOrderTraversalUsingDFS {
    
    func levelOrder(_ root: TreeNode?) -> [[Int]] {
        var result: [[Int]] = [[Int]]()
        dfs(root: root, level: 0, result: &result)
        return result
    }

    private func dfs(root: TreeNode?, level: Int, result: inout [[Int]]) {

        //base
        guard let root = root else {
            return
        }
        //logic
        if (level == result.count) {
            //it means the array corresponding to this level doesn't exist in the 2-D array
            result.append([])
        }
        //can add the root at the post order, preorder, inorder level. But the list should be appended at the preorder level.
        result[level].append(root.val)

        dfs(root: root.left, level: level + 1, result: &result)
        dfs(root: root.right, level: level + 1, result: &result)
    }
    
    private func levelOrderDeuplicate(_ root: TreeNode?) -> [[Int]] {
        var result = [[Int]]()
        dfsDuplicate(root, level: 0, result: &result)
        return result
    }
    
    private func dfsDuplicate(_ root: TreeNode?, level: Int, result: inout [[Int]]) {
        
        guard let root = root else {
            return
        }
        
        //logic
        if (result.count == level) {
            //means the array for a particular level is not present, so add it
            result.append([])
        }
        //action
        result[level].append(root.val)
        dfsDuplicate(root.left, level: level + 1, result: &result)
        dfsDuplicate(root.right, level: level + 1, result: &result)
    }
}
