package br.com.contmatic.funcionario;


public class ValidacoesFuncionario {
	public static Boolean validaCpf(String cpf) {
		if (cpf.length() != 11 || cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222")
				|| cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555") || cpf.equals("66666666666")
				|| cpf.equals("77777777777") || cpf.equals("88888888888") || cpf.equals("99999999999"))
			return false;

		int digitos[] = new int[11];
		for (int i = 0; i < 11; i++) {
			digitos[i] = Integer.parseInt(cpf.split("")[i]);
		}

		int digitoUm = (digitos[0] * 10) + (digitos[1] * 9) + (digitos[2] * 8) + (digitos[3] * 7) + (digitos[4] * 6)
				+ (digitos[5] * 5) + (digitos[6] * 4) + (digitos[7] * 3) + (digitos[8] * 2);
		if (digitoUm % 11 < 2) {
			digitoUm = 0;
		} else {
			digitoUm = 11 - (digitoUm % 11);
		}

		int digitoDois = (digitos[0] * 11) + (digitos[1] * 10) + (digitos[2] * 9) + (digitos[3] * 8) + (digitos[4] * 7)
				+ (digitos[5] * 6) + (digitos[6] * 5) + (digitos[7] * 4) + (digitos[8] * 3) + (digitoUm * 2);
		if (digitoDois % 11 < 2) {
			digitoDois = 0;
		} else {
			digitoDois = 11 - (digitoDois % 11);
		}
			
		if(digitoUm == digitos[9] && digitoDois == digitos[10])
			return true;
		else
			return false;

	}
}
