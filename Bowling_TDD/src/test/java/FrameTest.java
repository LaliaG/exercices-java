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
import static org.mockito.Mockito.mock;
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
        generateur = mock(IGenerateur.class);
        simpleFrame = new Frame(generateur, false);
        lastFrame = new Frame(generateur, true);

    }

    @Test
    public void whenRoll_SimpleFrame_FirstRoll_Then_CheckScore () throws ExecutionControl.NotImplementedException {
       /* //Arrange
        //frame = new Frame(generateur);
        when(generateur.randomPin(anyInt())).thenReturn(5);

        //Act
        //
        //boolean result = frame.makeRoll(rolls);
        boolean canRollAgain = simpleFrame.makeRoll();

        //Assert
        assertEquals(5, simpleFrame.getScore());
        assertEquals(1, simpleFrame.getRolls().size());
        assertFalse(canRollAgain);*/
        // Arrange
        IGenerateur generateurMock = mock(IGenerateur.class);
        when(generateurMock.randomPin(10)).thenReturn(5); // Suppose que le lancer abat 5 quilles
        Frame frame = new Frame(generateurMock, false);

        // Act
        boolean result = frame.makeRoll();

        // Assert
        assertTrue(result);
        assertEquals(5, frame.getScore());
        assertEquals(1, frame.getRolls().size());
        assertEquals(5, frame.getRolls().get(0).getPins());
    }
    @Test
    public void wenRoll_SimpleFrame_SecondRoll_Then_CheckScore() throws ExecutionControl.NotImplementedException {
        //Arrange
        when(generateur.randomPin(anyInt())).thenReturn(5);
        simpleFrame.makeRoll();

        when(generateur.randomPin(anyInt())).thenReturn(9);

        //Act
        boolean canRollAgain = simpleFrame.makeRoll();

        //Assert
        assertEquals(9, simpleFrame.getScore());
        assertEquals(2, simpleFrame.getRolls().size());
        assertFalse(canRollAgain);

    }

    @Test
    public void whenRoll_SimpleFrame_SecondRoll_FirstRollStrike_Then_ReturnFalse() throws ExecutionControl.NotImplementedException {
       /* // Arrange
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

        when(generateur.randomPin(anyInt())).thenReturn(7);
        simpleFrame.makeRoll();

        // Act
        boolean canRollAgain = simpleFrame.makeRoll();

        // Assert
        assertEquals(7, simpleFrame.getScore());
        assertEquals(2, simpleFrame.getRolls().size());
        assertFalse(canRollAgain);
    }*/
        // Arrange
        IGenerateur generateurMock = mock(IGenerateur.class);
        when(generateurMock.randomPin(10)).thenReturn(10); // Suppose que le premier lancer abat 10 quilles (strike)
        Frame frame = new Frame(generateurMock, false);

        // Act
        boolean firstRollResult = frame.makeRoll(); // Premier lancer (strike)
        boolean secondRollResult = frame.makeRoll(); // Essayer un deuxième lancer

        // Assert
        assertTrue(firstRollResult); // Le premier lancer doit être autorisé
        assertFalse(secondRollResult); // Le deuxième lancer ne doit pas être autorisé après un strike
        assertEquals(10, frame.getScore()); // Le score doit être 10 après un strike
        assertEquals(1, frame.getRolls().size()); // Il doit y avoir exactement un lancer
        assertEquals(10, frame.getRolls().get(0).getPins()); // Le premier lancer doit avoir 10 quilles
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
        when(generateur.randomPin(anyInt())).thenReturn(15);

        // Act
        lastFrame.makeRoll();

        // Assert
        assertEquals(15, lastFrame.getScore());
    }

    @Test
    public void whenRoll_LastFrame_ThirdRoll_FirstRollStrike_Then_ReturnTrue() throws ExecutionControl.NotImplementedException {
        /*// Arrange
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
        when(generateur.randomPin(anyInt())).thenReturn(18);

        // Act
        lastFrame.makeRoll();

        // Assert
        assertEquals(18, lastFrame.getScore());
    }*/
        // Arrange
        IGenerateur generateurMock = mock(IGenerateur.class);
        when(generateurMock.randomPin(10)).thenReturn(10).thenReturn(5).thenReturn(3); // Premier lancer: 10, Deuxième lancer: 5, Troisième lancer: 3
        Frame frame = new Frame(generateurMock, true);

        // Act
        boolean firstRollResult = frame.makeRoll(); // Premier lancer (strike)
        boolean secondRollResult = frame.makeRoll(); // Deuxième lancer
        boolean thirdRollResult = frame.makeRoll(); // Troisième lancer

        // Assert
        assertTrue(firstRollResult); // Le premier lancer doit être autorisé
        assertTrue(secondRollResult); // Le deuxième lancer doit être autorisé
        assertTrue(thirdRollResult); // Le troisième lancer doit être autorisé
        assertEquals(18, frame.getScore()); // Le score doit être 18 (10 + 5 + 3)
        assertEquals(3, frame.getRolls().size()); // Il doit y avoir exactement trois lancers
        assertEquals(10, frame.getRolls().get(0).getPins()); // Le premier lancer doit avoir 10 quilles
        assertEquals(5, frame.getRolls().get(1).getPins()); // Le deuxième lancer doit avoir 5 quilles
        assertEquals(3, frame.getRolls().get(2).getPins()); // Le troisième lancer doit avoir 3 quilles
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
        when(generateur.randomPin(anyInt())).thenReturn(13);

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