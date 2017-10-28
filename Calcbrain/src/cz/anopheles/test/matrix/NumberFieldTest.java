package cz.anopheles.test.matrix;

import static org.junit.Assert.assertTrue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NumberFieldTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertTrue(isCorrectCharacter("12.2"));
		assertTrue(!isCorrectCharacter("12.2."));
		assertTrue(!isCorrectCharacter("aa12.2"));
		assertTrue(!isCorrectCharacter("12.2df"));
		assertTrue(!isCorrectCharacter(""));
	}

	public boolean isCorrectCharacter(String character){
		Matcher m = Pattern.compile("\\d+\\.?\\d*").matcher(character);
		return m.matches();
	}
}
