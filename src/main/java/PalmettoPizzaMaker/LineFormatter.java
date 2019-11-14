package PalmettoPizzaMaker;

import java.util.NoSuchElementException;

public class LineFormatter {

    public static String formatForReceipt(String string){
        StringBuilder formatted = new StringBuilder();
        int numberOfSpaces = 0;

        String[] splitted = string.split("@");
        try{
            numberOfSpaces = 32 - (splitted[0].length() + splitted[1].length());
        }catch(NoSuchElementException e){
            e.printStackTrace();
        }
        if(numberOfSpaces < 1){
            throw new Error("String is not formatable!");
        }

        formatted.append(splitted[0]);
        formatted.append(new String(new char[numberOfSpaces]).replace("\0", " "));
        formatted.append(splitted[1]);

        return formatted.toString();
    }
    
}