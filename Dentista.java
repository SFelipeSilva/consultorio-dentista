package consultorio_dentista;

public class Dentista extends Funcionario{
    
    private String cro;
    private String especialidade;
    private final Procedimento[] procedimentosTreinados = new Procedimento[10];
    private int numAtendimentos;
    private int qtdProcedimentos = 0;
    
    public String getCro(){
        return cro;
    }
    
    public void setCro(String cro){
        this.cro = cro;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public int getNumAtendimentos() {
        return numAtendimentos;
    }

    public void setNumAtendimentos(int numAtendimentos) {
        this.numAtendimentos = numAtendimentos;
    }
    
    public void adicionarProcedimentoTreinados(Procedimento p) {
        if (qtdProcedimentos < procedimentosTreinados.length) {
            procedimentosTreinados[qtdProcedimentos] = p;
            qtdProcedimentos++;
        }
    }
    
    public void exibirProcedimentos(){
        System.out.println("Procedimentos habilitados:");
        for (int i = 0; i < qtdProcedimentos; i++) {
            System.out.println("- " + procedimentosTreinados[i].getNome());
        }
    }
    
    public boolean verificarProcedimentoHabilitado(Procedimento proc) {
        for (int i = 0; i < qtdProcedimentos; i++) {
            if (procedimentosTreinados[i].getCodigo() == proc.getCodigo()) {
                return true;
            }
        }
        return false;
    }
    
    public void realizarProcedimento(Paciente p, Procedimento proc) {
        if (verificarProcedimentoHabilitado(proc)) {
            System.out.println("Realizando procedimento " + proc.getNome() + " para o paciente " + p.getNome());
            p.adicionarProcedimento(proc);
            double bonus = proc.getPreco() * 0.10;
            setSalario(getSalario() + bonus);
            numAtendimentos++;
        } else {
            System.out.println("O dentista " + getNome() + " não está habilitado para realizar o procedimento: " + proc.getNome());
        }
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("CRO: " + cro);
        System.out.println("Especialidade: " + especialidade);
        System.out.println("Atendimentos Realizados: " + numAtendimentos);
    }
}

