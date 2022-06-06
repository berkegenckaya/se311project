package Data;

import java.util.ArrayList;

public abstract class Interrupt {
    protected ArrayList<Application> applications = new ArrayList();
    protected boolean isHandled;


    public Interrupt(ArrayList<Application> applications, boolean isHandled) {
        this.applications = applications;
        this.isHandled = isHandled;
    }

    public void Attach(Application application){
        applications.add(application);
    }

    public void Detach (Application application) {
        for (int i = 0; i< applications.size(); i++) {
            if (applications.get(i).getName() == application.getName()) {
                applications.remove(i);
                return;
            }
        }
    }

    public void Notify() {

        for (int i = 0; i < applications.size(); i++) {
            //applications.get(i).Update(this);
        }
    }

    public ArrayList<Application> getApplications() {
        return applications;
    }

    public void setApplications(ArrayList<Application> applications) {
        this.applications = applications;
    }

    public boolean isHandled() {
        return isHandled;
    }

    public void setHandled(boolean handled) {
        isHandled = handled;
    }
}
