package br.com.contmatic.empresa;

class EmpresaTest2 {

	public static void main(String[] args) {
		Empresa cont = new Empresa("60872504000123");

		cont.setAreaDeAtuacao("asds");
		
		System.out.println(cont.getAreaDeAtuacao());
	}

}
