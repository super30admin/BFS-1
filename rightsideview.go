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
add right, left child of element to q is not nil
append first element of array to result
*/
package main

import "fmt"

func rightSideView(root *TreeNode) []int {
	res := []int{}
	if root == nil {
		return res
	}
	q := make([]*TreeNode, 0)
	q = append(q, root)

	for len(q) > 0 {
		size := len(q)
		ele := []int{}
		for i:=0;i<size;i++ {
			v := q[0]
			q = q[1:]
			ele = append(ele, v.Val)
			if v.Right != nil {
				q = append(q, v.Right)
			}
			if v.Left != nil {
				q = append(q, v.Left)
			}
		}
		res = append(res, ele[0])
	}
	return res
}

func MainRightSideView() {
	root := &TreeNode{
		Val: 1,
		Left: &TreeNode{
			Val: 2,
			Right: &TreeNode{
				Val: 5,
			},
		},
		Right: &TreeNode{
			Val: 3,
			Right: &TreeNode{
				Val: 4,
			},
		},
	}
	fmt.Println(rightSideView(root)) //expected [1, 3, 4]
}
