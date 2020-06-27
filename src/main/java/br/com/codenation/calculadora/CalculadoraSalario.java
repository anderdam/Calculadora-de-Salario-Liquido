package br.com.codenation.calculadora;

public class CalculadoraSalario {

	public int calcularSalarioLiquido(double salarioBase) {

		double salarioMenosINSS = calcSalarioMenosINSS(salarioBase);
		double salarioMenosIRRF = calcSalarioMenosIRRF(salarioMenosINSS);

		if (salarioBase <= 1039.00){
			return (int) 0.0;
		}else{
			return (int) Math.round(salarioMenosIRRF);
		}
	}

	public double calcSalarioMenosINSS(double salarioBase) {

		double salarioMenosINSS = 0.0;

		//If para calcular o valor do salário descontando o INSS
		if (salarioBase <= 1500.00) {
			salarioMenosINSS = salarioBase - (salarioBase * 0.08);
		} else if (salarioBase >= 1500.01 && salarioBase <= 4000.00) {
			salarioMenosINSS = salarioBase - (salarioBase * 0.09);
		} else if (salarioBase >= 4000.01) {
			salarioMenosINSS = salarioBase - (salarioBase * 0.11);
		}
		return salarioMenosINSS;
	}

	public double calcSalarioMenosIRRF(double salarioMenosINSS) {

		double salarioMenosIRRF = 0.0;

		//If para calcular o valor do salário agora descontando o IRRF
		if (salarioMenosINSS <= 3000.00) {
			salarioMenosIRRF = salarioMenosINSS;
		} else if (salarioMenosINSS >= 3000.01 && salarioMenosINSS <= 6000.00) {
			salarioMenosIRRF = salarioMenosINSS - (salarioMenosINSS * 0.075);
		} else if (salarioMenosINSS >= 6000.01) {
			salarioMenosIRRF = salarioMenosINSS - (salarioMenosINSS * 0.15);
		}
		return Math.round(salarioMenosIRRF);
	}
}