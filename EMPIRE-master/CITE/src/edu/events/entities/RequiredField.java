package edu.events.entities;

import gui.AfficherEventsController;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextInputControl;

/**
 * Created by pedro_000 on 7/2/2014.
 */
public class RequiredField extends ValidatorBase {
    public RequiredField()
    {
    }

    /***************************************************************************
     *                                                                         *
     * Methods                                                                 *
     *                                                                         *
     **************************************************************************/

    @Override
    public void eval()
    {
        if(srcControl.get() instanceof TextInputControl)
            evalTextInputField();
        else if (srcControl.get() instanceof ComboBox)
            evalComboBox();

    }

    protected void evalComboBox() {
        ComboBox comboBox = (ComboBox) srcControl.get();

        if (comboBox.getValue() == null || comboBox.getValue().toString().trim().isEmpty())
            hasErrors.set(true);
        else
            hasErrors.set(false);

        onEval();
    }

    protected void evalTextInputField()
    {
        TextInputControl textField = (TextInputControl) srcControl.get();
        if (textField.getText() == null || textField.getText().equals("")||textField.getText().matches("^[0-9\\\\s]*$") )
            
            hasErrors.set(true);
        
        else 
            hasErrors.set(false);

        onEval();
    }
      public void eval2()
    {
        TextInputControl textField = (TextInputControl) srcControl.get();
        if (textField.getText() == null || textField.getText().equals("")||textField.getText().matches("^[a-zA-Z\\\\s]*$") )
            
            hasErrors.set(true);
        
        else 
            hasErrors.set(false);

        onEval();
    }
     public void evaldate(DatePicker date){

     if(date.getValue() == null)
                     hasErrors.set(true);
     else 
            hasErrors.set(false);

        onEval();

     } 
  




    /***************************************************************************
     *                                                                         *
     * Properties                                                              *
     *                                                                         *
     **************************************************************************/

}
