class Solution {
    public static int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> studentsQ = Arrays.stream(students).boxed().collect(Collectors.toCollection(ArrayDeque::new));

        Stack<Integer> sandwichesS = new Stack<>();
        IntStream.iterate(sandwiches.length - 1, i -> i >= 0, i -> i - 1).mapToObj(i -> sandwiches[i]).forEach(sandwichesS::push);

        int tries = studentsQ.size();
        while(!sandwichesS.isEmpty()) {
            if (studentsQ.isEmpty()) {
                return 0;
            } else {
                if (tries < 1) {
                    return studentsQ.size();
                }
                Integer poll = studentsQ.poll();
                if (poll.equals(sandwichesS.peek())) {
                    tries = studentsQ.size();
                    sandwichesS.pop();
                } else {
                    tries--;
                    studentsQ.add(poll);
                }
            }
        }
        return studentsQ.size();
    }
}