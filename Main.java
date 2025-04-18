import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        List<Zadanie> zadania = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int id = 0;

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Stwórz zadanie");
            System.out.println("2. Pokaż stan zadań");
            //System.out.println("3. Pokaż wyniki zadań");
            System.out.println("3. Anuluj zadanie");
            System.out.println("0. Wyjdź");

            String wybor = scanner.nextLine();

            switch (wybor) {
                case "1":
                    Zadanie zadanie = new Zadanie(++id);
                    zadania.add(zadanie);
                    zadanie.start();
                    break;

                case "2":
                    for (int i = 0; i < zadania.size(); i++) {
                       Zadanie z = zadania.get(i);
                        z.getStan();
                    }
                    break;

//                case "3":
//                    for (int i = 0; i < zadania.size(); i++) {
//                        Future<Long> f = zadania.get(i);
//                        if (f.isDone() && !f.isCancelled()) {
//                            try {
//                                System.out.println("Zadanie " + i + ": wynik = " + f.get());
//                            } catch (Exception e) {
//                                System.out.println("Zadanie " + i + ": błąd podczas pobierania wyniku.");
//                            }
//                        }
//                    }
//                    break;

                case "3":
                    System.out.print("Podaj indeks zadania do anulowania: ");
                    int idx = Integer.parseInt(scanner.nextLine());
                    if (idx >= 0 && idx < zadania.size()) {
                        boolean czyAnulowane = zadania.get(idx).anuluj();
                        if (czyAnulowane) {
                            System.out.println("Zadanie anulowane");
                        } else {
                            System.out.println("Nie udało się anulować zadania");
                        }
                    } else {
                        System.out.println("Niepoprawny indeks");
                    }
                    break;

                case "0":
                    System.out.println("Zamykanie programu");
                    return;

                default:
                    System.out.println("Nieznana opcja");
            }
        }
    }
}
