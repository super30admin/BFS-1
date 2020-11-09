// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
create a queue with root element
while q is not empty
get size of q, create new array
for loop till size
pop from queue and append value to array
add left, right child of element to q is not nil
append array to result
*/
package main

import "fmt"

type TreeNode struct {
	Val int
	Left *TreeNode
	Right *TreeNode
}

func levelOrder(root *TreeNode) [][]int {
	res := [][]int{}
	if root == nil {
		return res
	}

	q := make([]*TreeNode, 0)
	q = append(q, root)
	for len(q) > 0 {
		size := len(q)
		ele := []int{}
		for i:=0;i<size;i++ {
			val := q[0]
			q = q[1:]
			ele = append(ele, val.Val)
			if val.Left != nil {
				q = append(q, val.Left)
			}
			if val.Right != nil {
				q = append(q, val.Right)
			}
		}
		res = append(res, ele)
	}
	return res
}

func MainLevelOrder() {
	root := &TreeNode{
		Val: 3,
		Left: &TreeNode{
			Val: 9,
		},
		Right: &TreeNode{
			Val: 20,
			Left: &TreeNode{
				Val: 15,
			},
			Right: &TreeNode{
				Val: 7,
			},
		},
	}
	fmt.Println(levelOrder(root)) //expected [[3],[9,20],[15,7]]
}
