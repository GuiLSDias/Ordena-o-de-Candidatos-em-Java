# Ordenação de Candidatos

Esta aplicação em Java carrega dados de candidatos a partir de um arquivo CSV e os ordena de acordo com suas notas em um concurso. O critério de desempate é baseado na data de nascimento, classificando a pessoa mais velha em primeiro lugar em caso de notas iguais. A ordenação é feita utilizando o algoritmo de Insertion Sort.

## Funcionalidades

- **Carregamento de dados CSV**: A aplicação lê os candidatos a partir de um arquivo CSV com as colunas `Identificador`, `Nome`, `Data de Nascimento` e `Nota`.
- **Ordenação personalizada**: Os candidatos são ordenados por nota de forma decrescente. Em caso de empate nas notas, o candidato mais velho tem prioridade.
- **Algoritmo de Insertion Sort**: Implementação do algoritmo de Insertion Sort para ordenar os candidatos de acordo com o critério mencionado.

## Estrutura do Projeto

### 1. `Candidato.java`
Classe que representa um candidato no concurso. Implementa a interface `Comparable` para definir o critério de comparação entre dois candidatos.

- **Atributos**:
  - `identificador`: Identificador do candidato (String).
  - `nome`: Nome completo do candidato (String).
  - `dataNascimento`: Data de nascimento do candidato (LocalDate).
  - `nota`: Nota obtida no concurso (double).

- **Método `compareTo(Candidato outro)`**:
  - Compara dois candidatos primeiro pela nota (em ordem decrescente).
  - Em caso de empate na nota, compara pela idade (o mais velho fica melhor classificado).

### 2. `Contest.java`
Classe principal da aplicação, responsável por carregar os candidatos do arquivo CSV, ordená-los e exibir o resultado.

- **Métodos**:
  - `carregarCandidatos(String fileName)`: Lê o arquivo CSV e cria uma lista de objetos `Candidato`.
  - `insertionSort(List<Candidato> lista)`: Implementa o algoritmo de Insertion Sort para ordenar a lista de candidatos.
  - `main(String[] args)`: Ponto de entrada da aplicação. Carrega os candidatos, aplica a ordenação e exibe os resultados.

