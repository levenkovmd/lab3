import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PerformanceComparison {

    public static final int OPERATIONS_COUNT = 10000;

    public static void main(String[] args) {
        comparePerformance();
    }

    public static void comparePerformance() {
        System.out.printf("%-10s %-10s %-20s %-20s%n", "Method", "Count", "ArrayList Time (ms)", "LinkedList Time (ms)");

        System.out.printf("%-10s %-10d %-20d %-20d%n",
                "add",
                OPERATIONS_COUNT,
                measureTime(() -> addTest(new ArrayList<>())),
                measureTime(() -> addTest(new LinkedList<>())));

        System.out.printf("%-10s %-10d %-20d %-20d%n",
                "delete",
                OPERATIONS_COUNT,
                measureTime(() -> deleteTest(new ArrayList<>())),
                measureTime(() -> deleteTest(new LinkedList<>())));

        System.out.printf("%-10s %-10d %-20d %-20d%n",
                "get",
                OPERATIONS_COUNT,
                measureTime(() -> getTest(new ArrayList<>())),
                measureTime(() -> getTest(new LinkedList<>())));
    }

    public static void addTest(List<Integer> list) {
        for (int i = 0; i < OPERATIONS_COUNT; i++) {
            list.add(i);
        }
    }

    public static void deleteTest(List<Integer> list) {
        for (int i = 0; i < OPERATIONS_COUNT; i++) {
            list.add(i);
        }
        for (int i = 0; i < OPERATIONS_COUNT; i++) {
            list.remove(list.size() - 1); // Удаление с конца
        }
    }

    public static void getTest(List<Integer> list) {
        for (int i = 0; i < OPERATIONS_COUNT; i++) {
            list.add(i);
        }
        for (int i = 0; i < OPERATIONS_COUNT; i++) {
            list.get(i);
        }
    }

    private static long measureTime(Runnable task) {
        long startTime = System.currentTimeMillis();
        task.run();
        return System.currentTimeMillis() - startTime;
    }
}
