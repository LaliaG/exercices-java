import org.example.Fib;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FibTest {
    private Fib fib;
    @ParameterizedTest
    @MethodSource("provideParametersForRangeOne")
    public void whenGetFibSeries_Range1_ThenResultIsNotEmpty(int range, List<Integer> expected) {
        // Arrange
        Fib fib = new Fib(range);

        // Act
        List<Integer> result = fib.getFibSeries();

        // Assert
        Assertions.assertFalse(result.isEmpty(), "The result should not be empty.");
        Assertions.assertEquals(expected, result, "The result should contain " + expected);
    }

    @ParameterizedTest
    @MethodSource("provideParametersForRangeSix")
    public void whenGetFibSeries_Range6_ThenResultIsNotContains(3)(int range, List<Integer> expected) {
        // Arrange
        Fib fib = new Fib(range);

        // Act
        List<Integer> result = fib.getFibSeries();

        // Assert
        Assertions.assertTrue(result.contains(3), "The result should contain the number 3.");
        Assertions.assertEquals(expected.size(), result.size(), "The result should contain " + expected.size() + " elements.");
        Assertions.assertFalse(result.contains(4), "The result should not contain the number 4.");
        Assertions.assertEquals(expected, result, "The result should be " + expected);
        List<Integer> sortedResult = new ArrayList<>(result);
        sortedResult.sort(Integer::compareTo);
        Assertions.assertEquals(result, sortedResult, "The result should be sorted in ascending order.");
    }

    private static Stream<Arguments> provideParametersForRangeOne() {
        return Stream.of(
                Arguments.of(1, List.of(0))
        );
    }

    private static Stream<Arguments> provideParametersForRangeSix() {
        return Stream.of(
                Arguments.of(6, List.of(0, 1, 1, 2, 3, 5))
        );
    }

}
