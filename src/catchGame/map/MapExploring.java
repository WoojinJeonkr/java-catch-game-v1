package catchGame.map;

import java.util.Scanner;

/**
 * 맵 탐색 클래스
 * 
 * <p>
 * 맵 선택 및 탐색 관련 기능을 제공합니다.
 * 사용자의 맵 선택, 랜덤 맵 처리, 맵 이동 등의 기능을 지원합니다.
 * </p>
 * 
 * @author LJK0501
 * @author Woojinjeonkr
 */
public class MapExploring {
	/** 사용자 입력을 처리하는 Scanner 객체 */
	private final Scanner scanner = new Scanner(System.in);
	/** 사용자가 선택한 맵 */
    private MapType selectedMap;
    /** 랜덤 선택 후 최종 결정된 맵 */
    private MapType finalMap;
    /** 맵 선택 횟수 */
    private int selectionCount;
    
    /**
     * 맵 선택 메서드
     * 
     * <p>사용자로부터 맵을 입력받아 선택하고, 랜덤 맵 선택 또는 취소 처리를 수행합니다.</p>
     *
     * @param previousCount 이전 맵 선택 횟수
     * @throws InterruptedException 맵 선택 중 인터럽트 발생 시 예외 처리
     */
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
    
    /**
     * 기본 맵 선택 처리 메서드
     * 
     * <p>사용자가 하늘, 바다, 땅 맵 중 하나를 선택했을 때의 처리를 담당합니다.</p>
     *
     * @param type 선택된 맵 타입
     * @throws InterruptedException 맵 이동 중 인터럽트 발생 시 예외 처리
     */
    private void handleBasicMap(MapType type) throws InterruptedException {
        this.selectedMap = type;
        this.finalMap = type;
        System.out.println(type.getDisplayName() + "맵 페이지로 이동합니다");
        proceedToMap();
    }
    
    /**
     * 랜덤 맵 선택 처리 메서드
     * 
     * <p>사용자가 랜덤 맵을 선택했을 때의 처리를 담당하며, 실제 맵을 랜덤으로 결정합니다.</p>
     *
     * @throws InterruptedException 맵 생성 또는 이동 중 인터럽트 발생 시 예외 처리
     */
    private void handleRandomMap() throws InterruptedException {
        System.out.println("=========랜덤맵 생성 중...=========");
        Thread.sleep(500);
        this.selectedMap = MapType.RANDOM;
        this.finalMap = MapType.getRandomActualMap();
        System.out.println(finalMap.getDisplayName() + " 맵 페이지로 이동합니다");
        proceedToMap();
    }
    
    /**
     * 맵 선택 취소 처리 메서드
     * 
     * <p>사용자가 맵 선택을 취소했을 때의 처리를 담당합니다.</p>
     */
    private void handleCancel() {
        this.selectedMap = MapType.CANCEL;
        this.finalMap = MapType.CANCEL;
    }
    
    /**
     * 맵 이동 처리 메서드
     * 
     * <p>맵 이동 시의 공통 처리를 담당하며, 이동 메시지 출력 및 선택 횟수 증가를 처리합니다.</p>
     *
     * @throws InterruptedException 맵 이동 중 인터럽트 발생 시 예외 처리
     */
    private void proceedToMap() throws InterruptedException {
        Thread.sleep(500);
        System.out.println("\n>> 맵 이동중입니다...");
        Thread.sleep(500);
        this.selectionCount++;
    }
    
    /**
     * 선택된 맵 반환 메서드
     *
     * @return 선택된 맵
     */
    public MapType getSelectedMap() {
        return selectedMap;
    }

    /**
     * 최종 결정된 맵 반환 메서드
     *
     * @return 최종 결정된 맵
     */
    public MapType getFinalMap() {
        return finalMap;
    }

    /**
     * 맵 선택 횟수 반환 메서드
     *
     * @return 맵 선택 횟수
     */
    public int getSelectionCount() {
        return selectionCount;
    }
}