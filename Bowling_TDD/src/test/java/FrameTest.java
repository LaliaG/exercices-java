import jdk.jshell.spi.ExecutionControl;
import org.example.Frame;
import org.example.IGenerateur;
import org.example.Roll;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FrameTest {
    //private Roll roll;
    private Frame simpleFrame;
    private Frame lastFrame;
    private  IGenerateur generateur;

    /*public FrameTest(IGenerateur generateur) {
        this.generateur = generateur;
    } = Mockito.mock(IGenerateur.class);*/


    @BeforeEach
    public void setUp(){
        generateur = Mockito.mock(IGenerateur.class);
        simpleFrame = new Frame(generateur, false);
        lastFrame = new Frame(generateur, true);

    }

    @Test
    public void whenRoll_SimpleFrame_FirstRoll_Then_CheckScore () throws ExecutionControl.NotImplementedException {
        //Arrange
        //frame = new Frame(generateur);
        when(generateur.randomPin(anyInt())).thenReturn(6);

        //Act
        //
        //boolean result = frame.makeRoll(rolls);
        boolean canRollAgain = simpleFrame.makeRoll();

        //Assert
        assertEquals(6, simpleFrame.getScore());
        assertEquals(1, simpleFrame.getRolls().size());
        assertFalse(canRollAgain);
    }
    @Test
    public void wenRoll_SimpleFrame_SecondRoll_Then_CheckScore() throws ExecutionControl.NotImplementedException {
        //Arrange
        when(generateur.randomPin(anyInt())).thenReturn(5);
        simpleFrame.makeRoll();

        when(generateur.randomPin(anyInt())).thenReturn(4);

        //Act
        boolean canRollAgain = simpleFrame.makeRoll();

        //Assert
        assertEquals(9, simpleFrame.getScore());
        assertEquals(2, simpleFrame.getRolls().size());
        assertFalse(canRollAgain);

    }

    @Test
    public void whenRoll_SimpleFrame_SecondRoll_FirstRollStrike_Then_ReturnFalse() throws ExecutionControl.NotImplementedException {
        // Arrange
        when(generateur.randomPin(anyInt())).thenReturn(10);

        // Act
        boolean canRollAgain = simpleFrame.makeRoll();

        // Assert
        assertEquals(10, simpleFrame.getScore());
        assertEquals(1, simpleFrame.getRolls().size());
        assertFalse(canRollAgain);
    }
    @Test
    public void whenRoll_SimpleFrame_MoreRolls_Then_ReturnFalse() throws ExecutionControl.NotImplementedException {
        // Arrange
        when(generateur.randomPin(anyInt())).thenReturn(3);
        simpleFrame.makeRoll();

        when(generateur.randomPin(anyInt())).thenReturn(4);
        simpleFrame.makeRoll();

        // Act
        boolean canRollAgain = simpleFrame.makeRoll();

        // Assert
        assertEquals(7, simpleFrame.getScore());
        assertEquals(2, simpleFrame.getRolls().size());
        assertFalse(canRollAgain);
    }

    @Test
    public void whenRoll_LastFrame_SecondRoll_FirstRollStrike_Then_ReturnTrue() throws ExecutionControl.NotImplementedException {
        // Arrange
        when(generateur.randomPin(anyInt())).thenReturn(10);
        lastFrame.makeRoll();

        // Act
        boolean canRollAgain = lastFrame.makeRoll();

        // Assert
        assertTrue(canRollAgain);
    }

    @Test
    public void whenRoll_LastFrame_SecondRoll_FirstRollStrike_Then_CheckScore() throws ExecutionControl.NotImplementedException {
        // Arrange
        when(generateur.randomPin(anyInt())).thenReturn(10);
        lastFrame.makeRoll();
        when(generateur.randomPin(anyInt())).thenReturn(5);

        // Act
        lastFrame.makeRoll();

        // Assert
        assertEquals(15, lastFrame.getScore());
    }

    @Test
    public void whenRoll_LastFrame_ThirdRoll_FirstRollStrike_Then_ReturnTrue() throws ExecutionControl.NotImplementedException {
        // Arrange
        when(generateur.randomPin(anyInt())).thenReturn(10);
        lastFrame.makeRoll();
        when(generateur.randomPin(anyInt())).thenReturn(5);
        lastFrame.makeRoll();

        // Act
        boolean canRollAgain = lastFrame.makeRoll();

        // Assert
        assertTrue(canRollAgain);
    }

    @Test
    public void whenRoll_LastFrame_ThirdRoll_FirstRollStrike_Then_CheckScore() throws ExecutionControl.NotImplementedException {
        // Arrange
        when(generateur.randomPin(anyInt())).thenReturn(10);
        lastFrame.makeRoll();
        when(generateur.randomPin(anyInt())).thenReturn(5);
        lastFrame.makeRoll();
        when(generateur.randomPin(anyInt())).thenReturn(3);

        // Act
        lastFrame.makeRoll();

        // Assert
        assertEquals(18, lastFrame.getScore());
    }

    @Test
    public void whenRoll_LastFrame_ThirdRoll_Spare_Then_ReturnTrue() throws ExecutionControl.NotImplementedException {
        // Arrange
        when(generateur.randomPin(anyInt())).thenReturn(5);
        lastFrame.makeRoll();
        when(generateur.randomPin(anyInt())).thenReturn(5);
        lastFrame.makeRoll();

        // Act
        boolean canRollAgain = lastFrame.makeRoll();

        // Assert
        assertTrue(canRollAgain);
    }

    @Test
    public void whenRoll_LastFrame_ThirdRoll_Spare_Then_CheckScore() throws ExecutionControl.NotImplementedException {
        // Arrange
        when(generateur.randomPin(anyInt())).thenReturn(5);
        lastFrame.makeRoll();
        when(generateur.randomPin(anyInt())).thenReturn(5);
        lastFrame.makeRoll();
        when(generateur.randomPin(anyInt())).thenReturn(3);

        // Act
        lastFrame.makeRoll();

        // Assert
        assertEquals(13, lastFrame.getScore());
    }

    @Test
    public void whenRoll_LastFrame_FourthRoll_Then_ReturnFalse() throws ExecutionControl.NotImplementedException {
        // Arrange
        when(generateur.randomPin(anyInt())).thenReturn(5);
        lastFrame.makeRoll();
        lastFrame.makeRoll();
        lastFrame.makeRoll();

        // Act
        boolean canRollAgain = lastFrame.makeRoll();

        // Assert
        assertFalse(canRollAgain);
    }
}