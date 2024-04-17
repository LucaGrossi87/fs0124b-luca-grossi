package it.epicode.be.ex2;

public class Sim {
    private String phoneNum;
    private int credit;
    private String[] lastCalls = new String[5];
    int[] lastDur = new int[]{};

    public Sim (String phoneNum){
        this.phoneNum = phoneNum;
        this.credit = 0;
        this.lastCalls = new String[]{};
        this.lastDur=new int[]{};
    };

    private String callsList (){
        lastCalls = new String[]{"11111111", "22222222", "33333333", "444444444", "555555555"};
        int[] lastDur = new int[]{7, 5, 14, 22, 9};
        String[] lasts = new String[5];
        for (int i = 0; i < lastCalls.length; i++) {
            lasts[i]=lastCalls[i] + ", " + lastDur[i] + "min.";
        }
        return String.join("; ", lasts);
    };

    public String datiDim() {
        return "il numero " + phoneNum + " ha " + credit + "€ di credito residuo. Le ultime chiamate effettuate sono: " + callsList();
    }
}
