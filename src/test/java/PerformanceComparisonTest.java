import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PerformanceComparisonTest {

    private static final int TEST_OPERATIONS_COUNT = 100;

    @Test
    void testAddTest() {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        PerformanceComparison.addTest(arrayList);
        PerformanceComparison.addTest(linkedList);

        assertEquals(PerformanceComparison.OPERATIONS_COUNT, arrayList.size());
        assertEquals(PerformanceComparison.OPERATIONS_COUNT, linkedList.size());
    }

    @Test
    void testDeleteTest() {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        PerformanceComparison.addTest(arrayList); // Заполнение списка
        PerformanceComparison.addTest(linkedList);

        // Очистка перед тестированием
        arrayList.clear();
        linkedList.clear();

        PerformanceComparison.deleteTest(arrayList);
        PerformanceComparison.deleteTest(linkedList);

        assertEquals(0, arrayList.size());
        assertEquals(0, linkedList.size());
    }


    @Test
    void testGetTest() {
        // Проверяем, что метод getTest не выбрасывает исключений
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        assertDoesNotThrow(() -> PerformanceComparison.getTest(arrayList));
        assertDoesNotThrow(() -> PerformanceComparison.getTest(linkedList));
    }

    @Test
    void testComparePerformance() {
        // Проверяем, что comparePerformance работает без исключений
        assertDoesNotThrow(PerformanceComparison::comparePerformance);
    }
}
