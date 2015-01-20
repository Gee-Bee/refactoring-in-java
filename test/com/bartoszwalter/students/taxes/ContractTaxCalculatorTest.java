package com.bartoszwalter.students.taxes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ContractTaxCalculatorTest {

	TaxCalculator tc;
	
	@Before
	public void setUp() throws Exception {
		tc = new EmploymentTaxCalculator(1000);
		tc.calculate();
	}

	@Test
	public void testWynagrodzenie() {
		assertEquals(763.24, tc.getWynagrodzenie(), 0.01);
	}

	@Test
	public void testGetS_emerytalna() {
		assertEquals(97.60, tc.getS_emerytalna(), 0.01);
	}

	@Test
	public void testGetS_rentowa() {
		assertEquals(15.00, tc.getS_rentowa(), 0.01);
	}

	@Test
	public void testGetU_chorobowe() {
		assertEquals(24.50, tc.getU_chorobowe(), 0.01);
	}

	@Test
	public void testGetKosztyUzyskania() {
		assertEquals(77.66, tc.getS_zdrow1(), 0.01);
	}

	@Test
	public void testGetS_zdrow1() {
		assertEquals(77.66, tc.getS_zdrow1(), 0.01);
	}

	@Test
	public void testGetS_zdrow2() {
		assertEquals(66.87, tc.getS_zdrow2(), 0.01);
	}

	@Test
	public void testGetZaliczkaNaPod() {
		assertEquals(135.36, tc.getZaliczkaNaPod(), 0.01);
	}

	@Test
	public void testGetZaliczkaUS() {
		assertEquals(22.16, tc.getZaliczkaUS(), 0.01);
	}

	@Test
	public void testGetoPodstawa() {
		assertEquals(862.9, tc.getoPodstawa(), 0.01);
	}

	@Test
	public void testGetPodstawaOpodat() {
		assertEquals(751.65, tc.getPodstawaOpodat(), 0.01);
	}

	@Test
	public void testGetPodatekPotracony() {
		assertEquals(89.03, tc.getPodatekPotracony(), 0.01);
	}

}
