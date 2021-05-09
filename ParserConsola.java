import java.util.Arrays;
import java.util.Scanner;

public class ParserConsola implements IParser {

    @Override
    public String[] obtenDatos(String datos) {
        String[] result = new String[1];

        try (Scanner sc = new Scanner(datos)) {
            while (sc.hasNext()) {
                result[result.length - 1] = sc.next();
                result = Arrays.copyOf(result, result.length + 1);
            }
        } catch (Exception e) {
            throw new MiParserException("Error en obten Consola " + e.getMessage());
        }

        return Arrays.copyOf(result, result.length - 1);
    }

    @Override
    public boolean sacaDatos(String[] datos) {
        boolean result = true;
        StringBuilder sb = new StringBuilder();

        for (String dato : datos) {
            sb.append(dato + "\n");
        }

        try {
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }

        return result;
    }
}
