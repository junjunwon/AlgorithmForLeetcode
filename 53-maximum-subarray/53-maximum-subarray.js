/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function(nums) {
    
    
    let result = nums[0];
    let curSum = 0;
    for(let i = 0; i<nums.length; i++) {
        if(curSum<0) {
            curSum = 0;
        }
        curSum+=nums[i];
        if(curSum>=result) {
            result = curSum;
        }
    }
    
    return result;
    
    
//     //Time Limit Exceeded  -> Time Complexity : O(n2) -> succeed test 206/209 
//     let currSum = 0;
//     let result = -100001;
    
//     for(let i = 0; i < nums.length; i++) {
//         currSum = 0;
//         for(let j = i; j< nums.length; j++) {
//             currSum+=nums[j];
//             if(currSum >= result) {
//                 result = currSum;
                
//             }
//         }
        
//     }
//     return result;
    
    ////Error about Output Limit Exceeded -> Time Complexity : O(n3)
    //let finalResult=-100001;
    // let result=0;
//     for(let i = 0; i<nums.length; i++) {
//         for(let j = i; j<nums.length; j++) {
//             result=0;
//             for(let k = i; k<=j; k++) {
//                 console.log('k is : ', k)
//                 result += nums[k];
//                 console.log('result in k is : ', result)
//             }
//             console.log('finalResult is : ', finalResult)
//             console.log('result is : ', result)  
//             if(result >= finalResult) {
                          
//                 finalResult = result; 
//             }
//             console.log('=========================')
//         }
//     }
    
      // return finalResult;
};