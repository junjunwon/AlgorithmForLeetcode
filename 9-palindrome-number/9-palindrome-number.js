/**
 * @param {number} x
 * @return {boolean}
 */
const isPalindrome = (x) => {
    
    let array = String(x).split('')
    for(let i = 0; i<array.length; i++) {
        console.log('start i is ', i)
        if(array.length % 2 === 1 && i === array.length -1 - i) {
            console.log('i is ', i)
            console.log('array.length is ', array.length)
            return true
        } else if(array[i] !== array[array.length-1-i]) {
            return false
        }
        if(array.length %2 === 0 && i+1 === array.length / 2) {
            console.log("checking");
            return true
        } else if(array[i] !== array[array.length-1-i]) {
            return false
        }
        
    }
};