package main

func canFinish(numCourses int, prerequisites [][]int) bool {
	indegree := make([]int, numCourses)
	for _, pre := range prerequisites {
		indegree[pre[0]]++
	}
	var queue []int
	for course, degree := range indegree {
		if degree == 0 {
			queue = append(queue, course)
		}
	}
	canFinishCount := len(queue)
	for len(queue) != 0 {
		course := queue[0]
		queue = queue[1:]

		for _, pre := range prerequisites {
			if course == pre[1] {
				indegree[pre[0]]--
				if indegree[pre[0]] < 0 {
					return false
				}
				if indegree[pre[0]] == 0 {
					canFinishCount++
					queue = append(queue, pre[0])
				}
			}
		}
	}

	return canFinishCount == numCourses
}
