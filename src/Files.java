public abstract class Files extends System {
    protected String name;
    protected double size;


    public double getSize() {
        return size;
    }

    @Override
    public String displayName() {
        return name;
    }
}
