package tw.cy.study.leetcode;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

public class ThreeSumTest {

	List<List<Integer>> cases = Lists.newArrayList();
	List<List<List<Integer>>> expectes = Lists.newArrayList();
	int runs = 2;

	@Before
	public void before() {
		loadTestCases();
	}

	@Test(timeout = 20000)
	public void testBruteForce() {
		IntStream.range(0, runs).forEach(i -> {
			System.out.println("Case " + i);
			List<List<Integer>> result = ThreeSum.bruteForce(cases.get(i).stream().mapToInt(e -> (int) e).toArray());
			System.out.println("Case " + i + " >> result = " + Arrays.toString(result.toArray()));
			List<List<Integer>> expected = expectes.get(i);
			System.out.println("Case " + i + " >> expected = " + Arrays.toString(expected.toArray()));

			assertTrue(getFailResult(expected, result), checkResult(expected, result));
		});
	}

	private String getFailResult(List<List<Integer>> expected, List<List<Integer>> result) {
		StringBuilder sb = new StringBuilder(100);
		sb.append("expected: ");
		expected.forEach(e -> sb.append(Arrays.toString(e.toArray())));
		sb.append("\\nresult: ");
		result.forEach(e -> sb.append(Arrays.toString(e.toArray())));
		sb.trimToSize();
		return sb.toString();
	}

	private boolean checkResult(List<List<Integer>> expected, List<List<Integer>> result) {
		if (expected.size() != result.size()) {
			System.out.println("size not equals: " + expected.size() + " : " + result.size());
			return false;
		}

		Map<String, Integer> expectedMap = expected.stream().map(e -> Arrays.toString(e.toArray()))
				.collect(Collectors.toMap(Function.identity(), e -> 0));

		final boolean[] passed = { true };
		result.stream().forEach(e -> {
			String key = Arrays.toString(e.toArray());
			Integer existed = expectedMap.get(key);
			if (existed == null) {
				System.out.println("Not expected: " + key);
				passed[0] = false;
				return;
			}
			if (++existed > 1) {
				System.out.println("Duplicated: " + key);
				passed[0] = false;
				return;
			}

		});
		return passed[0];
	}

	private void loadTestCases() {
		Parameters params = new Parameters();
		FileBasedConfigurationBuilder<FileBasedConfiguration> builder = new FileBasedConfigurationBuilder<FileBasedConfiguration>(
				PropertiesConfiguration.class).configure(params.properties().setFileName("ThreeSum.properties"));

		Configuration config;
		try {
			config = builder.getConfiguration();
		} catch (ConfigurationException e) {
			throw new RuntimeException("Fail to get configuration: " + e.getLocalizedMessage(), e);
		}
		config.getKeys().forEachRemaining(key -> {
			if (key.contains("question")) {
				cases.add(Stream.of(config.getString(key).split(",")).map(e -> Integer.valueOf((String) e))
						.collect(Collectors.toList()));
			} else if (key.contains("expected")) {
				String expect = config.getString(key).replaceFirst(Pattern.quote("["), "")
						.replaceAll(Pattern.quote("]") + "$", "");
				expectes.add(Stream.of(expect.split(Pattern.quote("],[")))
						.map(e -> Stream.of(e.split(",")).map(i -> Integer.valueOf(i)).collect(Collectors.toList()))
						.collect(Collectors.toList()));
			} else {
				throw new RuntimeException("Unaccepted configuration: " + key);
			}
		});

	}

}
