package ex.o1.web;

import java.io.Serializable;
import org.apache.logging.log4j.*;

import ex.o1.Models.NumberPosition;
import ex.o1.services.CheckGuessNumber;
import ex.o1.services.ICheckGuessNumber;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@SessionScoped
@Named("numberDTO")
public class NumberBean implements Serializable 
{
    private static final Logger logger = LogManager.getLogger(CheckGuessNumber.class);
        
    @EJB
    private ICheckGuessNumber checkGuessNumberService;

    private int numberOne;
    private int numberTwo;
    private int numberThree;
    private int numberFour;
    private int numberFive;
    private int numberSix;
    private int chosenNumber;
    private int guessCount;

    private String numberOneColour = "numberField";
    private String numberTwoColour = "numberField";
    private String numberThreeColour = "numberField";
    private String numberFourColour = "numberField";
    private String numberFiveColour = "numberField";
    private String numberSixColour = "numberField";

    @PostConstruct
    public void init() {
        chosenNumber = checkGuessNumberService.GetRandomNumberFromList();
    }

    public void newGame()
    {
        reset();
        chosenNumber = checkGuessNumberService.GetRandomNumberFromList();
    }

    public void reset()
    {
        setNumberOneColour("numberField");
        setNumberTwoColour("numberField");
        setNumberThreeColour("numberField");
        setNumberFourColour("numberField");
        setNumberFiveColour("numberField");
        setNumberSixColour("numberField");

        setNumberOne(0);
        setNumberTwo(0);
        setNumberThree(0);
        setNumberFour(0);
        setNumberFive(0);
        setNumberSix(0);
    }


    public void guess() {

        var returnGuessOne = checkGuessNumberService.CheckNumberPosition(0,numberOne,chosenNumber);
        var returnGuessTwo = checkGuessNumberService.CheckNumberPosition(1,numberTwo,chosenNumber);
        var returnGuessThree = checkGuessNumberService.CheckNumberPosition(2,numberThree,chosenNumber);
        var returnGuessFour = checkGuessNumberService.CheckNumberPosition(3,numberFour,chosenNumber);
        var returnGuessFive = checkGuessNumberService.CheckNumberPosition(4,numberFive,chosenNumber);
        var returnGuessSix = checkGuessNumberService.CheckNumberPosition(5,numberSix,chosenNumber);

        if (returnGuessOne == NumberPosition.Blue) setNumberOneColour("numberFieldBlue");
        if (returnGuessTwo == NumberPosition.Blue) setNumberTwoColour("numberFieldBlue");
        if (returnGuessThree == NumberPosition.Blue) setNumberThreeColour("numberFieldBlue");
        if (returnGuessFour == NumberPosition.Blue) setNumberFourColour("numberFieldBlue");
        if (returnGuessFive == NumberPosition.Blue) setNumberFiveColour("numberFieldBlue");
        if (returnGuessSix == NumberPosition.Blue) setNumberSixColour("numberFieldBlue");

        if (returnGuessOne == NumberPosition.Green) setNumberOneColour("numberFieldGreen");
        if (returnGuessTwo == NumberPosition.Green) setNumberTwoColour("numberFieldGreen");
        if (returnGuessThree == NumberPosition.Green) setNumberThreeColour("numberFieldGreen");
        if (returnGuessFour == NumberPosition.Green) setNumberFourColour("numberFieldGreen");
        if (returnGuessFive == NumberPosition.Green) setNumberFiveColour("numberFieldGreen");
        if (returnGuessSix == NumberPosition.Green) setNumberSixColour("numberFieldGreen");

        if (returnGuessOne == NumberPosition.Red) setNumberOneColour("numberFieldRed");
        if (returnGuessTwo == NumberPosition.Red) setNumberTwoColour("numberFieldRed");
        if (returnGuessThree == NumberPosition.Red) setNumberThreeColour("numberFieldRed");
        if (returnGuessFour == NumberPosition.Red) setNumberFourColour("numberFieldRed");
        if (returnGuessFive == NumberPosition.Red) setNumberFiveColour("numberFieldRed");
        if (returnGuessSix == NumberPosition.Red) setNumberSixColour("numberFieldRed");

        if (returnGuessOne == NumberPosition.Orange) setNumberOneColour("numberFieldOrange");
        if (returnGuessTwo == NumberPosition.Orange) setNumberTwoColour("numberFieldOrange");
        if (returnGuessThree == NumberPosition.Orange) setNumberThreeColour("numberFieldOrange");
        if (returnGuessFour == NumberPosition.Orange) setNumberFourColour("numberFieldOrange");
        if (returnGuessFive == NumberPosition.Orange) setNumberFiveColour("numberFieldOrange");
        if (returnGuessSix == NumberPosition.Orange) setNumberSixColour("numberFieldOrange");

        if (returnGuessOne == NumberPosition.Yellow) setNumberOneColour("numberFieldYellow");
        if (returnGuessTwo == NumberPosition.Yellow) setNumberTwoColour("numberFieldYellow");
        if (returnGuessThree == NumberPosition.Yellow) setNumberThreeColour("numberFieldYellow");
        if (returnGuessFour == NumberPosition.Yellow) setNumberFourColour("numberFieldYellow");
        if (returnGuessFive == NumberPosition.Yellow) setNumberFiveColour("numberFieldYellow");
        if (returnGuessSix == NumberPosition.Yellow) setNumberSixColour("numberFieldYellow");

        guessCount++;
        logger.info("--- so far guessed: " + guessCount + " times.");
    }

