public class Main {

    public static int moltiplicazione(int a, int b){

        return a*b;
    }

    public static String concatenazione(String a, int b){

        return a+b;
    }

    public static String[] esercizioArray(String[] a, String b){
        String[] nuovoArray={a[0],a[1],a[2],b,a[3],a[4]};
        return nuovoArray;
    }

    public static void main(String[] args) {

        System.out.println(moltiplicazione(5, 7));

        System.out.println(concatenazione("Il numero scelto è ", 9));

        String[] nuovoArray = esercizioArray(new String[]{"ciao", "sono", "Luca", "37", "anni"}, "e ho");
        for (String s : nuovoArray) {
            System.out.println(s);
        }
        }
}