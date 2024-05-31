import org.example.NotFoundException;
import org.example.RechercheVille;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class RechercheVilleTest {
    private List<String> villes = Arrays.asList("Valence", "Vancouver", "Budapest", "Rome", "Paris");
    @Test
    public void whentestRechercheVille_ThenNotFoundException() {
        // Arrange
        List<String> villes = Arrays.asList("Paris", "Lyon", "Marseille");
        RechercheVille rechercheVille = new RechercheVille(villes);

        // Act & Assert
        Assertions.assertThrows(NotFoundException.class, () -> {
            rechercheVille.rechercher("A");
        });
    }

    @Test
    public void testRechercheVille_UnsupportedOperationException() {
        // Arrange
        List<String> villes = Arrays.asList("Paris", "Lyon", "Marseille");
        RechercheVille rechercheVille = new RechercheVille(villes);

        // Act & Assert
        Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            rechercheVille.rechercher("Par");
        });
    }
}
