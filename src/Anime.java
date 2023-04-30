package ListaDeAnimes.src;

public class Anime {
    
    private String anime;
    private int notaAnime;

    public Anime(String anime, int notaAnime){
        this.anime = anime;
        this.notaAnime = notaAnime;
    }

    public String getAnime() {
        return anime;
    }

    public void setAnime(String anime) {
        this.anime = anime;
    }

    public int getNotaAnime() {
        return notaAnime;
    }

    public void setNotaAnime(int notaAnime) {
        this.notaAnime = notaAnime;
    }

    @Override
    public String toString() {
        return "Anime: " + anime + " /  Nota: " + notaAnime;
    }
}
