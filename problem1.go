// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func levelOrder(root *TreeNode) [][]int {
    if root == nil{
        return [][]int{}
    }
    
    result := [][]int{}
    
    q := []*TreeNode{root}
    
    for len(q) > 0{
        size := len(q)
        temp := []int{}
        for size > 0{
            node := q[0]
            q = q[1:]
            temp = append(temp,node.Val)
            if node.Left != nil{
                q = append(q,node.Left)
            }
            
            if node.Right != nil{
                q = append(q,node.Right)
            }
            
            size -= 1
        }
        result = append(result,temp)
        
    }
    return result
}
