class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }

        Map<Character, Integer> required = new HashMap<>();

        for(char c : t.toCharArray()) {
            required.put(c, required.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();

        int l = 0, r = 0, formed = 0, requiredUnique = required.size(), minLength = Integer.MAX_VALUE, minLeft = 0;

        while (r < s.length()){
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c,0) + 1);
            if(required.containsKey(c) && window.get(c).equals(required.get(c))){
                formed++;
            }

            while (formed == requiredUnique){
                if(r - l + 1 < minLength){
                    minLength = r - l + 1;
                    minLeft = l;
                }

                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar) - 1);

                if(required.containsKey(leftChar) && window.get(leftChar) < required.get(leftChar)) {
                    formed--;
                }
                l++;
            }
            r++;

        }

        if(minLength == Integer.MAX_VALUE) {
            return "";
        }
 
        return s.substring(minLeft, minLeft + minLength);

    }
}
