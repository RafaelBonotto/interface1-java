package model.entities;

import java.util.Date;

public class AluguelDoVeiculo {

    private Date retiradaVeiculo;
    private Date devolucaoVeiculo;

    private Veiculo veiculo;
    private NotaDePagamento notaDePagamento;

    public AluguelDoVeiculo(){
    }

    public AluguelDoVeiculo(Date retiradaVeiculo, Date devolucaoVeiculo, Veiculo veiculo) {
        this.retiradaVeiculo = retiradaVeiculo;
        this.devolucaoVeiculo = devolucaoVeiculo;
        this.veiculo = veiculo;
    }

    public Date getRetiradaVeiculo() {
        return retiradaVeiculo;
    }

    public void setRetiradaVeiculo(Date retiradaVeiculo) {
        this.retiradaVeiculo = retiradaVeiculo;
    }

    public Date getDevolucaoVeiculo() {
        return devolucaoVeiculo;
    }

    public void setDevolucaoVeiculo(Date devolucaoVeiculo) {
        this.devolucaoVeiculo = devolucaoVeiculo;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public NotaDePagamento getNotaDePagamento() {
        return notaDePagamento;
    }

    public void setNotaDePagamento(NotaDePagamento notaDePagamento) {
        this.notaDePagamento = notaDePagamento;
    }
}
