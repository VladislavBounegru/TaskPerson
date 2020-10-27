package seven;


public class MenuItem {
    private String name;
    private Exec exec;

    public MenuItem(String name, Exec exec) {
        this.name = name;
        this.exec = exec;
    }

    public String getName() {
        return name;
    }

    public Exec getExec() {
        return exec;
    }

}
