package main

// will do a DFS solution on this now
// Time
// will do a DFS solution on this now
// Time : O(n)
// Space : O(h) - for recursive stack its height of the tree, we also have aux space that we have created to store the values temporarily and that is 100 (as its the constraint of the tree)
func rightSideView(root *TreeNode) []int {
	if root == nil {
		return []int{}
	}
	var dfs func(root *TreeNode, height int) int
	rightSide := make([]int, 100) // extra space, but required as trying DFS
	rightSide[0] = root.Val       // add the root to right side view array
	dfs = func(root *TreeNode, height int) int {
		// base
		if root == nil {
			return 0
		}
		// logic - doing pre order here
		if root.Left != nil {
			rightSide[height] = root.Left.Val
		}
		if root.Right != nil {
			rightSide[height] = root.Right.Val
		}

		// recurse
		lheight := dfs(root.Left, height+1)
		rheight := dfs(root.Right, height+1)
		return max(lheight, rheight) + 1
	}
	height := dfs(root, 1)     // need height as I need to remove the )'s that were init'd when default array was created
	return rightSide[0:height] // this is extra time. best could have been where we slicing was not required.
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
