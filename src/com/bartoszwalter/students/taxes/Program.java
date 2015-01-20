package com.bartoszwalter.students.taxes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Program {
	
	public static void main(String[] args) {
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			
			System.out.print("Podaj kwotę dochodu: ");	
			double podstawa = Double.parseDouble(br.readLine());
			
			System.out.print("Typ umowy: (P)raca, (Z)lecenie: ");
			char umowa = br.readLine().charAt(0);
			switch (umowa) {
			case 'P':
				(new EmploymentTaxCalculator(podstawa)).print();
				break;
			case 'Z':
				(new ContractTaxCalculator(podstawa)).print();
				break;
			default:
				System.out.println("Nieznany typ umowy!");
				break;
			}
			
		} catch (Exception ex) {
			System.out.println("Błędna kwota");
			System.err.println(ex);
			return;
		}	
	}
}
