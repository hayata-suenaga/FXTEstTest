package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalcModelTest {

    CalcModel model;

    @BeforeEach
    void setup() {
        model = new CalcModel();
    }

    @Test
    void add() {
        setNums(8, 3);
        model.add();
        assertEquals(11, getResultVal());
    }

    @Test
    void subtract() {
        setNums(8, 3);
        model.subtract();
        assertEquals(5, getResultVal());
    }

    @Test
    void multiply() {
        setNums(8, 3);
        model.multiply();
        assertEquals(24, getResultVal());
    }

    @Test
    void divide() {
        setNums(8, 3);
        model.divide();
        assertEquals(8 / (double) 3, getResultVal());
    }

    private void setNums(int num1, int num2) {
        model.getNum1().setValue(num1);
        model.getNum2().setValue(num2);
    }

    private double getResultVal() {
        return model.getResult().getValue();
    }
}