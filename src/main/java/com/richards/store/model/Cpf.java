package com.richards.store.model;

import com.richards.store.excepion.InvalidCpfException;

public class Cpf {

    private final Integer CPF_LENGTH = 11;
    private String cpf;

    public Cpf(String cpf) throws InvalidCpfException {
        this.cpf = getValidatedCpf(cpf);
    }

    public String getCpf() { return this.cpf; }

    private String getValidatedCpf(String cpf) throws InvalidCpfException {
        if (!hasValidFormat(cpf)) throw new InvalidCpfException("Invalid CPF.");

        String formattedCpf = getFormattedCpf(cpf);
        String cpfWithExpectedCheckDigits = getCpfWithExpectedCheckDigits(formattedCpf);

        if (!cpfWithExpectedCheckDigits.equals(formattedCpf)) throw new InvalidCpfException("Invalid CPF.");
        return formattedCpf;
    }

    private String getCpfWithExpectedCheckDigits(String formattedCpf) {
        String providedCpfWithoutCheckDigits = formattedCpf.substring(0, 9);
        String cpfWithFirstCheckDigit = getCpfWithNextCheckDigit(providedCpfWithoutCheckDigits);
        String cpfWithTwoCheckDigits = getCpfWithNextCheckDigit(cpfWithFirstCheckDigit);
        return cpfWithTwoCheckDigits;
    }

    private String getCpfWithNextCheckDigit(String formattedCpf) {
        int sumOfDigits = 0;
        for (int index = 0; index < formattedCpf.length(); index++) {
            int digit = Integer.parseInt(String.valueOf(formattedCpf.charAt(index)));
            sumOfDigits += (formattedCpf.length() + 1 - index) * digit;
        }
        int restOfDivision = sumOfDigits % CPF_LENGTH;
        int checkDigit = restOfDivision < 2 ? 0 : 11 - restOfDivision;
        return formattedCpf + checkDigit;
    }

    private Boolean hasValidFormat(String cpf) {
        if (cpf == null || cpf.isBlank()) return false;
        if (getFormattedCpf(cpf).length() != CPF_LENGTH) return false;
        if (isAllDigitsTheSame(getFormattedCpf(cpf))) return false;
        return true;
    }

    private String getFormattedCpf(String cpf) { return cpf.replaceAll("[.# -]", ""); }

    private Boolean isAllDigitsTheSame(String cpf) { return getFormattedCpf(cpf).chars().allMatch(c -> c == cpf.charAt(0)); }
}
