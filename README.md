# SpringBoot JPA
스프링부트 + JPA 기반 쇼핑몰 프로젝트입니다.

### 도메인 분석 설계

#### 요구사항 분석
##### 기능목록
- 회원기능
  - 회원등록
  - 회원조회
- 상품기능
  - 상품등록
  - 상품수정
  - 상품조회
- 주문기능
  - 상품주문
  - 주문 내역 조회
  - 주문 취소
- 기타 요구사항
  - 상품은 재고 관리가 가능하다.

##### 도메인 설계
<img src="/src/main/resources/static/images/domain.png" width="450px;" height="250px;">

##### 엔티티 설계
<img src="/src/main/resources/static/images/entity.png" width="450px;" height="350px;">

##### 테이블 설계
<img src="/src/main/resources/static/images/table.png" width="450px;" height="350px;">