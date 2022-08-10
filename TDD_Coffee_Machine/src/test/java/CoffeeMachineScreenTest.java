import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CoffeeMachineScreenTest {
    CoffeeMachineSystem coffeeMachine = new CoffeeMachineSystem();

        // underscores replace ":"

    @Test
    void ShouldReturnDrinkMakerMakes1TeaWith1SugarAndAAStickWhenCommandIsT_1_0() {
        String userCommand = "T:1:0";
        DrinkCommand command = coffeeMachine.toDrinkCommand(userCommand);
        String getCommandInSentence = coffeeMachine.getMessageToDisplay(command);
        assertThat(getCommandInSentence).isEqualTo("Drink maker makes 1 tea with 1 sugar and a stick");
    }

    @Test
    void ShouldReturnDrinkMakerMakes1ChocolateWithNoSugarAndThereforeNoStickWhenCommandIsH__() {
        String userCommand = "H::";
        DrinkCommand command = coffeeMachine.toDrinkCommand(userCommand);
        String getCommandInSentence = coffeeMachine.getMessageToDisplay(command);
        assertThat(getCommandInSentence).isEqualTo("Drink maker makes 1 chocolate with no sugar - and therefore no stick");
    }

    @Test
    void ShouldReturnDrinkMakerMakes1CoffeeWith2SugarsAndAStickWhenCommandIsC_2_0() {
        String userCommand = "C:2:0";
        DrinkCommand command = coffeeMachine.toDrinkCommand(userCommand);
        String getCommandInSentence = coffeeMachine.getMessageToDisplay(command);
        assertThat(getCommandInSentence).isEqualTo("Drink maker makes 1 coffee with 2 sugars and a stick");
    }

    @Test
    void ShouldReturnDrinkMakerMakes1OrangeJuiceWhenCommandIs0__() {
        String userCommand = "O::";
        DrinkCommand command = coffeeMachine.toDrinkCommand(userCommand);
        String getCommandInSentence = coffeeMachine.getMessageToDisplay(command);
        assertThat(getCommandInSentence).isEqualTo("Drink maker makes 1 orange juice");
    }

    @Test
    void ShouldReturnDrinkMakes1ExtraHotCoffeeWithNoSugarAndThereforeNoStickWhenCommandIsCh__() {
        String userCommand = "CH::";
        DrinkCommand command = coffeeMachine.toDrinkCommand(userCommand);
        String getCommandInSentence = coffeeMachine.getMessageToDisplay(command);
        assertThat(getCommandInSentence).isEqualTo("Drink maker makes 1 extra hot coffee with no sugar - and therefore no stick");
    }

    @Test
    void ShouldReturnDrinkMakerMakes1ExtraHotChocolateWith1SugarAndAStickWhenCommandIsHh_1_0() {
        String userCommand = "HH:1:0";
        DrinkCommand command = coffeeMachine.toDrinkCommand(userCommand);
        String getCommandInSentence = coffeeMachine.getMessageToDisplay(command);
        assertThat(getCommandInSentence).isEqualTo("Drink maker makes 1 extra hot chocolate with 1 sugar and a stick");
    }

    @Test
    void ShouldReturnDrinkMakerMakes1ExtraHotTeaWithTwoSugarsAndAStickWhenCommandIsTh_2_0() {
        String userCommand = "TH:2:0";
        DrinkCommand command = coffeeMachine.toDrinkCommand(userCommand);
        String getCommandInSentence = coffeeMachine.getMessageToDisplay(command);
        assertThat(getCommandInSentence).isEqualTo("Drink maker makes 1 extra hot tea with 2 sugars and a stick");
    }

    @Test
    void ShouldReturnDrinkMakerMakes1TeaWithNoSugarsAndThereforeNoStickWhenCommandIsT() {
        String userCommand = "T";
        DrinkCommand command = coffeeMachine.toDrinkCommand(userCommand);
        String getCommandInSentence = coffeeMachine.getMessageToDisplay(command);
        assertThat(getCommandInSentence).isEqualTo("Drink maker makes 1 tea with no sugar - and therefore no stick");
    }


}