import java.util.ArrayList;
import java.util.List;
import java.util.Optional; // Para lidar com músicas que podem não ser encontradas

// Playlist.java
public class Playlist {
    private List<Musica> musicas;

    public Playlist() {
        this.musicas = new ArrayList<>();
        // Adiciona algumas músicas iniciais para demonstração
        adicionarMusica(new Musica("Lembrei de Nós", "João Gomes, Jotapê, Mestrinho", "Dominguinho", 354));
        adicionarMusica(new Musica("Oceano", "Djavan", "Djavan - 1989", 482));
        adicionarMusica(new Musica("Numa Sala de Reboco", "Luiz Gonzaga", "Sala de Reboco", 390));
        adicionarMusica(new Musica("Flor", "João Gomes, Jotapê, Mestrinho", "Dominguinho", 301));
    }

    public void adicionarMusica(Musica musica) {
        if (!musicas.contains(musica)) {
            musicas.add(musica);
            System.out.println("Música '" + musica.getTitulo() + "' adicionada à playlist.");
        } else {
            System.out.println("A música '" + musica.getTitulo() + "' de '" + musica.getArtista() + "' já está na playlist.");
        }
    }

    public boolean removerMusica(String titulo, String artista) {
        // Encontra a música pelo título e artista
        Optional<Musica> musicaParaRemover = musicas.stream()
            .filter(m -> m.getTitulo().equalsIgnoreCase(titulo) && m.getArtista().equalsIgnoreCase(artista))
            .findFirst(); // Pega a primeira que encontrar

        if (musicaParaRemover.isPresent()) {
            musicas.remove(musicaParaRemover.get());
            System.out.println("Música '" + titulo + "' de '" + artista + "' removida da playlist.");
            return true;
        } else {
            System.out.println("Música '" + titulo + "' de '" + artista + "' não encontrada na playlist para remover.");
            return false;
        }
    }

    public Optional<Musica> buscarMusica(String titulo) {
        // Retorna a primeira música que corresponda ao título
        return musicas.stream()
                      .filter(m -> m.getTitulo().equalsIgnoreCase(titulo))
                      .findFirst();
    }

    public List<Musica> getTodasMusicas() {
        return new ArrayList<>(musicas); // Retorna uma cópia para evitar modificações externas diretas
    }

    public boolean estaVazia() {
        return musicas.isEmpty();
    }
}