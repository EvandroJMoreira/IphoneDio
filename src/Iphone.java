import java.util.Scanner;
import java.util.Optional;

public class Iphone implements ReprodutorMusical, AparelhoTelefonico, NavegadorInternet {

    // --- Atributos de Estado ---
    private Musica musicaAtual;
    private String paginaAtual;

    // --- Atributos para o Aparelho Telefônico Aprimorado ---
    private AgendaContatos minhaAgenda;
    private Contato chamadaAtiva;
    private Contato chamadaEmEspera;

    // --- Atributo para o Reprodutor Musical Aprimorado ---
    private Playlist minhaPlaylist;

    public Iphone() {
        this.musicaAtual = null;
        this.paginaAtual = "Página inicial";
        this.minhaAgenda = new AgendaContatos(); // Instancia a agenda de contatos
        this.chamadaAtiva = null;
        this.chamadaEmEspera = null;
        this.minhaPlaylist = new Playlist(); // Instancia a playlist de músicas
        System.out.println("iPhone ligado e pronto para uso!");
    }

    // --- Implementação dos métodos de ReprodutorMusical ---
    @Override
    public void tocar() {
        if (musicaAtual != null) {
            System.out.println("Tocando: " + musicaAtual.toString());
        } else {
            System.out.println("Nenhuma música selecionada para tocar.");
        }
    }

    @Override
    public void pausar() {
        if (musicaAtual != null) {
            System.out.println("Música pausada: " + musicaAtual.getTitulo());
        } else {
            System.out.println("Não há música tocando para pausar.");
        }
    }

    @Override
    public void selecionarMusica(String tituloMusica) {
        Optional<Musica> musicaEncontrada = minhaPlaylist.buscarMusica(tituloMusica);
        if (musicaEncontrada.isPresent()) {
            this.musicaAtual = musicaEncontrada.get();
            System.out.println("Música selecionada: " + musicaAtual.toString());
        } else {
            System.out.println("Música com título '" + tituloMusica + "' não encontrada na playlist.");
            this.musicaAtual = null;
        }
    }

    // --- Implementação Aprimorada dos métodos de AparelhoTelefonico ---
    @Override
    public void ligar(String numero) {
        Optional<Contato> contatoChamado = minhaAgenda.buscarContatoPorNumero(numero);
        String nomeContato = contatoChamado.isPresent() ? contatoChamado.get().getNome() : numero; // Usa o número se não encontrar nome

        if (chamadaAtiva == null && chamadaEmEspera == null) {
            this.chamadaAtiva = new Contato(nomeContato, numero, contatoChamado.isPresent() ? contatoChamado.get().getEmail() : null);
            System.out.println("Ligando para: " + chamadaAtiva.toString() + "...");
            if (musicaAtual != null) {
                System.out.println("Música pausada automaticamente para a chamada.");
                pausar();
            }
        } else if (chamadaAtiva != null && chamadaEmEspera == null) {
            System.out.println("Você já está em uma chamada com " + chamadaAtiva.toString() + ".");
            System.out.println("Colocando " + chamadaAtiva.getNome() + " em espera para ligar para " + nomeContato + "...");
            this.chamadaEmEspera = this.chamadaAtiva;
            this.chamadaAtiva = new Contato(nomeContato, numero, contatoChamado.isPresent() ? contatoChamado.get().getEmail() : null);
            System.out.println("Ligando para: " + chamadaAtiva.toString() + "...");
        } else {
            System.out.println("Você já tem uma chamada ativa e uma em espera. Não é possível iniciar outra.");
        }
    }

    @Override
    public void atender() {
        // Simula uma chamada recebida de um contato genérico para simplificar
        if (chamadaAtiva == null && chamadaEmEspera == null) {
            Contato novaChamada = new Contato("Número Desconhecido", "99999-9999", null);
            this.chamadaAtiva = novaChamada;
            System.out.println("Atendendo chamada de: " + chamadaAtiva.toString() + ".");
            if (musicaAtual != null) {
                System.out.println("Música pausada automaticamente para a chamada.");
                pausar();
            }
        } else if (chamadaAtiva != null && chamadaEmEspera == null) {
            System.out.println("Você já está em uma chamada com " + chamadaAtiva.toString() + ".");
            System.out.println("Colocando " + chamadaAtiva.getNome() + " em espera para atender a nova chamada...");
            this.chamadaEmEspera = this.chamadaAtiva;
            this.chamadaAtiva = new Contato("Número Desconhecido", "99999-9999", null);
            System.out.println("Atendendo chamada de: " + chamadaAtiva.toString() + ".");
        } else {
            System.out.println("Você já tem uma chamada ativa e uma em espera. Não é possível atender outra.");
        }
    }

