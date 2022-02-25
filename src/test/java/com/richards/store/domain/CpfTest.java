package com.richards.store.domain;

import com.richards.store.domain.entity.Cpf;
import com.richards.store.excepion.InvalidCpfException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CpfTest {

    @Test
    void mustCreateCpfWhenCpfIsValid() throws InvalidCpfException {
        String validCpf = "12345678909";
        Cpf cpf = new Cpf(validCpf);
        Assertions.assertThat(cpf.getCpf()).isEqualTo(validCpf);
    }

    @Test
    void mustCreateCpfWhenCpfIsValidAndHaveSpecialCharacters() throws InvalidCpfException {
        Cpf cpf = new Cpf("123.456.789-09");
        Assertions.assertThat(cpf.getCpf()).isEqualTo("12345678909");
    }

    @Test
    void mustNotCreateCpfAndThrowExceptionWhenCpfIsInvalid() throws InvalidCpfException {;
        Exception exception = assertThrows(InvalidCpfException.class, () -> { new Cpf("12345678988"); });
        Assertions.assertThat(exception.getMessage()).isEqualTo("Invalid CPF.");
    }

    @Test
    void mustNotCreateCpfAndThrowExceptionWhenAllNumbersIsTheSame() throws InvalidCpfException {;
        Exception exception = assertThrows(InvalidCpfException.class, () -> { new Cpf("11111111111"); });
        Assertions.assertThat(exception.getMessage()).isEqualTo("Invalid CPF.");
    }

    @Test
    void mustThrowExceptionWhenCpfHasLengthLessThanEleven() throws InvalidCpfException {;
        Exception exception = assertThrows(InvalidCpfException.class, () -> { new Cpf("123456"); });
        Assertions.assertThat(exception.getMessage()).isEqualTo("Invalid CPF.");
    }

    @Test
    void mustThrowExceptionWhenCpfHasLengthGraterThanEleven() throws InvalidCpfException {;
        Exception exception = assertThrows(InvalidCpfException.class, () -> { new Cpf("123456789091"); });
        Assertions.assertThat(exception.getMessage()).isEqualTo("Invalid CPF.");
    }
}