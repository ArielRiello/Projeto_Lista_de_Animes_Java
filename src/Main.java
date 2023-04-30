package ListaDeAnimes.src;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws InterruptedException, IOException {
     
        Scanner scan = new Scanner(System.in);
        boolean inicio = true;
        String comando = "";
        boolean comandoCodicao = true;
        boolean comandoCondicaoAposLogin = true;

        while (inicio == true) {

            inicio = false;

            Mensagem.getMensagem().digitar("Seja bem vindo a Lista de Animes !!!\n");
            System.out.println();
            Mensagem.getMensagem().digitar("Digite: /login - para acessar uma conta existe\n");
            Mensagem.getMensagem().digitar("Digite: /registro - para criar um novo usuario\n");
            System.out.println("");
            
            while (comandoCodicao == true) {

                comandoCodicao = false;
                Mensagem.getMensagem().digitar("Comando:  ");
                comando = scan.nextLine();

                switch (comando) { 
    
                    case "/login":
                        ComandoSlash.setComandoSlashAtual("usuarios");
                        Mensagem.getMensagem().digitar("\nDigite seu login: ");
                        String login = scan.nextLine();
                        
                        if (LerTxt.getArquivoTxt().verificarTxt(login) == true) {

                            UsuarioAtual.setUsuarioAtual(login);

                            System.out.println();
                            Mensagem.getMensagem().digitar(login + " - Login efetuado !!!\n");

                            Mensagem.getMensagem().digitar("Escolha o comando referete a ação que deseja executar\n");
                            Mensagem.getMensagem().digitar("/lista - exibe sua lista de animes\n");
                            Mensagem.getMensagem().digitar("/add - adiciona um novo anime a sua lista\n");
                            Mensagem.getMensagem().digitar("/rmv - remove um anime de sua lista\n");
                            
                            while (comandoCondicaoAposLogin == true) {
                            
                            comandoCondicaoAposLogin = false;
                            Mensagem.getMensagem().digitar("Comando:  ");
                            String opcao = scan.nextLine();
                            
                                switch (opcao) { 
                                    case "/lista":
                                        Mensagem.getMensagem().digitar("\nLista de Animes - " + login);
                                        System.out.println();
                                        LerTxt.LerArquivoAnimes();
                                        System.out.println();
                                        Mensagem.getMensagem().digitar("Digite o comando que desseja executar: /lista - /add - /rmv - /sair\n");
                                        comandoCondicaoAposLogin = true;
                                        break;
                                        
                                    case "/add":
                                        Boolean add = true;

                                        while (add == true) {
                                            add = false;

                                            Mensagem.getMensagem().digitar("Digite o nome do anime que deseja adicionar\n");
                                            Mensagem.getMensagem().digitar(" Nome do anime: ");
                                            String nomeAnimeAdd = scan.nextLine();

                                            Mensagem.getMensagem().digitar("Que nota você da para esse anime de 0 - 10 ?\n");
                                            Mensagem.getMensagem().digitar(" Nota: ");
                                            int notaAnimeAdd = scan.nextInt();

                                            Anime animeAdd = new Anime(nomeAnimeAdd, notaAnimeAdd);
                                            MensagemTxt.getMensagemTxt().gravarTxt(animeAdd);
                                            Mensagem.getMensagem().digitar("O anime: " + nomeAnimeAdd + ", com a nota: " + notaAnimeAdd + " foi adicionado com sucesso !!!\n");
                                            
                                            Mensagem.getMensagem().digitar("Deseja adicionar mais algum anime ? /add para adicionar um novo anime.\n");
                                            Mensagem.getMensagem().digitar("Se não, execute outro comando que deseja: /lista - /rmv - /sair\n");
                                            String addOpcao = scan.nextLine();
                                            if (addOpcao == "/add") {
                                                add = true;
                                            } else {
                                                comandoCondicaoAposLogin = true;
                                            }
                                        }
                                    break;
                                    
                                    case "/rmv":
                                        Boolean rmv = true;

                                        while (rmv == true) {
                                            rmv = false;

                                            Mensagem.getMensagem().digitar("Digite o nome do anime que deseja REMOVER\n");
                                            Mensagem.getMensagem().digitar("Nome do anime: ");
                                            String nomeAnimeRmv = scan.nextLine();

                                            MensagemTxt.RemoverAnimes(nomeAnimeRmv);
                                            Mensagem.getMensagem().digitar("Anime (" + nomeAnimeRmv + ") REMOVIDO com sucesso !!!\n");

                                            Mensagem.getMensagem().digitar("Deseja REMOVER mais algum anime ? /rmv para REMOVER um novo anime\n");
                                            Mensagem.getMensagem().digitar("Se não, execute outro comando que deseja: /lista - /rmv - /sair\n");
                                            String rmvOpcao = scan.nextLine();
                                            if (rmvOpcao == "/rmv") {
                                                rmv = true;
                                            } else {
                                                comandoCondicaoAposLogin = true;
                                            }
                                        }
                                    break;

                                    case "/sair":
                                        comandoCondicaoAposLogin = false;
                                        comandoCodicao = false;
                                        Mensagem.getMensagem().digitar("Arigatō, mata ne!");

                                    break;

                                    default:
                                        Mensagem.getMensagem().digitar("\nComando invalido, digite um comando valido\n");
                                        comandoCondicaoAposLogin = true;
                                    break;
                                }

                            }   
                        } else {
                            Mensagem.getMensagem().digitar("Login não registrado, use /registro para registrar um novo login\n");
                            comandoCodicao = true;
                        }
                    break;

                    case "/registro":
                        ComandoSlash.setComandoSlashAtual("usuarios");
                        Mensagem.getMensagem().digitar("\nDigite o LOGIN a ser registrado:  ");
                        String loginRegistro = scan.nextLine();

                        if (LerTxt.getArquivoTxt().verificarTxt(loginRegistro) == false) {

                            MensagemTxt.getMensagemTxt().gravarTxt(loginRegistro);
                            Mensagem.getMensagem().digitar("REGISTRO EFETUADO COM SUCESSO !!! ( "+ loginRegistro +" )\n");
                            new FileWriter("ListaDeAnimes/src/ArquivosTXT/" + loginRegistro + ".txt");
                            Mensagem.getMensagem().digitar("Use /login para efetuar seu login\n");
                            comandoCodicao = true;

                        } else {
                            System.out.println();
                            Mensagem.getMensagem().digitar("Login já existente, digite /registro para registrar um novo login\n");
                            comandoCodicao = true;
                        }
                    break;

                    case "/sair":
                        comandoCodicao = false;
                        Mensagem.getMensagem().digitar("Arigatō, mata ne!");
                    break;

                    default:
                        Mensagem.getMensagem().digitar("\nComando invalido, insira um comando valido.\n");
                        comandoCodicao = true;
                    break;
                }
            }
        }
        scan.close();
    }
}