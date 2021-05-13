package alessandromuscio.polverisottili;

import java.util.Date;
import java.util.Calendar;

import it.unibs.fp.mylib.InputDati;

public class ProgramMenu {
  private static int anno_corrente = getAnnoCorrente();
  private static Settimana settimana;
  private static boolean cambio_anno = false;

  private static int getAnnoCorrente() {
    Calendar calendario = Calendar.getInstance();
    calendario.setTime(new Date());

    return calendario.get(Calendar.YEAR);
  }

  private static int inserimentoAnno() {
    int contatore_settimane = Settimana.getContatore_settimane();

    if (contatore_settimane == 1) {
      if (cambio_anno)
        settimana.setAnno(settimana.getAnno() + 1);
      else
        return InputDati.leggiInteroCompreso(OutputStringhe.INSERIMENTO_ANNO, 0, anno_corrente);
    } else {
      cambio_anno = true;
    }

    return settimana.getAnno();
  }

  private static double[] inserimentoValori() {
    double[] valori_giornalieri = new double[Settimana.getGiorniInUnaSettimana()];

    for (int i = 0; i < Settimana.getGiorniInUnaSettimana(); i++)
      valori_giornalieri[i] = InputDati.leggiDoubleConMinimo(
          String.format(OutputStringhe.INSERIMENTO_VALORE, (i + 1), Settimana.getContatore_settimane()), 1);

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
        .println(String.format(OutputStringhe.INFORMAZIONI_GIORNO_SETTIMANA, Settimana.getContatore_settimane(), anno));

    valori_giornalieri = inserimentoValori();

    settimana = new Settimana(anno, valori_giornalieri);

    if (verificaSogliaMassimaSettimanale())
      System.out.println(String.format(OutputStringhe.MESSAGGIO_SUPERAMENTO_SOGLIA_MASSIMA_GIORNO,
          Settimana.getValoreSogliaMassimoSettimanale()));

    if (verificaSogliaMediaSettimanale())
      System.out.println(String.format(OutputStringhe.MESSAGGIO_SUPERAMENTO_SOGLIA_MEDIA_SETTIMANALE,
          Settimana.getValoreSogliaMediaSettimale()));
  }
}
