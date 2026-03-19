class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        int index = 0;
        long ans = 0;
        boolean isPositive = true;
        while (index < n && s.charAt(index) == ' ')
            index++;
        if (index < n && s.charAt(index) == '-') {
            isPositive = false;
            index++;
        } else if (index < n && s.charAt(index) == '+')
            index++;
        while (index < n && s.charAt(index) == 0)
            index++;
        while (index < n && Character.isDigit(s.charAt(index))) {
            ans = ans * 10 + (s.charAt(index) - '0');
            index++;
            if (isPositive && ans > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            else if (!isPositive && (ans * -1) < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }
        return isPositive ? (int) ans : (int) ans * -1;
    }
}