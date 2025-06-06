package QuizApp;
import java.util.*;


public class ClassQuiz {

    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);
            Player p = new Player();
            QuestionAndAnswers qa = new QuestionAndAnswers();
            Validate vldte = new Validate();

            // total lifeline for the user to escape from the critical stage
            int lifeLines = 2;

            System.out.println("Quizzy!...");
            System.out.println("We are happy to Welcome you :) ...");

            //Getting the player details
            System.out.println("Please enter your Credentails! to Continue..");
            p.playerDetails(sc);

            System.out.println("Credentails Saved Successfully");

            //asking the player, if he is ready or not 
            System.out.println("Are you ready to play the game!...");
            String userWilling = sc.next();
            userWilling.toLowerCase();

            if (userWilling.equals("no")) {
                System.out.println("We Miss you, hope we will meet soon!...");
                System.exit(0);
            } else if (userWilling.equals("yes")) {
                System.out.println("Excited to see your talent: " + p.name);
                showRules s = new showRules();
//                Thread.sleep(3000);
                for(int load = 0; load < 5;load++) {
                	System.out.print("#");
                	Thread.sleep(1000);
                }
                System.out.println();
                boolean answered = true;
                int questionNumber = 1; //initializing the q.no
                int optionValue = 1; //initializing the option.no
                int answerValue = 1;
                int bounty = 0; //inital prize amount is set to 0
                int level = 1;

                //entering into the game
                while (answered && level <= 10) {
                	System.out.println();
                	Thread.sleep(1000);
                    System.out.println("level :" + level + " Questions Listed below...");
                    System.out.println(qa.getQuestion(questionNumber));
                    System.out.println(qa.getOptions(optionValue));
                    //Option for User to Force Quit
                    System.out.println("Force Quit(5)");
                    //option for a life line
                    if (lifeLines > 0) {
                        System.out.println("Use LifeLine(6)...");
                    }
                    //display life lines pending
                    System.out.println("LifeLines Pending: " + lifeLines);

                    int correctAns = qa.getAnswer(answerValue);
                    System.out.println("Select the Correct Option from Below ones..");
                    int userOption = sc.nextInt();
                    if (vldte.validating(userOption, correctAns)) {
                        level++; //incrementing the level and promoting to next level
                        System.out.println("Great! It is the right answer..you are moved to level " + level);
                        //System.out.println("Great! It is the right answer..you are moved to level "+level);
                        bounty += 1000; // incrementing the prize amount
                        questionNumber += 1; //changing to next question
                        answerValue += 1; //changing to next answer to compare
                        optionValue += 1; //showing the options from the indices
                    } else if (userOption == 5) { // if user want to force quit
                        System.out.println("Looks like you are interested to continue the game :(..");
                        System.out.println("Thank you for participating...");
                        System.out.println("Total Bounty you have won so far : " + bounty);
                        answered = false;
                        System.exit(0);
                    } else if (userOption == 6) {
                        if (lifeLines > 1) {
                            System.out.println("Your First life line would be 50 - 50 options As mentioned in the rules");
                            System.out.println(qa.getQuestion(questionNumber));
                            System.out.println("The Answer is Either option " + correctAns + " or " + ((correctAns > 3) ? (correctAns - 1) : 4) + "option");
                            int reEnterOpt = sc.nextInt();
                            if (vldte.validating(correctAns, reEnterOpt)) {
                                level++; //incrementing the level and promoting to next level
                                System.out.println("Great! It is the right answer..you are moved to level " + level);
                                //System.out.println("Great! It is the right answer..you are moved to level "+level);
                                bounty += 1000; // incrementing the prize amount
                                questionNumber += 1; //changing to next question
                                answerValue += 1; //changing to next answer to compare
                                optionValue += 1; //showing the options from the indices
                            } else {
                                System.out.println("Ohhhh!... It is a wrong answer");
                                System.out.println("You are leaving this game with " + bounty + " bounty");
                                answered = false; //break the loop
                            }
                            lifeLines--;
                        } else if (lifeLines == 1) {
                            //						System.out.println(qa.getQuestion(questionNumber));
                            //						System.out.println(qa.getOptions(optionValue));
                            System.out.println("Below are the percentages for each option polled by audience");
                            String[] splittedOpt = qa.getOptions(questionNumber).split("\n");
                            String[] per = {
                                "15",
                                "50",
                                "20",
                                "15"
                            };
                            int iter = 0;
                            for (String o: splittedOpt) {
                                System.out.println(o + " " + per[iter]+"%");
                                iter++;
                            }
                            int selectOpt = sc.nextInt();
                            if (vldte.validating(correctAns, selectOpt)) {
                                level++; //incrementing the level and promoting to next level
                                System.out.println("Great! It is the right answer..you are moved to level " + level);
                                //System.out.println("Great! It is the right answer..you are moved to level "+level);
                                bounty += 1000; // incrementing the prize amount
                                questionNumber += 1; //changing to next question
                                answerValue += 1; //changing to next answer to compare
                                optionValue += 1; //showing the options from the indices
                            } else {
                                System.out.println("Ohhhh!... It is a wrong answer");
                                System.out.println("You are leaving this game with " + bounty + " bounty");
                                answered = false; //break the loop
                            }
                            lifeLines--;
                        }

                    } else {
                        //user failed to answer the question correctly
                        System.out.println("Ohhhh!... It is a wrong answer");
                        System.out.println("You are leaving this game with " + bounty + " bounty");
                        answered = false; //break the loop
                    }
                }

                if (level >= 10) {
                    System.out.println("Congratulations!.. You have passed all the levels and won the Big bounty of :" + bounty);
                    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    System.out.println("@                                                                                   @");
                    System.out.println("@                        Congratulations! "+p.name+"                                    @");
                    System.out.println("@                                                                                   @");
                    System.out.println("@                       Total Bounty Earned "+bounty+"                                   @");
                    System.out.println("@                                                                                   @");
                    System.out.println("@                                                                                   @");
                    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                }
            } else {
                System.out.println("select a proper option...");
            }


        } catch (Exception e) { //handling the exception
            System.out.println("Something Went Wrong, try re-running the application before using it...");
            e.printStackTrace();
        }
    }

}