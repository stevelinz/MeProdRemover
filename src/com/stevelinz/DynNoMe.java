package com.stevelinz;
import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DynNoMe {

    public static void main(String[] args) throws IOException {

        JOptionPane.showMessageDialog(null, "" +
            "Reads the Production Set file   " + "\n" +
            "Removes Standard Mekorma Products" +  " \n\nINSTRUCTIONS:" +  "\n\n" +
            "Browse to the .Set file on your machine    " + "\n\n" +
            "support@mekorma.com 2021                  " + "\n" +
            "REMOVE MEKORMA FOR TESTING               " + "\n" +
            "BEHAVIOR OF GP WITHOUT MEKORMA          ");

        JFileChooser fileChooser = new JFileChooser();

        int status = fileChooser.showOpenDialog(null);
        int once = 0;

        FileReader file = new FileReader(fileChooser.getSelectedFile());
        BufferedReader inputFile = new BufferedReader(file);

        List<String> fList = new ArrayList<String>();
        String listNew;


        if (status == JFileChooser.APPROVE_OPTION) {
            JOptionPane.showMessageDialog(null,

                            "Create a new file: like: DynNoMe  " + "\n\n" +
                            "LEAVE THE SET EXTENSION OFF (.set will be added) " + "\n\n" +

                            "Thank you for using this Utility. ");
        }
        int option = fileChooser.showSaveDialog(null);

        if (option == JFileChooser.APPROVE_OPTION) {
            File fileS = fileChooser.getSelectedFile();
            String filenameS = fileS.getPath();

            JOptionPane.showMessageDialog(null, "Saved: " + filenameS + ".set");
            FileWriter outFile = new FileWriter(fileS + ".set");

            while ((listNew = inputFile.readLine()) != null)
            {
                fList.add(listNew);
            }
            int productCount =Integer.parseInt(fList.get(0));
            productCount  = productCount - 5;
            String backToString=Integer.toString(productCount);
            fList.set(0, backToString);
            outFile.write(fList.get(0) + "\n");
            for (int i = 1; i < fList.size(); i++) {

                if(fList.get(i).contains("8209")) continue;
                if(fList.get(i).contains("Mekorma Enhanced ePayments")) continue;
                if(fList.get(i).contains("7156")) continue;
                if(fList.get(i).contains("Mekorma Products Manager")) continue;
                if(fList.get(i).contains("2404")) continue;
                if(fList.get(i).contains("Mekorma MICR")) continue;
                if(fList.get(i).contains("2916")) continue;
                if(fList.get(i).contains("MICR for Canadian Payroll")) continue;
                if(fList.get(i).contains("7150")) continue;
                if(fList.get(i).contains("Mekorma Multi-Batch Management")) continue;
                if(fList.get(i).contains("3183")) continue;
                if(fList.get(i).contains("Assign By Checkbook")) continue;
                if(fList.get(i).contains("MICR.DIC")) continue;
                if(fList.get(i).contains("MICRFRM.DIC")) continue;
                if(fList.get(i).contains("MICRRPT.DIC")) continue;
                if(fList.get(i).contains("MICRJOE.DIC")) continue;
                if(fList.get(i).contains("VPS.DIC")) continue;
                if(fList.get(i).contains("VPSFRM.DIC")) continue;
                if(fList.get(i).contains("VPSRPT.DIC")) continue;

                   outFile.write(fList.get(i) + "\n");
               }

            inputFile.close();
            outFile.flush();
            outFile.close();
        }


    }

}









