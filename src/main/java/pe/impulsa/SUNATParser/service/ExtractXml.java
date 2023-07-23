package pe.impulsa.SUNATParser.service;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;



public class ExtractXml {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        Map<String, String> filesContent = new HashMap<>();
        Set<File> listFilesUsingJavaIO = Stream.of(new File("/home/raknaros/xmls").listFiles()).collect(Collectors.toSet());
        for (File file:listFilesUsingJavaIO){
            String zipFilePath = file.toString();
            try (ZipFile zipFile = new ZipFile(zipFilePath)) {
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                while (entries.hasMoreElements()) {
                    ZipEntry entry = entries.nextElement();
                    if (!entry.isDirectory()) {
                        String entryName = entry.getName();
                        if (entryName.endsWith(".XML")) {  // Leer solo archivos de texto
                            InputStream inputStream = zipFile.getInputStream(entry);
                            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                            StringBuilder contentBuilder = new StringBuilder();
                            String line;
                            while ((line = bufferedReader.readLine()) != null) {
                                // Acumular el contenido del archivo
                                contentBuilder.append(line).append("\n");
                            }
                            bufferedReader.close();
                            // Guardar el nombre del archivo y su contenido en el Map
                            String fileContent = contentBuilder.toString();
                            filesContent.put(entryName, fileContent);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            /* Imprimir los nombres de los archivos y su contenido
            for (Map.Entry<String, String> entry : filesContent.entrySet()) {
                System.out.println("Archivo: " + entry.getKey());
                System.out.println("Contenido:\n" + entry.getValue());
            }*/
        }
        for(Map.Entry<String, String> entry : filesContent.entrySet()){
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db=dbf.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(entry.getValue()));
            Document doc=db.parse(is);
            System.out.println(doc.getDocumentElement().getNodeName());
        }
    }
}
