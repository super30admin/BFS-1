package main

// Time : O(v+e)
// Space : O(v+e)
func canFinish(numCourses int, prerequisites [][]int) bool {

	adList := map[int][]int{}

	indegress := make([]int, numCourses)

	for i := 0; i < len(prerequisites); i++ {
		course := prerequisites[i][0]
		dependsOn := prerequisites[i][1]
		indegress[course]++
		adList[dependsOn] = append(adList[dependsOn], course)
	}

	q := []int{}
	for i := 0; i < numCourses; i++ {
		if indegress[i] == 0 {
			q = append(q, i)
		}
	}

	if len(q) == 0 {
		return false
	} // there is no course that is independent

	count := 0

	for len(q) != 0 {
		dq := q[0]
		q = q[1:]
		count++

		alldepCourse := adList[dq]
		for _, course := range alldepCourse {
			indegress[course]--
			if indegress[course] == 0 {
				q = append(q, course)
			}
		}
	}
	return numCourses == count

}
