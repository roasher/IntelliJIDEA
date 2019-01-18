package presentation.navigation_inside_class;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.File;
import java.util.List;

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

    @Data
    @AllArgsConstructor
    public class House {
        private String address;
        private int levelNums;
        private int appartmentsNum;
        private List<String> persons;
        private char height;
        private char lenght;
        private String discrict;
    }

}
