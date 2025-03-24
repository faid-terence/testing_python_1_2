function findPairs(nums1, nums2, k) {
  const result = [];
  const n = nums1.length;

  let rot1 = 0;
  for (let i = 1; i < n; i++) {
    if (nums1[i] < nums1[i - 1]) {
      rot1 = i;
      break;
    }
  }

  let i = rot1;
  let j = n - 1;

  while (i < n + rot1) {
    let idx1 = i % n;
    let currSum = nums1[idx1] + nums2[j];

    if (currSum === k) {
      result.push([nums1[idx1], nums2[j]]);
      i++;
      j--;
    } else if (currSum < k) {
      i++;
    } else {
      j--;
    }
  }

  return result;
}

let nums1 = [4, 5, 6, 7, 0, 1];
let nums2 = [3, 9, 10, 11, 12, 19];
let k = 13;
console.log(findPairs(nums1, nums2, k));
