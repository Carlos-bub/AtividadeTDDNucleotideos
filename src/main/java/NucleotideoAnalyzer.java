/**
 * Classe principal.
 * @author carloshenriquenascimento
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NucleotideoAnalyzer {

    public int[] calculaNucleotideos(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String sequence = reader.readLine().toUpperCase();
        reader.close();

        int[] counts = new int[5];
        for (char nucleotide : sequence.toCharArray()) {
            switch (nucleotide) {
                case 'A':
                    counts[0]++;
                    break;
                case 'C':
                    counts[1]++;
                    break;
                case 'G':
                    counts[2]++;
                    break;
                case 'T':
                    counts[3]++;
                    break;
                default:
                    counts[4]++; 
            }
        }

        
        if (counts[4] > sequence.length() * 0.1) {
            return null;
        }

        return counts;
    }
}
