class Letter {
    char ch;
    int freq;

    Letter(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}

class Solution {
    public String reorganizeString(String s) {

        HashMap<Character, Integer> hs = new HashMap<>();

        for (char ch : s.toCharArray()) {
            hs.put(ch, hs.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Letter> maxHeap =
            new PriorityQueue<>((a, b) -> b.freq - a.freq);

        for (Map.Entry<Character, Integer> entry : hs.entrySet()) {
            maxHeap.offer(new Letter(entry.getKey(), entry.getValue()));
        }

        StringBuilder result = new StringBuilder();

        Letter prev = null;

        while (!maxHeap.isEmpty() || prev != null) {

            // Nothing available to put after prev
            if (prev != null && maxHeap.isEmpty()) {
                return "";
            }

            Letter letter = maxHeap.poll();

            result.append(letter.ch);

            letter.freq--;

            // Make previous character available again
            if (prev != null) {
                maxHeap.offer(prev);
            }

            // Current character must stay out for one turn
            if (letter.freq > 0) {
                prev = letter;
            } else {
                prev = null;
            }
        }

        return result.toString();
    }
}