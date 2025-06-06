package QuizApp;

class QuestionAndAnswers{
	
	//Questions posing to user in each level
	String Questions[] = {"1: What is the capital of France?",
						"2: Which planet is known as the \"Red Planet\"?",
						"3: How many continents are there in the world?",
						"4: What is the smallest state in the USA?",
						"5: What gas do plants release into the air during photosynthesis?",
						"6.Which country is known as the \"Land of the Rising Sun\"? ",
						"7.Which country is famous for its chocolate and cheese?",
						"8.What is the name of the largest country in the world?",
						"9.Which country has three capital cities? ",
						"10.Who is the Father of \"Indian Constitution\"?"};
	//options for the respective questions
	String Options[] = {"1) Berlin\n"+ "2) Rome\n"+ "3) Paris\n"+ "4) London",
						"1) Earth\n"+ "2) Mars\n"+ "3) Jupiter\n"+ "4) Venus ",
						"1) 5\n"+ "2) 6\n"+ "3) 7\n"+ "4) 8\n"+ "",
						"1) Texas\n"+ "2) Florida\n"+ "3) Delaware\n"+ "4) Rhode Island ",
						"1) Oxygen\n"+ "2) Carbon Dioxide\n"+ "3) Nitrogen\n"+ "4) Water Vapor ",
						"1) Japan\n"+ "2) China\n"+ "3) South Korea\n"+ "4) India",
						"1) Italy\n"+ "2) Germany\n"+ "3) Switzerland\n"+ "4) Spain",
						"1) China\n"+ "2) India\n"+ "3) United States\n"+ "4) Russia",
						"1) Canada\n"+ "2) Australia\n"+ "3) South Africa\n"+ "4) Brazil",
						"1) B.R Ambedhkar\n" + "2) Gandhiji\n" + "3)Bose\n" + "4)Bhagat Singh"};
	int CorrectAnswersList[] = {3,2,3,3,1,1,3,4,4,1};
	
	String getQuestion(int number) {
		return Questions[number - 1];
	}
	String getOptions(int number) {
		return Options[number - 1];
	}
	int getAnswer(int number) {
		return CorrectAnswersList[number - 1];
	}
}