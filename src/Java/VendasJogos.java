package Java;

public class VendasJogos {
	public String nome;
	public String ano;
	public Double globalSales;
	
	
	public VendasJogos(String nome, String ano, Double globalSales) {
		this.nome = nome;
		this.ano = ano;
		this.globalSales = globalSales;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getAno() {
		return ano;
	}


	public void setAno(String ano) {
		this.ano = ano;
	}


	public Double getGlobalSales() {
		return globalSales;
	}


	public void setGlobalSales(Double globalSales) {
		this.globalSales = globalSales;
	}


	@Override
	public String toString() {
		return "VendasJogos [nome=" + nome + ", ano=" + ano + ", globalSales=" + globalSales + "]";
	}
	
}
