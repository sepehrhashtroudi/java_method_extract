import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.*;
import java.io.FileInputStream;
import java.lang.instrument.ClassDefinition;
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
//    static final PrinterConfiguration prettyPrinterNoCommentsConfiguration = new DefaultPrinterConfiguration();

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

        FileWriter fw = new FileWriter("./methods/" + pathname , false);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw);


        directoryName = PATH.concat("context/"+new_path);
        directory = new File(directoryName);
        if (! directory.exists()){
            directory.mkdirs();
            System.out.println(directoryName+ "  made");
            // If you require it to make the entire directory path including parents,
            // use directory.mkdirs(); here instead.
        }
        FileWriter context_fw = new FileWriter("./context/" + pathname , false);
        BufferedWriter context_bw = new BufferedWriter(context_fw);
        PrintWriter context_out = new PrintWriter(context_bw);


        directoryName = PATH.concat("method_names/"+new_path);
        directory = new File(directoryName);
        if (! directory.exists()){
            directory.mkdirs();
            System.out.println(directoryName+ "  made");
            // If you require it to make the entire directory path including parents,
            // use directory.mkdirs(); here instead.
        }
        FileWriter m_fw = new FileWriter("./method_names/" + pathname , false);
        BufferedWriter m_bw = new BufferedWriter(m_fw);
        PrintWriter m_out = new PrintWriter(m_bw);


        new VoidVisitorAdapter<Object>() {
            @Override
            public void visit(ClassOrInterfaceDeclaration n, Object arg) {
                super.visit(n, arg);
//                System.out.println(" * " + n.toString(Main.prettyPrinterNoCommentsConfiguration).replace("\n", "\t")+ "\n");
//                System.out.println(" * " + n.getDeclarationAsString());
//                m_out.println(n.getDeclarationAsString());
//                m_out.println(n.getNameAsString());
                context_out.println(n.getNameAsString());
//                out.println(n.toString(Main.prettyPrinterNoCommentsConfiguration).replace("\n", "\t"));
            }
        }.visit(StaticJavaParser.parse(filePath), null);

        new VoidVisitorAdapter<Object>() {
            @Override
            public void visit(MethodDeclaration n, Object arg) {
                super.visit(n, arg);
//                System.out.println(" * " + n.toString(Main.prettyPrinterNoCommentsConfiguration).replace("\n", "\t")+ "\n");
//                System.out.println(" * " + n.getDeclarationAsString());
                m_out.println(n.getDeclarationAsString());
                context_out.println(n.getDeclarationAsString());
                out.println(n.toString(Main.prettyPrinterNoCommentsConfiguration).replace("\n", " [EOL] ") + " <line_num>: " + n.getName().getBegin().get().line);

            }
        }.visit(StaticJavaParser.parse(filePath), null);

        CompilationUnit cu = StaticJavaParser.parse(filePath);
        for (TypeDeclaration<?> typeDec : cu.getTypes()) {
            for (BodyDeclaration<?> member : typeDec.getMembers()) {
                member.toFieldDeclaration().ifPresent(field -> {
                    for (VariableDeclarator variable : field.getVariables()) {

                        //Print the field's class typr
                        context_out.print(variable.getType()+ " ");
                        //Print the field's name

                        //Print the field's init value, if not null
                        if (variable.getInitializer().toString() != "Optional.empty"){
                            context_out.print(variable.getName()+ "=");
                            context_out.println(variable.getInitializer().toString());
                        }
                        else{
                            context_out.print(variable.getName());
                            context_out.println("");
                        }

//                        variable.getInitializer().ifPresent(initValue -> m_out.println(initValue.toString()));

                    }
                });
            }
        }
        System.out.println();
        out.close();
        m_out.close();
        context_out.close();
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
