package com.bartoszwalter.students.taxes;

public class EmploymentTaxCalculator extends TaxCalculator {
	
	public EmploymentTaxCalculator(double podstawa) {
		super(podstawa);
	}
	
	@Override
	protected String title() {
		return "UMOWA O PRACĘ";
	}
	
	@Override
	protected void obliczKosztyUzyskania() {
		kosztyUzyskania = 111.25;
	}
	
	@Override
	protected void obliczKwoteZmniejsz() {
		kwotaZmniejsz = 46.33;		
	}
	
	@Override
	protected void obliczPodatekPotracony() {
		podatekPotracony = zaliczkaNaPod - kwotaZmniejsz;
	}
}
