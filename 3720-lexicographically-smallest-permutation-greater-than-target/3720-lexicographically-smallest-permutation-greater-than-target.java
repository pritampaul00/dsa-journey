class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] base = new int[26];
        for (char c : s.toCharArray()) base[c - 'a']++;
 
        for (int i = n - 1; i >= 0; i--) {
            int[] cnt = base.clone();
            boolean prefixOk = true;
 
            for (int j = 0; j < i; j++) {
                int c = target.charAt(j) - 'a';
                if (cnt[c] == 0) { 
                    prefixOk = false; break; 
                    }
                cnt[c]--;
            }
            if (!prefixOk) continue;
 
            int need = target.charAt(i) - 'a';
            int pick = -1;
            for (int c = need + 1; c < 26; c++) {
                if (cnt[c] > 0) { pick = c; break; }
            }
            if (pick == -1) continue;
 
            cnt[pick]--;
            StringBuilder sb = new StringBuilder();
            sb.append(target, 0, i);
            sb.append((char) ('a' + pick));
            for (int c = 0; c < 26; c++) {
                for (int k = 0; k < cnt[c]; k++) sb.append((char) ('a' + c));
            }
            return sb.toString();
        }
        return "";
    }
        
}
