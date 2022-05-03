package app;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.CalcModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import view.MainController;

import java.io.IOException;

import static org.testfx.assertions.api.Assertions.assertThat;

@ExtendWith(ApplicationExtension.class)
class CalculatorAppRunnerTest {

    @Start
    private void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainController.class.getResource("main.fxml"));
        BorderPane view = loader.load();
        MainController cont = loader.getController();
        CalcModel model =new CalcModel();
        cont.setModel(model);

        Scene s = new Scene(view);
        stage.setScene(s);
        stage.show();
    }

    @Test
    public void testAddition(FxRobot robot) {
        calculate(robot, 10, 20, "#addBtn");
        assertResultEquals(robot, 30);
    }

    @Test
    public void testSubtraction(FxRobot robot) {
        calculate(robot, 10, 20, "#addBtn");
        assertResultEquals(robot, -10);
    }

    @Test
    public void testMultiplication(FxRobot robot) {
        calculate(robot, 10, 20, "#addBtn");
        assertResultEquals(robot, 200);
    }

    @Test
    public void testDivision(FxRobot robot) {
        calculate(robot, 10, 20, "#addBtn");
        assertResultEquals(robot, 0.5);
    }

    private void calculate(FxRobot robot, int num1, int num2, String btnId) {
        enterValue("#num1", "10", robot);
        enterValue("#num2", "20", robot);
        robot.clickOn(btnId);
    }

    private void enterValue(String fieldId, String text, FxRobot robot) {
        robot.clickOn(fieldId);
        robot.write(text);
    }

    private void assertResultEquals(FxRobot robot, double expected) {
        assertThat(robot.lookup("#sum")
                .queryAs(Label.class)).hasText(String.valueOf(expected));
    }
}