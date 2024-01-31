/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

/*timecomplexity : O(n)
spacecomplexity : O(n)*/

package main

func levelOrder(root *TreeNode) [][]int {
	var result [][]int
	if root == nil {
		return result
	}
	var level []*TreeNode
	nextLevel := []*TreeNode{root}
	for len(nextLevel) > 0 {
		level = nextLevel
		nextLevel = []*TreeNode{}
		var nodeVal []int
		for _, node := range level {
			nodeVal = append(nodeVal, node.Val)
			if node.Left != nil {
				nextLevel = append(nextLevel, node.Left)
			}
			if node.Right != nil {
				nextLevel = append(nextLevel, node.Right)
			}
		}
		result = append(result, nodeVal)
	}
	return result
}
