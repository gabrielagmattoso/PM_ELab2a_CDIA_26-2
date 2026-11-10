import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

/**
 * Escolha AnalistaDados ou CientistaML e complete 2 testes.
 * Um deles deve obrigatoriamente verificar registrarPagamento.
 */
public class ColaboradorTest {
    @Test
    void exemploEstruturaAaa() {
        AnalistaDados analista = new AnalistaDados("Ana", "A001");
        double horas = analista.addHoraPipeline(1.0);
        assertEquals(0.0, horas, 0.001,
                "este exemplo só ilustra AAA; substitua pelos seus 2 testes");
    }

    @Test 
    public void testeVerificarAddHorasAnalista(){
        AnalistaDados analista = new AnalistaDados("Gabi", "ABC");
        double horas = analista.addHoraPipeline(-1);

        assertEquals(0, horas, "As horas nao contam quando o valor registrado é negativo");

    }

    @Test 
    public void RegistrarPagamentoAnalista(){
        AnalistaDados analista = new AnalistaDados("Gabi", "ABC");
        analista.addHoraPipeline(20);

        assertEquals(analista.registrarPagamento(), 5250, "O pagamento é feito corretamente quando tem bonus");


// essas outras que eu fiz foram para testar se esta tudo ok
    }
    @Test 
    public void TestarValorBonosCientsta(){
        CientistaML cientista = new CientistaML("Duda", "ABD");
        double valor = cientista.registrarPagamento();

        assertEquals(valor, 7800, "Quando nao tem experimentos o SALARIO é dado corretamente");

        Experimento e = new Experimento("01", LocalDate.now());
        cientista.alocarExperimento(e);

        e.finalizar();

        valor = cientista.registrarPagamento();

        assertEquals(valor, 8736, "Quando tem experimento o SALARIO + BONUS é dado corretamente");
    }

    @Test 

    public void TestarExperimetofinalizar(){
        Experimento e = new Experimento("ola", LocalDate.of(2026, 10, 29));

        assertEquals(e.finalizar(), 12 );

    }

    

    // TODO: criar 2 testes unitários (AAA + mensagem na asserção)
    // TODO: um deles deve testar registrarPagamento
}
