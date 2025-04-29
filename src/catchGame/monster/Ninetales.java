package catchGame.monster;

public class Ninetales extends MonsterBase {

	public Ninetales() {
        super(MonsterType.NINETALES);
    }

    @Override
    public void displayAppearanceMessage() {
        System.out.println("=========포켓몬 조우=========");
        this.probabilityValue = random.nextInt(3);
        
        if (this.probabilityValue == 0) {
            System.out.println("\"화염 폭풍 속에서 " + this.getName() + "가 나타났다!\"\n➤ \"꼬리~꼬리~!\"\n(아홉 꼬리에서 블루스크린 불꽃이 터져나옴)");
        } else if (this.probabilityValue == 1) {
            System.out.println("\"지면이 갈라지며 " + this.getName() + "가 솟아올랐다!\"\n➤ \"불타오르는 분노를 느껴봐!\"");
        } else {
            System.out.println("\"화려한 꼬리 춤을 추며 " + this.getName() + " 등장!\"\n➤ \"이것이 진정한 아홉 꼬리의 위력이다!\"");
        }
        
        System.out.println();
    }

    @Override
    public boolean attemptEscape() {
        this.probabilityValue = random.nextInt(3);
        
        if (random.nextInt(100) + 1 <= 67) { // 67% 확률
            System.out.println("=========포켓몬이 도망쳤다!=========");
            
            if (this.probabilityValue == 0) {
                System.out.println("\"67% 확률로 " + this.getName() + "가 화염 장막을 치고 사라졌다!\"");
            } else if (this.probabilityValue == 1) {
                System.out.println("\"67% 확률로 " + this.getName() + "가 지열을 타고 도주!\"");
            } else {
                System.out.println("\"67% 확률로 " + this.getName() + "가 불꽃 분신술을 사용해 사라졌다!\"");
            }
            
            System.out.println();
            return false;
        }
        
        System.out.println("=========포켓몬이 도망치지 않았다!=========");
        
        if (this.probabilityValue == 0) {
            System.out.println("\"33% 확률로 " + this.getName() + "가 불꽃 방패를 전개했다!\"");
        } else if (this.probabilityValue == 1) {
            System.out.println("\"33% 확률로 " + this.getName() + "가 도발하며 공격 태세!\"");
        } else {
            System.out.println("\"33% 확률로 " + this.getName() + "가 화염 결계를 치고 버티고 있다!\"");
        }
        
        System.out.println();
        return true;
    }

    @Override
    public boolean attemptCatch() throws InterruptedException {
        showDelay();
        
        if (random.nextInt(4) + 1 == 1) { // 25% 확률
            System.out.println("=========포켓몬 포획 성공!=========");
            System.out.println("\"25% 확률로 " + this.getName() + "가 잡혔다! 화염 속에서 빛나는 구슬이 됐다!\"");
            this.setCaught(true);
            return true;
        }
        
        System.out.println("=========포켓몬 포획 실패!=========");
        System.out.println("\"75% 확률로 " + this.getName() + "가 불꽃으로 볼을 녹여버렸다!\"");
        return false;
    }

}
