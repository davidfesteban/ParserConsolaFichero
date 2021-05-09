public class Parser {
    private static final int TAM = 5;

    private String[] palabrasLeidas;

    public Parser() {
        this(TAM);
    }

    public Parser(int tam) {
        palabrasLeidas = new String[TAM];
    }

    public void leer(IParser parser, String datos) {
        try {
            palabrasLeidas = parser.obtenDatos(datos);
        } catch (MiParserException e) {
            System.err.println(e.getMessage());
        }
    }

    public void imprimir(IParser parser, String[] datos) {
        if (!parser.sacaDatos(datos)) {
            throw new RuntimeException("Error al imprimir");
        }
    }

    public String[] getPalabrasLeidas() {
        return palabrasLeidas;
    }
}
