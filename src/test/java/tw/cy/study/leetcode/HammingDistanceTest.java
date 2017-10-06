package tw.cy.study.leetcode;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HammingDistanceTest {

	Map<Integer[], Integer> data = new HashMap<Integer[], Integer>();
	int runs = 20000;

	@Before
	public void before() {
		data.put(new Integer[] { 0, 0 }, 0);
		data.put(new Integer[] { 0, 1 }, 1);
		data.put(new Integer[] { 0, 2 }, 1);
		data.put(new Integer[] { 0, 3 }, 2);
		data.put(new Integer[] { 0, 4 }, 1);
		data.put(new Integer[] { 0, 5 }, 2);
		data.put(new Integer[] { 0, 6 }, 2);
		data.put(new Integer[] { 0, 7 }, 3);
		data.put(new Integer[] { 0, 8 }, 1);
		data.put(new Integer[] { 0, 9 }, 2);
		data.put(new Integer[] { 0, 10 }, 2);
		data.put(new Integer[] { 1, 0 }, 1);
		data.put(new Integer[] { Integer.MAX_VALUE, 0 }, 31);
		data.put(new Integer[] { Integer.MAX_VALUE, 1 }, 30);
		data.put(new Integer[] { Integer.MAX_VALUE, 2 }, 30);
		data.put(new Integer[] { Integer.MAX_VALUE, 3 }, 29);
		data.put(new Integer[] { Integer.MAX_VALUE, 4 }, 30);
		data.put(new Integer[] { Integer.MAX_VALUE, 5 }, 29);
		data.put(new Integer[] { Integer.MAX_VALUE, Integer.MAX_VALUE - 1 }, 1);
		data.put(new Integer[] { Integer.MAX_VALUE, Integer.MAX_VALUE }, 0);
	}

	@Test
	public void test() {
	}
	
	@Test
	public void testHammingDistance5() {
		IntStream.range(0, runs).forEach(i -> {
			data.entrySet()
			.forEach(e -> assertTrue(
					String.format("%s : %s : %s", Arrays.toString(e.getKey()), e.getValue(),
							HammingDistance.hammingDistance5(e.getKey()[0], e.getKey()[1])),
					e.getValue() == HammingDistance.hammingDistance5(e.getKey()[0], e.getKey()[1])));
		});
	}
	
	@Test
	public void testHammingDistance4() {
		IntStream.range(0, runs).forEach(i -> {
			data.entrySet()
			.forEach(e -> assertTrue(
					String.format("%s : %s : %s", Arrays.toString(e.getKey()), e.getValue(),
							HammingDistance.hammingDistance4(e.getKey()[0], e.getKey()[1])),
					e.getValue() == HammingDistance.hammingDistance4(e.getKey()[0], e.getKey()[1])));
		});
	}
	
	@Test
	public void testHammingDistance3() {
		IntStream.range(0, runs).forEach(i -> {
			data.entrySet()
			.forEach(e -> assertTrue(
					String.format("%s : %s : %s", Arrays.toString(e.getKey()), e.getValue(),
							HammingDistance.hammingDistance3(e.getKey()[0], e.getKey()[1])),
					e.getValue() == HammingDistance.hammingDistance3(e.getKey()[0], e.getKey()[1])));
		});
	}

	@Test
	public void testHammingDistance2() {
		IntStream.range(0, runs).forEach(i -> {
			data.entrySet()
					.forEach(e -> assertTrue(
							String.format("%s : %s : %s", Arrays.toString(e.getKey()), e.getValue(),
									HammingDistance.hammingDistance2(e.getKey()[0], e.getKey()[1])),
							e.getValue() == HammingDistance.hammingDistance2(e.getKey()[0], e.getKey()[1])));
		});
	}

	@Test
	public void testHammingDistance() {
		IntStream.range(0, runs).forEach(i -> {
			data.entrySet()
					.forEach(e -> assertTrue(
							String.format("%s : %s : %s", Arrays.toString(e.getKey()), e.getValue(),
									HammingDistance.hammingDistance(e.getKey()[0], e.getKey()[1])),
							e.getValue() == HammingDistance.hammingDistance(e.getKey()[0], e.getKey()[1])));
		});
	}

}
