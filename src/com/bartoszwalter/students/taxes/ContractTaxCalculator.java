package com.bartoszwalter.students.taxes;

public class ContractTaxCalculator extends TaxCalculator {
	public ContractTaxCalculator(double podstawa) {
		super(podstawa);
	}
	
	@Override
	protected String title() {
		return "UMOWA-ZLECENIE";
	}
	
	protected void obliczKosztyUzyskania() {
		kosztyUzyskania = (oPodstawa * 20) / 100;		
	}
	
	@Override
	protected void obliczKwoteZmniejsz() {
		kwotaZmniejsz = 0.0;		
	}

	protected void obliczPodatekPotracony() {
		podatekPotracony = zaliczkaNaPod;
	}
}
