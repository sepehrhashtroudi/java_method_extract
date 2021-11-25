import com.github.javaparser.ast.body.*;
import com.github.javaparser.*;
import java.io.FileInputStream;
import java.util.Scanner;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.github.javaparser.printer.configuration.DefaultConfigurationOption;
import com.github.javaparser.printer.configuration.DefaultPrinterConfiguration;
import com.github.javaparser.printer.configuration.PrinterConfiguration;

import java.io.*;

public class Main {

    static final PrinterConfiguration prettyPrinterNoCommentsConfiguration = new DefaultPrinterConfiguration().removeOption(new DefaultConfigurationOption(DefaultPrinterConfiguration.ConfigOption.PRINT_COMMENTS));

    static public void listClasses(String filePath, String pathname) throws IOException {

        FileWriter fw = new FileWriter("./tests/" + "CSVFormat" , true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw);
//        out.println(pathname);

        new VoidVisitorAdapter<Object>() {
            @Override
            public void visit(MethodDeclaration n, Object arg) {
                super.visit(n, arg);
                System.out.println(" * " + n.toString(Main.prettyPrinterNoCommentsConfiguration).replace("\n", "\t")+ "\n");
//                System.out.println(" * " + n.getDeclarationAsString());
//                Writer w = new FileWriter("output.txt");
                out.println(n.toString(Main.prettyPrinterNoCommentsConfiguration).replace("\n", "\t"));
            }
        }.visit(StaticJavaParser.parse(filePath), null);
        System.out.println();
        out.close();
    }

    public static void main(String [] args) throws Exception{
        String[] pathnames;
        // Creates a new File instance by converting the given pathname string
        // into an abstract pathname
        File f = new File("csv/");
        // Populates the array with names of files and directories
        pathnames = f.list();
        // For each pathname in the pathnames array
        for (String pathname : pathnames) {
            // Print the names of files and directories
            System.out.println(pathname);
            File text = new File("csv/"+ pathname);
            Scanner scanner = new Scanner(text);
            String all_text = "";
            int lineNumber = 1;
            while(scanner.hasNextLine()){
                String line = scanner.nextLine() + "\n";
                all_text += line;
                lineNumber++;
            }
            listClasses(all_text,pathname);
        }


    }
}
