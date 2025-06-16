// # Problem 1
// Binary Tree Level Order Traversal (https://leetcode.com/problems/binary-tree-level-order-traversal/)

// var levelOrder = function(root) {
//         //Time Complexity : O(N)
//     //Space Complexity : O(N)
//     let res = []
//     function helper(root,level){
//         if(!root)return 
//         if(res.length == level){
//             res.push([root.val])
//         }
//         else{
//             res[level].push(root.val)
//         }
//         helper(root.left,level+1)
//         helper(root.right,level+1)
//     }
//     helper(root,0)
//     return res
// };


var levelOrder = function(root) {
    //Time Complexity : O(N)
    //Space Complexity : O(N)
    //BSF using a queue
    if(!root) return []
    let res = [] 
    let queue = [root] 
    while(queue.length){
        let temp = []
        let size = queue.length
        for(let i=0;i <size ;i++){
            let current = queue.shift()
            temp.push(current.val)
            if(current.left) queue.push(current.left)
            if(current.right) queue.push(current.right)
        }
        res.push(temp)
    }
    return res     
};