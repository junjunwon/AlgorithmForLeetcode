/**
 * @param {number[]} nums
 * @return {number}
 */
var maxProduct = function(nums) {
    
    let result = nums.reduce(function(previous, current) {
        return previous > current ? previous : current
    })
    
    // console.log('max is', result)
    let currMax =1, currMin = 1;
    // console.log('currMax is ', currMax)
    // console.log('currMin is ', currMin)
    nums.forEach(num => {
        if(num === 0) {
            
        }
        let temp = num * currMax;
        // console.log("===========================")
        // console.log(num)
        // console.log('temp is ', temp)
        // console.log('beforecurrMax is ', currMax)
        // console.log('before currMin is ', currMin)
        currMax = Math.max(num * currMax, num * currMin, num);
        currMin = Math.min(temp, num * currMin, num);
        result = Math.max(result, currMax)
        // console.log('currMax is ', currMax)
        // console.log('currMin is ', currMin)
    })
    
    return result
};