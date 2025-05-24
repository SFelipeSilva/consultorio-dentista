package consultorio_dentista;

abstract class Funcionario extends Pessoa {
    
    private double salarioBase;
    private double salario;
    private String turno;

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salario) {
        this.salarioBase = salario;
    }
    
     public double getSalario() {
        return salario;
    }
     
    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
    
    public void receberSalario() {
    System.out.println("Salário recebido: R$" + getSalario());
    setSalario(salarioBase);
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Salario: " + getSalario());
        System.out.println("Salario Base: " + getSalarioBase());
        System.out.println("Turno: " + getTurno());
    }
    
}
