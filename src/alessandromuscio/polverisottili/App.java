package alessandromuscio.polverisottili;

import it.unibs.fp.mylib.InputDati;

public class App {
  public static void main(String[] args) throws Exception {
    System.out.println("Benvenuto al programma Polvere Sottili");

    do {
      ProgramMenu.gestioneProgramma();
    } while (InputDati.leggiSiONo("Vuoi inserire una nuova settimana"));
  }
}
