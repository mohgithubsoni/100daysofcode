class Solution {
    public int[] searchRange(int[] nums, int target) {
        int []arr={1,1};
        int s1=range1(nums,target);
        int s2=range2(nums,target);
        arr[0]=s1;
        arr[1]=s2;
        return arr;
    }
    public int range1(int []nums,int target){
        int strt = 0;
        while (strt <= nums.length- 1) {

            if (nums[strt] != target) {
                strt++;
            } else if (nums[strt] == target) {
                return strt;

//
//           } else if (strt == arr.length) {
//                return -1;
//            }

            }


        }
        return -1;

    }
    public int range2(int []arr,int tar){
           int end=arr.length-1;
        while(end>=0){
            if(arr[end]!=tar){
                end--;
            }
            else if(arr[end]==tar){
                return end;
            }
        }
        return -1;
    }


    }