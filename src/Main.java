public class Main {
    public static void main(String[] args) {
        Player p1 = new Player();
        p1.setName("Name1");
        System.out.println(p1.getName());

        Player p2 = new Player("Name2");
        System.out.println(p2.getName());
    }
}