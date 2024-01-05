/**
 * @author Aryan Farhang
 *
 * This class, WordLL, is used to manage a history of word guesses. The class has two
 * instance variables: mysteryWord, which stores the word to be guessed, and history, which is a linked list of guessed
 * words.
 *
 * The constructor WordLL(Word mystery) initializes the mysteryWord with the provided mystery word and sets the history
 * to null.
 *
 * The method tryWord(Word guess) takes a guess as input and labels the guess word using the labelWord method. It then
 * creates a new node with the guess word and adds it to the beginning of the history linked list.
 *
 * The toString() method iterates over the history linked list and concatenates the string representation of each word
 * node, separated by a newline character.
 *
 * Overall, this class provides a simple way to keep track of word guesses and their order in a linked list,
 * allowing for the examination of the guess history.
 *
 */


public class WordLL {


    /**
     * Here we declare a private instance variable called mysteryWord of type Word. It will store the mystery word to
     * be guessed.
     */
    private Word mysteryWord;

    /**
     * Here we declare a private instance variable called history of type LinearNode<Word>. It will store the linked
     * list of guessed words.
     */
    private LinearNode<Word> history;

    /**
     * this is the constructor of the WordLL class. It takes a Word object mystery as a parameter.
     * This line assigns the value of the mystery parameter to the mysteryWord variable. It stores the mystery word
     * for later reference.
     * This line initializes the history variable to null. It indicates that the history of word guesses is currently
     * empty.
     *
     * @param mystery will take in an argument of o mystery word type Word
     */

    public WordLL(Word mystery) {
        mysteryWord = mystery;
        history = null;
    }

    /**
     * This line defines a method named tryWord that takes a Word object guess as a parameter. It returns a boolean value indicating whether the guess was correct.
     *
     * @param guess This will be the guess word in which the user has chosen to be checked with the Password Word.
     * @return If the chosen word picked by the user is correct then it will return true. Else false.
     */
    public boolean tryWord(Word guess) {
        guess.labelWord(mysteryWord); // here we will call the labelWord method of the guess object and passes the mysteryWord as an argument. It labels the guess word based on the comparison with the mystery word.
        LinearNode<Word> node = new LinearNode<>(guess); // This line creates a new LinearNode object called node with the guess word as its element.

        //The below condition checks if the history linked list is empty. If it is, the node is assigned to history. Otherwise,
        // the next reference of the node is set to the current history head, and history is updated to node,
        // effectively adding the guess word to the beginning of the linked list.

        if (history == null) {
            history = node;
        }
        else {
            node.setNext(history);
            history = node;
        }
        return guess.labelWord(mysteryWord); // This line returns the result of the labelWord method called on the guess word, comparing it to the mysteryWord. It indicates whether the guess was correct
    }

    /**
     * This line defines the toString method, which returns a string representation of the WordLL object.
     * We can easily iterate through the  history linked list by using a while loop. It will then concatenate the
     * string representation of each element in the linked list, separated by a newline character. The node variable
     * is updated to the next node in each iteration.
     *
     * @return this method will finally will return each past words with their appropriate labels.
     */

    public String toString () {
        LinearNode<Word> node = history;
        String outPut = ""; // Here we declare a local variable outPut of type String and initializes it with an empty string.

        while(node != null) {
            outPut += node.getElement().toString()+"\n" ;
            node = node.getNext();
        }
        return outPut; // returns the string format of past words
    }

}
