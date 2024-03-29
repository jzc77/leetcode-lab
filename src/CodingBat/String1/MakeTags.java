package CodingBat.String1;

// https://codingbat.com/prob/p147483
/*
The web is built with HTML strings like "<i>Yay</i>" which draws Yay as italic text.
In this example, the "i" tag makes <i> and </i> which surround the word "Yay".
Given tag and word strings, create the HTML string with tags around the word, e.g. "<i>Yay</i>".

makeTags("i", "Yay") → "<i>Yay</i>"
makeTags("i", "Hello") → "<i>Hello</i>"
makeTags("cite", "Yay") → "<cite>Yay</cite>"
 */
public class MakeTags {
    public static String makeTags(String tag, String word) {
        return String.format("<%s>%s</%s>", tag, word, tag);
    }

    public static void main(String[] args) {
        String tag = "i";
        String word = "Hello";  // "<i>Hello</i>"
        System.out.println(makeTags(tag, word));
    }
}
