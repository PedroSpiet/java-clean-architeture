package br.com.alura.escola.aluno;

import br.com.alura.escola.dominio.aluno.Email;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmailTest {

    @Test
    void naoDeveCriarEmailsInvalidos() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Email(null);
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Email("emailinvalido");
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Email("");
        });
    }

    @Test
    void deveCriarEmailsValidos() {
        Email email = new Email("Pedro@gmail.com");
        Assertions.assertEquals("Pedro@gmail.com", email.getEndereco());
    }
}
