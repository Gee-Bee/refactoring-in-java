package com.bartoszwalter.students.taxes;

import java.text.DecimalFormat;

public abstract class TaxCalculator {
	protected double podstawa = 0;
	protected double s_emerytalna = 0;
	protected double s_rentowa = 0;
	protected double u_chorobowe = 0;
	protected double kosztyUzyskania = 111.25; 
	protected double s_zdrow1 = 0;
	protected double s_zdrow2 = 0;
	protected double zaliczkaNaPod = 0;
	protected double kwotaZmniejsz = 0;
	protected double zaliczkaUS = 0;
	protected double zaliczkaUS0 = 0;
	protected DecimalFormat df00 = new DecimalFormat("#.00");
	protected DecimalFormat df = new DecimalFormat("#");
	protected boolean calculated;
	protected double oPodstawa = 0;
	protected double podstawaOpodat = 0;
	protected double podatekPotracony  = 0;
	protected double wynagrodzenie = 0;
	
	public TaxCalculator(double podstawa) {
		this.podstawa = podstawa;
		this.calculated = false;
	}
	
	public void calculate() {
		obliczSkladki();
		obliczPodstawe();
		obliczUbezpieczenia();
		obliczKosztyUzyskania();
		obliczPodstaweOpodat();
		obliczKwoteZmniejsz();
		obliczPodatek();
		obliczPodatekPotracony();
		obliczZaliczke();
		obliczWynagrodzenie();
		this.calculated = true;
	}
	
	protected void print() {
		if(!calculated) calculate();
		
		System.out.println(title());
		System.out.println("Podstawa wymiaru składek " + podstawa);
		System.out.println("Składka na ubezpieczenie emerytalne " + df00.format(s_emerytalna));
		System.out.println("Składka na ubezpieczenie rentowe    " + df00.format(s_rentowa));
		System.out.println("Składka na ubezpieczenie chorobowe  " + df00.format(u_chorobowe));
		System.out.println("Podstawa wymiaru składki na ubezpieczenie zdrowotne: " + oPodstawa);
		System.out.println("Składka na ubezpieczenie zdrowotne: 9% = " + df00.format(s_zdrow1) + " 7,75% = " + df00.format(s_zdrow2));
		System.out.println("Koszty uzyskania przychodu w stałej wysokości " + kosztyUzyskania);
		System.out.println("Podstawa opodatkowania " + podstawaOpodat + " zaokrąglona " + df.format(podstawaOpodat));
		System.out.println("Zaliczka na podatek dochodowy 18 % = " + zaliczkaNaPod);
		if(kwotaZmniejsz > 0) System.out.println("Kwota wolna od podatku = " + kwotaZmniejsz);
		System.out.println("Podatek potrącony = " + df00.format(podatekPotracony));
		System.out.println("Zaliczka do urzędu skarbowego = " + df00.format(zaliczkaUS) + " po zaokrągleniu = "	+ df.format(zaliczkaUS));
		System.out.println("\nPracownik otrzyma wynagrodzenie netto w wysokości = "	+ df00.format(wynagrodzenie));
	}
	
	protected abstract String title();
	
	protected void obliczSkladki() {
		s_emerytalna = (podstawa * 9.76) / 100;
		s_rentowa = (podstawa * 1.5) / 100;
		u_chorobowe = (podstawa * 2.45) / 100;
	}

	protected void obliczPodstawe() {
		oPodstawa = podstawa - s_emerytalna - s_rentowa - u_chorobowe;
	}
	
	protected void obliczUbezpieczenia() {
		s_zdrow1 = (oPodstawa * 9) / 100;
		s_zdrow2 = (oPodstawa * 7.75) / 100;
	}
	
	protected abstract void obliczKosztyUzyskania();
	
	protected void obliczPodstaweOpodat() {
		podstawaOpodat = oPodstawa - kosztyUzyskania;
	}
	
	protected void obliczPodatek() {
		zaliczkaNaPod = (Double.parseDouble(df.format(podstawaOpodat)) * 18) / 100;
	}
	
	protected abstract void obliczPodatekPotracony();
	
	protected abstract void obliczKwoteZmniejsz();
	
	protected void obliczZaliczke() {
		zaliczkaUS = zaliczkaNaPod - s_zdrow2 - kwotaZmniejsz;
		zaliczkaUS0 = Double.parseDouble(df.format(zaliczkaUS));
	}
	
	protected void obliczWynagrodzenie() {
		wynagrodzenie = podstawa - ((s_emerytalna + s_rentowa + u_chorobowe) + s_zdrow1 + zaliczkaUS0);
	}
	
	public double getS_emerytalna() {
		return s_emerytalna;
	}

	public double getS_rentowa() {
		return s_rentowa;
	}

	public double getU_chorobowe() {
		return u_chorobowe;
	}

	public double getKosztyUzyskania() {
		return kosztyUzyskania;
	}

	public double getS_zdrow1() {
		return s_zdrow1;
	}

	public double getS_zdrow2() {
		return s_zdrow2;
	}

	public double getZaliczkaNaPod() {
		return zaliczkaNaPod;
	}

	public double getZaliczkaUS() {
		return zaliczkaUS;
	}

	public double getoPodstawa() {
		return oPodstawa;
	}

	public double getPodstawaOpodat() {
		return podstawaOpodat;
	}

	public double getPodatekPotracony() {
		return podatekPotracony;
	}
	
	public double getWynagrodzenie() {
		return wynagrodzenie;
	}
}
