package test.app;

import java.util.HashMap;

/**
 * Created by JMZ on 6/24/2014.
 */
public class ApplicationController {
    private static HashMap<String, Handler> hashBrown = new HashMap<String, Handler>();
    static{


        //When you want to run the code for addition, you call the hashmap with the key of '+',
        //To add a new operation to the program, create a new class, add that class to the handler hashmap and done!

        //Create a New Instance of the AdditionHandler and add it to the hashmap with key = '+'
        ConnectHandler theConnectHandler = new ConnectHandler();
        hashBrown.put("connect", theConnectHandler);
        //Create a New Instance of the SubHandler and add it to the hashmap with key = '-'


    }

    public static void handleRequest(String command, Object ... parameters) {
        //instead of setting to handler can we use reflection to set the Type of anOperation
        //to the type of the result of controlHash.get(command); thereby giving us flexability
        Handler anOperation = hashBrown.get(command);
        anOperation.handleIt(parameters);
    }


}
