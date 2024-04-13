package model;

public class Usuario {
    private int Id;
    private String nome;
    private String email;
    private String cargo;



    public Usuario(String nome, String email, String cargo) {
        this.nome = nome;
        this.email = email;
        this.cargo = cargo;
    }

    public Usuario(int id, String nome, String email, String cargo) {
        Id = id;
        this.nome = nome;
        this.email = email;
        this.cargo = cargo;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
