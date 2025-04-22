public class Libros {
    private String titulo,autor,editorial,isbn;
    private int anioPubli, paginas;
    private int idLibro;
    private static int idContar=0;

    public Libros(String titulo, String autor, String editorial, String isbn, int anioPubli, int paginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.isbn = isbn;
        this.anioPubli = anioPubli;
        this.paginas = paginas;
        this.idLibro = ++idContar;
    }

    //Métodos Getter y Setter
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getAnioPubli() {
        return anioPubli;
    }

    public void setAnioPubli(int anioPubli) {
        this.anioPubli = anioPubli;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public int getIdLibro() {
        return idLibro;
    }

    @Override
    public String toString() {
        return "\nLibro  ID ("+ idLibro +")" +
                "\nTitulo → " + titulo +
                "\nAutor → " + autor +
                "\nEditorial → " + editorial +
                "\nISBN → " + isbn +
                "\nAño publicación → " + anioPubli +
                "\nPáginas → " + paginas;
    }
}
