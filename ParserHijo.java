import java.util.Arrays;

public class ParserHijo extends Parser {
    private String[] palabrasDeprecadas;

    public ParserHijo(String[] palabrasDeprecadas) {
        this.palabrasDeprecadas = palabrasDeprecadas;
    }

    public String[] getPalabrasSeleccionadas() {
        String[] result = new String[1];
        for (String palabra : super.getPalabrasLeidas()) {
            if (!isInPalabrasDeprecadas(palabra)) {
                result[result.length - 1] = palabra;
                result = Arrays.copyOf(result, result.length + 1);
            }
        }

        return Arrays.copyOf(result, result.length - 1);
    }

    private boolean isInPalabrasDeprecadas(String palabra) {
        boolean result = false;

        int i = 0;
        while (i < palabrasDeprecadas.length && !palabrasDeprecadas[i].equalsIgnoreCase(palabra)) {
            ++i;
        }

        if (i < palabrasDeprecadas.length) {
            result = true;
        }

        return result;
    }
}
