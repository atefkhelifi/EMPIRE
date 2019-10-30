package edu.events.entities;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.TextInputControl;

/**
 * Created by pedro_000 on 7/5/2014.
 */
public class CardinalityValidator extends ValidatorBase{

    /***************************************************************************
     *                                                                         *
     * Methods                                                                 *
     *                                                                         *
     **************************************************************************/

    @Override
    public void eval() {
        if(srcControl.get() instanceof TextInputControl)
            evalTextInputField();
    }

    private void evalTextInputField()
    {
        TextInputControl textField = (TextInputControl) srcControl.get();
        if (textField.getText() == null)
            hasErrors.set(true);
        else {
            String text = textField.getText();
            hasErrors.set(!evalString(text));
        }

        onEval();
    }

    /*
    @return Returns true if the evaluated string is correct according to this validator
     */
    protected boolean evalString(String text)
    {
        if (min.get() == -1) // no min value
        {
            if (max.get() == -1) // no max value
                return true;
            else if (text.length() <= max.get())
                return true;
            else
                return false;
        }
        else {  // min value exists
            if (max.get() == -1)    // no max value
            {
                if (text.length() >= min.get())
                    return true;
                else
                    return false;
            } else { // min and max value exist
                if (text.length() <= max.get() && text.length() >= min.get())
                    return true;
                else
                    return false;
            }
        }
    }

    /***************************************************************************
     *                                                                         *
     * Properties                                                              *
     *                                                                         *
     **************************************************************************/

    /***** min *****/
    protected SimpleIntegerProperty min = new SimpleIntegerProperty(-1);

    public void setMin(int min)
    {
        this.min.set(min);
    }

    public int getMin()
    {
        return this.min.get();
    }

    public IntegerProperty minProperty()
    {
        return this.min;
    }

    /***** max *****/
    protected SimpleIntegerProperty max = new SimpleIntegerProperty(-1);

    public void setMax(int max)
    {
        this.max.set(max);
    }

    public int getMax()
    {
        return this.min.get();
    }

    public IntegerProperty maxProperty()
    {
        return this.min;
    }

}
