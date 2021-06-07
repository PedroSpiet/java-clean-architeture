package br.com.alura.escola.aluno;

import br.com.alura.escola.dominio.aluno.Telefone;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TelefoneTest {

    @Test
    void invalidDDD() {
        assertThrows(IllegalArgumentException.class, () -> new Telefone(null, "123456789"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("", "123456789"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("1", "123456789"));

    }

    @Test
    void invalidTelephone() {
        assertThrows(IllegalArgumentException.class, () -> new Telefone("13", ""));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("13", null));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("13", "1111"));
    }

    @Test
    void validTelephoneAndDDD() {
        String ddd = "13";
        String numero = "112233445";
        Telefone telefone = new Telefone(ddd, numero);
        assertEquals(ddd, telefone.getDdd());
        assertEquals(numero, telefone.getNumero());
    }

}
