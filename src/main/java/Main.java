import com.github.javaparser.ast.body.*;
import com.github.javaparser.*;
import java.io.FileInputStream;
import java.util.Scanner;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.github.javaparser.printer.configuration.DefaultConfigurationOption;
import com.github.javaparser.printer.configuration.DefaultPrinterConfiguration;
import com.github.javaparser.printer.configuration.PrinterConfiguration;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.*;

public class Main {
    static String path = "lang3/";
    static final PrinterConfiguration prettyPrinterNoCommentsConfiguration = new DefaultPrinterConfiguration().removeOption(new DefaultConfigurationOption(DefaultPrinterConfiguration.ConfigOption.PRINT_COMMENTS));

    static public void listClasses(String filePath, String pathname) throws IOException {
        String PATH = "./";
        String new_path = "";
        for(int i=0; i < pathname.split("/").length - 1; i++){
            new_path += pathname.split("/")[i]+"/";
        }
        String directoryName = PATH.concat("methods/"+new_path);
        File directory = new File(directoryName);
        System.out.println(directoryName);
        if (! directory.exists()){
            directory.mkdirs();
            System.out.println(directoryName+ "   made");
            // If you require it to make the entire directory path including parents,
            // use directory.mkdirs(); here instead.
        }
        File file=new File("./methods/"+pathname);
        file.delete();
        FileWriter fw = new FileWriter("./methods/" + pathname , true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw);


        directoryName = PATH.concat("method_names/"+new_path);
        directory = new File(directoryName);
        if (! directory.exists()){
            directory.mkdirs();
            System.out.println(directoryName+ "  made");
            // If you require it to make the entire directory path including parents,
            // use directory.mkdirs(); here instead.
        }
        file=new File("./method_names/"+pathname);
        file.delete();
        FileWriter m_fw = new FileWriter("./method_names/" + pathname , true);
        BufferedWriter m_bw = new BufferedWriter(m_fw);
        PrintWriter m_out = new PrintWriter(m_bw);

//        directoryName = PATH.concat("test_names/");
//        directory = new File(directoryName);
//        if (! directory.exists()){
//            directory.mkdir();
//            // If you require it to make the entire directory path including parents,
//            // use directory.mkdirs(); here instead.
//        }
//        file=new File("./test_names/"+pathname);
//        file.delete();
//        FileWriter test_fw = new FileWriter("./test_names/" + pathname , true);
//        BufferedWriter test_bw = new BufferedWriter(test_fw);
//        PrintWriter test_out = new PrintWriter(test_bw);
//        out.println(pathname);

        new VoidVisitorAdapter<Object>() {
            @Override
            public void visit(MethodDeclaration n, Object arg) {
                super.visit(n, arg);
//                System.out.println(" * " + n.toString(Main.prettyPrinterNoCommentsConfiguration).replace("\n", "\t")+ "\n");
//                System.out.println(" * " + n.getDeclarationAsString());
                m_out.println(n.getDeclarationAsString());
//                Writer w = new FileWriter("output.txt");
                out.println(n.toString(Main.prettyPrinterNoCommentsConfiguration).replace("\n", "\t"));
            }
        }.visit(StaticJavaParser.parse(filePath), null);
        System.out.println();
        out.close();
        m_out.close();
//        test_out.close();
    }
    public static List<String> findFiles(Path path, String fileExtension)
            throws IOException {

        if (!Files.isDirectory(path)) {
            throw new IllegalArgumentException("Path must be a directory!");
        }

        List<String> result;

        try (Stream<Path> walk = Files.walk(path)) {
            result = walk
                    .filter(p -> !Files.isDirectory(p))
                    // this is a path, not string,
                    // this only test if path end with a certain path
                    //.filter(p -> p.endsWith(fileExtension))
                    // convert path to string first
                    .map(p -> p.toString())
                    .filter(f -> f.endsWith(fileExtension))
                    .collect(Collectors.toList());
        }

        return result;
    }

    public static void main(String [] args) throws Exception{
//        String[] pathnames;
        // Creates a new File instance by converting the given pathname string
        // into an abstract pathname
//        File f = new File(path);
        // Populates the array with names of files and directories
//        pathnames = f.list();
        List<String> pathnames = findFiles(Paths.get(path), "java");
        System.out.println(pathnames);
        // For each pathname in the pathnames array
        for (String pathname : pathnames) {
            // Print the names of files and directories
            System.out.println(pathname);
            File text = new File( pathname);
            Scanner scanner = new Scanner(text);
            String all_text = "";
            while(scanner.hasNextLine()){
                String line = scanner.nextLine() + "\n";
                all_text += line;

            }
            listClasses(all_text,pathname);
        }


    }
}
