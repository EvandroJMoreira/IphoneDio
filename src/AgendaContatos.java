import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AgendaContatos {
    private List<Contato> contatos;

    public AgendaContatos() {
        this.contatos = new ArrayList<>();

        adicionarContato(new Contato("Steve Jobs", "11912345679", "steve.jobs@apple.com"));
        adicionarContato(new Contato("Esposa", "11912345678", "esposa@email.com"));
        adicionarContato(new Contato("Mãe", "11999999999", "mae.casa@email.com"));
        adicionarContato(new Contato("Pai", "11999999998", null)); 
    }

    public void adicionarContato(Contato contato) {
        if (!contatos.contains(contato)) {
            contatos.add(contato);
            System.out.println("Contato '" + contato.getNome() + "' adicionado.");
        } else {
            System.out.println("O contato '" + contato.getNome() + "' (" + contato.getNumeroTelefone() + ") já existe na agenda.");
        }
    }

    public void adicionarContato(String nome, String numeroTelefone, String email) {
        adicionarContato(new Contato(nome, numeroTelefone, email));
    }

    public boolean removerContato(String nome) {
        Optional<Contato> contatoParaRemover = contatos.stream()
            .filter(c -> c.getNome().equalsIgnoreCase(nome))
            .findFirst();

        if (contatoParaRemover.isPresent()) {
            contatos.remove(contatoParaRemover.get());
            System.out.println("Contato '" + nome + "' removido.");
            return true;
        } else {
            System.out.println("Contato '" + nome + "' não encontrado para remover.");
            return false;
        }
    }

    public Optional<Contato> buscarContatoPorNome(String nome) {
        return contatos.stream()
                      .filter(c -> c.getNome().equalsIgnoreCase(nome))
                      .findFirst();
    }

    public Optional<Contato> buscarContatoPorNumero(String numero) {
        return contatos.stream()
                      .filter(c -> c.getNumeroTelefone().equals(numero))
                      .findFirst();
    }

    public Optional<Contato> buscarContatoPorEmail(String email) {
        return contatos.stream()
                      .filter(c -> c.getEmail() != null && c.getEmail().equalsIgnoreCase(email))
                      .findFirst();
    }

    public List<Contato> getTodosContatos() {
        return new ArrayList<>(contatos);
    }

    public boolean estaVazia() {
        return contatos.isEmpty();
    }
}