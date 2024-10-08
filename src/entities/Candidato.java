package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Candidato implements Comparable<Candidato> {
    private String identificador;
    private String name;
    private LocalDate dataNascimento;
    private double nota;

    public Candidato(String identificador, String name, LocalDate birthDate, double nota) {
        this.identificador = identificador;
        this.name = name;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataNascimento = LocalDate.parse(birthDate.format(formatter), formatter);
        this.nota = nota;
    }

    public String getIdentificador() {
        return identificador;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return dataNascimento;
    }

    public double getNota() {
        return nota;
    }
    @Override
    public int compareTo(Candidato outro) {
        if (this.nota > outro.nota) {
            return -1;
        } else if (this.nota < outro.nota) {
            return 1;
        } else {
            return this.dataNascimento.compareTo(outro.dataNascimento);
        }
    }

    @Override
    public String toString() {
        return identificador + " - " + name + " - " + dataNascimento + " - Nota: " + nota;
    }
}
