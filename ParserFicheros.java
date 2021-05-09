import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ParserFicheros implements IParser {
    private String ruta;

    public ParserFicheros(String ruta) {
        this.ruta = ruta;
    }

    @Override
    public String[] obtenDatos(String datos) {
        String[] result = new String[1];
        Scanner sc = null;
        File file = null;
        try {
            file = new File(datos);
            sc = new Scanner(file);

            while (sc.hasNext()) {
                result[result.length - 1] = sc.next();
                result = Arrays.copyOf(result, result.length + 1);
            }

            sc.close();
        } catch (Exception e) {
            throw new MiParserException("Error en obten Fichero " + e.getMessage());
        }

        return Arrays.copyOf(result, result.length - 1);
    }

    @Override
    public boolean sacaDatos(String[] datos) {
        boolean result = true;
        PrintWriter pw = null;
        File file = null;
        try {
            file = new File(this.ruta);
            pw = new PrintWriter(file);

            for (String dato : datos) {
                pw.println(dato);
            }

            pw.flush();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }

        return result;
    }
}
