
// Names: Ammar Hatiya, Seodong Lim
// Sofware Systems Development and Integration Assignment 2



//          READ BELOW BEFORE RUNNING
// IMPORTANT NOTE: airline_safety.csv is currently as is from the canvas webpage.
// when you run the program, airline_safety.csv updates, and has an extra final column
// containing the total num of incidents. If you run the program again, make sure to 
// replace the airline_safety.csv with the original one from canvas or else it will
// keep adding more columns to the end of the file. Delete this note when submitting
package SSDI.Assignment2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.nio.file.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class App {
    public static void main(String[] args) {

        String file = "./src/main/resources/airline_safety.csv";

        // Try catch block to find the number of entries in the csv file:
        long numLines = 0;
        Path path = Paths.get(file);
        try {
            // much slower, this task better with sequence access
            // lines = Files.lines(path).parallel().count();
            numLines = Files.lines(path).count();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // List that we fill with extracted values from each column
        List<String> airline = new ArrayList<String>();
        List<String> avail_seat_km_per_week = new ArrayList<String>();
        List<String> incidents_85_99 = new ArrayList<String>();
        List<String> fatal_accidents_85_99 = new ArrayList<String>();
        List<String> fatalities_85_99 = new ArrayList<String>();
        List<String> incidents_00_14 = new ArrayList<String>();
        List<String> fatal_accidents_00_14 = new ArrayList<String>();
        List<String> fatalities_00_14 = new ArrayList<String>();
        List<String> totalNumIncidents = new ArrayList<String>();
        // List for stats of each column
        List<String> col_names = new ArrayList<String>();
        Double total_incidents_85_99 = 0.0;
        Double total_incidents_00_14 = 0.0;
        Double avg_incidents8599 = 0.0;
        Double avg_incidents0014 = 0.0;

        // read the airline_safety.csv file and store each columns data into an array
        String line;
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                // Get a list of all the column names so that we can
                // needed for part 2
                if (count == 0) {
                    for (int i = 1; i < 8; i++) {
                        col_names.add(line.split(",")[i]);
                    }
                }
                // add each column's data into it's own list
                airline.add(line.split(",")[0]);
                avail_seat_km_per_week.add(line.split(",")[1]);
                incidents_85_99.add(line.split(",")[2]);
                fatal_accidents_85_99.add(line.split(",")[3]);
                fatalities_85_99.add(line.split(",")[4]);
                incidents_00_14.add(line.split(",")[5]);
                fatal_accidents_00_14.add(line.split(",")[6]);
                fatalities_00_14.add(line.split(",")[7]);
                // For part 2, total all the different events
                // so that we can find average later
                total_incidents_85_99 += todouble(line.split(",")[2]);
                total_incidents_00_14 += todouble(line.split(",")[5]);

                count += 1;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        // For loop that sums both incident numbers (in each time period) and creates an
        // array full of them
        for (int i = 1; i < incidents_00_14.size(); i++) {
            int oldEra = Integer.parseInt(incidents_85_99.get(i));
            int newEra = Integer.parseInt(incidents_00_14.get(i));
            int total = oldEra + newEra;
            totalNumIncidents.add(Integer.toString(total));
        }
        // Update the airline_safety.csv by:
        // 1. making a new file sample.csv which copies all the contents of
        // airline_safety.csv
        // and adds the final column
        // 2. Overwriting our original airline_safety.csv with sample.csv
        File sample = new File("./src/main/resources/sample.csv");
        String reline;
        int track = 0;
        try (BufferedReader br2 = new BufferedReader(new FileReader(file))) {
            PrintWriter out = new PrintWriter(sample);
            while ((reline = br2.readLine()) != null) {
                String curr = reline;
                if (track != 0) {
                    curr = reline + "," + totalNumIncidents.get(track - 1);
                } else {
                    curr = reline + ",totalNumIncidents";
                }
                // System.out.println("CurrentLine is: " + curr);
                out.println(curr);
                track++;
            }
            out.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        Path from = sample.toPath(); // convert from File to Path
        Path to = Paths.get(file); // convert from String to Path
        try {
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Converts our csv file to an xml file and adds an extra 'column'
        // that contains
        // the total # of incidents from 85 to 14
        String xml_filepath = "./src/main/resources/converted_airline_safety.xml";
        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
            // root element
            Element root = document.createElement("AirlineData");
            document.appendChild(root);
            for (int i = 1; i < avail_seat_km_per_week.size(); i++) {
                // System.out.print("\n Airline Name is: " + airline.get(i));
                // airline element
                Element airline_el = document.createElement("airline");
                root.appendChild(airline_el);
                // Name Element
                Element name_el = document.createElement("Name");
                name_el.appendChild(document.createTextNode(airline.get(i)));
                airline_el.appendChild(name_el);
                // avail_seat_km_per_week element
                Element avail_seat_km_per_week_el = document.createElement("avail_seat_km_per_week");
                avail_seat_km_per_week_el.appendChild(document.createTextNode(avail_seat_km_per_week.get(i)));
                airline_el.appendChild(avail_seat_km_per_week_el);
                // incidents_85_99 element
                Element incidents_85_99_el = document.createElement("incidents_85_99");
                incidents_85_99_el.appendChild(document.createTextNode(incidents_85_99.get(i)));
                airline_el.appendChild(incidents_85_99_el);
                // email element
                Element fatal_accidents_85_99_el = document.createElement("fatal_accidents_85_99");
                fatal_accidents_85_99_el.appendChild(document.createTextNode(fatal_accidents_85_99.get(i)));
                airline_el.appendChild(fatal_accidents_85_99_el);
                // department elements
                Element fatalities_85_99_el = document.createElement("fatalities_85_99");
                fatalities_85_99_el.appendChild(document.createTextNode(fatalities_85_99.get(i)));
                airline_el.appendChild(fatalities_85_99_el);
                // incidents_85_99 element
                Element incidents_00_14_el = document.createElement("incidents_00_14");
                incidents_00_14_el.appendChild(document.createTextNode(incidents_00_14.get(i)));
                airline_el.appendChild(incidents_00_14_el);
                // email element
                Element fatal_accidents_00_14_el = document.createElement("fatal_accidents_00_14");
                fatal_accidents_00_14_el.appendChild(document.createTextNode(fatal_accidents_00_14.get(i)));
                airline_el.appendChild(fatal_accidents_00_14_el);
                // department elements
                Element fatalities_00_14_el = document.createElement("fatalities_00_14");
                fatalities_00_14_el.appendChild(document.createTextNode(fatalities_00_14.get(i)));
                airline_el.appendChild(fatalities_00_14_el);
                Element totalNumIncidents_el = document.createElement("Total_Incidents");
                totalNumIncidents_el.appendChild(document.createTextNode(totalNumIncidents.get(i - 1)));
                airline_el.appendChild(totalNumIncidents_el);
            }
            // create the xml file
            // transform the DOM Object to an XML File
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(xml_filepath));
            // If you use
            // StreamResult result = new StreamResult(System.out);
            // the output will be pushed to the standard output ...
            // You can use that for debugging
            transformer.transform(domSource, streamResult);
            System.out.println("Done creating XML File");
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
        // Creates the XML file needed for part 2
        String stats_xml_file = "./src/main/resources/airline_summary_statistic.xml";
        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
            // root element
            Element root = document.createElement("Summary");
            document.appendChild(root);
            for (int i = 0; i < 7; i++) {

                String line1;
                double c = 0;
                double avg = 0;
                double max = 0;
                double min = 1000000000;
                try (BufferedReader br1 = new BufferedReader(new FileReader(file))) {
                    while ((line1 = br1.readLine()) != null) {
                        String[] b = line1.split(",");
                        try {
                            double number = Double.parseDouble(b[i+1]);
                            avg += number;
                            c += 1;
                            if (number > max) {
                                max = number;
                            }
                            if (min > number) {
                                min = number;
                            }

                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                avg = avg/c;
                System.out.println("Column Name: " + col_names.get(i));
                System.out.println("Max: " + max);
                System.out.println("Min: " + min);
                System.out.println("Avg: " + avg);

                // Statistic element
                Element summary_el = document.createElement("Stat");
                root.appendChild(summary_el);
                // Name of column
                Element name_el = document.createElement("Name");
                name_el.appendChild(document.createTextNode(col_names.get(i)));
                summary_el.appendChild(name_el);
                // min element
                Element min_el = document.createElement("min");
                min_el.appendChild(document.createTextNode(Double.toString(min))); // MUST CHANGE
                summary_el.appendChild(min_el);
                // max element
                Element max_el = document.createElement("max");
                max_el.appendChild(document.createTextNode(Double.toString(max)));
                summary_el.appendChild(max_el);
                // avg element
                Element avg_el = document.createElement("avg");
                avg_el.appendChild(document.createTextNode(Double.toString(avg)));
                summary_el.appendChild(avg_el);
            }



            avg_incidents8599 = total_incidents_85_99 / numLines;
            avg_incidents0014 = total_incidents_00_14 / numLines;
            // Manually Add The last two Stat entries: Average incidents 85-99 and 00-14:
            // Stat Entry for AVG8599 element
            Element summary_el = document.createElement("Stat");
            root.appendChild(summary_el);
            // Name of column
            Element name_el = document.createElement("Name");
            name_el.appendChild(document.createTextNode("avg_85_99"));
            summary_el.appendChild(name_el);
            // min element
            Element min_el = document.createElement("min");
            min_el.appendChild(document.createTextNode(""));
            summary_el.appendChild(min_el);
            // max element
            Element max_el = document.createElement("max");
            max_el.appendChild(document.createTextNode(""));
            summary_el.appendChild(max_el);
            // avg element
            Element avg_el = document.createElement("avg");
            avg_el.appendChild(document.createTextNode(avg_incidents8599.toString()));
            summary_el.appendChild(avg_el);
            // Stat Entry for AVG0014
            Element summary2_el = document.createElement("Stat");
            root.appendChild(summary2_el);
            // Name of column
            Element name2_el = document.createElement("Name");
            name2_el.appendChild(document.createTextNode("avg_00_14"));
            summary2_el.appendChild(name2_el);
            // min element
            Element min2_el = document.createElement("min");
            min2_el.appendChild(document.createTextNode(""));
            summary2_el.appendChild(min2_el);
            // max element
            Element max2_el = document.createElement("max");
            max2_el.appendChild(document.createTextNode(""));
            summary2_el.appendChild(max2_el);
            // avg element
            Element avg_new = document.createElement("avg");
            avg_new.appendChild(document.createTextNode(avg_incidents0014.toString()));
            summary2_el.appendChild(avg_new);
            // create the xml file
            // transform the DOM Object to an XML File
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(stats_xml_file));
            transformer.transform(domSource, streamResult);
            System.out.println("Done creating XML File");
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }

    public static double todouble(String input) {
        double i = 0;
        try {
            i = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return i;
    }
}