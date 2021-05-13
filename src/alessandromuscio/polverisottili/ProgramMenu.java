package alessandromuscio.polverisottili;

import it.unibs.fp.mylib.InputDati;

public class ProgramMenu {
  private static Settimana settimana;
  private static boolean cambio_anno = false;

  private static int inserimentoAnno() {
    int contatore_settimane = Settimana.getContatore_settimane();

    if (contatore_settimane == 1) {
      if (cambio_anno)
        settimana.setAnno(settimana.getAnno() + 1);
      else
        return InputDati.leggiIntero("Inserisci l'anno da cui partire ad inserire i valori: ");
    } else {
      cambio_anno = true;
    }

    return settimana.getAnno();
  }

  private static double[] inserimentoValori() {
    double[] valori_giornalieri = new double[Settimana.getGiorniInUnaSettimana()];

    for (int i = 0; i < Settimana.getGiorniInUnaSettimana(); i++)
      valori_giornalieri[i] = InputDati
          .leggiDoubleConMinimo(String.format("Inserisci il valore del giorno numero %d della settimana numero %d: ",
              (i + 1), Settimana.getContatore_settimane()), 1);

    return valori_giornalieri;
  }

  private static boolean verificaSogliaMassimaSettimanale() {
    double valore_massimo_settimanale = settimana.getMassimoValoreSettimale();

    if (valore_massimo_settimanale > Settimana.getValoreSogliaMassimoSettimanale())
      return true;
    else
      return false;
  }

  private static boolean verificaSogliaMediaSettimanale() {
    double media_settimanale = settimana.getMediaSettimanale();

    if (media_settimanale > Settimana.getValoreSogliaMediaSettimale())
      return true;
    else
      return false;
  }

  public static void gestioneProgramma() {
    int anno;
    double[] valori_giornalieri;

    anno = inserimentoAnno();
    System.out
        .println(String.format("Stai per inserire i valori di polveri sottili della settimana numero %d dell'anno %d",
            Settimana.getContatore_settimane(), anno));

    valori_giornalieri = inserimentoValori();

    settimana = new Settimana(anno, valori_giornalieri);

    if (verificaSogliaMassimaSettimanale())
      System.out.println(String.format(
          "Attenzione! Un valore della settimana appena inserita ha superato la soglia massima consigliata di polveri sottili di %.2f μg/m^3",
          Settimana.getValoreSogliaMassimoSettimanale()));

    if (verificaSogliaMediaSettimanale())
      System.out.println(String.format(
          "Attenzione! La media valori della settimana appena inserita ha superato la soglia massima consigliata di polveri sottili di %.2f μg/m^3",
          Settimana.getValoreSogliaMediaSettimale()));
  }
}
