// Time complexity - O(V+E)
// Space complexity - O(V+E)
function canFinish(numCourses: number, prerequisites: number[][]): boolean {
	// indegrees to store number of prerequisites for course i
	let indegrees = new Array(numCourses).fill(0);

	// map to store adjacency list
	// [prerequisite, dependent courses..]
	let adjMap = new Map<number, number[]>();

	for (let prerequisite of prerequisites) {
		let dep = prerequisite[0];
		let indep = prerequisite[1];

		// update the indegree array
		indegrees[dep]++;

		if (!adjMap.has(indep)) {
			adjMap.set(indep, []);
		}
		// update the adjacency list map
		adjMap.get(indep).push(dep);
	}

	// queue to process courses reeady to be taken
	let q: number[] = [];
	// count the number of courses that is taken
	let finishedCourseCount = 0;

	for (let i = 0; i < numCourses; i++) {
		// if in degree of any course i =0, means it has no prerequisite
		// it's ready to be taken, add it to queue for processing
		if (indegrees[i] === 0) {
			q.push(i);
		}
	}

	while (q.length !== 0) {
		// get the next course ready to be taken
		let courseTotake = q.shift();

		// increase the finished course count
		finishedCourseCount++;

		// check if any courses are depend on the current course
		if (adjMap.has(courseTotake)) {
			// get all course dependent on current course
			const dependencies = adjMap.get(courseTotake);

			for (let dependentCourse of dependencies) {
				// reduce it's indegree since it's prerequisite has been taken
				indegrees[dependentCourse]--;

				// if the indegree for dependent course is 0, means it's ready to be taken
				// add it to queue for processing
				if (indegrees[dependentCourse] === 0) {
					q.push(dependentCourse);
				}
			}
		}
	}

	// if finished course count is equal to numCourses, meaning all courses were processed successfully and can be taken
	return finishedCourseCount === numCourses;
}
