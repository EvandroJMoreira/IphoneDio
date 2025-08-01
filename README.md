# 📱 iPhoneDio: Simulação de um iPhone em Java (Console)
Este projeto Java simula as principais funcionalidades de um iPhone clássico (lançado em 2007), aplicando conceitos fundamentais de Programação Orientada a Objetos (POO).
Desenvolvido para fins didáticos, ele demonstra o uso de interfaces, herança, polimorfismo, encapsulamento, e composição através de um aplicativo interativo via console.

## 🌟 Funcionalidades Implementadas
O iPhoneDio simula as seguintes funcionalidades:

### 🎵 Reprodutor Musical
- Gerenciamento de Playlist: Adicione, remova e visualize músicas de uma playlist interna.
- Seleção e Reprodução: Selecione uma música da playlist para "tocar" e "pausar".

### 📞 Aparelho Telefônico
- Agenda de Contatos: Adicione, remova e visualize contatos com nome, número de telefone e e-mail.
- Realizar Chamadas: Ligue para contatos da agenda ou para números digitados manualmente.
- Atender Chamadas: Simule o atendimento de uma chamada recebida.
- Gerenciamento de Chamadas:
° Chamada Ativa: Mantenha uma conversa principal.
° Chamada em Espera: Coloque a chamada ativa em espera para atender ou iniciar outra ligação.
° Alternar Chamadas: Troque entre a chamada ativa e a chamada em espera.
- Correio de Voz: Inicie uma simulação de correio de voz.

### 🌐 Navegador na Internet
- Exibir Páginas: "Navegue" para URLs especificadas.
- Gestão de Abas: Adicione novas abas e "atualize" a página atual.

## 🛠️ Tecnologias Utilizadas
- Java 11+
- Conceitos de POO: Interfaces, classes, objetos, encapsulamento, composição.
- Estruturas de Dados: ArrayList para gerenciar listas de músicas e contatos.
- Entrada/Saída: java.util.Scanner para interação via console.

## 📄 Estrutura do Projeto
O projeto é organizado em classes e interfaces que representam as funcionalidades do iPhone:

IphoneDio/
- ├── src/
- │   ├── main/java/
- │   │   ├── AparelhoTelefonico.java        ### Interface para funções de telefone
- │   │   ├── AgendaContatos.java            ### Gerencia a lista de contatos
- │   │   ├── Contato.java                   ### Define um objeto Contato
- │   │   ├── Iphone.java                    ### Classe principal e ponto de entrada (com o main)
- │   │   ├── Musica.java                    ### Define um objeto Musica
- │   │   ├── NavegadorInternet.java         ### Interface para funções de navegador
- │   │   ├── Playlist.java                  ### Gerencia a lista de músicas
- │   │   └── ReprodutorMusical.java         ### Interface para funções musicais

## 🚀 Como Executar o Projeto
Para testar o iPhoneDio em sua máquina, siga os passos abaixo:

#### Pré-requisitos
- Certifique-se de ter o Java Development Kit (JDK), usei 17.
- Recomenda-se usar uma IDE, usei Eclipse.

#### Passos:
1) Clone o Repositório:
Abra seu terminal (Git Bash, PowerShell, CMD) e clone este repositório:
- git clone https://github.com/EvandroJMoreira/IphoneDio.git

2) Navegue até o Diretório do Projeto:
- cd IphoneDio
  
3) Importe para o Eclipse (ou sua IDE):
- Abra o Eclipse.
- Vá em File > Import... > General > Existing Projects into Workspace.
- Selecione o diretório IphoneDio que você clonou.

4) Execute o Projeto:
- No "Package Explorer" do Eclipse, localize a classe Iphone.java.
- Clique com o botão direito sobre Iphone.java e selecione Run As > Java Application.
- 
O programa será executado diretamente no console da sua IDE, apresentando os menus interativos.

## 💡 Contribuições
Sinta-se à vontade para explorar o código, propor melhorias ou adicionar novas funcionalidades! Pull requests são bem-vindos.
