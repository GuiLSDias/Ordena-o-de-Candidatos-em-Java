package application;

import entities.Candidato;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Contest {
    public static void main(String[] args) {

        String path = "C:\\Users\\guidi\\IdeaProjects\\Ordenacao_Java\\dadosConcurso.csv";

        List<Candidato> candidatos = carregarCandidatos(path);

        insertionSort(candidatos);

        for (Candidato c : candidatos) {
            System.out.println(c);
        }
    }

    public static List<Candidato> carregarCandidatos(String fileName) {
        List<Candidato> candidatos = new ArrayList<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String linha;
            boolean primeiraLinha = true;
            while ((linha = br.readLine()) != null) {
                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue;
                }

                String[] dados = linha.split(",");
                String identificador = dados[0];
                String nome = dados[1];
                String dataNascimento = dados[2];
                double nota = Double.parseDouble(dados[3]);

                LocalDate dataNasc = LocalDate.parse(dataNascimento, formatter);

                Candidato candidato = new Candidato(identificador, nome, dataNasc, nota);
                candidatos.add(candidato);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return candidatos;
    }

    public static void insertionSort(List<Candidato> lista) {
        for (int i = 1; i < lista.size(); i++) {
            Candidato chave = lista.get(i);
            int j = i - 1;

            while (j >= 0 && lista.get(j).compareTo(chave) > 0) {
                lista.set(j + 1, lista.get(j));
                j = j - 1;
            }
            lista.set(j + 1, chave);
        }
    }
}
