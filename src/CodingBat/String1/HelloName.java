package CodingBat.String1;
// https://codingbat.com/prob/p171896
/*
Given a string name, e.g. "Bob", return a greeting of the form "Hello Bob!".

helloName("Bob") → "Hello Bob!"
helloName("Alice") → "Hello Alice!"
helloName("X") → "Hello X!"
 */
public class HelloName {
    public static String helloName(String name) {
        return "Hello " + name + "!";
    }

    public static void main(String[] args) {
        String name = "Bob";
        System.out.println(helloName(name));
    }
}
