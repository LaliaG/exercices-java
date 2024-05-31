import com.sun.jdi.Value;
import org.example.DiceScore;
import org.example.Ide;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class DiceScoreTest {
    private DiceScore diceScore ;

    private final Ide de = Mockito.mock(Ide.class);


    @Test
    public void WhenDeGetRoll_getScoreFirst_getScoreSecond_ThenDiceScoreReturnDieOfValue*2 + 10 (){
        //Arrange
        diceScore = new DiceScore(de);
        Mockito.when(de.getRoll()).thenReturn(DieOfValue*2 + 10);

        //Act
        int result = diceScore.getScore();

        //Assert
        Assert.assertTrue(result,DieOfValue*2 + 10
                );
    }

    @Test
    public void WhenDeLancerWithValue19_ThenJeuReturnFalse (){
        //Arrange
        jeu = new Jeu(de);
        Mockito.when(de.lancer()).thenReturn(19);

        //Act
        boolean result = jeu.jouer();

        //Assert
        Assert.assertFalse(result);
    }

}
