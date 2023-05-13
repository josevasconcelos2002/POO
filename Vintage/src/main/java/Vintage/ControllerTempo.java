package Vintage;

import Vintage.Transportadoras.Transportadora;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ControllerTempo {

    public static boolean dataValida(String dataString, LocalDate now) {;
        LocalDate data;
        try {
            // Tenta converter a string para LocalDate
            DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
            data = LocalDate.parse(dataString, formatter);
        } catch (Exception e) {
            return false;
        }

        return data.isAfter(now);
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
                        vintage.getEstado().escreverLog("Data avançou 1 dia. \n");
                        break;

                    case 2:
                        Menu.limpaTerminal();
                        vintage.getEstado().setTempoAtual(vintage.getEstado().getTempoAtual().plusDays(5));
                        vintage.getEstado().escreverLog("Data avançou 5 dias. \n");
                        break;

                    case 3:
                        Menu.limpaTerminal();
                        Menu.menuAvancarData(vintage);
                        break;

                    case 0:
                        exit = true;
                        Menu.limpaTerminal();
                        Menu.menuPrincipal(vintage);

                }
            }
        }
        catch(java.util.InputMismatchException e){
            Menu.errors(7);
        }
    }
}
