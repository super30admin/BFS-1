// Time Complexity : O(v+e)
// Space Complexity : O(v+e)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
create a vert array with increment of all dependecies
create map from independent to dependent edges
create q and add all independent vertices
while q is not empty
pop from q, get all dependents from map
for each dependent reduce count in vert array for that element
add all elements with value 0 into q
after loop is finished check if vert has any value greater than 0 if so return false else return true
*/
package main

import "fmt"

func canFinish(numCourses int, prerequisites [][]int) bool {
	vert := make([]int, numCourses)
	m := make(map[int][]int)

	for i:=0;i<len(prerequisites);i++ {
		vert[prerequisites[i][0]]++
	}
	for i:=0;i<len(prerequisites);i++ {
		if _, e := m[prerequisites[i][1]]; e {
			m[prerequisites[i][1]] = append(m[prerequisites[i][1]], prerequisites[i][0])
		} else {
			m[prerequisites[i][1]] = append([]int{}, prerequisites[i][0])
		}
	}

	q := make([]int, 0)
	for i := 0; i < numCourses; i++ {
		if vert[i] == 0 {
			q = append(q, i)
		}
	}

	for len(q) != 0 {
		course := q[0]
		subClasses := m[course]
		for i := 0; i < len(subClasses); i++ {
			vert[subClasses[i]]--
			if vert[subClasses[i]] == 0 {
				q = append(q, subClasses[i])
			}
		}
		q = q[1:]
	}

	for i := 0; i < numCourses; i++ {
		if vert[i] != 0 {
			return false
		}
	}

	return true
}

func MainCourseSchedule() {
	fmt.Println(canFinish(2, [][]int{[]int{1,0}})) //expected true
}
