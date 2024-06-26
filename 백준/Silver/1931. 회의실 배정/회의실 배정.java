import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Meeting> meetings = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            Long startTime = sc.nextLong();
            Long endTime = sc.nextLong();
            meetings.add(new Meeting(startTime, endTime));
        }

        Collections.sort(meetings, new MeetingComparator());

        int count = 0;
        Long startMin = 0L;
        int nextIndex =0;
        for (int i = 0; i < n; i++) {
            Long endMin = 0L;
            for (int j = nextIndex; j < n; j++) {

                if (meetings.get(j).getStartTime() < startMin) {
                    continue;
                }
                endMin =  meetings.get(j).getEndTime();
                nextIndex = j+1;
                break;
            }

            if (endMin == 0) {
                break;
            }
            startMin = endMin;
            count++;
        }
        System.out.println(count);
    }

    private static class Meeting {

        private Long startTime;
        private Long endTime;

        public Meeting(Long startTime, Long endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public Long getStartTime() {
            return startTime;
        }

        public Long getEndTime() {
            return endTime;
        }
    }

    static class MeetingComparator implements Comparator<Meeting> {
        @Override
        public int compare(Meeting a, Meeting b) {
            if (a.getEndTime() > b.getEndTime()) {
                return 1;
            }
            if (a.getEndTime() == b.getEndTime()) {
                if (a.getStartTime() > b.getStartTime()) {
                    return 1;
                }
                if (a.getStartTime() < b.getStartTime()) {
                    return -1;
                }
            }
            if (a.getEndTime() < b.getEndTime()) {
                return -1;
            }
            return 0;
        }
    }
}