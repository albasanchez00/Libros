/* Recrear lo que hemos realizado ayer con Alumnos, crearlo en un nuevo proyecto usando
una Clase Libro.
Atributos
id
Titulo
Autor
Paginas
ISBN
Año Publicacion
Editorial
* */


import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        menu();
    }

    static ArrayList<Libros> grupoLibros=new ArrayList();

    public static void menu(){
        int opcion=0;
        String opcionString= JOptionPane.showInputDialog(null,"Ingrese la opcion: \n1. Nuevo Libro \n2. Eliminar \n3. Modificar \n4. Mostrar \n5. Salir");
        try{
            opcion=Integer.parseInt(opcionString);
            switch (opcion) {
                case 1,3-> crearModificar(opcion);
                case 2-> eliminar();
                case 4-> mostrar();
                case 5-> {
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    break;
                }
                default-> JOptionPane.showMessageDialog(null,"Ingrese una opción válida");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Ingrese una opción valida");
        }
    }



    public static void crearModificar(int opcion){
        String titulo="",autor="", editorial="",isbn="";
        int anioPubli=0, paginas=0;
        if (opcion==1){
            titulo = JOptionPane.showInputDialog(null, "Ingrese el título del libro: ");
            autor = JOptionPane.showInputDialog(null, "Ingrese el autor del libro: ");
            editorial = JOptionPane.showInputDialog(null, "Ingrese la editorial: ");
            isbn = JOptionPane.showInputDialog(null, "Ingrese el código ISBN: ");
            anioPubli = leerFecha();
            paginas = leerPaginas();

            Libros nuevo=new Libros(titulo,autor,editorial,isbn,anioPubli,paginas);
            if (nuevo != null) {
                grupoLibros.add(nuevo);
                menu();
            }
        }

        if (opcion==3){
            String salida=mostrarLibros();
            String modificarId=JOptionPane.showInputDialog(null,"Ingrese el id del libro: ");
            String queModificar=JOptionPane.showInputDialog(null,"1.Título \n2.Autor \n3.Editorial \n4. ISBN \n5. Año Publicación \n6.Páginas");
            int opcionModificar=0;
            int idLibroMod=0;
            try {
                opcionModificar=Integer.parseInt(queModificar);
                idLibroMod=Integer.parseInt(modificarId);
                switch (opcionModificar){
                    case 1->{
                        titulo = JOptionPane.showInputDialog(null, "Ingrese el nuevo título → ");
                    }
                    case 2->{
                        autor = JOptionPane.showInputDialog(null, "Ingrese el nuevo apellido → ");
                    }
                    case 3->{
                        editorial = JOptionPane.showInputDialog(null, "Ingrese la nueva editorial → ");
                    }
                    case 4->{
                        isbn = JOptionPane.showInputDialog(null, "Ingrese el nuevo ISBN → ");
                    }
                    case 5->{
                        paginas =leerPaginas();
                    }
                    case 6->{
                        anioPubli = leerFecha();
                    }
                }
                Iterator<Libros> librosIterator=grupoLibros.iterator();
                while (librosIterator.hasNext()){
                    Libros libro = librosIterator.next();
                    if (libro.getIdLibro() == idLibroMod){
                        switch(opcionModificar) {
                            case 1 -> libro.setTitulo(titulo);
                            case 2 -> libro.setAutor(autor);
                            case 3 -> libro.setEditorial(editorial);
                            case 4 -> libro.setIsbn(isbn);
                            case 5 -> libro.setPaginas(paginas);
                            case 6 -> libro.setAnioPubli(anioPubli);
                        }
                        JOptionPane.showMessageDialog(null, "Libro modificado exitosamente");
                        break;
                    }
                }
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"No exiten libros que mostrar");
            }
            mostrar();
        }
    }


    public static void eliminar(){
        if (!grupoLibros.isEmpty()){
            String salida="";
            String idEliminar=JOptionPane.showInputDialog(null,"Ingrese el id del libro a eliminar → ");
            int id;
            boolean eliminado=false;
            try {
                id=Integer.parseInt(idEliminar);
                Iterator <Libros> it = grupoLibros.iterator();
                while (it.hasNext()){
                    Libros libro = it.next();
                    if (libro.getIdLibro()==id){
                        it.remove();
                        eliminado=true;
                    }
                }
                if (!eliminado){
                    JOptionPane.showMessageDialog(null,"El id del libro no existe");
                }
                mostrar();
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"Ingrese el id del libro a eliminar");
            }
        }else {
            mostrar();
        }
    }

    public static void mostrar(){
        String salida= mostrarLibros();
        JOptionPane.showMessageDialog(null,salida);
        menu();
    }

    public static String mostrarLibros(){
        String salida="";
        if (!grupoLibros.isEmpty()){
            for (Libros libro:grupoLibros){
                salida+=libro.toString();
            }
        }else {
            salida="Libro no encontrado";
        }
        return salida;
    }

    public static int leerFecha(){
        int anioPubli=0;
        String anioString="";
        anioString=JOptionPane.showInputDialog(null ,"Ingrese la fecha de publicación");
        try {
            anioPubli= Integer.parseInt(anioString);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Ingrese un número entero, sin decimales");
        }
        return anioPubli;
    }

    public static int leerPaginas(){
        int numPaginas=0;
        String paginaString="";
        paginaString = JOptionPane.showInputDialog(null,"Ingrese el número de páginas");
        try {
            numPaginas= Integer.parseInt(paginaString);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Ingrese un número entero, sin decimales");
        }
        return numPaginas;
    }
}