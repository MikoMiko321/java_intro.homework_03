package geekbrains.java_intro.homework_03;


import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
//2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
//        При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
//        сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
//        apple – загаданное
//        apricot - ответ игрока
//        ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
//        Для сравнения двух слов посимвольно, можно пользоваться:
//        String str = "apple";
//        str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
//        Играем до тех пор, пока игрок не отгадает слово
//        Используем только маленькие буквы

public class Main {

    public static void main(String[] args) {
	Scanner myScanner = new Scanner(System.in);
	String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
	//Zagadivaem slovo
	String selectedWord = words[(int)Math.floor(Math.random()*words.length)];
	//System.out.println(selectedWord); //Spoiler dlia proverki
	System.out.println("You have to guess a word! It maybe one of the following:");
	System.out.println(Arrays.toString(words));
	String myGuess;
	StringBuilder lettersInPlace;
	do {
		System.out.println("Which word do you think I have selected?");
		myGuess = myScanner.nextLine();
		if (Objects.equals(myGuess, selectedWord)) {
			System.out.println("Correct!");

		} else {
		lettersInPlace = new StringBuilder("###############");
		int shortestWordLenght;
		if (selectedWord.length()<myGuess.length()) {
			shortestWordLenght = selectedWord.length();
		} else {
			shortestWordLenght = myGuess.length();
		}
		for (int i=0;i<shortestWordLenght;i++){
			if (myGuess.charAt(i)== selectedWord.charAt(i)) {
				lettersInPlace.setCharAt(i,myGuess.charAt(i));
			}
		}
		System.out.println("Wrong! But you have guessed the following letters in the word I have selected:");
		System.out.println(lettersInPlace);
		System.out.println("Now, try again!");
		}
	} while (!Objects.equals(myGuess, selectedWord));
    }
}
