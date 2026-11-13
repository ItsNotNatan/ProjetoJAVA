package model;

/** Representa o investidor autenticado e sua carteira. */
public class Investidor extends Pessoa {
    private Carteira carteira;

    public Investidor(String nome, String cpf, String senha) {
        super(nome, cpf, senha);
        this.carteira = new Carteira();
    }

    public Carteira getCarteira() { return carteira; }
    public void setCarteira(Carteira carteira) {
        if (carteira == null) {
            throw new IllegalArgumentException("A carteira não pode ser nula.");
        }
        this.carteira = carteira;
    }
}
