/**
 * @param {number[]} numbers
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(numbers, target) {
//     const map = new Map();
//     const result = [1,1];
//     // result[1] = 5;
//     map.set(numbers[0], 0)
//     let num = -99
//     for(let i = 1; i<numbers.length; i++) {
//         num = target - numbers[i];
//         if(map.has(num)) {
//             console.log('===========================')
//             console.log('got in!!')
//             console.log('i is', i)
//             console.log('map.get(num) is', map.get(num))
            
//             result[0] = map.get(num)+1;
//             result[1] = i+1;
//             break;
//         }
//         console.log('i is', i)
//         console.log('num is ', num);
//         map.set(num, i);
//         // result[0] = i+1
//     }
    
//     return result
    const indices = new Map();

    for (let index = 0; index < numbers.length; index++) {
        const complement = target - numbers[index];

        if (indices.has(complement)) {
            return [indices.get(complement)+1, index+1]
        }

        indices.set(numbers[index], index)
    }
    
    
    
};