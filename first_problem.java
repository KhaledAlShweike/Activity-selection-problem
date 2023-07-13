import java.util.Arrays;

public class first_problem {

    private static class Activity implements Comparable<Activity> {
        private final int startTime;
        private final int endTime;

        public Activity(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Activity other) {
            return Integer.compare(endTime, other.endTime);
        }
    }

    private static Activity[] createActivities(int[] startTimes, int[] endTimes) {
        Activity[] activities = new Activity[startTimes.length];
        for (int i = 0; i < startTimes.length; i++) {
            activities[i] = new Activity(startTimes[i], endTimes[i]);
        }
        return activities;
    }

    public static int select_act(int[] startTimes, int[] endTimes) {
        Activity[] activities = createActivities(startTimes, endTimes);
        Arrays.sort(activities);

        int biggest = 1;
        int prevEndTime = activities[0].endTime;

        for (int i = 1; i < activities.length; i++) {
            if (activities[i].startTime >= prevEndTime) {
                biggest++;
                prevEndTime = activities[i].endTime;
            }
        }

        return biggest;
    }


    public static void main(String[] args) {
        int[] startTimes = {1, 3, -1, 5, 8, 5};
        int[] endTimes = {8, 4, 6, 7, 9, 9};

        int maxActivities = select_act(startTimes, endTimes);
        System.out.println(" the most number of activites we can do: " + maxActivities);
    }
}