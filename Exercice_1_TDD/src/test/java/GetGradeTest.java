import org.example.GradingCalculator;
import org.junit.Assert;
import org.junit.Test;

import static javax.print.attribute.standard.MediaSizeName.A;

public class GetGradeTest {
    private GradingCalculator gradingCalculator;

    @Test
    public void WhenGrade_95_AndPresence_90_Then_A (){
        //Arrange
        gradingCalculator = new GradingCalculator(95, 90);

        //Act
        char gradGet = gradingCalculator.getGrade();

        //Assert
        Assert.assertEquals(gradGet,
                'A');
    }

    @Test
    public void WhenDivision_30_10_Then_3(){
        //Arrange
        calcul = new Calcul();
        double x = 30;
        double y = 10;

        //Act
        double result = calcul.division(x,y);

        //Assert
        Assert.assertEquals(3,result,0.01);
    }

    @Test
    public void WhenDivision_10_0_Then_DivideByZeroException (){
        //Arrange
        calcul = new Calcul();
        double x = 10;
        double y = 0;

        //ACt Arrange
        Assert.assertThrows(DivideByZeroException.class,()->{calcul.division(x,y);});
    }

}
