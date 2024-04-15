//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static float rettangolo(float a, float b) {
        return a*b;
    }

    public static String pari(int a) {
        if (a % 2 == 0){
            return a+" è pari";
        } else {
            return a+" è dispari";
        }
    }

    public static float triangolo(float a, float b, float c) {
        float p = a+b+c;
        return (float) Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }

    public static void main(String[] args) {
        System.out.println(rettangolo(7.2f, 9.7f));
        System.out.println(pari(3));
        System.out.println(triangolo(3.2f,5.7f,8.4f));
        }
    }