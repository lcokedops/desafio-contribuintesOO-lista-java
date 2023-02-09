package entities;

public class TaxPayer {
	private Double salaryIncome, servicesIncome, capitalIncome, healthSpending, educationSpending;
	
	public TaxPayer() {}

	public TaxPayer(Double salaryIncome, Double servicesIncome, Double capitalIncome, Double healthSpending, Double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}

	public Double getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(Double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public Double getServicesIncome() {
		return servicesIncome;
	}

	public void setServicesIncome(Double servicesIncome) {
		this.servicesIncome = servicesIncome;
	}

	public Double getCapitalIncome() {
		return capitalIncome;
	}

	public void setCapitalIncome(Double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}

	public Double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(Double healthSpending) {
		this.healthSpending = healthSpending;
	}

	public Double getEducationSpending() {
		return educationSpending;
	}

	public void setEducationSpending(Double educationSpending) {
		this.educationSpending = educationSpending;
	}
	
	public double salaryTax() {
		double monthIncome = salaryIncome / 12;
		if (monthIncome > 3000 && monthIncome <= 5000) {
			return salaryIncome * 0.1;
		} else if (monthIncome > 5000){
			return salaryIncome * 0.2;
		} else {
			return 0;
		}
	}
	
	public double serviceTax() {
		if (servicesIncome > 0) {
			return servicesIncome * 0.15;
		} else {
			return 0;
		}
	}
	
	public double capitalTax() {
		if (capitalIncome > 0) {
			return capitalIncome * 0.2;
		} else {
			return 0;
		}
	}
	
	public double grossTax() {
		return salaryTax() + serviceTax() + capitalTax();
	}
	
	public double taxRebate() {
		double rebate = healthSpending + educationSpending;
		if (rebate < (grossTax() * 0.3)) {
			return rebate;
		} else {
			return grossTax() * 0.3;
		}
	}
	
	public double netTax() {
		return grossTax() - taxRebate();
	}
	
	public String toString() {
		return String.format("Imposto bruto total: %.2f %nAbatimento: %.2f %nImposto devido: %.2f", grossTax(), taxRebate(), netTax());
	}
}
