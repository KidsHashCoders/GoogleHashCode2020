package com.company;

import com.company.model.*;
import com.company.utils.FileParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    private static final FileProblem[] FAST_FILES = { Files.A, Files.B, Files.C, Files.E, Files.F };

    private static final boolean ALL = false;

    public static void main(String[] args) throws IOException {
        if (ALL) {
            for (FileProblem fileProblem : FAST_FILES) {
                processProblem(fileProblem);
            }
        } else {
            processProblem(CHOSEN_FILE);
        }
    }

    private static void processProblem(FileProblem file) throws IOException {
        FileParser fileParser = new FileParser();
        Problem problem = fileParser.parseFile(file.getInput());


        final List<ResultLibrary> resultLibraries = new ArrayList<>();
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
            resultLibraries.add(bestLibrary.choseLibrary());
            problem.setDaysLeft(problem.getDaysLeft() - bestLibrary.getSignUpCost());
        }

        fileParser.writeOutput(file.getOutput(), resultLibraries);
    }
}
