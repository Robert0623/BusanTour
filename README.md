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

## 07.16
### RegisterController에 UserValidator를 추가
### ```<form:form>```태그로 view에 error_message를 보여주도록

## 07.07
### User, RecruitBoard - DB, mapper, DAO 추가
- UserDao - JDBC로 추가 - MyBatis로 수정 예정
- RecruitBoardDao - mapper생성 후 작성 및 테스트
### Paging 
- PageHandler - domain에 추가
- PageHandlerTest - PageHandler 테스트 - beginPage, endPage, showPrev, showNext
### Service, Controller 추가, List만들기, Paging 처리
- RecruitBoardService, RecruitBoardServiceImpl - DAO를 보고 작성
- RecruitBoardController - getPage와 페이지 정보를 Model에 저장해서 뷰로 보내도록 작성
- recruitBoardList.jsp - getPage 정보를 받아서 반복문으로 보여주고, 페이지 정보를 받아서 반복문으로 보여주게 작성