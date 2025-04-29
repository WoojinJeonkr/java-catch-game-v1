package catchGame.monster;

public class Arceus extends MonsterBase {

	public Arceus() {
        super(MonsterType.ARCEUS);
    }

    @Override
    public void displayAppearanceMessage() {
        System.out.println("=========포켓몬 조우=========");
        this.probabilityValue = random.nextInt(3);
        
        if (this.probabilityValue == 0) {
            System.out.println("\"⚡시공간 서버 터짐! " + this.getName() + " 접속!\"");
        } else if (this.probabilityValue == 1) {
            System.out.println("\"📡 우주에서 " + this.getName() + " 강림!\"");
        } else {
            System.out.println("\"💥세계가 리셋! " + this.getName() + " 등장!\"");
        }
        
        System.out.println();
    }

    @Override
    public boolean attemptEscape() {
        System.out.println("=========포켓몬이 도망치지 않았다!=========");
        System.out.println("\"" + this.getName() + "는 도망갈 필요가 없다!\"");
        return true; // 무조건 도망가지 않음
    }

    @Override
    public boolean attemptCatch() throws InterruptedException {
        showDelay();
        
        if (random.nextInt(1000000) + 1 <= 23) { // 0.0023% 확률
            System.out.println("=========포켓몬 포획 성공!=========");
            System.out.println("\"0.0023% 확률로 " + this.getName() + "를 잡았다!\"");
            this.setCaught(true);
            return true;
        }
        
        System.out.println("=========포켓몬 포획 실패!=========");
        System.out.println("\"99.9977% 확률로 " + this.getName() + "가 저항했다!\"");
        return false;
    }

}
