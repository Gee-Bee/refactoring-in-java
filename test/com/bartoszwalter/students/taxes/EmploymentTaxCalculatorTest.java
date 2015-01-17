package com.bartoszwalter.students.taxes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmploymentTaxCalculatorTest {
	
	@Before
	public void setup() {
		TaxCalculator.umowa = 'P';
		TaxCalculator.podstawa = 1000;
		TaxCalculator.obliczonaPodstawa(TaxCalculator.podstawa);
	}
	
	@Test
	public void testSklEmerytalna() throws Exception {
		assertEquals(97.6, TaxCalculator.s_emerytalna, 0.01);
	}
	
	@Test
	public void testSklRentowa() throws Exception {
		assertEquals(15.0, TaxCalculator.s_rentowa, 0.01);
	}
	
	@Test
	public void testSklChorobowa() throws Exception {
		assertEquals(24.50, TaxCalculator.u_chorobowe, 0.01);
	}

}
