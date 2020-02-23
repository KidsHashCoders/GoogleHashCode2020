package com.company;

import com.company.model.FileProblem;
import com.company.model.Library;
import com.company.model.Problem;
import com.company.model.ScoringComparator;
import com.company.utils.FileParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final class Files {
        private static final FileProblem A = new FileProblem("a_example.txt", "return_a.txt");
        private static final FileProblem B = new FileProblem("b_read_on.txt", "return_b.txt");
        private static final FileProblem C = new FileProblem("c_incunabula.txt", "return_c.txt");
        private static final FileProblem D = new FileProblem("d_tough_choices.txt", "return_d.txt");
        private static final FileProblem E = new FileProblem("e_so_many_books.txt", "return_e.txt");
        private static final FileProblem F = new FileProblem("f_libraries_of_the_world.txt", "return_f.txt");
    }

    private static final FileProblem CHOSEN_FILE = Files.F;


    private static final List<Library> resultLibraries = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        FileParser fileParser = new FileParser();
        Problem problem = fileParser.parseFile(CHOSEN_FILE.getInput());

        while (true) {
            if (problem.getDaysLeft() <= 0) {
                break;
            }

            if (problem.getLibraries().size() == 0) {
                break;
            }

            for (Library library : problem.libraries) {
                library.updateScore(problem.getDaysLeft());
            }
            problem.libraries.sort(ScoringComparator.instance);

            Library bestLibrary = problem.libraries.remove(0);
            resultLibraries.add(bestLibrary);
            problem.setDaysLeft(problem.getDaysLeft() - bestLibrary.getSignUpCost());
        }

        resultLibraries.addAll(problem.libraries);

        fileParser.writeOutput(CHOSEN_FILE.getOutput(), resultLibraries);
    }
}
