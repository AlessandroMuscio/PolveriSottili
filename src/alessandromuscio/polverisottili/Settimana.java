package alessandromuscio.polverisottili;

public class Settimana {
  private static final double VALORE_SOGLIA_GIORNO = 75;
  private static final double VALORE_SOGLIA_MEDIA_SETTIMALE = 50;
  private static final int GIORNI_IN_UNA_SETTIMANA = 7;
  private int anno;
  private static final int MASSIMO_SETTIMANE_IN_ANNO = 53;
  private static int contatore_settimane = 0;
  private int settimana;
  private double[] valori_giornalieri = new double[GIORNI_IN_UNA_SETTIMANA];

  public Settimana(int anno, double[] valori_giornalieri) {
    this.anno = anno;

    if (contatore_settimane != MASSIMO_SETTIMANE_IN_ANNO)
      contatore_settimane++;
    else
      contatore_settimane = 1;

    settimana = contatore_settimane;
    this.valori_giornalieri = valori_giornalieri;
  }

  public static double getValoreSogliaGiorno() {
    return VALORE_SOGLIA_GIORNO;
  }

  public static double getValoreSogliaMediaSettimale() {
    return VALORE_SOGLIA_MEDIA_SETTIMALE;
  }

  public static int getGiorniInUnaSettimana() {
    return GIORNI_IN_UNA_SETTIMANA;
  }

  public int getAnno() {
    return anno;
  }

  public static int getMassimoSettimaneInAnno() {
    return MASSIMO_SETTIMANE_IN_ANNO;
  }

  public int getSettimana() {
    return settimana;
  }

  public double[] getValori_giornalieri() {
    return valori_giornalieri;
  }

  public void setAnno(int anno) {
    this.anno = anno;
  }

  public void setSettimana(int settimana) {
    this.settimana = settimana;
  }

  public void setValori_giornalieri(double[] valori_giornalieri) {
    this.valori_giornalieri = valori_giornalieri;
  }

  public double getMassimoValoreSettimale() {
    double massimo = valori_giornalieri[0];

    for (int i = 1; i < GIORNI_IN_UNA_SETTIMANA; i++)
      if (valori_giornalieri[i] > massimo)
        massimo = valori_giornalieri[i];

    return massimo;
  }

  public double getMediaSettimanale() {
    double sommatoria = valori_giornalieri[0];

    for (int i = 1; i < GIORNI_IN_UNA_SETTIMANA; i++)
      sommatoria += valori_giornalieri[i];

    return (sommatoria / GIORNI_IN_UNA_SETTIMANA);
  }
}
