package alessandromuscio.polverisottili;

import it.unibs.fp.mylib.InputDati;

public class App {
  public static void main(String[] args) throws Exception {
    System.out.println(OutputStringhe.MESSAGGIO_BENVENUTO);

    do {
      ProgramMenu.gestioneProgramma();
    } while (InputDati.leggiSiONo(OutputStringhe.CONTINUAZIONE_INSERIMENTO));
  }
}
