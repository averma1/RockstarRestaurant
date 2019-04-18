package edu.ithaca.comp345.Rockstar;

public class Login extends Restaurant {

    public Login(int pin){
        String mode1= pins.get(pin);
        UIMode mode = UIMode.valueOf(mode1);

        if (mode == UIMode.manager) {
            //call manager UI
        } else if (mode == UIMode.host){
            //call host UI
        }else if (mode == UIMode.waiter){
            //call waiter UI
        }else if (mode == UIMode.bartender){
            //call bartender UI
        } else {
            throw new RuntimeException("UI entered invalid mode.");
        }
    }
    
}
