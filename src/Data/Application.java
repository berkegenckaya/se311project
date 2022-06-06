package Data;

public class Application implements Observer{
    private String name;
    private Interrupt _interrupt;
    private boolean _isHandled;

    public Application(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void Action(Interrupt interrupt) {
            _isHandled = _interrupt.isHandled();
        System.out.println("Interruption is handled");
    }


}
