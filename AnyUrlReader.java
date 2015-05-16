
package parser;

import java.net.*;
import java.io.*;
import java.io.Console;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class AnyUrlReader {

    public static void main(String[] args) throws Exception {
        Console console = System.console();
        if (console == null) {
            System.err.println("No console.");
            System.exit(1);
        }
        while (true) {

            Pattern pattern = 
            Pattern.compile(console.readLine("%nEnter your regex: "));


            URL oracle = new URL(console.readLine("Enter URL: "));
            BufferedReader in = new BufferedReader(
            new InputStreamReader(oracle.openStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null)
            //System.out.println(inputLine);
            in.close();

            Matcher matcher = 
            pattern.matcher(inputLine);

            boolean found = false;
            while (matcher.find()) {
                console.format("I found the text" +
                    " \"%s\" starting at " +
                    "index %d and ending at index %d.%n",
                    matcher.group(),
                    matcher.start(),
                    matcher.end());
                found = true;
            }
            if(!found){
                console.format("No match found.%n");
            
            //in.close();
            }
        }
    }
}

