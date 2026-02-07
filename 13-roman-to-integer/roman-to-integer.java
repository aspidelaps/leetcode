class Solution {
    public int romanToInt(String s) {
        int result = 0;
        char prev = 'P';
        for (char letter : s.toCharArray()) {
            if(letter == 'M') {
                result = result + 1000;
                if (prev == 'C') {
                    result = result - 200;
                }
            }
            if(letter == 'D') {
                result = result + 500;
                if (prev == 'C') {
                    result = result - 200;
                }
            }
            if(letter == 'C') {
                result = result + 100;
                if (prev == 'X') {
                    result = result - 20;
                }
            }
            if(letter == 'L') {
                result = result + 50;
                if (prev == 'X') {
                    result = result - 20;
                }
            }
            if(letter == 'X') {
                result = result + 10;
                if (prev == 'I') {
                    result = result - 2;
                }
            }
            if(letter == 'V') {
                result = result + 5;
                if (prev == 'I') {
                    result = result - 2;
                }
            }
            if(letter == 'I') {
                result = result + 1;
            }
            prev = letter;
        }
        return result;
    }
}