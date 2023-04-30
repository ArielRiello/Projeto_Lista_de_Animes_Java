package ListaDeAnimes.src;

public class Mensagem {

    private static Mensagem mensagem;
    
    private Mensagem() {}
    
    public static Mensagem getMensagem() {
        
        if (mensagem == null) {
            mensagem = new Mensagem();
        }
        return mensagem;
    }

    public void digitar(String mensagem) throws InterruptedException {

        int intervalo = 1;

        for (int i = 0; i < mensagem.length(); i++) {
            System.out.print(mensagem.charAt(i));
            Thread.sleep(intervalo);
        }
    }
}