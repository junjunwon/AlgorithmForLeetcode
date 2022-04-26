/**
 * @param {string} s
 * @return {number}
 */

const romanToInt = (s) => {
    // MCMXCIV
    const symbols = {
        'I' : 1,
        'V' : 5,
        'X' : 10,
        'L' : 50,
        'C' : 100,
        'D' : 500,
        'M' : 1000
    }
    const array = s.split("")
    let result = 0;
    console.log(array)
    // for(let [index, num] of array.entries()) {
    for(let index = 0; index<array.length; index++) {
        console.log('index is ', index);
        console.log(array[index]);
        console.log(array[index+1]);
        console.log(symbols[array[index]]);
        console.log(symbols[array[index+1]]);
        if(symbols[array[index]] < symbols[array[index+1]]) {
            result += (symbols[array[index+1]] - symbols[array[index]])
            index++;
            
        } else {
            result += symbols[array[index]]
        }
        console.log('result is ',result);
    }
    return result
};