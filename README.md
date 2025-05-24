# 🦷 Sistema de Consultório Odontológico em Java

Este projeto é um sistema de gestão simples para consultórios odontológicos, desenvolvido com **Java puro** e utilizando os **principais conceitos da Programação Orientada a Objetos (POO)**.

---

## 🎯 Objetivo

Este projeto tem como objetivo praticar e demonstrar conceitos fundamentais de POO, como:

- **Encapsulamento** – Controle de acesso aos atributos por meio de métodos.
- **Herança** – Reutilização de atributos e comportamentos comuns.
- **Polimorfismo** – Métodos sobrescritos com comportamentos diferentes.
- **Abstração** – Criação de estruturas genéricas que servem de base para especializações.

---

## 🚀 Funcionalidades

- ✅ Cadastro de **pacientes** com plano *individual* ou *familiar*
- ✅ Adição de **dependentes** ao plano familiar
- ✅ Registro de **dentistas** com suas especialidades
- ✅ Registro e execução de **procedimentos odontológicos**
- ✅ Controle de **fatura** do paciente (mensalidade + procedimentos avulsos)
- ✅ Sistema de **avaliação de atendimento**
- ✅ Cálculo de **salário e bônus** para **recepcionistas** e **dentistas**

---

## 📦 Estrutura de Classes

- `Pessoa` (classe abstrata base para `Paciente` e `Funcionario`)
- `Paciente` (plano, dependentes, fatura, avaliação)
- `Funcionario` (classe abstrata base para `Dentista` e `Recepcionista`)
- `Dentista` (especialidade, procedimentos, bônus por atendimento)
- `Recepcionista` (registro de pacientes, salário baseado em avaliações)
- `Procedimento` (informações sobre serviços odontológicos)
- `Programa` (classe principal com exemplos de uso)

---

## 🛠️ Tecnologias Utilizadas

- Linguagem: **Java**
- Paradigma: **POO (Programação Orientada a Objetos)**

---

## 💡 Exemplo de Uso (console)

```java
Dentista d1 = new Dentista();
// define nome, CPF, especialidade, etc.

Paciente p1 = new Paciente();
// define plano, adiciona dependentes...

d1.realizarProcedimento(p1, procedimento);
// paciente realiza atendimento

p1.checarFatura();
// verifica valor da fatura no console

p1.darNotaAtendimento(4);
// paciente avalia o atendimento

Recepcionista r1 = new Recepcionista();
// calcula salário com base nas notas recebidas
r1.receberSalario();

## 📽️ Tutorial em Vídeo
https://youtu.be/KtB1OzYTBRE

## 📘 Licença
Este projeto é de livre uso para fins educacionais.

Feito com 💙 e ☕ por [Felipe Silva]
