package com.github.jinahya.algorithm.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.github.jinahya.algorithm.sort.SelectionSort.sort;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static java.util.Comparator.naturalOrder;
import static java.util.Comparator.reverseOrder;
import static java.util.concurrent.ThreadLocalRandom.current;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

@Slf4j
public class SelectionSortTest {

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    public void testSortWithEmptyList() {
        final List<String> list = emptyList();
        final Comparator<String> comparator = naturalOrder();
        sort(list, comparator);
        assertThat(list)
                .isSortedAccordingTo(comparator);
    }

    @Test
    public void testSortWithSingletonList() {
        final List<Integer> list = singletonList(current().nextInt());
        final Comparator<Integer> comparator = naturalOrder();
        sort(list, comparator);
        assertThat(list)
                .isSortedAccordingTo(comparator);
    }

    /**
     * Tests {@link SelectionSort#sort(List, Comparator)} method with a list of random elements.
     */
    @Test
    public void testSort() {
        final List<Integer> unsorted
                = range(0, current().nextInt(2, 128))
                .map(i -> current().nextInt())
                .boxed()
                .collect(toList());
        final Comparator<Integer> comparator = naturalOrder();
        final List<Integer> actual = new ArrayList<>(unsorted);
        {
            sort(actual, comparator);
        }
        final List<Integer> expected = new ArrayList<>(unsorted);
        {
            Collections.sort(expected);
        }
        assertIterableEquals(expected, actual);
    }

    @Test
    public void testSortReverse() {
        final List<String> actual = new ArrayList<>();
        actual.add("3");
        actual.add("1");
        actual.add("2");
        sort(actual, reverseOrder());
        assertIterableEquals(asList("3", "2", "1"), actual);
    }
}
