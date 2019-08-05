function palindrome(str) {
  let arr =  str.replace(/[^a-zA-Z0-9]/g, '').toLowerCase();
  str = arr;
  arr = arr.split('').reverse().join('');

  return  arr === str;
}

palindrome("eye");

/*
palindrome("My age is 0, 0 si ega ym.") should return true.
palindrome("1 eye for of 1 eye.") should return false.
palindrome("0_0 (: /-\ :) 0-0") should return true.
*/
