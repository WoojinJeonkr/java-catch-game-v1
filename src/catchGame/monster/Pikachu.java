package catchGame.monster;

public class Pikachu extends MonsterBase {

	public Pikachu() {
        super(MonsterType.PIKACHU);
    }

    @Override
    public void displayAppearanceMessage() {
        System.out.println("=========포켓몬 조우=========");
        this.probabilityValue = random.nextInt(3);
        
        if (this.probabilityValue == 0) {
            System.out.println("\"전기가 튀는 소리와 함께… " + this.getName() + "가 튀어나왔다!\"\n➤ \"피카~츄!!\"\n(꼬리를 세우며 전기를 모으고 있다!)");
        } else if (this.probabilityValue == 1) {
            System.out.println("\"귀여운 생쥐처럼 보이지만… 눈빛이 매섭다!\"\n➤ " + this.getName() + "의 전기가 벌써 충전됐다! ⚡\n(상대 트레이너가 긴장하기 시작했다.)");
        } else {
            System.out.println("\"" + this.getName() + "가 등장했다! 주머니 속에서 점프하듯 튀어나왔다!\"\n➤ \"피카피카~!\"\n(초반에는 귀여움, 다음은 백만 볼트의 공포.)");
        }
        
        System.out.println();
    }

    @Override
    public boolean attemptEscape() {
        this.probabilityValue = random.nextInt(3);
        
        if (random.nextInt(25) + 1 <= 8) { // 32% 확률
            System.out.println("=========포켓몬이 도망쳤다!=========");
            
            if (this.probabilityValue == 0) {
                System.out.println("\"32% 확률로 " + this.getName() + "가 도망쳤다! 전기를 충전하고 바람처럼 사라졌다!\"\n➤ \"피카~!! (도망가는 건 나야 나!)\"");
            } else if (this.probabilityValue == 1) {
                System.out.println("\"32% 확률로 " + this.getName() + "가 도망칠 때, 전기가 풀로 터질 것 같아!\"\n➤ \"피카! 피카!! (어디가서 전기를 좀 쓰고 올게!)\"");
            } else {
                System.out.println("\"32% 확률로 " + this.getName() + "가 도망쳤다! '누구든 나를 잡을 수 없다!'는 느낌.\"");
            }
            
            System.out.println();
            return false;
        }
        
        System.out.println("=========포켓몬이 도망치지 않았다!=========");
        
        if (this.probabilityValue == 0) {
            System.out.println("\"68% 확률로 " + this.getName() + "가 당당히 서 있다. '어차피 나 피할 필요 없지!'\"");
        } else if (this.probabilityValue == 1) {
            System.out.println("\"68% 확률로 " + this.getName() + "가 도망치지 않는다. '너는 못 이겨!'\"");
        } else {
            System.out.println("\"68% 확률로 " + this.getName() + "가 전기를 모은다!\"");
        }
        
        System.out.println();
        return true;
    }

    @Override
    public boolean attemptCatch() throws InterruptedException {
        showDelay();
        
        if (random.nextInt(100) + 1 <= 33) { // 33% 확률
            System.out.println("=========포켓몬 포획 성공!=========");
            System.out.println("\"33% 확률로 " + this.getName() + "가 잡혔다! 볼 안에서 뒹굴고 있다.\"");
            this.setCaught(true);
            return true;
        }
        
        System.out.println("=========포켓몬 포획 실패!=========");
        System.out.println("\"67% 확률로 " + this.getName() + "가 느긋하게 도망쳤다!\"");
        return false;
    }

}
