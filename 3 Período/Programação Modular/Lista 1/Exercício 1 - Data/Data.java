
public class Data {

	private int dia;
	private int mes;
	private int ano;
	
	Data(){
		this.dia = 1;
		this.mes = 1;
		this.ano = 2022; // 1 de janeiro de 2022 == Sábado
	}
	
	Data(int dia, int mes, int ano){
		this.dia = dia;
		this.mes = mes;
		this.ano = ano; 
	}
	
	public int getDia() {
		return dia;
	}

	private void setDia(int dia) {
		this.dia = dia;
		formatarData();
	}

	public int getMes() {
		return mes;
	}

	private void setMes(int mes) {
		this.mes = mes;
		formatarData();
	}

	public int getAno() {
		return ano;
	}

	private void setAno(int ano) {
		this.ano = ano;
		formatarData();
	}
	
	public int diasNoMes(int mes) {
		int dias = 0;
		if (mes > 8) {
			if (mes % 2 == 0) {
				dias = 31;
			} else {
				dias = 30;
			}
		} else {
			if (mes % 2 == 0) {
				if (mes == 2) {
					if (eAnoBissexto(this.ano) == true) {
						dias = 29;
					} else {
						dias = 28;
					}
				}
				dias = 30;
			} else {
				dias = 31;
			}
		}
		return dias;
	}
	
	public void formatarData() {

		while (dia >= diasNoMes(this.mes)) {
			dia -= diasNoMes(this.mes);
			mes++;
		}

		while (mes >= 12) {
			mes -= 12;
			ano++;
		}
	}
	
	public void adicionarDias(int dias)
	{
		int novoDia = this.dia + dias;
		setDia(novoDia);
		
	}
	
	public String diaDaSemana(int dia) {
		int diaNaSemana = (dia % 7);
		String diaDaSemana = "";
		switch (diaNaSemana) {
		case 1:
			diaDaSemana = "Sabado";
			break;
		case 2:
			diaDaSemana = "Domingo";
			break;
		case 3:
			diaDaSemana = "Segunda-Feira";
			break;
		case 4:
			diaDaSemana = "Terca-Feira";
			break;
		case 5:
			diaDaSemana = "Quarta-Feira";
			break;
		case 6:
			diaDaSemana = "Quinta-Feira";
			break;
		case 7:
			diaDaSemana = "Sexta-Feira";
			break;
		default:
			break;
		}
		return diaDaSemana;
	}
	
	public boolean eAnoBissexto(int ano) {
		boolean anoBissexto = false;

		if (ano % 4 == 0) {
			if (ano % 100 == 0) {
				if (ano % 400 == 0) {
					anoBissexto = true;
				}
			} else {
				anoBissexto = true;
			}
		}

		return anoBissexto;
	}
	
	public void proximoDia() {
		setDia(this.dia + 1);
	}
	
	public String mesDoAno(int mes) {
		String mesAno = "";
		switch (mes) {
		case 1:
			mesAno = "Janeiro";
			break;
		case 2:
			mesAno = "Fevereiro";
			break;
		case 3:
			mesAno = "Marco";
			break;
		case 4:
			mesAno = "Abril";
			break;
		case 5:
			mesAno = "Maio";
			break;
		case 6:
			mesAno = "Junho";
			break;
		case 7:
			mesAno = "Julho";
			break;
		case 8:
			mesAno = "Agosto";
			break;
		case 9:
			mesAno = "Setembro";
			break;
		case 10:
			mesAno = "Outubro";
			break;
		case 11:
			mesAno = "Novembro";
			break;
		case 12:
			mesAno = "Dezembro";
			break;
		default:
			break;
		}
		return mesAno;
	}
	
	public String dataPorExtenso()
	{
		return diaDaSemana(dia) + " " + dia + " de " + mesDoAno(mes) + " de " + ano;
	}
	
}
