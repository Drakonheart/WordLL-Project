/**
 * @author Aryan Farhang
 *
 * This class extends the Letter class and introduces new features. It has instance variables for content,
 * family, related, and a constant SINGLETON. The class provides two constructors to initialize these variables.
 *
 * The equals method compares two ExtendedLetter objects based on their family values and content, setting related to
 * true if they match. The toString method generates a string representation of the object, surrounding the content
 * with dots if the letter is unused and related.
 *
 * The fromStrings method creates an array of Letter objects from arrays of strings and codes. It iterates through the
 * arrays, creating ExtendedLetter objects with the given content and family values.
 *
 * Overall, the ExtendedLetter class enhances the functionality of the base Letter class by introducing additional
 * properties and methods. It enables comparisons of ExtendedLetter objects based on their family and content, provides
 * a customized string representation, and allows for the creation of letter arrays from strings and codes.
 */


public class ExtendedLetter extends Letter {

    private String content;
    private int family;
    private boolean related;
    private final int SINGLETON = -1;

    /**
     * This is the constructor for the ExtendedLetter class that takes a string s as a parameter. It calls the
     * superclass constructor Letter with a blank character as the argument. It initializes the content with the
     * provided string, sets related to false, and assigns SINGLETON to the family variable.
     *
     * @param s takes a string s as a parameter to be initialized.
     */

    public ExtendedLetter(String s) {
        super(' '); // Calling the superclass constructor and inputting blank since it won't be used
        this.content = s;
        this.related = false;
        this.family = SINGLETON;
    }


    /**
     * This line defines another constructor for the ExtendedLetter class that takes a string s and an integer fam as
     * parameters. It calls the superclass constructor Letter with a blank character as the argument. It initializes
     * the content with the provided string, sets related to false, and assigns the fam value to the family variable.
     *
     * @param s takes a string s as a parameter to be initialized.
     * @param fam takes in a int value.
     */

    public ExtendedLetter(String s, int fam) {
        super(' ');
        this.content = s;
        this.related = false;
        this.family = fam; // initializing family with a number
    }

    /**
     * This line overrides the equals method inherited from the Letter class. It takes an Object parameter otherObject
     * and checks if it is an instance of ExtendedLetter. If not, it returns false. It then casts otherObject to an
     * ExtendedLetter object and compares the family values. If they match, it sets related to true. Finally, it
     * compares the content of the letters and returns true if they are equal.
     *
     * @param otherObject this method will take an argument of otherObject type object. note the other object should be
     * of type Letter else it will return false.
     * @return If they match, returns true. else false.
     */


    @Override
    public boolean equals(Object otherObject) {
        if (!(otherObject instanceof ExtendedLetter)){ // if it's not the same type returns false
            return false;
        }
        ExtendedLetter otherLetter = (ExtendedLetter) otherObject;


        if (otherLetter.family == this.family) { // if the family matches related will be set to true.
            this.related = true;
        }
        if (otherLetter.content.equals(this.content)) { // if the otherLetter's content is the same as this content, it will return true
            return true;
        }
        return false;


    }

    /**
     * This toString method inherited from the Letter class. It generates a string representation of
     * the ExtendedLetter object. If the letter is unused and related, it returns the content surrounded by dots.
     * Otherwise, it calls the decorator method (not shown in the provided code) to generate a decorative string and
     * concatenates it with the content.
     *
     * @return the String representation;
     */

    @Override
    public String toString () {
        if (super.isUnused() && related) {
            return "." + content + ".";
        }

        return decorator() + content + decorator();


    }

    /**
     *
     * This line defines a static method named fromStrings that takes an array of strings content and an array of
     * integers codes as parameters. It creates an array of Letter objects called letters with the same length as
     * the content array. It then iterates through the content array and creates ExtendedLetter objects using the
     * content values. If the codes array is null, a standard ExtendedLetter object is created without a family value.
     * Finally, it returns the letters array.
     *
     * @param content an array of strings representing the content for each Letter object
     * @param codes codes   an array of integers representing the codes for each Letter object
     *              (can be null if no codes are provided)
     * @return array of Letter objects created based on the content and codes arrays
     */

    public static Letter[] fromStrings(String[] content,int[] codes) {
        Letter[] letters= new Letter[content.length];

        for (int i = 0; i < content.length; i++) {
            if (codes == null) {
                letters[i] = new ExtendedLetter(content[i]);
            } else {
                letters[i] = new ExtendedLetter(content[i], codes[i]);
            }
        }

        return letters;

    }

}
