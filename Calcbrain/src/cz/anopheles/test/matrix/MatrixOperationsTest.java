package cz.anopheles.test.matrix;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cz.anopheles.exception.CalcbrainCalculationException;
import cz.anopheles.exception.CalcbrainException;
import cz.anopheles.matrix.controller.MatrixController;
import cz.anopheles.matrix.model.Matrix;

public class MatrixOperationsTest {

	private Matrix first, second, third, fourth, multiFirst, multiSecond, multiResult;
	
	@Before
	public void setUp() throws Exception {
		first = new Matrix(2,2);
		second = new Matrix(2,2);
		third = new Matrix(2,2);
		fourth = new Matrix(3,1);
		multiFirst = new Matrix(2,2);
		multiSecond = new Matrix(2,2);
		multiResult = new Matrix(2,2);
		
		for(int i = 0; i < first.getHeight(); i++){
			for(int j = 0; j < first.getWidth(); j++){
				first.setValue(i, j, 0d);
			}
		}
		for(int i = 0; i < second.getHeight(); i++){
			for(int j = 0; j < second.getWidth(); j++){
				second.setValue(i, j, 0d);
			}
		}
		for(int i = 0; i < third.getHeight(); i++){
			for(int j = 0; j < third.getWidth(); j++){
				third.setValue(i, j, 0d);
			}
		}
		third.setValue(0, 0, 1d);
		for(int i = 0; i < fourth.getHeight(); i++){
			for(int j = 0; j < fourth.getWidth(); j++){
				fourth.setValue(i, j, 0d);
			}
		}
		
		multiFirst.setValue(0, 0, 1.0);
		multiFirst.setValue(0, 1, 2.0);
		multiFirst.setValue(1, 0, 3.0);
		multiFirst.setValue(1, 1, 4.0);
		
		multiSecond.setValue(0, 0, 2.0);
		multiSecond.setValue(0, 1, 3.0);
		multiSecond.setValue(1, 0, 4.0);
		multiSecond.setValue(1, 1, 5.0);
		
		multiResult.setValue(0, 0, 10.0);
		multiResult.setValue(0, 1, 13.0);
		multiResult.setValue(1, 0, 22.0);
		multiResult.setValue(1, 1, 29.0);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		MatrixController controller = new MatrixController();
		assertTrue("Test 1", controller.isSameSize(first, third));
		assertTrue("Test 2", !controller.isSameSize(second, fourth));
		assertTrue("Test 3", controller.equals(first, second));
		assertTrue("Test 4", !controller.equals(first, third));
		assertTrue("Test 5", !controller.equals(first, fourth));
		try {
			assertTrue("Test 6", controller.equals(third, controller.addition(first, third)));
		} catch (CalcbrainCalculationException e) {
		}
		try {
			controller.addition(first, fourth);
			assertTrue("Test 7", false);
		} catch (CalcbrainCalculationException e) {
			assertTrue("Test 7", true);
		}
		
		try {
			assertTrue("Test 8", controller.equals(controller.multiply(multiFirst, multiSecond), multiResult));
		} catch (CalcbrainCalculationException e) {
			assertTrue("Test 8", false);
		}
	}

}
