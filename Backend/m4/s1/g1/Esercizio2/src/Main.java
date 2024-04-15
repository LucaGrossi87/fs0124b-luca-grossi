public class Main {
    public static String concatenazione(String a, String b, String c){
        String[] arr = {a, b, c};
        String risultante = arr[0]+" "+arr[1]+" "+arr[2];
        String inverso = "";
        for (int i = arr.length-1; i >= 0 ; i--) {
        inverso += arr[i]+" ";
        }
        return risultante + " " + inverso;
    }
    public static void main(String[] args) {
            System.out.println(concatenazione("Non","C'è", "Provare"));
        }
    }