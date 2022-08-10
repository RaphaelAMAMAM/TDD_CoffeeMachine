import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CoffeeMachineSystemTest {
    CoffeeMachineSystem coffeeMachineSystem = new CoffeeMachineSystem();

    // underscores replace ":"

    @Test
    void shouldReturnObjectWhenCommandInputFromUserIsT_1_0() {
        String userCommand = "T:1:0";
        DrinkCommand command = coffeeMachineSystem.toDrinkCommand(userCommand);
        assertThat(command.toString()).isEqualTo(new DrinkCommand(new Tea(), 1, true, false).toString());
    }

    @Test
    void shouldReturnObjectWhenCommandInputFromUserIsH__() {
        String userCommand = "H::";
        DrinkCommand command = coffeeMachineSystem.toDrinkCommand(userCommand);
        assertThat(command.toString()).isEqualTo(new DrinkCommand(new Chocolate(), 0, false, false).toString());
    }

    @Test
    void shouldReturnObjectWhenCommandInputFromUserIsC_2_0() {
        String userCommand = "C:2:0";
        DrinkCommand command = coffeeMachineSystem.toDrinkCommand(userCommand);
        assertThat(command.toString()).isEqualTo(new DrinkCommand(new Coffee(), 2, true, false).toString());
    }

    @Test
    void shouldReturnObjectWhenCommandInputFromUserIsVoid() {
        String userCommand = "";
        DrinkCommand command = coffeeMachineSystem.toDrinkCommand(userCommand);
        assertThat(command.toString()).isEqualTo(new DrinkCommand(null, 0, false, false).toString());
    }

    @Test
    void shouldReturnObjectWhenCommandInputFromUserIsCH__() {
        String userCommand = "CH::";
        DrinkCommand command = coffeeMachineSystem.toDrinkCommand(userCommand);
        assertThat(command.toString()).isEqualTo(new DrinkCommand(new Coffee(), 0, false, true).toString());
    }

    @Test
    void shouldReturnTrueWhenCommandInputFromUserIsT_1_0() {
        DrinkCommand userCommand = new DrinkCommand(new Tea(), 1, true, false);
        boolean isAValidCommand = coffeeMachineSystem.checkUserCommand(userCommand);
        assertThat(isAValidCommand).isTrue();
    }

    @Test
    void shouldReturnTrueWhenCommandInputFromUserIsH__() {
        DrinkCommand userCommand = new DrinkCommand(new Chocolate(), 0, false, false);
        boolean isAValidCommand = coffeeMachineSystem.checkUserCommand(userCommand);
        assertThat(isAValidCommand).isTrue();
    }

    @Test
    void shouldReturnTrueWhenCommandInputFromUserIsC_2_0() {
        DrinkCommand userCommand = new DrinkCommand(new Coffee(), 2, true, false);
        boolean isAValidCommand = coffeeMachineSystem.checkUserCommand(userCommand);
        assertThat(isAValidCommand).isTrue();
    }

    @Test
    void ShouldReturnTrueIfUserPutEnoughMoneyForHisDrink() {
        DrinkCommand userCommand = new DrinkCommand(new Coffee(), 2, true, false);
        double moneyFromUser = 0.6;
        boolean thereIsEnoughMoney = coffeeMachineSystem.userPutEnoughMoney(userCommand, moneyFromUser);
        assertThat(thereIsEnoughMoney).isTrue();
    }

    @Test
    void shouldReturnTrueWhenCommandInputFromUserIsCh__() {
        DrinkCommand userCommand = new DrinkCommand(new Coffee(), 0, false, true);
        boolean isAValidCommand = coffeeMachineSystem.checkUserCommand(userCommand);
        assertThat(isAValidCommand).isTrue();
    }

}