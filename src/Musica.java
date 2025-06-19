public class Musica {
    private String titulo;
    private String artista;
    private String album;
    private int duracaoEmSegundos; 

    public Musica(String titulo, String artista, String album, int duracaoEmSegundos) {
        this.titulo = titulo;
        this.artista = artista;
        this.album = album;
        this.duracaoEmSegundos = duracaoEmSegundos;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public String getAlbum() {
        return album;
    }

    public int getDuracaoEmSegundos() {
        return duracaoEmSegundos;
    }

    @Override
    public String toString() {
        return "'" + titulo + "' - " + artista + (album != null && !album.isEmpty() ? " (" + album + ")" : "");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Musica musica = (Musica) obj;
        return titulo.equalsIgnoreCase(musica.titulo) &&
               artista.equalsIgnoreCase(musica.artista);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(titulo.toLowerCase(), artista.toLowerCase());
    }
}