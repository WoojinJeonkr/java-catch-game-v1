package catchGame.monster;

public class Venusaur extends MonsterBase {

	public Venusaur() {
        super(MonsterType.VENUSAUR);
    }

    @Override
    public void displayAppearanceMessage() {
        System.out.println("=========포켓몬 조우=========");
        this.probabilityValue = random.nextInt(3);
        
        if (this.probabilityValue == 0) {
            System.out.println("\n" + this.getName() + "이(가) 햇살을 받으며 졸고 있다…\n");
        } else if (this.probabilityValue == 1) {
            System.out.println("\n" + this.getName() + "의 덩굴 채찍이 번개처럼 휘둘러진다!\n");
        } else {
            System.out.println("\n" + this.getName() + "이(가) 잎사귀를 흔들며 등장했다! 싱그러운 풀 내음이 가득하다!\n");
        }
        
    }

    @Override
    public boolean attemptEscape() {
        this.probabilityValue = random.nextInt(3);
        
        if (random.nextInt(100) + 1 <= 9) { // 9% 확률
            System.out.println("=========포켓몬이 도망쳤다!=========");
            
            if (this.probabilityValue == 0) {
                System.out.println("\n 9% 확률로 " + this.getName() + "의 덩굴이 땅속으로 스르륵 사라졌다!\n");
            } else if (this.probabilityValue == 1) {
                System.out.println("\n 9% 확률로 " + this.getName() + "가 꽃잎을 흩날리며 조용히 사라졌다!\n");
            } else {
                System.out.println("\n 9% 확률로 " + this.getName() + "가 덩굴을 뻗어 숲 속으로 사라졌다!\n");
            }
            
            System.out.println();
            return false;
        }
        
        System.out.println("=========포켓몬이 도망치지 않았다!=========");
        
        if (this.probabilityValue == 0) {
            System.out.println("\n 91% 확률로 " + this.getName() + "가 넓은 잎사귀 위에 편안하게 누워 있다!\n");
        } else if (this.probabilityValue == 1) {
            System.out.println("\n 91% 확률로 " + this.getName() + "가 꽃봉오리를 살짝 닫고 휴식을 취한다!\n");
        } else {
            System.out.println("\n 91% 확률로 " + this.getName() + "가 주변의 햇살을 즐기며 여유로운 시간을 보낸다!\n");
        }
        
        System.out.println();
        return true;
    }

    @Override
    public boolean attemptCatch() throws InterruptedException {
        showDelay();
        
        if (random.nextInt(2) + 1 == 1) { // 50% 확률
            System.out.println("=========포켓몬 포획 성공!=========");
            System.out.println("\"50% 확률로 " + this.getName() + "가 잡혔다!\"");
            this.setCaught(true);
            return true;
        }
        
        System.out.println("=========포켓몬 포획 실패!=========");
        System.out.println("\"50% 확률로 " + this.getName() + "가 놓쳤다!\"");
        return false;
    }

}
