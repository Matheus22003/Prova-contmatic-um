package br.com.contmatic.empresa;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class FuncionarioTest {
    Funcionario funcionario;

    @BeforeEach
    void setup() {
        funcionario = new Funcionario("42793727806");
    }

    @Test
    void deve_aceitar_nome_valido() {
        funcionario.setNome("Matheus");
        assertThat("Erro ao adicionar nome", funcionario.getNome(), equalTo("Matheus"));
    }

    @Test
    void nao_deve_aceitar_um_nome_contendo_numero_como_caracter() {

        assertThrows(IllegalArgumentException.class, () -> funcionario.setNome("123"));
    }

    @Test
    void nao_deve_aceitar_um_nome_maior_que_80() {
        assertThrows(IllegalArgumentException.class, () -> funcionario.setNome("asdasdgsghasjasdjhasjhasdjhasjhasdgjahdgjhasdgajhsdgjasdghjasdghasjdgajjsjssjsjs"));
    }

    @Test
    void deve_aceitar_dataNascimento_valido() throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        funcionario.setDataNascimento(formato.parse("22/03/2003"));
        assertThat("Erro ao adicionar data de nascimento", formato.format(funcionario.getDataNascimento()), equalTo("22/03/2003"));
    }

    @Test
    void nao_deve_aceitar_dataNascimento_nulo() throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        assertThrows(IllegalArgumentException.class, () -> funcionario.setDataNascimento(formato.parse("22/03/2022")));
    }

    @Test
    void deve_aceitar_cpf_valido() {
        funcionario.setCpf("42793727806");
        assertThat("Erro ao adicionar CPF", funcionario.getCpf(), equalTo("42793727806"));
    }

    @Test
    void nao_deve_aceitar_cpf_falso() {
        assertThrows(IllegalArgumentException.class, () -> funcionario.setCpf("42793727800"));
    }

    @Test
    void nao_deve_aceitar_cpf_com_numero_de_caracteres_diferente_de_11() {
        assertThrows(IllegalArgumentException.class, () -> funcionario.setCpf("4279372234324234237800"));
    }

    @Test
    void deve_aceitar_cargo_valido() {
        funcionario.setCargo("Estagiario");
        assertThat("Erro ao adicionar Cargo", funcionario.getCargo(), equalTo("Estagiario"));
    }

    @Test
    void nao_deve_aceitar_um_cargo_contendo_numero_como_caracter() {
        assertThrows(IllegalArgumentException.class, () -> funcionario.setCargo("23234"));
    }

    @Test
    void nao_deve_aceitar_um_nome_maior_que_90() {
        assertThrows(IllegalArgumentException.class, () -> funcionario.setCargo("asdasdgsghasjasdjhasjhasdjhasjhasdgjahdgjhasdgajhsdgjasdghjasdghasjdgajjsjssjsjsasdasdasda"));
    }

    @Test
    void deve_aceitar_salario_valido() {
        funcionario.setSalario(2000);
        assertThat("Erro ao adicionar Cargo", funcionario.getSalario(), equalTo(2000.00));
    }

    @Test
    void nao_deve_aceitar_um_salario_com_valor_menor_que_1100() {
        assertThrows(IllegalArgumentException.class, () -> funcionario.setSalario(1000));
    }

    @Test
    void deve_mostrar_esse_exato_hashcode() {
        assertThat("Erro ao calcular HashCode", funcionario.hashCode(), equalTo(-617216460));
    }

    @Test
    void deve_mostrar_que_os_dois_funcionarios_de_cpf_iguais_sao_as_mesmas() {
        Funcionario funcionarioTeste = new Funcionario("42793727806");
        assertThat("Erro ao calcular Equal", funcionario.equals(funcionarioTeste), equalTo(true));
    }

    @Test
    void deve_mostrar_que_os_dois_funcionarios_de_cpf_diferentes_sao_as_outra_pessoa() {
        Funcionario funcionarioTeste = new Funcionario("71105099075");
        assertThat("Erro ao calcular Equal", funcionario.equals(funcionarioTeste), equalTo(false));
    }

    @Test
    void deve_retornar_string() {
        assertThat("Erro ao exibir toString", funcionario.toString(), equalTo("Funcionario [nome=null, dataNascimento=null, cpf=42793727806, cargo=null, salario=0.0]"));
    }

}
