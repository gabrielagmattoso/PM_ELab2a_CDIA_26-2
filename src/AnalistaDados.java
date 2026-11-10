/** Analista de dados (CLT): salário base + horas de pipeline. */
public class AnalistaDados extends Colaborador {
    private static final double SALARIO = 4200.0;
    private static final double FRACAO_HORA = 1.0 / 80.0;
    private static final int MAX_HORAS = 35;

    private double horasPipeline;

    public AnalistaDados(String nome, String registro) {
        super(nome, registro);
        this.horasPipeline = 0.0;
    }

    private double valorHorasPipeline() {
        return horasPipeline * SALARIO * FRACAO_HORA;
    }

    /**
     * Acrescenta horas de pipeline, respeitando o máximo mensal.
     * @return a quantidade efetiva de horas após a operação
     */
    public double addHoraPipeline(double quantidade) {

        if (quantidade <= 0){
            return this.horasPipeline;
        }
        else if(this.horasPipeline+quantidade == MAX_HORAS){
            return this.horasPipeline = MAX_HORAS;
        }
        return this.horasPipeline += quantidade;
        // TODO: se quantidade <= 0, não altera e devolve horasPipeline atual
        // TODO: soma quantidade, sem ultrapassar MAX_HORAS; devolve o novo total
    }

    /**
     * Pagamento = salário base + valor das horas de pipeline.
     * Após o pagamento, as horas devem ser zeradas e o total guardado em ultimoPagamento.
     */
    @Override
    public double registrarPagamento() {
        this.ultimoPagamento = SALARIO + valorHorasPipeline();
        this.horasPipeline = 0;
        return this.ultimoPagamento;

        // TODO: calcular total, armazenar, zerar horasPipeline e devolver
        
    }

    @Override
    public String toString() {
        return "AnalistaDados " + super.toString() + " | horasPipeline=" + horasPipeline;
    }
}
