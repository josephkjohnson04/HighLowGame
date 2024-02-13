public class Main {
    public static void main(String[] args) {
        Player p1 = new Player();
        p1.setName("Jaylen");
        p1.addWin();
        System.out.println(p1.getId());
        System.out.println(p1.getName());
        System.out.println(p1.getWins());
        System.out.println(p1.getHighestAttempts());
        System.out.println(p1.getLowestAttempts());
        Player p2 = new Player("Joe");
        System.out.println(p2.getName());

    }
}