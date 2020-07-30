package application;


import model.entities.AluguelDoVeiculo;
import model.entities.Veiculo;
import model.services.ServicoDeAluguel;
import model.services.TaxaServicoBrazil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        System.out.println("Entre com os dados da locação: ");
        System.out.print("Modelo do Veiculo: ");
        String modeloVeiculo = sc.nextLine();
        System.out.print("Data e Hora da Retirada (dd/MM/yyyy HH:mm): ");
        Date retirada = sdf.parse(sc.nextLine());
        System.out.print("Data e Hora da Devolução (dd/MM/yyyy HH:mm): ");
        Date devolucao  = sdf.parse(sc.nextLine());

        AluguelDoVeiculo av = new AluguelDoVeiculo(retirada, devolucao, new Veiculo(modeloVeiculo));

        System.out.print("Entre com o preço por hora: ");
        double precoPorHora = sc.nextDouble();
        System.out.print("Entre com o preço por dia: ");
        double precoPorDia = sc.nextDouble();

        ServicoDeAluguel servicoDeAluguel = new ServicoDeAluguel(precoPorDia, precoPorHora, new TaxaServicoBrazil());

        servicoDeAluguel.processarNota(av);

        System.out.println("N O T A: ");
        System.out.println("Pagamento Básico: " + String.format("%.2f", av.getNotaDePagamento().getPagamentoBasico()));
        System.out.println("Taxa: " + String.format("%.2f", av.getNotaDePagamento().getTaxa()));
        System.out.println("Pagamento Total: " + String.format("%.2f", av.getNotaDePagamento().getPagamentoTotal()));




        sc.close();

    }
}
