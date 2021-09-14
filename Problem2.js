// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes

var canFinish = function (numCourses, prerequisites) {
    let map = new Map();
    let indegrees = new Array(numCourses).fill(0);
    for (let edge of prerequisites) {
        indegrees[edge[0]]++;
        if (!map.has(edge[1])) {
            map.set(edge[1], []);
        }
        map.get(edge[1]).push(edge[0]);
    }
    let q = [];
    let count = 0;
    for (let i = 0; i < indegrees.length; i++) {
        if (indegrees[i] === 0) {
            q.push(i);
            count++;
        }
    }

    if (q.length === 0) return false;

    while (q.length) {
        let current = q.shift();
        let children = map.get(current);
        if (children) {
            for (let child of children) {
                indegrees[child]--;
                if (indegrees[child] === 0) {
                    q.push(child);
                    count++;
                }

            }
        }
    }
    return count === numCourses;
};