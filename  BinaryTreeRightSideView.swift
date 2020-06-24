//After class
// Time Complexity : (O)N
// Space Complexity : (O)h
// Did this code successfully run on Leetcode : yes
// Use recursive postorder traversal appraoch to add right view by checking the depth with result array. Cince we are traversing on the right side we always first visit the right view even it has only left node.

class Solution {
    var result: [Int] = [Int]()
    func rightSideView(_ root: TreeNode?) -> [Int] {
        postorderTraversal(root, 0)
        return result
    }
    
    private func postorderTraversal(_ root: TreeNode?, _ depth: Int) {
        //base
        if root == nil {
            return
        }
        if depth == result.count {
            result.append(root!.val)
        }
        //logic
        postorderTraversal(root?.right, depth+1)
        postorderTraversal(root?.left, depth+1)
    }
}