// Contato.java
public class Contato {
    private String nome;
    private String numeroTelefone;
    private String email;

    public Contato(String nome, String numeroTelefone, String email) {
        this.nome = nome;
        this.numeroTelefone = numeroTelefone;
        this.email = email;
    }

    // Construtor opcional para casos onde o email não é fornecido inicialmente
    public Contato(String nome, String numeroTelefone) {
        this(nome, numeroTelefone, null); // Chama o construtor principal com email nulo
    }

    public String getNome() {
        return nome;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        String info = nome + " (" + numeroTelefone + ")";
        if (email != null && !email.isEmpty()) {
            info += " - " + email;
        }
        return info;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Contato contato = (Contato) obj;
        return nome.equalsIgnoreCase(contato.nome) &&
               numeroTelefone.equals(contato.numeroTelefone);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(nome.toLowerCase(), numeroTelefone);
    }
}