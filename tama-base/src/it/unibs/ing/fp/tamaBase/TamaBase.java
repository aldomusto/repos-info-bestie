package it.unibs.ing.fp.tamaBase;

public class TamaBase {

	protected static final int MINIMO_VALORI = 0;
	protected static final int MASSIMO_VALORI = 100;

	protected static final int VAL_FELICITA = 80;
	protected static final int VAL_INFELICITA = 30;

	protected int soddisfazione;
	protected int sazieta;
	protected String nome;

	public String toString() {

		StringBuffer messaggio = new StringBuffer();

		messaggio.append(String.format("Stato attuale :"
				+ "\nNome = %s"
				+ "\nSazieta = %d"
				+ "\nSoddisfazione = %d"
				, nome,	sazieta, soddisfazione));

		if (verificaFelicita() || verificaInfelicita()) {
			messaggio.append("Il tamagotchi e' ");
			messaggio.append(verificaFelicita() ? "felice\n" : "");
			messaggio.append(verificaInfelicita() ? "triste\n" : "");
		}
		return messaggio.toString();
	}

	public void daiCarezza(int quante) {

		// diminuisci sazieta'
		if (sazieta - 5 < 1)
			sazieta = 0;
		else
			sazieta -= 5;

		// incrementa soddisfazione
		for (int i = 0; i < quante; i++) {
			if (soddisfazione <= MASSIMO_VALORI)
				soddisfazione += 1;
			if (soddisfazione > MASSIMO_VALORI)
				soddisfazione = MASSIMO_VALORI;
		}

	}

	public void daiBiscotto(int quante) {

		// diminuisci soddisafzione
		if (soddisfazione - 5 < 1)
			soddisfazione = 0;
		else
			soddisfazione -= 5;

		// incrementa sazieta�
		for (int i = 0; i < quante; i++) {
			if (sazieta < MASSIMO_VALORI)
				sazieta += 1;
			if (sazieta > MASSIMO_VALORI)
				sazieta = MASSIMO_VALORI;
		}

	}

	public boolean verificaFelicita() {
		return (sazieta >= VAL_FELICITA && soddisfazione >= VAL_FELICITA);
	}

	public boolean verificaInfelicita() {
		return (sazieta <= VAL_INFELICITA || soddisfazione <= VAL_INFELICITA);
	}

	public boolean contollaParametri() {

		if (sazieta < 1) {
			System.out.print(nome + " e' morto di fame!");
			return false;
		}

		if (soddisfazione < 1) {
			System.out.print(nome + " e' morto per carenza d'affetto!");
			return false;
		}
		return true;
	}

	public void salutoFinale() {
		toString();
		System.out.print("Grazie di aver giocato con me! Alla prossima!");
	}

}
