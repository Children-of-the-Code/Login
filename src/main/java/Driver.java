import Service.UserService;

public class Driver {
    public static void main(String[] args) {
        UserService serv = new UserService();
        System.out.println(serv);
        /*
        polymorphism: we changed the form that was
        inherited from Object by overriding its method
         */

        /*Collection API is all about
        java's data structure implementations
        that basically completely interface with java:
        for instance, they can be iterated over in
        an advanced for loop (because they implement
        the iterable interface)

        for(User u : users){
//            this is an advanced for loop
        }

        they also implement interfaces for their specific
        format of information
        (eg, the list interface contains all the methods
        vital for looking through an ordered collection
        of items, a set contains everything required to
        manipulate unique items (add, get, remove)

        primitives are basic units of information with
        no independent behavior (they don't have methods
        and just store a single thing,
        be it an int, char, double, byte, boolean, float,
        long, short

        the way you can think about objects vs primitives..
        objects have a memory reference and real location
        in memory, primitives are stored as-is

        this is the difference between the stack and the heap
        the heap memory contains objects , the stack
        contains primitive variables (as well as storing
        method calls in the call stack)


         */
    }
}
