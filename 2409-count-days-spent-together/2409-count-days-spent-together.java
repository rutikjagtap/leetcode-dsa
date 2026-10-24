class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice,String arriveBob, String leaveBob) {
        int arriveA = convertToDays(arriveAlice);
        int leaveA = convertToDays(leaveAlice);
        int arriveB = convertToDays(arriveBob);
        int leaveB = convertToDays(leaveBob);
        int count = 0;
        int start = Math.max(arriveA, arriveB);
        int end = Math.min(leaveA, leaveB);
        for (int day = start; day <= end; day++) {
            count++;
        }
        return count;
    }
    private int convertToDays(String date) {String[] parts = date.split("-");
        int month = Integer.parseInt(parts[0]);
        int day = Integer.parseInt(parts[1]);
        int[] daysInMonth = {31, 28, 31, 30, 31, 30,31, 31, 30, 31, 30, 31};
        int totalDays = day;
        for (int i = 0; i < month - 1; i++) {
            totalDays += daysInMonth[i];
        }
        return totalDays;
    }
}