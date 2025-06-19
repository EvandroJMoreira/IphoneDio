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