    public void encerrarChamadaAtiva() {
        if (chamadaAtiva != null) {
            System.out.println("Chamada com " + chamadaAtiva.toString() + " encerrada.");
            this.chamadaAtiva = null;
            if (chamadaEmEspera != null) {
                System.out.println("Retomando chamada com " + chamadaEmEspera.toString() + " da espera.");
                this.chamadaAtiva = this.chamadaEmEspera;
                this.chamadaEmEspera = null;
            } else {
                System.out.println("Nenhuma outra chamada em espera.");
                // Lógica para retomar a música pode vir aqui, se desejar
            }
        } else {
            System.out.println("Não há chamada ativa para encerrar.");
        }
    }

    public void trocarParaChamadaEmEspera() {
        if (chamadaAtiva != null && chamadaEmEspera != null) {
            System.out.println("Trocando para a chamada em espera...");
            Contato temp = this.chamadaAtiva;
            this.chamadaAtiva = this.chamadaEmEspera;
            this.chamadaEmEspera = temp;
            System.out.println("Agora em chamada com " + chamadaAtiva.toString() + ". " + chamadaEmEspera.getNome() + " em espera.");
        } else if (chamadaEmEspera == null && chamadaAtiva != null) {
            System.out.println("Não há nenhuma chamada em espera para trocar.");
        } else {
            System.out.println("Não há chamada ativa nem em espera para trocar.");
        }
    }

    @Override
    public void iniciarCorreioVoz() {
        System.out.println(" voicemail => Iniciando correio de voz.");
    }

    // --- Implementação dos métodos de NavegadorInternet ---
    @Override
    public void exibirPagina(String url) {
        this.paginaAtual = url;
        System.out.println("Exibindo página: " + url);
    }

    @Override
    public void adicionarNovaAba() {
        System.out.println("Nova aba adicionada.");
    }

    @Override
    public void atualizarPagina() {
        System.out.println("Página " + paginaAtual + " atualizada.");
    }

