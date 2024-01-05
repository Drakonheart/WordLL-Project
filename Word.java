/**
 * @author Aryan Farhang
 *
 * Class "Word," represents a word composed of individual letters and offers several functionalities
 * related to word manipulation and comparison. Here's a summary of what this class does:
 *
 * The class has a private instance variable named firstLetter, which represents the first letter of the word and is of
 * type LinearNode<Letter>. This variable is initialized in the constructor, taking an array of Letter objects as input.
 * The constructor creates a linked list of LinearNode objects, where each node corresponds to a letter in the array.
 *
 * This cllass will then overrides the toString method to provide a string representation of the word. It traverses the linked list,
 * concatenating the string representation of each letter with space.
 *
 * This class includes a method named labelWord, which compares the current Word object with another Word object
 * (referred to as "mystery") to determine the labeling of the letters. It then will set the label of the letters
 * accordingly, such as UNUSED, USED, or CORRECT, based on the comparison results. More dtails and logic is provided
 * throught out the code.
 */


public class Word {

    /**
     * This private instance variable will store the first letter of the object type LinearNode<Letter>
     */
    private final LinearNode<Letter> firstLetter;

    /**
     *the constructor initializes a Word object using an array of Letter objects. Here's a summary of what the constructor
     * does:
     *
     * The constructor takes an array of Letter objects, named letters, as input. It begins by creating a new LinearNode
     * object using the first letter from the letters array. This initial node is assigned to the firstLetter variable,
     * which represents the first letter of the word.
     *
     * Next, the constructor creates a reference variable curNode and assigns it the value of firstLetter. This
     * variable will be used to keep track of the current node during the iteration process.
     *
     * @param letters this argument will take in an array that store the type letter objects
     */
    public Word(Letter[] letters) {
        firstLetter = new LinearNode<>(letters[0]); // The first letter will be stored first
        LinearNode<Letter> curNode = firstLetter; // Temp node
        for (int i = 1; i < letters.length; i++) { // Making the nodes connected to another (making the linked list)
            curNode.setNext(new LinearNode<>(letters[i]));
            curNode = curNode.getNext(); // the next node that we just created from the before line;
        }

    }

    /**
     * This toString method will iterate through the linked list and will print each letter forming a word
     *
     * @return will return the word as a String format.
     */

    public String toString() {
        LinearNode<Letter> iteratorNode = firstLetter; // temp array
        String outPut= "Word: ";

        while (iteratorNode != null) {
            outPut += iteratorNode.getElement().toString() + " "; // Storing the words in a string format
            iteratorNode = iteratorNode.getNext();
        }

        return outPut;
    }

    /**
     *The labelWord method compares the current Word object with another Word object (referred to as "mystery") to
     * determine the labeling of the letters. It initializes variables to keep track of indices and the number of correct
     * labels. The method calculates the size of the mystery word by iterating through its linked list. Then, using nested
     * loops, it compares the letters at each position between the current and mystery words. Based on the comparison results,
     * it sets the labels of the letters accordingly. The method returns true if the number of correct labels matches the size
     * of both words, indicating a successful label match, and false otherwise.
     *
     * @param mystery
     * @return
     */


    public boolean labelWord (Word mystery) { // mystery is the "password word" input.
        LinearNode<Letter> thisNode = firstLetter; // the user's word referencing to the starter node
        LinearNode<Letter> mysteryNode = mystery.firstLetter;  // the password's word referencing to the starter node
        int mysterySize = 0; // number of characters in the password word
        int thisIndex = 0; // the index of the user word
        int mysteryIndex = 0; // the index of the password word
        int finalAnswer = 0; // this should match the size of the thisIndex

        while (mysteryNode != null) { // This loop will indicate the size of the mystery word
            mysterySize ++;
            mysteryNode = mysteryNode.getNext();

        }

        mysteryNode = mystery.firstLetter; // again signing the mysteryNode to the beginning of the linked list

        while (thisNode != null) {
            thisNode.getElement().setUnused(); // setting the user word letter to unset.
            while (mysteryNode != null) {

                    //This condition checks if the current letter in the current Word object matches the corresponding
                    //letter in the mystery Word object and if the indices of the letters are the same. If both conditions
                    //are met, it sets the label of the current letter to "CORRECT" and increments the final answer count
                    //by 1. It then breaks out of the inner loop.

                if (thisNode.getElement().equals(mysteryNode.getElement()) && thisIndex == mysteryIndex) {
                    thisNode.getElement().setCorrect();
                    finalAnswer += 1;
                    break;

                    //This condition checks if the current letter in the current Word object matches the corresponding
                    // letter in the mystery Word object. If they match, it sets the label of the current letter to
                    // "USED".

                } else if (thisNode.getElement().equals(mysteryNode.getElement())) {
                    thisNode.getElement().setUsed();

                    // This condition checks if the current letter in the mystery Word object is the last letter in the
                    // linked list and if the label of the current letter in the current Word object is "UNUSED". If
                    // both conditions are true, it sets the label of the current letter to "UNUSED" and breaks out
                    // of the inner loop.

                } else if (mysteryNode.getNext() == null && thisNode.getElement().isUnused()) {
                    thisNode.getElement().setUnused();
                    break;
                }
                mysteryIndex++;
                mysteryNode = mysteryNode.getNext();
            }

            thisNode = thisNode.getNext();
            mysteryNode = mystery.firstLetter; // Start again from the first node
            thisIndex++;
            mysteryIndex = 0;
        }

        // This condition checks if the index of the current letter in the current Word object (thisIndex) is equal
        // to the size of the mystery Word object (mysterySize) and also if it is equal to the final count of correctly
        // labeled letters (finalAnswer). If both conditions are met, it means that all letters in both words have been
        // compared and correctly labeled

        if (thisIndex == mysterySize && thisIndex == finalAnswer){
            return true;
        }
        return false;

    }

}
