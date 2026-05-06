import org.example.MinSubarrayWithNegatives;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


class MinSubarrayWithNegativesTest {

    private MinSubarrayWithNegatives solver;

    @BeforeEach
    void setUp() {
        solver = new MinSubarrayWithNegatives();
    }

    // ── Parameterized test — all cases in one place ──────────────────────────

    @ParameterizedTest(name = "{0}")
    @MethodSource("testCases")
    @DisplayName("minSubArrayLen")
    void testMinSubArrayLen(String label, int expected, int target, int[] nums) {
        Assertions.assertEquals(expected, solver.minSubArrayLen(target, nums), label);
    }

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("Blog example [2,-1,2,-2,3] t=3",      1, 3,   new int[]{2,-1,2,-2,3}),
                Arguments.of("[1,-1,5,-2,3] t=3",                   1, 3,   new int[]{1,-1,5,-2,3}),
                Arguments.of("All negatives [-1,-2,-3] t=1",        -1, 1,   new int[]{-1,-2,-3}),
                Arguments.of("All positives [2,3,1,2,4,3] t=7",     2, 7,   new int[]{2,3,1,2,4,3}),
                Arguments.of("Single element [5] t=5",              1, 5,   new int[]{5}),
                Arguments.of("Empty array t=10",                    -1, 10,  new int[]{}),
                Arguments.of("Duplicate prefixes [1,-1,1,-1,5] t=4",1, 4,   new int[]{1,-1,1,-1,5}),
                Arguments.of("Unreachable [1,2,3] t=100",           -1, 100, new int[]{1,2,3}),
                Arguments.of("Negative-heavy [-5,10,-3,1] t=2",     1, 2,   new int[]{-5,10,-3,1}),
                Arguments.of("Full array [1,1,1,1] t=4",            4, 4,   new int[]{1,1,1,1}),
                Arguments.of("Single below target [3] t=5",         -1, 5,   new int[]{3}),
                Arguments.of("Negative sandwich [-1,6,-1] t=5",     1, 5,   new int[]{-1,6,-1}),
                Arguments.of("Mix [3,-1,2] t=1",                    1, 1,   new int[]{3,-1,2}),
                Arguments.of("Large negative drag [-100,10,5] t=15",2, 15,  new int[]{-100,10,5})
        );
    }
}