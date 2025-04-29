package catchGame.map;

import java.util.Scanner;

/**
 * 맵 탐색 클래스
 */
public class MapExploring {
	private final Scanner scanner = new Scanner(System.in);
    private MapType selectedMap; // 사용자가 선택한 맵
    private MapType finalMap; // 랜덤 선택 후 최종 결정된 맵
    private int selectionCount; // 맵 선택 횟수
    
    // 맵 선택 메서드
    public void selectMap(int previousCount) throws InterruptedException {
        this.selectionCount = previousCount;
        while (true) {
            if (this.selectionCount < 1) {
                System.out.println("\n+++ 몬스터 잡기 게임 +++");
            }
            
            System.out.println("🗺️ 맵을 선택하세요 (☁️ 하늘|🌊 바다|🌴 땅|🎲 랜덤|⚠️ 취소)");
            String userInput = scanner.nextLine().trim();
            MapType inputType = MapType.fromKorean(userInput);

            if (inputType == null) {
                System.out.println("잘못 입력하셨습니다");
                continue;
            }

            switch (inputType) {
                case SKY:
                case SEA:
                case LAND:
                    handleBasicMap(inputType);
                    return;
                case RANDOM:
                    handleRandomMap();
                    return;
                case CANCEL:
                    handleCancel();
                    return;
                default:
                    System.out.println("잘못 입력하셨습니다");
            }
        }
    }
    
    // 맵 선택 처리
    private void handleBasicMap(MapType type) throws InterruptedException {
        this.selectedMap = type;
        this.finalMap = type;
        System.out.println(type.getDisplayName() + "맵 페이지로 이동합니다");
        proceedToMap();
    }
    
    private void handleRandomMap() throws InterruptedException {
        System.out.println("=========랜덤맵 생성 중...=========");
        Thread.sleep(500);
        this.selectedMap = MapType.RANDOM;
        this.finalMap = MapType.getRandomActualMap();
        System.out.println(finalMap.getDisplayName() + " 맵 페이지로 이동합니다");
        proceedToMap();
    }
    
    private void handleCancel() {
        this.selectedMap = MapType.CANCEL;
        this.finalMap = MapType.CANCEL;
    }
    
    private void proceedToMap() throws InterruptedException {
        Thread.sleep(500);
        System.out.println("\n>> 맵 이동중입니다...");
        Thread.sleep(500);
        this.selectionCount++;
    }
    
    public MapType getSelectedMap() {
        return selectedMap;
    }

    public MapType getFinalMap() {
        return finalMap;
    }

    public int getSelectionCount() {
        return selectionCount;
    }
}