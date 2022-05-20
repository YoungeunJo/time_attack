import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

abstract class Player{
    private String name;
    private String initNumber;
    private List<String> fightList = new LinkedList<String>();
    private Boolean isEnd;
    public Player(String name, String initNumber) {
        this.name = name;
        this.initNumber = initNumber;
        this.isEnd = false;
    }
    public abstract void play(String number) throws Exception;
    public void addFightList(String number) { fightList.add(number); }
    public Boolean getIsEnd() { return isEnd; }
    public void setIsEnd(Boolean isEnd) { this.isEnd = isEnd; }
    public String getInitNumber() { return initNumber; }
    public String getName() { return name; }
    public void printFightList() {
        // TODO
    }
}
class PlayerATeam extends Player
{
    public PlayerATeam(String name, String number) {
        super(name, number);
    }

    @Override
    public void play(String number) throws Exception {
        int strike = 0;
        int ball = 0;
        int out = 0;

        // TODO
        //        자리와 숫자가 일치하면 strike, 숫자만 일치하면 ball, 해당 숫자가 없으면 out 입니다.
        String initNumber = getInitNumber(); //맞춰야할 문자
        //입력받은 문자
        char numCharAt0 = number.charAt(0);
        char numCharAt1 = number.charAt(1);
        char numCharAt2 = number.charAt(2);
        char numCharAt3 = number.charAt(3);

        char initCharAt0 = initNumber.charAt(0);
        char initCharAt1 = initNumber.charAt(1);
        char initCharAt2 = initNumber.charAt(2);
        char initCharAt3 = initNumber.charAt(3);

        //check Strike
        for (int i=0; i<=3; i++){
            if (number.charAt(i) == initNumber.charAt(i)){
                strike += 1;
            }
        }
        //check contains number
        if (strike < 4){

        }

        if(strike == 4) {
            System.out.println("Congratulation!");
            super.setIsEnd(true);
        } else {
            System.out.println("Strike : "+strike+", Ball :"+ball+", Out: "+out);
        }
    }
}

class PlayerBTeam extends Player
{
    public PlayerBTeam(String name, String number) {
        super(name, number);
    }
    @Override
    public void play(String number) throws Exception {
        int strike = 0;
        int ball = 0;
        int out = 0;

        // TODO
        String initNumber = getInitNumber(); //맞춰야할 문자
        //check Strike -> Ball
        for (int i=0; i<=3; i++){
            if (number.charAt(i) == initNumber.charAt(i)){
                ball += 1;
            }
        }

        if(ball == 4) {
            System.out.println("Congratulation!");
            super.setIsEnd(true);
        } else {
            System.out.println("Strike : "+strike+", Ball :"+ball+", Out: "+out);
        }
    }
}

public class Main {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Player playerArray[] = {new PlayerATeam("A Team","1234"), new PlayerBTeam("B Team","5678")};
        int checkPlayer = 0;

        while(true) {
            checkPlayer = 0;
            for(Player player : playerArray) {
                if (player.getIsEnd() == false) {
                    System.out.print("Please enter a 4 digit number (" + player.getName() + ") defence : ");
                    String number = scanner.nextLine();
                    try {
                        player.play(number);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    checkPlayer++;
                }
            }
            if(checkPlayer == playerArray.length) break;
        }

        for(Player player : playerArray) {
            player.printFightList();
        }
    }
}