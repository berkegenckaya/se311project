public abstract class Directory extends System {
    protected String name;
<<<<<<< Updated upstream
=======
    protected String directoryType;
    protected ArrayList<Files> files;

    @Override
    public String displayName() {
        return name;
    }

    public void displayList(){
        files.forEach((n)-> System.out.println("file: " + n.name));
    }

    public String getDirectoryType() {
        return directoryType;
    }


    public ArrayList<Files> getFiles() {
        return files;
    }
>>>>>>> Stashed changes

    public String displayName() { return name;	}

}
