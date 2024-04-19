package PruebaLoggroMain;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws Exception {

       //Esto de aqui lo uso a modo de prueba
       /*String[] SPANISH_WORDS = {
                "a", "abajo", "abierto", "abrazo", "abril", "agua",
                "ahora", "aire", "alma", "alto", "amar", "amigo",
                "amor", "anillo", "anoche", "ante", "apoyo", "aprender",
                "apto", "arroz", "arte", "atento", "año", "aún",
                "ayuda", "azul", "bajo", "belleza", "bien", "boca"
        };
        //Para mostrar los resultados impresos
        Arrays.stream(SPANISH_WORDS).forEach(Main::canWriteWord);*/

        System.out.println(canWriteWord("traje"));
       // System.out.println(canWriteWord("traje1"));

    }

    public static boolean isWord(String word) {
        /* Define un patron regular que acepte cualquier letra del alphabeto
         tanto con como sin tilde*/
        Pattern pattern = Pattern.compile("\\p{L}+");
        /*retorna true si cumple con el patron*/
        return pattern.matcher(word).matches();
    }

    public static boolean canWriteWord(String word) throws Exception {

        if (isWord(word)) {
            List<String> blocks = Arrays.asList("BO", "XK", "DQ", "CP", "NA",
                    "GT", "RE", "TG", "QD", "FS",
                    "HU", "VI", "AT", "OB", "ER",
                    "FS", "LY", "PC", "ZM", "JW");

            List<String> usedBlocks = new ArrayList<>();
            //El set no permite elementos repetidos
            Set<String> setBlocks = new HashSet<>(blocks);
            //Transformo la palabra para que siempre sea mayuscula
            String wordToUpperCase = word.toUpperCase();
            System.out.println(wordToUpperCase);
            // List<Boolean> hasCompletedWord = new ArrayList<>();
            for (int i = 0; i < wordToUpperCase.length(); i++) {

                char character = wordToUpperCase.charAt(i);

                AtomicBoolean letterFound = new AtomicBoolean(false);
                for (String b : setBlocks) {
                    if (b.indexOf(character) != -1) {
                        usedBlocks.add(b);
                        setBlocks.remove(b); // Remuevo los bloques que voy usando
                        letterFound.set(true); // Si la letra esta en algun bloque, seteo a true
                        break; // Cuando la letra esta en algun bloque salgo del ciclo
                    }
                }

                if (!letterFound.get()) {
                    System.out.println("Bloques usados-----------------------------");
                    usedBlocks.forEach(System.out::println);
                    System.out.println("NO es posible escribir usando los bloques la palabra: " + wordToUpperCase + " el resultado es: false-----------------------------");
                    return false; //Retorno false si alguna letra no se encuen
                }
            }

            // setBlocks.forEach(System.out::println);
            System.out.println("Bloques usados-----------------------------");
            usedBlocks.forEach(System.out::println);
            System.out.println("Se puede escribir con bloques la palabra: " + wordToUpperCase + " el resultado es:true-----------------------------");
            return true;
        }
        else {
            System.out.println("La cadena " + word + " no es una palabra");
            throw new Exception("Esto no es una palabra");
        }
    }
}