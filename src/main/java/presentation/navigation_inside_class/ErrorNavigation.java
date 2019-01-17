package presentation.navigation_inside_class;

import java.io.File;

public class ErrorNavigation {

    public void method(String path) {
        if (path == null) {
            throw new IllegalArgumentException("Input path be null");
        }
        String toUpperCase = path.trim();

        System.out.println(toUpperCase);


        /*
         * Some code
         *
         *
         *
         *
         *
         *
         *
         *
         *
         *
         *
         *
         *
         *
         *
         *
         *
         */

        StringBuilder stringBuilder = new StringBuilder(toUpperCase);
        stringBuilder.append(System.getProperty("line.separator"));
        stringBuilder.append("\t");
        stringBuilder.append(toUpperCase);

        String concat = toUpperCase.concat(stringBuilder.toString());
        System.out.println(concat);

        String file = toUpperCase + ".xml";
        boolean delete = new File(file).delete();
        System.out.println("File deletion: " + delete);
    }

}
