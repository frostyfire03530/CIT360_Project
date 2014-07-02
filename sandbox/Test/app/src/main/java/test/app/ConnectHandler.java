package test.app;

import android.widget.TextView;

/**
 * Created by JMZ on 6/24/2014.
 */
public class ConnectHandler implements Handler {


    @Override
    public void handleIt(Object ... parameters) {
        //pull the CalculatorActivity from the Calculator class and assigns to activity
        AppMainActivity activity = (AppMainActivity) parameters[0];


       //declare Textviews from textViews pass from Calculator



    }
}
