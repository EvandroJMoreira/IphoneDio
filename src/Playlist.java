import java.util.ArrayList;
import java.util.List;
import java.util.Optional; // Para lidar com m�sicas que podem n�o ser encontradas

// Playlist.java
public class Playlist {
    private List<Musica> musicas;

    public Playlist() {
        this.musicas = new ArrayList<>();
        // Adiciona algumas m�sicas iniciais para demonstra��o
        adicionarMusica(new Musica("Lembrei de N�s", "Jo�o Gomes, Jotap�, Mestrinho", "Dominguinho", 354));
        adicionarMusica(new Musica("Oceano", "Djavan", "Djavan - 1989", 482));
        adicionarMusica(new Musica("Numa Sala de Reboco", "Luiz Gonzaga", "Sala de Reboco", 390));
        adicionarMusica(new Musica("Flor", "Jo�o Gomes, Jotap�, Mestrinho", "Dominguinho", 301));
    }

    public void adicionarMusica(Musica musica) {
        if (!musicas.contains(musica)) {
            musicas.add(musica);
            System.out.println("M�sica '" + musica.getTitulo() + "' adicionada � playlist.");
        } else {
            System.out.println("A m�sica '" + musica.getTitulo() + "' de '" + musica.getArtista() + "' j� est� na playlist.");
        }
    }

    public boolean removerMusica(String titulo, String artista) {
        // Encontra a m�sica pelo t�tulo e artista
        Optional<Musica> musicaParaRemover = musicas.stream()
            .filter(m -> m.getTitulo().equalsIgnoreCase(titulo) && m.getArtista().equalsIgnoreCase(artista))
            .findFirst(); // Pega a primeira que encontrar

        if (musicaParaRemover.isPresent()) {
            musicas.remove(musicaParaRemover.get());
            System.out.println("M�sica '" + titulo + "' de '" + artista + "' removida da playlist.");
            return true;
        } else {
            System.out.println("M�sica '" + titulo + "' de '" + artista + "' n�o encontrada na playlist para remover.");
            return false;
        }
    }

    public Optional<Musica> buscarMusica(String titulo) {
        // Retorna a primeira m�sica que corresponda ao t�tulo
        return musicas.stream()
                      .filter(m -> m.getTitulo().equalsIgnoreCase(titulo))
                      .findFirst();
    }

    public List<Musica> getTodasMusicas() {
        return new ArrayList<>(musicas); // Retorna uma c�pia para evitar modifica��es externas diretas
    }

    public boolean estaVazia() {
        return musicas.isEmpty();
    }
}