    // --- Método principal para interagir com o iPhone ---
    public static void main(String[] args) {
        Iphone meuIphone = new Iphone();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Menu Principal do iPhone ---");
            System.out.println("1. Reprodutor Musical");
            System.out.println("2. Aparelho Telefônico");
            System.out.println("3. Navegador na Internet");
            System.out.println("0. Desligar iPhone");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    menuMusical(meuIphone, scanner);
                    break;
                case 2:
                    menuTelefonico(meuIphone, scanner);
                    break;
                case 3:
                    menuNavegador(meuIphone, scanner);
                    break;
                case 0:
                    System.out.println("Desligando iPhone...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    // --- Métodos de Menu Auxiliares ---
    private static void menuMusical(Iphone iphone, Scanner scanner) {
        int subOpcao;
        do {
            System.out.println("\n--- Reprodutor Musical ---");
            System.out.println("Música atual: " + (iphone.musicaAtual != null ? iphone.musicaAtual.getTitulo() : "Nenhuma"));
            System.out.println("1. Tocar Música Atual");
            System.out.println("2. Pausar Música");
            System.out.println("3. Selecionar Música da Playlist");
            System.out.println("4. Exibir Playlist Completa");
            System.out.println("5. Adicionar Nova Música");
            System.out.println("6. Remover Música da Playlist");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            subOpcao = scanner.nextInt();
            scanner.nextLine();

            switch (subOpcao) {
                case 1:
                    iphone.tocar();
                    break;
                case 2:
                    iphone.pausar();
                    break;
                case 3:
                    if (iphone.minhaPlaylist.estaVazia()) {
                        System.out.println("A playlist está vazia. Adicione músicas primeiro.");
                    } else {
                        System.out.println("\n--- Músicas Disponíveis ---");
                        iphone.minhaPlaylist.getTodasMusicas().forEach(m -> System.out.println("- " + m.toString()));
                        System.out.print("Digite o TÍTULO da música para selecionar: ");
                        String titulo = scanner.nextLine();
                        iphone.selecionarMusica(titulo);
                    }
                    break;
                case 4:
                    if (iphone.minhaPlaylist.estaVazia()) {
                        System.out.println("Sua playlist está vazia.");
                    } else {
                        System.out.println("\n--- Playlist Completa ---");
                        iphone.minhaPlaylist.getTodasMusicas().forEach(m -> System.out.println("- " + m.toString()));
                    }
                    break;
                case 5:
                    System.out.print("Título da música: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Artista: ");
                    String artista = scanner.nextLine();
                    System.out.print("Álbum (opcional, deixe em branco se não houver): ");
                    String album = scanner.nextLine();
                    System.out.print("Duração em segundos (ex: 180): ");
                    int duracao = scanner.nextInt();
                    scanner.nextLine();

                    iphone.minhaPlaylist.adicionarMusica(new Musica(titulo, artista, album.isEmpty() ? null : album, duracao));
                    break;
                case 6:
                    if (iphone.minhaPlaylist.estaVazia()) {
                        System.out.println("A playlist está vazia. Não há o que remover.");
                    } else {
                        System.out.print("Digite o TÍTULO da música para remover: ");
                        String tituloRemover = scanner.nextLine();
                        System.out.print("Digite o ARTISTA da música para remover: ");
                        String artistaRemover = scanner.nextLine();
                        iphone.minhaPlaylist.removerMusica(tituloRemover, artistaRemover);
                        if (iphone.musicaAtual != null && iphone.musicaAtual.getTitulo().equalsIgnoreCase(tituloRemover) && iphone.musicaAtual.getArtista().equalsIgnoreCase(artistaRemover)) {
                            iphone.musicaAtual = null;
                            System.out.println("Música atual foi removida da playlist. Nenhuma música selecionada agora.");
                        }
                    }
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (subOpcao != 0);
    }

    private static void menuTelefonico(Iphone iphone, Scanner scanner) {
        int subOpcao;
        do {
            System.out.println("\n--- Aparelho Telefônico ---");
            System.out.println("Status da Chamada Ativa: " + (iphone.chamadaAtiva != null ? iphone.chamadaAtiva.toString() : "Nenhuma"));
            System.out.println("Status da Chamada em Espera: " + (iphone.chamadaEmEspera != null ? iphone.chamadaEmEspera.toString() : "Nenhuma"));
            System.out.println("1. Ligar para um Contato");
            System.out.println("2. Ligar para um Número (Manual)");
            System.out.println("3. Atender Chamada (Simulada)");
            System.out.println("4. Encerrar Chamada Ativa");
            System.out.println("5. Trocar para Chamada em Espera");
            System.out.println("6. Iniciar Correio de Voz");
            System.out.println("7. Exibir Contatos");
            System.out.println("8. Adicionar Contato");
            System.out.println("9. Remover Contato");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            subOpcao = scanner.nextInt();
            scanner.nextLine();

            switch (subOpcao) {
                case 1:
                    if (iphone.minhaAgenda.estaVazia()) {
                        System.out.println("Sua agenda está vazia. Adicione contatos primeiro.");
                    } else {
                        System.out.println("\n--- Seus Contatos ---");
                        iphone.minhaAgenda.getTodosContatos().forEach(c -> System.out.println("- " + c.toString()));
                        System.out.print("Digite o NOME do contato para ligar: ");
                        String nomeContato = scanner.nextLine();
                        Optional<Contato> contato = iphone.minhaAgenda.buscarContatoPorNome(nomeContato);
                        if (contato.isPresent()) {
                            iphone.ligar(contato.get().getNumeroTelefone());
                        } else {
                            System.out.println("Contato não encontrado.");
                        }
                    }
                    break;
                case 2:
                    System.out.print("Digite o número para ligar: ");
                    String numero = scanner.nextLine();
                    iphone.ligar(numero);
                    break;
                case 3:
                    iphone.atender(); // Simula atendimento de uma nova chamada
                    break;
                case 4:
                    iphone.encerrarChamadaAtiva();
                    break;
                case 5:
                    iphone.trocarParaChamadaEmEspera();
                    break;
                case 6:
                    iphone.iniciarCorreioVoz();
                    break;
                case 7:
                    if (iphone.minhaAgenda.estaVazia()) {
                        System.out.println("Sua agenda está vazia.");
                    } else {
                        System.out.println("\n--- Contatos na Agenda ---");
                        iphone.minhaAgenda.getTodosContatos().forEach(c -> System.out.println("- " + c.toString()));
                    }
                    break;
                case 8:
                    System.out.print("Nome do novo contato: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Número do novo contato: ");
                    String novoNumero = scanner.nextLine();
                    System.out.print("Email do novo contato (opcional, deixe em branco se não houver): ");
                    String novoEmail = scanner.nextLine();
                    iphone.minhaAgenda.adicionarContato(new Contato(novoNome, novoNumero, novoEmail.isEmpty() ? null : novoEmail));
                    break;
                case 9:
                    if (iphone.minhaAgenda.estaVazia()) {
                        System.out.println("Sua agenda está vazia. Não há o que remover.");
                    } else {
                        System.out.print("Digite o NOME do contato para remover: ");
                        String nomeRemover = scanner.nextLine();
                        iphone.minhaAgenda.removerContato(nomeRemover);
                    }
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (subOpcao != 0);
    }

    private static void menuNavegador(Iphone iphone, Scanner scanner) {
        int subOpcao;
        do {
            System.out.println("\n--- Navegador na Internet ---");
            System.out.println("1. Exibir Página");
            System.out.println("2. Adicionar Nova Aba");
            System.out.println("3. Atualizar Página");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            subOpcao = scanner.nextInt();
            scanner.nextLine();

            switch (subOpcao) {
                case 1:
                    System.out.print("Digite a URL da página: ");
                    String url = scanner.nextLine();
                    iphone.exibirPagina(url);
                    break;
                case 2:
                    iphone.adicionarNovaAba();
                    break;
                case 3:
                    iphone.atualizarPagina();
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (subOpcao != 0);
    }
}