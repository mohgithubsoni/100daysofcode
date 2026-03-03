class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int max=Integer.MIN_VALUE;
        int n=nums.length;
        Stack<Integer> st=new Stack<>();
        int []res=new int[n];
        Arrays.fill(res,-1);

        for(int i=2*n-1;i>=0;i--){
            int num=nums[i%n];
            while(!st.isEmpty()&&st.peek()<=num) st.pop();

            if(i<n) res[i]=st.isEmpty()?-1:st.peek();

            st.push(num);
        }

        return res;
    }
}