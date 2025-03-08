package _19Interfaces._02ImplementandoMultiplasInterfaces;

public interface DataLoader {
    public abstract void load();

    public default void checkPermission() {
        System.out.println("Fazendo checagem de permissões");
    }

}
