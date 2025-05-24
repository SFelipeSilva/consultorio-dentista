package consultorio_dentista;

public class Programa {

    public static void main(String[] args) {
        
        //  Criando um dentista
        Dentista dentista = new Dentista();
        dentista.setNome("Dr. Carlos");
        dentista.setCpf("123.456.789-00");
        dentista.setTelefone("(11) 91234-5678");
        dentista.setEmail("carlos.dentista@email.com");
        dentista.setSexo('M');
        dentista.setIdade(45);
        dentista.setEspecialidade("Ortodontia");
        dentista.setCro("CRO12345");
        dentista.setSalarioBase(5000.0);
        dentista.setSalario(5000.0);
        dentista.setTurno("Manhã");

        // Criando um procedimento
        Procedimento limpeza = new Procedimento(1, "Limpeza", 200.0);

        // Dentista é treinado para o procedimento
        dentista.adicionarProcedimentoTreinados(limpeza);

        System.out.println("\n--- Dados do Dentista ---");
        dentista.exibirDados();
        dentista.exibirProcedimentos();

        // Criando um paciente
        Paciente paciente = new Paciente();
        paciente.setNome("Ana Souza");
        paciente.setCpf("987.654.321-00");
        paciente.setTelefone("(11) 99876-5432");
        paciente.setEmail("ana.souza@email.com");
        paciente.setSexo('F');
        paciente.setIdade(30);
        paciente.setPlano("individual");

        System.out.println("\n--- Dados do Paciente Antes do Atendimento ---");
        paciente.exibirDados();

        //  Dentista realiza o procedimento no paciente
        dentista.realizarProcedimento(paciente, limpeza);

        System.out.println("\n--- Dados do Paciente Após o Procedimento ---");
        paciente.exibirDados();

        //  Verificando a fatura do paciente
        paciente.checarFatura();

        //  Paciente dá nota de atendimento
        paciente.darNotaAtendimento(4); // Nota ótima

        // Criando uma recepcionista
        Recepcionista recepcionista = new Recepcionista();
        recepcionista.setNome("Mariana Lima");
        recepcionista.setCpf("111.222.333-44");
        recepcionista.setTelefone("(99) 93456-7890");
        recepcionista.setEmail("mariana.recepcionista@email.com");
        recepcionista.setSexo('F');
        recepcionista.setIdade(28);
        recepcionista.setSalarioBase(2000.0);
        recepcionista.setSalario(2000.0);
        recepcionista.setTurno("Integral");

        // Registrando o paciente na recepção
        recepcionista.registrarPaciente(paciente);

        // Recepcionista faz o recebimento do salário
        System.out.println("\n--- Recebimento de Salário da Recepcionista ---");
        recepcionista.receberSalario();

        // Dentista o recebe salário
        System.out.println("\n--- Recebimento de Salário do Dentista ---");
        dentista.receberSalario();
    }
}
