
public class Aplicacao {

	public static void main(String[] args) {
		
		Data data1 = new Data();
		Data data2 = new Data(8,10,2002);
		
		
		System.out.println("Conta com inicializador padrão");
		System.out.println("-------------------------------------------");
		System.out.println("Dia da conta 1: " +  data1.getDia());
		System.out.println("Mes da conta 1: " +  data1.getMes());
		System.out.println("Ano da conta 1: " +  data1.getAno());
		System.out.println("Dias no mes: " +  data1.diasNoMes(data1.getMes()));
		data1.adicionarDias(12);
		System.out.println("Dia da conta 1 após adição: " +  data1.getDia());
		System.out.println("Dia da semana da conta 1: " +  data1.diaDaSemana(data1.getDia()));
		System.out.println("Ano da conta 1 é bissexto: " +  data1.eAnoBissexto(data1.getAno()));
		data1.proximoDia();
		System.out.println("Dia seguinte da conta 1: " +  data1.getDia());
		System.out.println("Mes da conta 1 por extenso: " +  data1.mesDoAno(data1.getMes()));
		System.out.println("Data da conta 1 por extenso: " +  data1.dataPorExtenso());
		System.out.println("-------------------------------------------");
		System.out.println("Conta com inicializador com parâmetros");
		System.out.println("-------------------------------------------");
		System.out.println("Dia da conta 2: " +  data2.getDia());
		System.out.println("Mes da conta 2: " +  data2.getMes());
		System.out.println("Ano da conta 2: " +  data2.getAno());
		System.out.println("Dias no mes da conta 2: " +  data2.diasNoMes(data2.getMes()));
		data2.adicionarDias(18);
		System.out.println("Dia da conta 2 após adição: " +  data2.getDia());
		System.out.println("Dia da semana da conta 2: " +  data2.diaDaSemana(data2.getDia()));
		System.out.println("Ano da conta 2 é bissexto: " +  data2.eAnoBissexto(data2.getAno()));
		data2.proximoDia();
		System.out.println("Dia seguinte da conta 2: " +  data1.getDia());
		System.out.println("Mes da conta 2 por extenso: " +  data2.mesDoAno(data2.getMes()));
		System.out.println("Data da conta 2 por extenso: " +  data2.dataPorExtenso());
		System.out.println("-------------------------------------------");
		
	}

}
