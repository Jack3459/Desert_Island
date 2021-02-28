import java.util.Arrays;
import java.util.Scanner;

public class OnsdagsOpgave {

  public static void main(String[] args) {
// udskriv muligheder
    displayThingsOnIsland(thingsOnIsland());

    int[] answers = inputAnswers(insertParticipant());

    //System.out.println("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]");

    int[] answerHistogram = countingAnswer(answers);
    displayPopularOption(answerHistogram);

  }

  public static String[] thingsOnIsland() {
    String[] options = {"kæreste", "kaffemaskine", "Netflix", "sofa", "løbesko", "guitar", "slik", "hund", "bog", "øl"};
    return options;
  }

  public static void displayThingsOnIsland(String[] options) {
    int countOption = 1;

    System.out.println("Hvilken ting vil du helst have med på en øde ø?");
    for (String option : options) {
      System.out.println(countOption + ".\t" + option);
      countOption++;
    }

    System.out.println();
  }

  public static int insertParticipant() {
    int participants;
    Scanner scanner = new Scanner(System.in);

    do {
      System.out.print("Hvor mange ville deltage i denne undersøgelse \nskriv hvormange der skal svare: ");
      while (!scanner.hasNextInt()) {
        System.out.println("Det er ikke et nummer!");
        System.out.print("Prøv igen at skrive hvormange der skal svare: ");
        scanner.next();
      }
      participants = scanner.nextInt();
      if (participants <= 0 ) {
        System.out.println("Der skal minumum være en deltager :-)");
      }
    } while (participants <= 0);

    return participants;

  }

  public static int[] inputAnswers(int participants) {
    int[] answers = new int[participants];
    int count = 1;

    Scanner scanner = new Scanner(System.in);

    for (int i = 0; i < answers.length; i++) {
      int scannerInput;

      do {
        System.out.print("Vælg mulighed (person " + count + "/" + answers.length + "): ");
        while (!scanner.hasNextInt()) {
          System.out.println("Det er ikke et nummer!");
          System.out.print("Vælg mulighed (person " + count + "/" + answers.length + "): ");
          scanner.next();
        }
        scannerInput = scanner.nextInt();

        if (scannerInput <= 0 || scannerInput > answers.length) {
          System.out.println("Nummert skal være på listen, indtast nummer mellem 1-" + answers.length);
        }
      } while (scannerInput <= 0 || scannerInput > answers.length);
      answers[i] = scannerInput - 1;
      count++;
    }

    return answers;
  }

  public static int[] countingAnswer(int[] answers) {
    int[] countAnswer = new int[answers.length];

    for (int answer : answers) {
      countAnswer[answer]++;
    }

    // System.out.println(Arrays.toString(countAnswer));
    return countAnswer;

  }

  public static int findBiggestNumber(int[] answers) {
    int chek = answers[0];
    int max = 0;

    for (int i = 1; i < answers.length; i++) {
      if (answers[i] > chek) {
        chek = answers[i];
        max = i;
      }
    }

    return max;
  }

  public static void displayPopularOption(int[] answers) {
    int max = findBiggestNumber(answers);
    String[] options = thingsOnIsland();

    System.out.println();
    System.out.println("Mest populær valg er: " + (max + 1) + ". " + options[max]);
  }

}

