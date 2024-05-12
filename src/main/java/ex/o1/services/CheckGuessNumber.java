package ex.o1.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import jakarta.ejb.Stateless;
import org.apache.logging.log4j.*;

import ex.o1.Models.NumberPosition;

@Stateless
public class CheckGuessNumber implements ICheckGuessNumber 
{
    private static final Logger logger = LogManager.getLogger(CheckGuessNumber.class);

    @Override
    public int GetRandomNumberFromList()
    {
        List<Integer> numberList = new ArrayList<>();
        int number;

        try 
        {
            InputStream inputStream = getClass().getResourceAsStream("/numbers.txt");
            logger.info("--- reding numbers.txt ---");
            if (inputStream == null) 
            {
                logger.error("--- error at reading numbers.txt - inputStream is null ---");
                throw new IOException();
            }
            else
            {
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
    
                while ((line = reader.readLine()) != null) {
                    numberList.add(Integer.parseInt(line));
                }
                reader.close();
    
                Random random = new Random();
                int randomIndex = random.nextInt(numberList.size());
                number = numberList.get(randomIndex);
            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
            logger.error("--- error at reading numbers.txt ---" + e.getMessage());
            number = -1;
        }

        return number;
    }

    @Override
    public NumberPosition CheckNumberPosition(int index, int pickedNumber, int randomNumber) 
    {
        var pickedNumberString = Integer.toString(pickedNumber);
        var numberAsString = Integer.toString(randomNumber).toCharArray();
        var pickedChar =pickedNumberString.toCharArray()[0];

        if (numberAsString[index] == pickedChar)
        {
            return NumberPosition.Green;
        } 

        if (index > 0) 
        {
            if (numberAsString[index-1] == pickedChar) 
            {
                return NumberPosition.Yellow;
            }
        }

        if (index < 5) 
        {
            if (numberAsString[index+1] == pickedChar) 
            {
                return NumberPosition.Orange;
            }
        }

        if (new String(numberAsString).contains(pickedNumberString)) 
        {
            return NumberPosition.Blue;
        }

        return NumberPosition.Red;
    }
    
}
