class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> chain = new ArrayDeque<>();
        chain.add(beginWord);
        Set<String> dict = new HashSet<>(wordList);
        dict.remove(beginWord);
        
        int length = 0;
        while (!chain.isEmpty()) {
            length++;
            int size = chain.size();
            while (size-- > 0) {
                String word = chain.remove();
                if (word.equals(endWord)) {
                    return length;
                }
                
                for (int i = 0; i < word.length(); i++) {
                    String prefix = word.substring(0, i);
                    String suffix = word.substring(i + 1, word.length());
                    for (char c = 'a'; c <= 'z'; c++) {
                        String candidate = prefix + c + suffix;
                        if (dict.remove(candidate)) {
                            chain.add(candidate);
                        }
                    }
                }
            }
        }
        return 0;
    }
}