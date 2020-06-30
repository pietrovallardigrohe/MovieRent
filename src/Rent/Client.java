package Rent;

public class Client {

    private String name;
    private String CPF;
    private int age;

    public Client(String CPF, String name, int idade) {

        this.CPF = CPF;
        this.name = name;
        this.age = idade;

    }

    public String getCPF() {
        return CPF;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {

        return String.format("%s;%s;%d", getCPF(), getName(), getAge());

    }

}
