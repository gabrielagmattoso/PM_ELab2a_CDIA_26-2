import java.util.ArrayList;
import java.util.List;

/** Cientista de ML (PJ): salário base + bônus por experimentos finalizados recentemente. */
public class CientistaML extends Colaborador {
    private static final double SALARIO = 7800.0;
    private static final double BONUS = 12.0 / 100.0;
    private static final int TEMPO_BONUS = 45;

    private List<Experimento> experimentos;

    public CientistaML(String nome, String registro) {
        super(nome, registro);
        this.experimentos = new ArrayList<>();
    }

    /**
     * Soma SALARIO × BONUS para cada experimento finalizado
     * há no máximo TEMPO_BONUS dias (diasAposFinalizacao entre 0 e TEMPO_BONUS, inclusive).
     */
    private double valorBonus() {
        double valor = 0;
        for(Experimento e: this.experimentos){
            if(e.diasAposFinalizacao() >=0 && e.diasAposFinalizacao() < TEMPO_BONUS){
                valor += SALARIO*BONUS;
            }
        }
        // TODO: percorrer experimentos e acumular o bônus dos elegíveis
        return valor;
    }

    /**
     * Aloca um experimento se não houver nenhum não finalizado.
     * @return quantidade após a alocação, ou -1 se não foi possível
     */
    public int alocarExperimento(Experimento experimento) {
        for (Experimento e : experimentos) {
            if (e.diasAposFinalizacao() == -1) return -1;
        }
        experimentos.add(experimento);
        return experimentos.size();
    }

    /** Pagamento = salário base + valorBonus(); guardar em ultimoPagamento. */
    @Override
    public double registrarPagamento() {
        this.ultimoPagamento = SALARIO + valorBonus();
        // TODO: calcular total, armazenar em ultimoPagamento e devolver
        return this.ultimoPagamento;
    }

    @Override
    public String toString() {
        return "CientistaML " + super.toString() + " | experimentos=" + experimentos.size();
    }
}
