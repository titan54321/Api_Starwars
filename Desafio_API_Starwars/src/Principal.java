import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner lectura = new Scanner(System.in);
        ConsultaPelicula consulta= new ConsultaPelicula();
        System.out.println("Escribe el numero de la pelicula de Star Wars que quiere consultar: ");

        try{
            var numeroDePelicula = Integer.valueOf(lectura.nextLine());
            Pelicula pelicula = consulta.buscarPelicula(numeroDePelicula);
            System.out.println(pelicula);
            GeneradorDeArchivo generador  = new GeneradorDeArchivo();
            generador.guardarJson(pelicula);
        }catch (NumberFormatException e){
            System.out.println("El numero de la pelicula no puede ser String" + e.getMessage());
        }
        catch (RuntimeException | IOException e){
            System.out.println(e);
            System.out.println("Finalizando la aplicación");
        }

    }
}
