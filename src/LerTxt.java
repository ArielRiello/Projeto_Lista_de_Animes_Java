package ListaDeAnimes.src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LerTxt {
    
    private static LerTxt arquivoTxt;
    
    private LerTxt() {}
    
    public static LerTxt getArquivoTxt() {
        if (arquivoTxt == null) {
            arquivoTxt = new LerTxt();
        }
        return arquivoTxt;
    };

    public static void LerArquivoAnimes() throws FileNotFoundException {

        File arquivo = new File("ListaDeAnimes/src/ArquivosTXT/" + UsuarioAtual.getUsuarioAtual() + ".txt");
        Scanner scanner = new Scanner(arquivo);
        ArrayList<String> linhas = new ArrayList<>();

        while (scanner.hasNextLine()) {
            linhas.add(scanner.nextLine());
        }

        scanner.close();

        Collections.sort(linhas);

        for (String linha : linhas) {
            System.out.println(linha);
        }
    }


    public boolean verificarTxt(String arquivoTxt) {
        
        try {
            File arquivo = new File("ListaDeAnimes/src/ArquivosTXT/" + ComandoSlash.getComandoSlashAtual() + ".txt");
            try (Scanner scan = new Scanner(arquivo)) {
                String stringProcurada = arquivoTxt;

                while (scan.hasNextLine()) {
                    String linhaAtual = scan.nextLine();
                    if (linhaAtual.contains(stringProcurada)) {
                        return true;
                    }
                }

                scan.close();
            }
        } catch (FileNotFoundException e) {
            return false;
        }
        return false;
    }
}