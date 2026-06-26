class Solution {

    public String countAndSay(int n) {

        String curr = "1";

        for (int i = 2; i <= n; i++) {

            StringBuilder next = new StringBuilder();

            int count = 1;

            for (int j = 1; j <= curr.length(); j++) {

                if (j < curr.length() && curr.charAt(j) == curr.charAt(j - 1)) {
                    count++;
                } else {
                    next.append(count);
                    next.append(curr.charAt(j - 1));
                    count = 1;
                }
            }

            curr = next.toString();
        }

        return curr;
    }
}