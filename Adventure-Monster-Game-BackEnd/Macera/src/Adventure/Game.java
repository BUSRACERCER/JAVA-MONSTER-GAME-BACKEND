package Adventure;

import java.util.Scanner;

public class Game {
    Player player;
    Location location;
    Scanner scan = new Scanner(System.in);

    public void login() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Macera Oyununa Hoşgeldiniz!");
        System.out.println("Oyuna Başlamadan Önce isminizi Giriniz : ");
        String playerName = scan.nextLine();
        player = new Player(playerName);
        player.selectCha();
        start();

    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println(",,,,,,,,,,,,,");
            System.out.println();
            System.out.println("Eylem gerçekleştirmk için bir yer seçinin :");
            System.out.println("1. Güvenli Ev--> Size ait güvenli bir mekan ,düşman yok");
            System.out.println("2. Mağara--> Karşınıza belki zombi çıkabilir");
            System.out.println("3. Orman--> Karşınıza belki vampir çıkabilir");
            System.out.println("4. Nehir--> Karşınıza belki ayı çıkabilir");
            System.out.println("5. Mağaza--> Silah veya Zırh alabilirsiniz");
            System.out.println("Gitmek istediğiniz yer :");
            int selloc = scan.nextInt();
            while (selloc < 0 || selloc > 5) {
                System.out.println("Lütfen geçerli bir yer seçiniz: ");
                selloc = scan.nextInt();
            }
            switch (selloc) {
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new Cave(player);
                    break;
                case 3:
                    location = new Forest(player);
                    break;
                case 4:
                    location = new River(player);
                    break;
                case 5:
                    location = new ToolStore(player);
                    break;
                default:
                    location = new SafeHouse(player);
            }
            if (location.getClass().getName().equals("SafeHouse")) {
                if (player.getInv().isFirewood() && player.getInv().isFood() && player.getInv().isWater()) {
                    System.out.println("Tebrikler Oyunu Kazandın !");
                    break;
                }
            }
            if (location.getLocation()) {
                System.out.println("Oyun bitti!");
                break;
            }
        }

    }

}
