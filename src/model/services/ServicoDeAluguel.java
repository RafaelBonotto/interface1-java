package model.services;

import model.entities.AluguelDoVeiculo;
import model.entities.NotaDePagamento;

public class ServicoDeAluguel {

    private Double precoPorDia;
    private Double precoPorHora;

    private TaxaDeServico taxaDeServico;

    public ServicoDeAluguel(Double precoPorDia, Double precoPorHora, TaxaDeServico taxaDeServico) {
        this.precoPorDia = precoPorDia;
        this.precoPorHora = precoPorHora;
        this.taxaDeServico = taxaDeServico;
    }

    public void processarNota(AluguelDoVeiculo aluguelDoVeiculo){
        long t1 = aluguelDoVeiculo.getRetiradaVeiculo().getTime();
        long t2 = aluguelDoVeiculo.getDevolucaoVeiculo().getTime();
        double horas = (double)(t2 - t1) / 1000 / 60 / 60;

        double pagamentoBasico;
        if (horas <= 12.0) {
            pagamentoBasico = Math.ceil(horas) * precoPorHora;
        }
        else {
            pagamentoBasico = Math.ceil(horas / 24) * precoPorDia;
        }

        double taxa = taxaDeServico.taxa(pagamentoBasico);


       aluguelDoVeiculo.setNotaDePagamento(new NotaDePagamento(pagamentoBasico, taxa));
    }
}
