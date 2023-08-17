# yskbns_study
yskbns_study

컴포넌트 스캔 방식과 자바코드로 직접 빈 등록하는 방법.
장단점이 있음

컴포넌트 스캔
  간단함

직접 빈 등록
  변경사항 있을때 설정파일만 수정하면 됨

H2
  최초 접속시
    jdbc:h2:~/test
    루트폴더(C:\Users\Lenovo) 에
    test.mv.db 라는 파일 생성되야함

이후 접속시
  jdbc:h2:tcp://localhost/~/test
  소켓으로 연결하는것

테스트
  테스트 코드를 다른곳에 쓸것이 아닌 테스트 하고 끝이기 때문에 *@*Autowired 로 편하게 씀(필드 방식)

JdbcTemplate
  JdbcTemplateMemberRepository.java
    생성자가 하나일 경우 @Autowired 어노테이션 생략 가능. 스프링이 DataSource 자동으로 주입
