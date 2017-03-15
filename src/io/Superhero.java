package io;




/*
 * - TASK: Extend the class Superhero as a subclass of Human.
 * - TASK: Add a String field that stores the hero's alter ego!
 * - TASK: Modify the given constructor by adding the alter ego as an additional parameter
 *   and setting it.
 * - TASK: Override the introduce() method to ALSO include the alter ego! (In other words,
 *   you should call the superclass introduce method when you override the method.)
*/

public class Superhero extends Human{
    
     private String alterEgo;
    
    public Superhero(String givenName, int age, String alterEgo) {
        super(givenName, age);
        this.alterEgo = alterEgo;
    }
    
    public String getAlterEgo() {
        return alterEgo;
    }
    
    public String introduce() {
        return "Hey! I'm " + super.getName() + ", My alter ego name is " + alterEgo + " and I'm " + super.getAge() + " years old.";
    }
    
    
}
