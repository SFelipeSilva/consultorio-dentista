package consultorio_dentista;

public class Paciente extends Pessoa{
    
    private String plano;
    private double mensalidade;
    private final Pessoa[] dependentes = new Pessoa[5];
    private int qtdDependentes = 0;
    private final Procedimento[] procedimentos = new Procedimento[10];
    private int qtdProcedimentos = 0;
    private double fatura = 0.0;
    private boolean statusFatura = false;
    private int notaAtendimento;


    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano.toLowerCase();
        switch (this.plano) {
            case "individual":
                this.mensalidade = 100.0;
                break;
            case "familia":
                atualizarMensalidade();
                break;
            default:
                this.mensalidade = 0.0;
                break;
        }
    }

    public double getMensalidade() {
        return mensalidade;
    }
    
    public int getNotaAtendimento() {
    return notaAtendimento;
    }

    public void adicionarDependente(Pessoa dependente) {
        if (!"familia".equals(plano)) {
            System.out.println("Só é possível adicionar dependentes no plano família.");
            return;
        }

        if (qtdDependentes < dependentes.length) {
            dependentes[qtdDependentes] = dependente;
            qtdDependentes++;
            atualizarMensalidade();
        } else {
            System.out.println("Limite de dependentes atingido.");
        }
    }

    private void atualizarMensalidade() {
        this.mensalidade = 100.0 + (qtdDependentes * 70.0);
        fatura = this.mensalidade;
    }
    
    public void adicionarProcedimento(Procedimento p) {
        if (qtdProcedimentos < procedimentos.length) {
            procedimentos[qtdProcedimentos] = p;
            qtdProcedimentos++;
            if (plano.equals("nenhum") || plano.isEmpty()) {
                fatura += p.getPreco();
                statusFatura = false;
            }
        } else {
            System.out.println("Limite de procedimentos atingido.");
        }
    }

    public void checarFatura() {
        System.out.printf("Fatura: R$%.2f\n", fatura);
        System.out.println("Status: " + (statusFatura ? "Paga" : "Pendente"));
    }

    public void pagarFatura() {
        if (!statusFatura && fatura > 0.0) {
            System.out.println("Fatura paga com sucesso.");
            fatura = 0.0;
            statusFatura = true;
        } else if (statusFatura) {
            System.out.println("Fatura já está paga.");
        } else {
            System.out.println("Nenhuma fatura pendente.");
        }
    }
    
    public void darNotaAtendimento(int nota) {
        if (nota >= -1 && nota <= 4) {
            this.notaAtendimento = nota;
            System.out.println("Paciente " + getNome() + " avaliou o atendimento com nota " + nota);
        } else {
            System.out.println("Nota inválida! Utilize: Péssimo (-1), Ruim (1), Regular (2), Bom (3), Ótimo (4).");
        }
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Plano: " + getPlano());
        System.out.printf("Mensalidade: R$%.2f\n", getMensalidade());
        checarFatura();

        if (qtdDependentes > 0) {
            System.out.println("Dependentes:");
            for (int i = 0; i < qtdDependentes; i++) {
                System.out.println(" - " + dependentes[i].getNome() + ", CPF: " + dependentes[i].getCpf());
            }
        }
    }
    
}
