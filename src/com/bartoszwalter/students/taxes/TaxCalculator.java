package com.bartoszwalter.students.taxes;

import java.text.DecimalFormat;

public class TaxCalculator {
	public double podstawa = 0;
	public char umowa = ' ';
	// składki na ubezpieczenia społeczne
	public double s_emerytalna = 0; // 9,76% podstawyy
	public double s_rentowa = 0; // 1,5% podstawy
	public double u_chorobowe = 0; // 2,45% podstawy
	// składki na ubezpieczenia zdrowotne
	public double kosztyUzyskania = 111.25; 
	public double s_zdrow1 = 0; // od podstawy wymiaru 9%
	public double s_zdrow2 = 0; // od podstawy wymiaru 7,75 %
	public double zaliczkaNaPod = 0; // zaliczka na podatek dochodowy 18%
	public double kwotaZmiejsz = 46.33; // kwota zmienjszająca podatek 46,33 PLN
	public double zaliczkaUS = 0;
	public double zaliczkaUS0 = 0;
	
	public TaxCalculator(double podstawa, char umowa) {
		this.podstawa = podstawa;
		this.umowa = umowa;
	}
	
	public void print() {
		DecimalFormat df00 = new DecimalFormat("#.00");
		DecimalFormat df = new DecimalFormat("#");
		
		if (umowa == 'P') {
			System.out.println("UMOWA O PRACĘ");
			System.out.println("Podstawa wymiaru składek " + podstawa);
			double oPodstawa = obliczonaPodstawa(podstawa);
			System.out.println("Składka na ubezpieczenie emerytalne "
					+ df00.format(s_emerytalna));
			System.out.println("Składka na ubezpieczenie rentowe    "
					+ df00.format(s_rentowa));
			System.out.println("Składka na ubezpieczenie chorobowe  "
					+ df00.format(u_chorobowe));
			System.out
					.println("Podstawa wymiaru składki na ubezpieczenie zdrowotne: "
							+ oPodstawa);
			obliczUbezpieczenia(oPodstawa);
			System.out.println("Składka na ubezpieczenie zdrowotne: 9% = "
					+ df00.format(s_zdrow1) + " 7,75% = " + df00.format(s_zdrow2));
			System.out.println("Koszty uzyskania przychodu w stałej wysokości "
					+ kosztyUzyskania);
			double podstawaOpodat = oPodstawa - kosztyUzyskania;
			double podstawaOpodat0 = Double
					.parseDouble(df.format(podstawaOpodat));
			System.out.println("Podstawa opodatkowania " + podstawaOpodat
					+ " zaokrąglona " + df.format(podstawaOpodat0));
			obliczPodatek(podstawaOpodat0);
			System.out.println("Zaliczka na podatek dochodowy 18 % = "
					+ zaliczkaNaPod);
			System.out.println("Kwota wolna od podatku = " + kwotaZmiejsz);
			double podatekPotracony = zaliczkaNaPod - kwotaZmiejsz;
			System.out.println("Podatek potrącony = "
					+ df00.format(podatekPotracony));
			obliczZaliczke();
			zaliczkaUS0 = Double.parseDouble(df.format(zaliczkaUS));
			System.out.println("Zaliczka do urzędu skarbowego = "
					+ df00.format(zaliczkaUS) + " po zaokrągleniu = "
					+ df.format(zaliczkaUS0));
			double wynagrodzenie = podstawa
					- ((s_emerytalna + s_rentowa + u_chorobowe) + s_zdrow1 + zaliczkaUS0);
			System.out.println();
			System.out
					.println("Pracownik otrzyma wynagrodzenie netto w wysokości = "
							+ df00.format(wynagrodzenie));
		} else if (umowa == 'Z') {
			System.out.println("UMOWA-ZLECENIE");
			System.out.println("Podstawa wymiaru składek " + podstawa);
			double oPodstawa = obliczonaPodstawa(podstawa);
			System.out.println("Składka na ubezpieczenie emerytalne "
					+ df00.format(s_emerytalna));
			System.out.println("Składka na ubezpieczenie rentowe    "
					+ df00.format(s_rentowa));
			System.out.println("Składka na ubezpieczenie chorobowe  "
					+ df00.format(u_chorobowe));
			System.out
					.println("Podstawa wymiaru składki na ubezpieczenie zdrowotne: "
							+ oPodstawa);
			obliczUbezpieczenia(oPodstawa);
			System.out.println("Składka na ubezpieczenie zdrowotne: 9% = "
					+ df00.format(s_zdrow1) + " 7,75% = " + df00.format(s_zdrow2));
			kwotaZmiejsz = 0;
			kosztyUzyskania = (oPodstawa * 20) / 100;
			System.out.println("Koszty uzyskania przychodu (stałe) "
					+ kosztyUzyskania);
			double podstawaOpodat = oPodstawa - kosztyUzyskania;
			double podstawaOpodat0 = Double.parseDouble(df.format(podstawaOpodat));
			System.out.println("Podstawa opodatkowania " + podstawaOpodat
					+ " zaokrąglona " + df.format(podstawaOpodat0));
			obliczPodatek(podstawaOpodat0);
			System.out.println("Zaliczka na podatek dochodowy 18 % = "
					+ zaliczkaNaPod);
			double podatekPotracony = zaliczkaNaPod;
			System.out.println("Podatek potrącony = "
					+ df00.format(podatekPotracony));
			obliczZaliczke();
			zaliczkaUS0 = Double.parseDouble(df.format(zaliczkaUS));
			System.out.println("Zaliczka do urzędu skarbowego = "
					+ df00.format(zaliczkaUS) + " po zaokrągleniu = "
					+ df.format(zaliczkaUS0));
			double wynagrodzenie = podstawa
					- ((s_emerytalna + s_rentowa + u_chorobowe) + s_zdrow1 + zaliczkaUS0);
			System.out.println();
			System.out
					.println("Pracownik otrzyma wynagrodzenie netto w wysokości = "
							+ df00.format(wynagrodzenie));
		} else {
			System.out.println("Nieznany typ umowy!");
		}

	}
	
	public void obliczZaliczke() {
		zaliczkaUS = zaliczkaNaPod - s_zdrow2 - kwotaZmiejsz;
	}

	public void obliczPodatek(double podstawa) {
		zaliczkaNaPod = (podstawa * 18) / 100;
	}

	public double obliczonaPodstawa(double podstawa) {
		s_emerytalna = (podstawa * 9.76) / 100;
		s_rentowa = (podstawa * 1.5) / 100;
		u_chorobowe = (podstawa * 2.45) / 100;
		return (podstawa - s_emerytalna - s_rentowa - u_chorobowe);
	}

	public void obliczUbezpieczenia(double podstawa) {
		s_zdrow1 = (podstawa * 9) / 100;
		s_zdrow2 = (podstawa * 7.75) / 100;
	}	
}
