package br.com.contmatic.empresa;

public class ValidacoesEmpresa {
	private int div(int dividendo, int divisor) {
		return (int) Math.round(dividendo - (Math.floor(dividendo / divisor) * divisor));
	}

	public boolean valdiaCnpj(String eCnpj) {
		if (eCnpj == null || eCnpj.equals("") || eCnpj.equals(" ") || eCnpj.equals("00000000000000")
				|| eCnpj.equals("11111111111111") || eCnpj.equals("22222222222222") || eCnpj.equals("33333333333333")
				|| eCnpj.equals("44444444444444") || eCnpj.equals("55555555555555") || eCnpj.equals("66666666666666")
				|| eCnpj.equals("77777777777777") || eCnpj.equals("88888888888888") || eCnpj.equals("99999999999999")
				|| (eCnpj.length() != 14)) {
			return false;
		}

		int digitos[] = new int[14];
		for (int i = 0; i < 14; i++) {
			digitos[i] = Integer.parseInt(eCnpj.split("")[i]);
		}

		int digitoUm = digitos[11] * 2 + digitos[10] * 3 + digitos[9] * 4 + digitos[8] * 5 + digitos[7] * 6
				+ digitos[6] * 7 + digitos[5] * 8 + digitos[4] * 9 + digitos[3] * 2 + digitos[2] * 3 + digitos[1] * 4
				+ digitos[0] * 5;

		digitoUm = 11 - (div(digitoUm, 11));

		if (digitoUm >= 10) {
			digitoUm = 0;
		}

		int digitoDois = digitoUm * 2 + digitos[11] * 3 + digitos[10] * 4 + digitos[9] * 5 + digitos[8] * 6
				+ digitos[7] * 7 + digitos[6] * 8 + digitos[5] * 9 + digitos[4] * 2 + digitos[3] * 3 + digitos[2] * 4
				+ digitos[1] * 5 + digitos[0] * 6;

		digitoDois = 11 - (div(digitoDois, 11));

		if (digitos[12] == digitoUm && digitos[13] == digitoDois)
			return true;
		else
			return false;

	}
}
