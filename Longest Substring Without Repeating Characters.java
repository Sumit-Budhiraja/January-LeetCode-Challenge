class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> characterIndexMap = new HashMap();
        int maxLength = 0;
        int substringStartIndex = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int characterIndex = characterIndexMap.getOrDefault(c, -1);
            if(characterIndex > -1 && characterIndex >= substringStartIndex) {
                substringStartIndex = characterIndex + 1;    
            }
            int length = i - substringStartIndex + 1;
            if(length > maxLength) {
                maxLength = length;
            }
            characterIndexMap.put(c, i);
        }
        return maxLength;
    }
}