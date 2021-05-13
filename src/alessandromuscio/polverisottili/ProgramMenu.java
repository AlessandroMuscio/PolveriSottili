package alessandromuscio.polverisottili;

import it.unibs.fp.mylib.Menu;
import it.unibs.fp.mylib.InputDati;

public class ProgramMenu extends Menu {
  public static void inserimentoValori() {
    int i;
    double[] valori_giornalieri = new double[Settimana.getGiorniInUnaSettimana()];

    for(i=0;i<Settimana.getGiorniInUnaSettimana(); i++)
      valori_giornalieri[i] = I;
  }
}
