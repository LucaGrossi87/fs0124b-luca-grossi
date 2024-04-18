package it.epicode.be.ex3;

public class Main {
    public static void main(String[] args){

        DipendenteFullTime dipFull1 = new DipendenteFullTime("6874321", 1567.89, Dipendente.Dipartimento.PRODUZIONE);
        DipendenteFullTime dipFull2 = new DipendenteFullTime("4234586", 1485.36, Dipendente.Dipartimento.VENDITE);
        DipendenteFullTime dipFull3 = new DipendenteFullTime("8745545", 1623.14, Dipendente.Dipartimento.PRODUZIONE);

        DipendentePartTime dipPart1 = new DipendentePartTime("1276855", 9.50, Dipendente.Dipartimento.VENDITE, 80);
        DipendentePartTime dipPart2 = new DipendentePartTime("6542318", 9.50, Dipendente.Dipartimento.PRODUZIONE, 75);
        DipendentePartTime dipPart3 = new DipendentePartTime("8435788", 9.50, Dipendente.Dipartimento.VENDITE, 90);

        Dirigente dirig1=new Dirigente("1234", 4658.39, Dipendente.Dipartimento.AMMINISTRAZIONE);
        Dirigente dirig2=new Dirigente("1235", 5469.53, Dipendente.Dipartimento.AMMINISTRAZIONE);
        Dirigente dirig3=new Dirigente("1236", 6254.96, Dipendente.Dipartimento.AMMINISTRAZIONE);

        Dipendente[] dipArr = {
            dipFull1,dipFull2,dipFull3,dipPart1,dipPart2,dipPart3,dirig1,dirig2,dirig3
        };

        double totSalary=0.0;

        for (Dipendente dip:dipArr){
            if (dip instanceof DipendenteFullTime){
                totSalary+=((DipendenteFullTime) dip).calculateSalary();
            } else if (dip instanceof DipendentePartTime) {
                totSalary += ((DipendentePartTime) dip).calculateSalary();
            }
                else if (dip instanceof Dirigente){
                    totSalary+=((Dirigente) dip).calculateSalary();
                }
            }
        System.out.println(totSalary);
        }
    }
