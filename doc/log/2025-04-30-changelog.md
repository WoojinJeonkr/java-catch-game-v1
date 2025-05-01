# Java Catch Game v1 변경 기록

## 2025-04-30

### 추가

- `MonsterFactory` 클래스 추가: 몬스터 생성 로직을 팩토리 패턴으로 구현
- 새로운 몬스터 유형 10종 추가 (Arceus, Dialga, Groudon 등)
- 맵 타입 관리용 `MapType` 열거형 클래스 추가
- 이전 디렉토리 구조 문서화 (`docs/tree/BEFORE_DIRECTORY_TREE.md`)

### 변경

- **리팩토링 작업**
  - 몬스터 클래스 계층 구조 개선: `MonsterBase` 추상 클래스 도입
  - 맵 탐색 로직을 `MapExploring` 클래스로 캡슐화
  - 사용자 정보 관리 클래스(`User.java`) 재작성
- **문서 개선**
  - README.md에 몬스터 등장 확률 테이블 추가
  - 커밋 메시지 컨벤션 도입 (feat, fix, refactor 등)

### 제거

- 중복된 몬스터 클래스 11종 제거 (Monster0-Monster10)
- 사용하지 않는 `GameManager` 초기 구현체 제거
- 레거시 모듈 정보 파일(`module-info.java`) 삭제

### 수정

- `.gitignore` 파일 위치 수정: `/catchGame/` → `/bin/`
- IDE 설정 파일 경로 문제 해결 (`org.eclipse.core.resources.prefs`)
