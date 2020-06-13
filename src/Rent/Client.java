package Rent;

public class Client {

    private long CPF;
    private String name;
    private int idade;

    public Client(long CPF, String name, int idade) {

        this.CPF = CPF;
        this.name = name;
        this.idade = idade;

    }

    public long getCPF() {
        return CPF;
    }

    public String getName() {
        return name;
    }

    public int getIdade() {
        return idade;
    }

    public void setCPF(int CPF) {
        this.CPF = CPF;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Client{" +
                "CPF=" + CPF +
                ", name='" + name + '\'' +
                ", idade=" + idade +
                '}';
    }

}
