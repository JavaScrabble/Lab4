public class Main {
    public static void main(String[] args) throws InterruptedException {
        Zadanie zadanie1 = new Zadanie(1);
        Zadanie zadanie2 = new Zadanie(2);

        zadanie1.start();
        zadanie2.start();

        Thread.sleep(1000);

        System.out.println("Status zadania 1: " + zadanie1.getStan());
        System.out.println("Status zadania 2: " + zadanie2.getStan());

//        zadanie1.anuluj();
        zadanie2.anuluj();

        Thread.sleep(2000);
        System.out.println("Status zadania 1 po anulowaniu: " + zadanie1.getStan());
        System.out.println("Status zadania 2 po anulowaniu: " + zadanie2.getStan());
    }
}
