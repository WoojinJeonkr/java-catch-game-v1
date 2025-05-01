# 🎮 catchGame - 자바 콘솔 몬스터 게임

## 🌱 기존 프로젝트 개요

- 프로젝트 명: 자바 콘솔 몬스터 게임
- 프로젝트 참여 인원: 5명
- 프로젝트 진행 기간: 2025-04-22 ~ 2025-04-25
- 프로젝트 요약: Java의 상속 개념을 활용하여 콘솔 환경에서 몬스터를 잡는 게임 개발

## 👥 팀 소개

| 이름   | 역할                   | GitHub ID                                                      |
|--------|------------------------|----------------------------------------------------------------|
| 박도현 | 🧠 팀장 및 몬스터 클래스 구현   | [@ImaginaryNumberi](https://github.com/ImaginaryNumberi)        |
| 방현민 | 🗺️ 몬스터 도감 클래스 구현     | [@banghyunmin1999](https://github.com/banghyunmin1999)          |
| 윤수인 | 👾 게임 매니저 클래스 구현     | [@yooncount](https://github.com/yooncount)                      |
| 이정택 | 🧍‍♂️ 맵 클래스 구현          | [@LJK0501](https://github.com/LJK0501)                          |
| 전우진 | 🧪 유저 클래스 구현           | [@WoojinJeonkr](https://github.com/WoojinJeonkr)                |

## 👾 몬스터 등장 확률

### 1. 땅 (Earth)

| 몬스터 | 확률 | 값 범위 |
|---------|------|---------|
| Monster0 (아무 것도 없음) | 20% (4/20) | 0~3 |
| Monster2 (피카츄) | 25% (5/20) | 4~8 |
| Monster3 (다꼬리) | 25% (5/20) | 9~13 |
| Monster4 (마자용) | 30% (6/20) | 14~19 |

### 2. 바다 (Sea)

| 몬스터 | 확률 | 값 범위 |
|---------|------|---------|
| Monster0 (아무 것도 없음) | 40% (8/20) | 0~7 |
| Monster1 (잉어킹) | 40% (8/20) | 8~15 |
| Monster5 (가이오가) | 5% (1/20) | 16 |
| Monster6 (그란돈) | 15% (3/20) | 17~19 |

### 3. 하늘 (Sky)

| 몬스터 | 확률 | 값 범위 |
|---------|------|---------|
| Monster0 (아무 것도 없음) | 10% (2/20) | 0~1 |
| Monster7 (뮤츠) | 40% (8/20) | 2~9 |
| Monster8 (디아루가) | 25% (5/20) | 10~14 |
| Monster9 (펄기아) | 25% (5/20) | 15~19 |

### 4. 우주(히든맵) (Universe)

| 몬스터 | 확률 | 값 범위 |
|---------|------|---------|
| Monster0 (아무 것도 없음) | 90% (180/200) | 0~179 |
| Monster8 (디아루가) | 4% (8/200) | 180~187 |
| Monster9 (펄기아) | 4% (8/200) | 188~195 |
| Monster10 (아르세우스) | 2% (4/200) | 196~199 |

## 📁 프로젝트 구조

- 기존 프로젝트 구조: [BEFORE_DIRECTORY_TREE.md](./doc/tree/BEFORE_DIRECTORY_TREE.md)
- 리팩토링 후 프로젝트 구조: [CURRENT_DIRECTORY_TREE.md](./doc/tree/CURRENT_DIRECTORY_TREE.md)

## ✅ 기존 커밋 컨벤션 규칙

팀원 모두가 일관성 있게 협업할 수 있도록 공통된 Git 커밋 컨벤션을 사용하였습니다.

## 🔄 리팩토링 개요

- 리팩토링 기간: 2025-04-29 ~ 2025-05-01
- 리팩토링 인원: 1명 ([@WoojinJeonkr](https://github.com/WoojinJeonkr))
- 기준 커밋
  - 기존 프로젝트: [185acc5](https://github.com/WoojinJeonkr/java-catch-game-v1/commit/185acc5c7d4d42123856484e6f2c69efd6f030c7)
  - 리팩토링 완료: [1918479](https://github.com/WoojinJeonkr/java-catch-game-v1/commit/1918479610ab837b240cc24dfd6154d67f608efa)

## 🎯 리팩토링 목적

- 코드 가독성 및 유지보수성 향상
- 중복 코드 제거 및 구조 개선
- 클래스/메소드 네이밍 통일 및 역할 분리
- 테스트 및 예외 처리 강화

## 🛠️ 주요 변경사항

### 1. 아키텍처 개선

- 몬스터 생성 로직을 팩토리 패턴으로 재구현
- 몬스터 클래스 계층 구조 개선: `MonsterBase` 추상 클래스 도입
- 맵 탐색 로직을 `MapExploring` 클래스로 캡슐화
- 맵 타입 관리용 `MapType` 클래스 추가
- 몬스터 타입 관리용 `MonsterType` 클래스 추가
- 각 기능 별 manager 클래스 추가

### 2. 기능 확장

- 기존 몬스터 클래스 10종 명칭 변경 (Arceus, Dialga, Groudon 등)
- 세이브 파일 저장 및 불러오기 기능 추가
- 멀티 플레이어 기능 추가
- 소지 몬스터 제한(최대 6마리) 및 포기 기능 추가
- 몬스터 레벨 속성 추가(포획 시 랜덤하게 레벨 설정)
- 랭킹 시스템 추가(플레이어 레벨 별, 소지 몬스터 평균 레벨 별)
- 게임 실행 시 사용자 기본 이름 중복 방지

### 3. 코드 최적화

- Java 버전 17 → 1.8로 다운그레이드하여 호환성 개선
- 소스 패키지 경로 단순화 (`catchGame.src` → `src`)
- 몬스터 클래스 11종에서 중복된 코드 제거 (Monster0-Monster10)
- 사용하지 않는 레거시 코드 및 파일 정리
- 클래스 별 메서드 분리 및 확장

### 4. 문서 및 프로젝트 구조

- Eclipse 프로젝트 설정 파일(.classpath, .project) 업데이트
- 기존 디렉토리 구조 문서화
- 프로젝트에 대한 JavaDoc 문서 생성

## 📝 일자별 변경 내역

각 날짜별 상세 변경 내역은 다음 CHANGELOG 파일에서 확인할 수 있습니다

- [2025-04-29 변경 내역](./docs/changelog/2025-04-29-changelog.md)
- [2025-04-30 변경 내역](./docs/changelog/2025-04-30-changelog.md)
- [2025-05-01 변경 내역](./docs/changelog/2025-05-01-changelog.md)

## 📚 API 문서 (JavaDoc)

프로젝트의 상세 API 문서는 [Java catch game v1 API 문서](https://woojinjeonkr.github.io/java-catch-game-v1/)에서 확인할 수 있습니다.

### 주요 패키지 구성

- `catchGame`: 게임 실행 및 전체 구조 관리
- `catchGame.manage`: 게임 핵심 관리 요소
- `catchGame.map`: 게임 맵 관련 클래스
- `catchGame.monster`: 몬스터 관련 클래스
- `catchGame.user`: 사용자 관련 클래스

### 로컬에서 JavaDoc 확인하기

프로젝트를 클론한 후 `/docs` 폴더의 `index.html` 파일 우클릭 후 Open with > Web Browser 클릭 후 문서를 확인할 수 있습니다.
