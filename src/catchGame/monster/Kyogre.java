package catchGame.monster;

public class Kyogre extends MonsterBase {

	public Kyogre() {
        super(MonsterType.KYOGRE);
    }

    @Override
    public void displayAppearanceMessage() {
        System.out.println("=========포켓몬 조우=========");
        this.probabilityValue = random.nextInt(3);
        
        if (this.probabilityValue == 0) {
            System.out.println("\"바다 그 자체인 " + this.getName() + " 등장!\"\n➤ .....(내가 꼭 살아있기를)");
        } else if (this.probabilityValue == 1) {
            System.out.println("\"해저 마그마에서 " + this.getName() + "가 솟구쳤다!\"");
        } else {
            System.out.println("\"거대한 그림자가 올라온다… " + this.getName() + "다!\"");
        }
        
        System.out.println();
    }

    @Override
    public boolean attemptEscape() {
        this.probabilityValue = random.nextInt(3);
        
        if (random.nextInt(100) + 1 <= 89) { // 89% 확률
            System.out.println("=========포켓몬이 도망쳤다!=========");
            
            if (this.probabilityValue == 0) {
                System.out.println("\"89% 확률로 " + this.getName() + "가 물보라를 일으키며 사라졌다!\"");
            } else if (this.probabilityValue == 1) {
                System.out.println("\"89% 확률로 " + this.getName() + "가 조용히 사라졌다!\"");
            } else {
                System.out.println("\"89% 확률로 " + this.getName() + "가 구름 속으로 숨었다!\"");
            }
            
            System.out.println();
            return false;
        }
        
        System.out.println("=========포켓몬이 도망치지 않았다!=========");
        System.out.println("\"11% 확률로 " + this.getName() + "가 버티고 있다!\"");
        return true;
    }

    @Override
    public boolean attemptCatch() throws InterruptedException {
        showDelay();
        
        if (random.nextInt(100) + 1 <= 9) { // 9% 확률
            System.out.println("=========포켓몬 포획 성공!=========");
            System.out.println("\"9% 확률로 " + this.getName() + "를 잡았다!\"");
            this.setCaught(true);
            return true;
        }
        
        System.out.println("=========포켓몬 포획 실패!=========");
        System.out.println("\"91% 확률로 " + this.getName() + "가 탈출했다!\"");
        return false;
    }

}
