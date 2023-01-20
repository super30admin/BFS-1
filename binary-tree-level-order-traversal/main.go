package main

// will do a DFS solution on this now
// Time
// will do a DFS solution on this now
// Time : O(n) : n are the number of nodes in the tree
// Space : O(w) - w is width of the tree
func levelOrder(root *TreeNode) [][]int {
	if root == nil {
		return nil
	}
	q := []*TreeNode{root}
	result := [][]int{}

	for len(q) != 0 {
		level := []int{}
		qSize := len(q)
		for qSize != 0 {
			dq := q[0]
			q = q[1:]
			level = append(level, root.Val)
			if dq.Left != nil {
				q = append(q, root.Left)
			}
			if dq.Right != nil {
				q = append(q, root.Left)
			}
			qSize--
			if qSize == 0 {
				result = append(result, level)
			}
		}
	}
	return result

}
