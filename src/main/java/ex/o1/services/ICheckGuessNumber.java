package ex.o1.services;

import ex.o1.Models.NumberPosition;
import jakarta.ejb.Local;

@Local
public interface ICheckGuessNumber 
{
    public NumberPosition CheckNumberPosition(int index, int pickedNumber, int randomNumber);
    public int GetRandomNumberFromList();
}
