package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.TaxPayer;

public class Prorgam {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Quantos contribuintes você vai digitar? ");
		int n = sc.nextInt();
		
		List<TaxPayer> taxPayers = new ArrayList<>();
		
		for (int i=0; i<n; i++) {
			System.out.println();
			System.out.printf("Digito os dados do %do contribuinte:%n", (i+1));
			System.out.print("Renda anual com salário: ");
			double salaryIncome = sc.nextDouble();
			System.out.print("Renda anual com prestação de serviço: ");
			double serviceIncome = sc.nextDouble();
			System.out.print("Renda anual com ganho de capital: ");
			double capitalIncome = sc.nextDouble();
			System.out.print("Gastos médicos: ");
			double healthSpending = sc.nextDouble();
			System.out.print("Gastos educacionais: ");
			double educationSpending = sc.nextDouble();
			
			taxPayers.add(new TaxPayer(salaryIncome, serviceIncome, capitalIncome, healthSpending, educationSpending));
		}
		
		for(int i=0; i<taxPayers.size(); i++) {
			System.out.printf("%nResumo do %do contribuinte%n", i);
			System.out.printf("Imposto bruto total: %.2f%n", taxPayers.get(i).grossTax());
			System.out.printf("Abatimento: %.2f%n", taxPayers.get(i).taxRebate());
			System.out.printf("Imposto devido: %.2f%n", taxPayers.get(i).netTax());
		}
		
		sc.close();
		
	}

}
