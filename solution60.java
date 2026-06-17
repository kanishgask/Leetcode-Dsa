class Solution {
    public char processStr(String s, long k) {
        // Stack to store operations
        java.util.List<Character> ops = new java.util.ArrayList<>();
        for (char c : s.toCharArray()) ops.add(c);

        // First compute final length
        long len = 0;
        for (char c : ops) {
            if (c >= 'a' && c <= 'z') {
                len++;
            } else if (c == '*') {
                if (len > 0) len--;
            } else if (c == '#') {
                len *= 2;
            } else if (c == '%') {
                // length unchanged
            }
        }

        if (k < 0 || k >= len) return '.';

        // Walk backwards
        for (int i = ops.size() - 1; i >= 0; i--) {
            char c = ops.get(i);
            if (c >= 'a' && c <= 'z') {
                if (k == len - 1) return c;
                len--;
            } else if (c == '*') {
                // one char removed
                // if k == len-1, that char was deleted, invalid
                len++;
                if (k == len - 1) return '.';
            } else if (c == '#') {
                long half = len / 2;
                if (k >= half) k -= half;
                len /= 2;
            } else if (c == '%') {
                k = len - 1 - k;
            }
        }
        return '.';
    }
}
