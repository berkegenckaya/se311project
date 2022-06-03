public abstract class Files extends System {
    protected String name;
    protected double size;

    @Override
    public double getSize() {
        return size;
    }

    @Override
    public String displayName() {
        return name;
    }
}