    public int getNumberOne() {
        return numberOne;
    }

    public void setNumberOne(int numberOne) {
        this.numberOne = numberOne;

    }

    public int getNumberTwo() {
        return numberTwo;
    }

    public void setNumberTwo(int numberTwo) {
        this.numberTwo = numberTwo;
    }

    public int getNumberThree() {
        return numberThree;
    }

    public void setNumberThree(int numberThree) {
        this.numberThree = numberThree;
    }

    public int getNumberFour() {
        return numberFour;
    }

    public void setNumberFour(int numberFour) {
        this.numberFour = numberFour;
    }

    public int getNumberFive() {
        return numberFive;
    }

    public void setNumberFive(int numberFive) {
        this.numberFive = numberFive;
    }

    public int getNumberSix() {
        return numberSix;
    }

    public void setNumberSix(int numberSix) {
        this.numberSix = numberSix;
    }

    public int getGuessCount() {
        return guessCount;
    }

    public void setGuessCount(int guessCount) {
        this.guessCount = guessCount;
    }

    public String getNumberSixColour() {
        return numberSixColour;
    }

    public void setNumberSixColour(String numberSixColour) {
        this.numberSixColour = numberSixColour;
    }

    public String getNumberFiveColour() {
        return numberFiveColour;
    }

    public void setNumberFiveColour(String numberFiveColour) {
        this.numberFiveColour = numberFiveColour;
    }

    public String getNumberFourColour() {
        return numberFourColour;
    }

    public void setNumberFourColour(String numberFourColour) {
        this.numberFourColour = numberFourColour;
    }

    public String getNumberThreeColour() {
        return numberThreeColour;
    }

    public void setNumberThreeColour(String numberThreeColour) {
        this.numberThreeColour = numberThreeColour;
    }
    
    public String getNumberTwoColour() {
        return numberTwoColour;
    }

    public void setNumberTwoColour(String numberTwoColour) {
        this.numberTwoColour = numberTwoColour;
    }

    public String getNumberOneColour() {
        return numberOneColour;
    }

    public void setNumberOneColour(String numberOneColour) {
        this.numberOneColour = numberOneColour;
    }


    public int getChosenNumber() {
        return chosenNumber;
    }

    public void setChosenNumber(int chosenNumber) {
        this.chosenNumber = chosenNumber;
    }
}
