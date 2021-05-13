package alessandromuscio.polverisottili;

import it.unibs.fp.mylib.Menu;
import it.unibs.fp.mylib.InputDati;

public class ProgramMenu extends Menu {
  public static void inserimentoValori() {
    int anno, i;
    double[] valori_giornalieri = new double[Settimana.getGiorniInUnaSettimana()];

    anno = InputDati.leggiIntero("Inserisci l'anno da cui partire ad inserire i valori: ");

    for(i=0;i<Settimana.getGiorniInUnaSettimana(); i++)
      valori_giornalieri[i] = InputDati.leggiDoubleConMinimo(String.format("Inserisci il valore del giorno numero %d di questa settimana: ", (i+1)), 0);
  }
}
