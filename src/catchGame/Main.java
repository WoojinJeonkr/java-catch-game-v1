package catchGame;

import catchGame.manage.GameManager;

/**
 * 게임 실행의 Entry Point 역할을 하는 클래스
 * 
 * <p>GameManager를 생성하고 게임을 실행합니다.</p>
 * 
 * @author Woojinjeonkr
 */
public class Main {

	/**
     * 게임 실행의 메인 메서드
     * 
     * <p>GameManager 인스턴스를 생성하고 게임을 시작합니다.</p>
     *
     * @param args 프로그램 실행 시 전달되는 인수 (사용되지 않음)
     * @throws InterruptedException 게임 실행 중 스레드 관련 예외 발생 시 던져짐
     */
	public static void main(String[] args) throws InterruptedException {
		GameManager gameManager = new GameManager();
		gameManager.runGame();
	}
}
