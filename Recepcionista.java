package consultorio_dentista;

public class Recepcionista extends Funcionario {
    
    private double notaAtendimento;
    private Paciente[] pacientes = new Paciente[100];
    private int numPacientes = 0;

    public double getNotaAtendimento() {
        return notaAtendimento;
    }

    public int getNumPacientes() {
        return numPacientes;
    }
    
    public void registrarPaciente(Paciente paciente) {
        if (numPacientes < pacientes.length) {
            pacientes[numPacientes] = paciente;
            numPacientes++;
            System.out.println("Paciente " + paciente.getNome() + " registrado com sucesso.");
        } else {
            System.out.println("Limite máximo de pacientes atingido. Não é possível registrar mais.");
        }
    }
    
    @Override
    public void receberSalario() {
        if (numPacientes == 0) {
            super.receberSalario();
            return;
        }

        int somaNotas = 0;
        for (int i = 0; i < numPacientes; i++) {
            somaNotas += pacientes[i].getNotaAtendimento();
        }

        double media = (double) somaNotas / numPacientes;
        System.out.printf("Média de avaliação: %.2f\n", media);
        
        this.notaAtendimento = media; 
        
        if (media < 0) {
            System.out.println("Compareça ao RH.");
        } else if (media >= 0 && media < 1) {
            System.out.println("Melhore o seu atendimento.");
        } else if (media >= 1 && media < 2) {
            System.out.println("Bom trabalho.");
        } else if (media >= 2 && media < 3) {
            System.out.println("Bom trabalho. Bônus de R$100 adicionado.");
            setSalario(getSalario() + 100);
        } else if (media >= 3 && media <= 4) {
            System.out.println("Excelente atendimento. Bônus de R$200 adicionado.");
            setSalario(getSalario() + 200);
        }

        super.receberSalario();

        for (int i = 0; i < numPacientes; i++) {
            pacientes[i].darNotaAtendimento(0);
            pacientes[i] = null;
        }
        numPacientes = 0;
    }
    
}
