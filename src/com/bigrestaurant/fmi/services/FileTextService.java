package com.bigrestaurant.fmi.services;

import com.bigrestaurant.fmi.model.*;


import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class FileTextService {

    private static FileTextService myInstance = new FileTextService();

    public static FileTextService getInstance(){
        return myInstance;
    }
    private FileTextService() {
    }

    public void writeBulkTextToFile(ArrayList<String> textToWrite, String fileNamePath){
        try{
            PrintWriter printWriter = new PrintWriter(new FileOutputStream(fileNamePath));
            for (String text: textToWrite){
                printWriter.println(text);
            }
            printWriter.flush();
            printWriter.close();

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void writeTextToFile(String textToWrite, String fileNamePath){
        try{
            PrintWriter printWriter = new PrintWriter(new FileOutputStream(fileNamePath));
            printWriter.println(textToWrite);
            printWriter.flush();
            printWriter.close();

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void appendTextToFile(String textToAppend, String fileNamePath){
        try{
            FileWriter fw = new FileWriter(fileNamePath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(textToAppend);
            bw.newLine();
            bw.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public ArrayList<FoodItem> readFoodItemsFromFile(String fileNamePath){
        ArrayList<FoodItem> foodItems = new ArrayList<>();

        try{

            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(fileNamePath));
            String line = lineNumberReader.readLine();

            // Read all lines from the file
            while(line != null){
                String[] values = line.split(",");

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                FoodItem currentFoodItem = new FoodItem(values[0], new Price(Float.parseFloat(values[1])),
                        simpleDateFormat.parse(values[2]), Integer.parseInt(values[3]), Float.parseFloat(values[4]));
                foodItems.add(currentFoodItem);

                line = lineNumberReader.readLine();
            }


        }catch (FileNotFoundException e){
            System.out.println("Error");
            e.printStackTrace();
        }catch (IOException|ParseException e){
            e.printStackTrace();
        }
        return foodItems;
    }

    public ArrayList<LiquidItem> readLiquidItemsFromFile(String fileNamePath){
        ArrayList<LiquidItem> liquidItems = new ArrayList<>();

        try{

            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(fileNamePath));
            String line = lineNumberReader.readLine();

            // Read all lines from the file
            while(line != null){
                String[] values = line.split(",");

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Boolean alcoholic = Boolean.parseBoolean(values[5]);
                Float alcoholAmount = 0f;
                alcoholAmount = alcoholic ? Float.parseFloat(values[6]) : 0;

                LiquidItem currentLiquidItem = new LiquidItem(values[0], new Price(Float.parseFloat(values[1])),
                        simpleDateFormat.parse(values[2]), Integer.parseInt(values[3]), Float.parseFloat(values[4]), alcoholic, alcoholAmount);
                liquidItems.add(currentLiquidItem);

                line = lineNumberReader.readLine();
            }


        }catch (FileNotFoundException e){
            System.out.println("Error");
            e.printStackTrace();
        }catch (IOException|ParseException e){
            e.printStackTrace();
        }
        return liquidItems;
    }

}
