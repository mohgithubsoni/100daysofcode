class Solution {
    public int reverse(int x) {

        // Edge case:
        // Integer.MIN_VALUE = -2^31
        // abs(-2^31) overflows because +2^31 is out of int range.
        // In C++ this would overflow; in Java Math.abs(Integer.MIN_VALUE) returns Integer.MIN_VALUE.
        // Explicitly handling it to avoid incorrect behavior.
        if (x == Integer.MIN_VALUE) return 0;

        // Convert absolute value of x to string for digit manipulation
        StringBuilder num = new StringBuilder(Integer.toString(Math.abs(x)));

        // String representation of the maximum allowed 32-bit signed integer
        StringBuilder limit = new StringBuilder(Integer.toString(Integer.MAX_VALUE));

        // Reverse the digits
        num.reverse();

        // If the reversed number has fewer than 10 digits,
        // it can never overflow a 32-bit integer.
        if (num.length() < 10)
            return x > 0
                    ? Integer.parseInt(num.toString())
                    : -1 * Integer.parseInt(num.toString());

        int ptr = 0;

        /*
         * Compare digit by digit with Integer.MAX_VALUE from left to right.
         *
         * - If at any position the digit exceeds the limit, overflow occurs → return 0
         * - If it is smaller, the number is guaranteed to fit → stop checking
         * - If equal, continue checking the next digit
         */
        while (ptr < num.length()) {
            if (num.charAt(ptr) > limit.charAt(ptr)) return 0;
            else if (num.charAt(ptr) < limit.charAt(ptr)) break;
            ptr++;
        }

        // Safe to parse and restore sign
        return x > 0
                ? Integer.parseInt(num.toString())
                : -1 * Integer.parseInt(num.toString());
    }
}