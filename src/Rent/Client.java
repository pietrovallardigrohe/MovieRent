package Rent;

public class Client {

    private int id;
    private String name;
    private int idade;

    public Client(int id, String name, int idade) {

        this.id = id;
        this.name = name;
        this.idade = idade;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getIdade() {
        return idade;
    }

    public void setId(int id) {
        this.id = id;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", idade=" + idade +
                '}';
    }

}
