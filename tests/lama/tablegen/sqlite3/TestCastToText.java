package lama.tablegen.sqlite3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import lama.sqlite3.ast.SQLite3Constant;
import lama.sqlite3.gen.SQLite3Cast;

public class TestCastToText {
	
	@Test
	void test0() {
		assertBinaryCastToText("3dca", "=�");
	}
	
	@Test
	void test1() {
		assertBinaryCastToText("7e0fa8", "~�");
	}
	
	@Test
	void test2() {
		assertBinaryCastToText("a4ee", "��");
	}
	
	@Test
	void test3() {
		assertBinaryCastToText("2D8A", "-�");
	}


	void assertBinaryCastToText(String val, String expected) {
		SQLite3Constant c = SQLite3Constant.createBinaryConstant(val);
		SQLite3Constant intVal = SQLite3Cast.castToText(c);
		assertEquals(intVal.asString(), expected);
	}
	
}