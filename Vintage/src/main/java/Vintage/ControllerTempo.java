package Vintage;

import Vintage.Transportadoras.Transportadora;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ControllerTempo {

    // Tenta converter a string para LocalDate
    public static boolean dataValida(String dataString, LocalDate now) {;
        LocalDate data = dataConverter(dataString);
        return data.isAfter(now);
    }

    public static LocalDate dataConverter(String dataString){
        LocalDate data = LocalDate.of(2000,1,1);
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
            data = LocalDate.parse(dataString, formatter);
        } catch (Exception e) {
            Menu.errors(24);
            Menu.pressToContinue();
            return data;
        }
        return data;
    }

    public static void run(Vintage vintage){
        boolean exit = false;
        Scanner input = new Scanner(System.in);
        try {
            while (!exit) {
                int opcao = -1;
                while (opcao < 0 || opcao > 3) {
                    opcao = Menu.menuAvancarTempo(vintage);
                }

                switch (opcao) {

                    case 1:
                        Menu.limpaTerminal();
                        vintage.getEstado().setTempoAtual(vintage.getEstado().getTempoAtual().plusDays(1));
                        vintage.getEstado().escreverLog("Data avancou 1 dia. \n");
                        break;

                    case 2:
                        Menu.limpaTerminal();
                        vintage.getEstado().setTempoAtual(vintage.getEstado().getTempoAtual().plusDays(5));
                        vintage.getEstado().escreverLog("Data avancou 5 dias. \n");
                        break;

                    case 3:
                        Menu.limpaTerminal();
                        Menu.menuAvancarData(vintage);
                        break;

                    case 0:
                        exit = true;
                        Menu.limpaTerminal();
                        break;
                }
            }
        }
        catch(java.util.InputMismatchException e){
            Menu.errors(7);
            Menu.pressToContinue();
        }
    }
}
