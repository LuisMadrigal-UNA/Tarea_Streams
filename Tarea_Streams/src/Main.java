import java.util.*;
import java.util.stream.Collectors;

public class Main
{
    public static void main(String[] args)
    {
        List<Pelicula> peliculas = new ArrayList<>();
        peliculas.add(new Pelicula("E.T.", "Steven Spielberg", 1982));
        peliculas.add(new Pelicula("Avatar", "James Cameron", 2009));
        peliculas.add(new Pelicula("Salvar al soldado Ryan", "Steven Spielberg", 1998));
        peliculas.add(new Pelicula("Origen", "Christopher Nolan", 2010));
        peliculas.add(new Pelicula("L.A. Confidential", "Curtis Hanson", 1997));

        //Peliculas Ordenadas por la fecha de Estreno en el siglo XXI (Osea, El año 2000 para adelante).

        List<Pelicula> peliculasDelSigloXXI = peliculas.stream()
                .filter(p -> p.getEstreno() >= 2000)
                .toList();

        System.out.println("\nLas peliculas Estrenadas en el Siglo XXI: ");
        peliculasDelSigloXXI.forEach(p ->
                System.out.println(p.getTitulo() + " (" + p.getEstreno() + ")")
        );

        //Peliculas Ordenadas por Steven Spielberg (Pueden ser ya sea por este director o otro distinto.).

        String titulosSpielberg = peliculas.stream()
                .filter(p -> p.getDirector().equals("Steven Spielberg"))
                .map(Pelicula::getTitulo)
                .collect(Collectors.joining(", ")
                );

        System.out.println("\nLas Peliculas Hechas por Steven Spielberg: ");
        System.out.println(titulosSpielberg);

        //Peliculas Ordenadas Alfabeticamente (Ya manda que no se sepa xd, pero si es asi... basicamente empieza en A y termina en Z).

        List<String> titulosOrdenados = peliculas.stream()
                .map(Pelicula::getTitulo)
                .sorted()
                .collect(Collectors.toList());

        System.out.println("\nLas Peliculas Ordenadas Alfabeticamente: ");
        System.out.println(titulosOrdenados);

    }
}