/* Try this 10-1
 * Compares two files.
 * To use this program, specify the names of the files to be compared in the program line
 * 
 * java CompFile FIRST.TXT SECOND.TXT
 */

 import java.io.*;

 class CompFiles {
    public static void main(String[] args) {
        int i = 0, j = 0;
        boolean flag = false;
        long position = 0;
        // First confirm that both files are specified.
        if(args.length != 2){
            System.out.println("Usage: CompFiles f1 f2");
            return;
        }

        // Compare two files.
        try (FileInputStream f1 = 
                new FileInputStream(args[0]);
            FileInputStream f2 = 
                new FileInputStream(args[1]))
        {
            // Check the file content contain 
            do {
                i = f1.read();
                j = f2.read();
                position ++;
                if( i != j){
                    System.out.println("The difference in position " + position + ": ");
                    System.out.println("    File 1: Value(int) " + i + "| Character: '" + (char) i + "'");
                    System.out.println("    File 2: Value(int) " + j + "| Character: '" + (char) j + "'");
                    flag = true; 
                } 
            } while( i != -1 && j !=-1);
        } catch(IOException exc) {
            System.out.println("I/O Error: " + exc);
        }
            if( flag ==false) {
            System.out.println("Files are same");}
    }
 }