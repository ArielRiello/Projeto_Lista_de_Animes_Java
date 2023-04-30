package ListaDeAnimes.src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MensagemTxt {
    
    private static MensagemTxt mensagem;

    public static MensagemTxt getMensagemTxt() {
        if (mensagem == null) {
            mensagem = new MensagemTxt();
        }
        return mensagem;
    };

    public static void RemoverAnimes(String arquivoRemovido) throws IOException {
        
        String nomeArquivo = UsuarioAtual.getUsuarioAtual() + ".txt";
        File arquivo = new File("ListaDeAnimes/src/ArquivosTXT/" + nomeArquivo);
    
        BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
        List<String> linhas = new ArrayList<>();
        String linhaAtual;
        while ((linhaAtual = leitor.readLine()) != null) {
            if (!linhaAtual.contains(arquivoRemovido)) {
                linhas.add(linhaAtual);
            }
        }
        leitor.close();
    
        BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivo));
        for (String linha : linhas) {
            escritor.write(linha);
            escritor.newLine();
        }
        escritor.close();
    }
    

    private MensagemTxt() {}

    public void gravarTxt(String mensagem) throws IOException {
        
        File caminhoDoArquivo = new File ("ListaDeAnimes/src/ArquivosTXT/" + ComandoSlash.getComandoSlashAtual() + ".txt");
        FileWriter gravar = new FileWriter(caminhoDoArquivo, true);
        PrintWriter escrever = new PrintWriter(gravar);

        System.out.println("\n");
        escrever.println(mensagem);
        escrever.close();
    }

    public void gravarTxt(Anime animeAdd) throws IOException {

        File caminhoDoArquivo = new File ("ListaDeAnimes/src/ArquivosTXT/" + UsuarioAtual.getUsuarioAtual() + ".txt");
        FileWriter gravar = new FileWriter(caminhoDoArquivo, true);
        PrintWriter escrever = new PrintWriter(gravar);

        System.out.println("\n");
        escrever.println(animeAdd);
        escrever.close();
    }
}