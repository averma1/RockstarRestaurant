package edu.ithaca.comp345.Rockstar;

public class Login extends Restaurant {

    public Login(int pin){
        if(isValidPin(pin)) {
            String mode1 = pins.get(pin);
            UIMode mode = UIMode.valueOf(mode1);

            if (mode == UIMode.manager) {
                //call manager UI
            } else if (mode == UIMode.host) {
                //call host UI
            } else if (mode == UIMode.waiter) {
                //call waiter UI
            } else if (mode == UIMode.bartender) {
                //call bartender UI
            } else {
                throw new RuntimeException("UI entered invalid mode.");
            }
        } else {
            throw new RuntimeException("Invalid pin");
        }
    }

    public boolean isValidPin(int pin){
        int length = (int) (Math.log10(pin) + 1);
        if(length==4) {
            if (pins.containsKey(pin)) {
                return true;
            }
        }
        return false;
    }

}
