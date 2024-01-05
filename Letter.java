/**
 * @author Aryan Farhang
 *
 * Class Summary: This calss "Letter," represents a letter and provides various functionalities related
 * to letter manipulation and comparison.
 *
 * The class has three private instance variables: letter, label, and three constant integer values UNSET, UNUSED, USED,
 * and CORRECT. The letter variable holds the character value of the letter, while the label variable represents the
 * label associated with the letter. The constants UNSET, UNUSED, USED, and CORRECT are used to define different label
 * values.
 *
 * In summary, the Letter class provides a representation of letters and includes various methods to manipulate
 * and compare them. It allows for setting labels, comparing equality, obtaining decorator symbols, and converting
 * letters from strings to objects. These functionalities enable convenient handling and processing of letters within
 * software applications.
 *
 * Further we will explore each method and the logics nehind it.
 *
 */
public class Letter {

    /**
     *The letter is a private instance variable of the Letter class that store a character type char from the
     * constructor
     */
    private char letter;

    /**
     *The label is a private instance variable of the Letter class that stores the label associated with the chosen
     * letter which is also initialized in the constructor as well.
     */
    private int label;
    /**
     *The UNSET is a private constant variable of which is initialized to 0. This number is only associated to the UNSET
     * variable.
     */
    private int UNSET = 0;

    /**
     *The UNUSED is a private constant variable of which is initialized to 1. This number is only associated to the UNUSED
     * variable.
     */
    private int UNUSED = 1;

    /**
     *The USED is a private constant variable of which is initialized to 2. This number is only associated to the USED
     * variable.
     */
    private int USED = 2;

    /**
     *The CORRECT is a private constant variable of which is initialized to 3. This number is only associated to the CORRECT
     * variable.
     */
    private int CORRECT = 3;

    /**
     *This is the constoctor where
     * @param c This constructor will take in an argument c type char and will initialize it to the instance variable letter.
     * Additionally, the instance variable label will be initialized to Unset with respect to the specific letter.
     */

    public Letter (char c) {
        label = UNSET;
        letter = c;

    }

    /**
     *
     * This method will take in an argument of type Object but will check to see if the argument is an instance of class letter.
     * If it is, it will check the instance variable of this letter to compare to the other instance variable of the letter
     * of the otherObject. If true it will return true. Else will return false.
     *
     * @param otherObject this method will take an argument of otherObject type object. note the other object should be
     * of type Letter else it will return false.
     * @return the function will return either true or false. It will return true if the other object is type Letter and
     * otherObject.letter equals to this.letter else it will return false.
     */

    public boolean equals (Object otherObject){
        if (otherObject instanceof Letter) { // The other object must be of type Letter
            if (this.letter == ((Letter) otherObject).letter) { // checks to see if the this.letter equals to otherObject.letter
                return true;
            }
            return false;

        }
        return false;
    }

    /**
     * This method will return either 4 different symbols in terms of what the object is assigned with:
     * Symbols: +, -, !, " "(space)
     * @return symbol 1: if the label is set to USED it will return "+"
     * symbol 2: if the label is set to UNUSED it will return "-"
     * symbol 3: if the label is set to CORRECT it will return "!"
     * symbol 4: if the label is set to UNSET it will return " "
     */

    public String decorator () {
        if (label == USED) {  // Set to used
            return "+";
        }
        else if (label == UNUSED) { // Set to Unused
            return "-";
        }
        else if (label == CORRECT) { // Set to Correct
            return "!";
        }

        return " "; // Set to Unset
    }

    /**
     * This toString will override the Object class toString method to display the letter label with the appropriate label
     * @return will return a String format of the labeled letter.
     */
    @Override
    public String toString () {
        return decorator() + this.letter + decorator(); // returning string format

    }

    /**
     * Will set the label with constant UNUSED
     */
    public void setUnused() {
        label = UNUSED;
    }

    /**
     * Will set the label with constant USED
     */
    public void setUsed() {

        label = USED;
    }

    /**
     * Will set the label with constant CORRECT
     */
    public void setCorrect() {
        label = CORRECT;
    }

    /**
     * Will return if the Letter's label is UNUSED or not
     */
    public boolean isUnused(){
        if (label == UNUSED) {
            return true; // returns true if label is UNUSED
        }
        return false;
    }

    /**
     * This method will convert converts a given string into an array of Letter objects.
     *
     * @param s the input string to be converted in object of type Letter
     * @return an array of Letter objects representing the characters in the input string
     */

    public static Letter[] fromString (String s) {
        Letter[] letterObjectArray = new Letter[s.length()]; // STORES object of type Letter(character)
        for (int objIndex = 0; objIndex < s.length(); objIndex++){
            letterObjectArray[objIndex] = new Letter(s.charAt(objIndex)); // appends the newly created object of type Letter
        }
        return letterObjectArray; // returns the array

    }

}
