public class Main {

    public static void main(String args[]) {
        Parser parser = new ParserHijo(new String[]{"Hola", "a", "este"});
        IParser parserConsola = new ParserConsola();
        IParser parserFicheros = new ParserFicheros("miFichero.txt");

        //Leo la cadena, imprimo en pantalla las palabras leidas, imprimo en un fichero las palabras leidas
        parser.leer(parserConsola, "Hola voy a aprobar este examen");
        parser.imprimir(parserConsola, parser.getPalabrasLeidas());
        parser.imprimir(parserFicheros, parser.getPalabrasLeidas());

        //Leo el fichero, imprimo en pantalla
        parser.leer(parserFicheros, "miFichero.txt");
        parser.imprimir(parserConsola, parser.getPalabrasLeidas());

        //Saco por pantalla palabras seleccionadas
        parser.imprimir(parserConsola, ((ParserHijo) parser).getPalabrasSeleccionadas());
    }
}
