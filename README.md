# **Projeto - Lista de Animes v1.0**
 >*Esse projeto foi elaborado para aperfeiçoar e por em prática conceitos aprendidos no Bootcamp Java Developer - Banco PAN - DIO e estudar novos conceitos usando o Chat GPT como ferramenta de estudos.*
 > 
 >*Conforme evoluir em meus estudos irei atualizando o projeto.* 

 ## **O Projeto:**
 ***
> Criar um programa onde você pode criar listas de animes assistidos, adicionar e remover animes a lista e exibi-la. 

## **Versão 1.0**
***
>Em sua primeira versão, ao iniciar o programa você pode fazer um login em uma conta existente ou regristrar uma nova conta, a conta é referente a lista que você ira criar/modificar, sendo assim o nome de login será o nome da respectiva lista. 
>
>Apos criar um login, o programa ira criar um arquivo .txt com o nome de login, onde sera armazenada sua lista. Em seguida, você entrará no menu de opções de sua lista, usando comandos slash (comandos de barra) poderá executar os seguintes comandos:
>
>* /lista (exibir sua lista)
>* /add (adicionar um novo anime em sua lista e dar uma nota)
>* /rmv (remover um anime de sua lista)
>* /sair (sair do programa)

## **Classes e Métodos**
***
> ### **MAIN**
> ***
> *Foi criado um sitema de **registro** e **login** para definir qual lista de animes sera acessada, usando comandos logicos e de repetição, **Switch/Case**, **While** e **If/Else** foi criado um sistema de **menus** e **comandos slash** para definir o que e onde seram executadas as tarefas.*
>
>* Exemplo de uma condição criada para o menu (Codigo completo na pasta do Projeto)
>~~~Java
>while (comandoCondicaoAposLogin == true) {
>	
>	comandoCondicaoAposogin = false;
>	Mensagem.getMensagem().digitar("Comando:  ");
>      String opcao = scan.nextLine();
>
>	switch(opcao) {
>
>		case "/lista":
>
>			//codigo...
>
>		break;
>		
>		case "/add":
>			Bolean add = true;
>			while (add == true) {
>				add = false;
>
>				//codigo...
>
>				String addOpcao = scan.nextLine();
>				if (addOpcao == "/add") {
>					add = true;
>				} else {
>					comandoCondicaoAposLogin = true;
>				}
>			}
>		break;
>   }
>}
***
> ### **COMANDOSLASH**
> ***
>A ComandoSlash é uma classe com um atributo estático chamado **comandoSlashAtual** e dois métodos estáticos, **getComandoSlashAtual()** e **setComandoSlashAtual()**, para obter e definir o valor desse atributo. O atributo é privado e estático, permitindo que seja acessado diretamente a partir da classe e compartilhado por todas as instâncias. Essa classe é útil para armazenar e recuperar o valor de um comando de slash atualmente em uso em um programa.
>~~~Java
>public class ComandoSlash {
>    
>    private static String comandoSlashAtual = "";
>
>    public static String getComandoSlashAtual() {
>        return comandoSlashAtual;
>    }
>
>    public static void setComandoSlashAtual(String comando) {
>        comandoSlashAtual = comando;
>    }
>}
***
> ### **USUARIOATUAL**
> ***
> *A classe **UsuarioAtual** é uma classe com um atributo estático chamado **usuarioAtual** e dois métodos estáticos: **getUsuarioAtual()** e **setUsuarioAtual(String usuario)**. O atributo armazena uma string que representa o usuário atualmente em uso e pode ser definido ou recuperado usando os métodos **setUsuarioAtual()** e **getUsuarioAtual()**. Essa classe é útil para armazenar e recuperar o valor do usuário atual em outras partes do programa, e pode ser atualizado usando o método **setUsuarioAtual()**.*
>~~~Java
>public class UsuarioAtual {
>    
>    private static String usuarioAtual = "";
>
>    public static String getUsuarioAtual() {
>        return usuarioAtual;
>    }
>
>    public static void setUsuarioAtual(String usuario) {
>        usuarioAtual = usuario;
>    }    
>}
***
> ### **MENSAGEM**
> ***
> *Essa classe chamada **Mensagem** tem uma instância única, que pode ser acessada através do método estático **getMensagem()**. Esse padrão de projeto é conhecido como **Singleton**, que garante que somente uma instância da classe seja criada durante a execução do programa.*
>
> *O construtor da classe é privado, o que significa que a classe não pode ser instanciada diretamente. Isso força o uso do método estático **getMensagem()** para obter a instância da classe.*
>
> *O método **getMensagem()** verifica se a instância da classe já existe. Se sim, ele retorna essa instância. Se não, ele cria uma nova instância e retorna essa nova instância.*
> * **Singleton**
>~~~Java
>public class Mensagem { 
>
>    private static Mensagem mensagem;
>    
>    private Mensagem() {}
>    
>    public static Mensagem getMensagem() {
>        
>        if (mensagem == null) {
>            mensagem = new Mensagem();
>        }
>        return mensagem;
>    }
>~~~
> * **digitar()**
> *O método recebe uma mensagem como parâmetro e exibe a mensagem caractere por caractere no console, com um intervalo de 1 milissegundo entre cada caractere. Ele também pode lançar uma exceção **InterruptedException**, que é uma exceção verificada que pode ser lançada quando uma thread é interrompida enquanto está aguardando.*
>~~~Java
>    public void digitar(String mensagem) throws InterruptedException {
>
>        int intervalo = 1;
>
>        for (int i = 0; i < mensagem.length(); i++) {
>            System.out.print(mensagem.charAt(i));
>            Thread.sleep(intervalo);
>        }
>    }
>}
>~~~
***
> ### **MENSAGEMTXT**
> ***
>*Essa classe chamada MensagemTxt é responsável por lidar com arquivos de texto*
>* **getMensagemTxt()**: *Esse método é um padrão **singleton** para garantir que haja apenas uma instância dessa classe. Ele retorna a instância atual da classe ou cria uma nova se ela ainda não existir.*
>~~~Java
>private static MensagemTxt mensagem;
>
>public static MensagemTxt getMensagemTxt() {
>   if (mensagem == null) {
>       mensagem = new MensagemTxt();
>       }
>   return mensagem;
> };
>~~~
>
> * **private MensagemTxt() {}**: *Esse é um construtor privado que garante que essa classe só possa ser instanciada de dentro da própria classe.*
>~~~Java
>~~~
>
>* **RemoverAnimes()**: *Esse método remove uma linha específica de um arquivo TXT. O método abre o arquivo, lê cada linha e adiciona as que não correspondem ao nome do arquivo passado como parâmetro em uma lista. Depois, sobrescreve o arquivo com as linhas que sobraram na lista. Ele pode lançar uma exceção **IOException** se ocorrer algum problema durante a leitura ou gravação do arquivo.*
>~~~Java
>    public static void RemoverAnimes(String arquivoRemovido) throws IOException {
>        
>        String nomeArquivo = UsuarioAtual.getUsuarioAtual() + ".txt";
>        File arquivo = new File("ListaDeAnimes/src/ArquivosTXT/" + nomeArquivo);
>    
>        BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
>        List<String> linhas = new ArrayList<>();
>        String linhaAtual;
>        while ((linhaAtual = leitor.readLine()) != null) {
>            if (!linhaAtual.contains(arquivoRemovido)) {
>                linhas.add(linhaAtual);
>            }
>        }
>        leitor.close();
>    
>        BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivo));
>        for (String linha : linhas) {
>            escritor.write(linha);
>            escritor.newLine();
>        }
>        escritor.close();
>    }
>~~~
> * **gravarTxt()**: *Esse método grava uma mensagem em um arquivo TXT especificado pelo **ComandoSlashAtual**. Ele cria o arquivo, escreve a mensagem e depois fecha o arquivo. Ele pode lançar uma exceção **IOException** se ocorrer algum problema durante a gravação do arquivo.*
>~~~Java
>public void gravarTxt(String mensagem) throws IOException {
>        
>        File caminhoDoArquivo = new File ("ListaDeAnimes/src/ArquivosTXT/" 
>                                           + ComandoSlash.getComandoSlashAtual() +
>                                                ".txt");
>        FileWriter gravar = new FileWriter(caminhoDoArquivo, true);
>        PrintWriter escrever = new PrintWriter(gravar);
>
>        System.out.println("\n");
>        escrever.println(mensagem);
>        escrever.close();
>    }
>~~~
>
> * **gravarTxt()**: *Esse método grava um **objeto** do tipo Anime em um arquivo TXT. Ele cria o arquivo, escreve o **objeto** e depois fecha o arquivo. Ele pode lançar uma exceção **IOException** se ocorrer algum problema durante a gravação do arquivo.*
>~~~Java
>public void gravarTxt(Anime animeAdd) throws IOException {
>
>        File caminhoDoArquivo = new File ("ListaDeAnimes/src/ArquivosTXT/" +
>                                           UsuarioAtual.getUsuarioAtual() + 
>                                                ".txt");
>        FileWriter gravar = new FileWriter(caminhoDoArquivo, true);
>        PrintWriter escrever = new PrintWriter(gravar);
>
>        System.out.println("\n");
>        escrever.println(animeAdd);
>        escrever.close();
>    }
>~~~
***
> ### **LERTXT**
>A classe LerTxt é responsável por lidar com arquivos de texto contendo listas de animes em um diretório específico do projeto. 
> * O método estático **getArquivoTxt()**: *é utilizado para obter uma instância da própria classe. Ele utiliza um padrão de projeto conhecido como **"Singleton"**, que garante que apenas uma instância da classe seja criada e utilizada em todo o projeto.*
>~~~Java
>public class LerTxt {
>    
>    private static LerTxt arquivoTxt;
>    
>    private LerTxt() {}
>    
>    public static LerTxt getArquivoTxt() {
>        if (arquivoTxt == null) {
>            arquivoTxt = new LerTxt();
>        }
>        return arquivoTxt;
>    };
>}
>~~~
> * O método estático **LerArquivoAnimes()**: *é responsável por ler um arquivo de texto contendo uma lista de animes, ordená-la em ordem alfabética e exibi-la no console. Ele utiliza a classe **File** para acessar o arquivo no diretório especificado e a classe **Scanner** para ler as linhas do arquivo. As linhas são armazenadas em um **ArrayList** e ordenadas utilizando o método **Collections.sort()**. Em seguida, o método percorre o **ArrayList** e exibe as linhas no console utilizando um laço de repetição **for-each**.
>~~~Java
>public static void LerArquivoAnimes() throws FileNotFoundException {
>
>        File arquivo = new File("ListaDeAnimes/src/ArquivosTXT/" + 
>                                   UsuarioAtual.getUsuarioAtual() + ".txt");
>        Scanner scanner = new Scanner(arquivo);
>        ArrayList<String> linhas = new ArrayList<>();
>
>        while (scanner.hasNextLine()) {
>            linhas.add(scanner.nextLine());
>        }
>
>        scanner.close();
>
>        Collections.sort(linhas);
>
>        for (String linha : linhas) {
>            System.out.println(linha);
>        }
>    }
>~~~
> * *O método público de instância **verificarTxt()** é utilizado para verificar se um determinado arquivo de texto existe no diretório especificado. Ele recebe como parâmetro uma **String** contendo o nome do arquivo a ser verificado e utiliza a classe **File** para acessar o arquivo. Em seguida, utiliza um laço de repetição **while** e o método **contains()** da classe **String** para verificar se a **String** procurada está presente em alguma linha do arquivo. Se encontrar a **String**, o método retorna **true**, caso contrário, retorna **false**. Se ocorrer uma exceção **FileNotFoundException**, o método também retorna **false**.*
>~~~Java
>public boolean verificarTxt(String arquivoTxt) {
>        
>        try {
>            File arquivo = new File("ListaDeAnimes/src/ArquivosTXT/" + 
>                                       ComandoSlash.getComandoSlashAtual() + ".txt");
>            try (Scanner scan = new Scanner(arquivo)) {
>                String stringProcurada = arquivoTxt;
>
>                while (scan.hasNextLine()) {
>                    String linhaAtual = scan.nextLine();
>                    if (linhaAtual.contains(stringProcurada)) {
>                        return true;
>                    }
>                }
>
>                scan.close();
>            }
>        } catch (FileNotFoundException e) {
>            return false;
>        }
>        return false;
>    }
>~~~
> ***
***
> #### **ANIME**
>A classe Anime possui dois atributos privados: **anime** e **notaAnime**. Ambos podem ser acessados e modificados usando métodos **getters e setters**. O construtor da classe recebe como argumentos o nome do anime e a nota atribuída ao mesmo.
>
>Os métodos **getAnime()** e **getNotaAnime()** são públicos e retornam o nome do anime e a nota atribuída, respectivamente. Os métodos **setAnime(String anime)** e **setNotaAnime(int notaAnime)** são públicos e permitem definir o nome do anime e a nota atribuída, respectivamente.
>
>A classe também implementa o método **toString()** que retorna uma string contendo o nome do anime e a nota atribuída formatados. Esse método é usado para imprimir uma representação em string de objetos Anime.
>~~~Java
>public class Anime {
>    
>    private String anime;
>    private int notaAnime;
>
>    public Anime(String anime, int notaAnime){
>        this.anime = anime;
>        this.notaAnime = notaAnime;
>    }
>
>    public String getAnime() {
>        return anime;
>    }
>
>    public void setAnime(String anime) {
>        this.anime = anime;
>    }
>
>    public int getNotaAnime() {
>        return notaAnime;
>    }
>
>    public void setNotaAnime(int notaAnime) {
>        this.notaAnime = notaAnime;
>    }
>
>    @Override
>    public String toString() {
>        return "Anime: " + anime + " /  Nota: " + notaAnime;
>    }
>}
>~~~
> ***