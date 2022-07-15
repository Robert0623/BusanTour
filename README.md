# BusanTour - 개인 프로젝트
## 07.15
### 초기 설정
- pom.xml - dependency 추가
- web.xml - 한글 변환 필터 추가
- root-context.xml 
1. dataSource를 bean으로 등록(JDBC Driver, MySQL 연결)
2. sqlSessionFactory, sqlSession bean으로 등록
3. transactionManager bean으로 등록
4. component-scan태그 추가
- servlet-context.xml
1. resources mapping 경로 수정
2. component-scan태그 추가
3. view-controller로 index.jsp 등록

### 회원가입, 로그인 기능 구현
