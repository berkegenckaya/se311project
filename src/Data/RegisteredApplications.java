package Data;

import java.util.ArrayList;

class RegisteredApplications extends Interrupt{
    public RegisteredApplications(ArrayList<Application> applications, boolean isHandled) {
        super(applications, isHandled);
    }

    public void setHandled(){
        isHandled = true;
        Notify();
    }
}
