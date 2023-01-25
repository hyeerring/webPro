## [19] JDBC 프로그래밍

**💡데이터베이스**

테이블은 칼럼(속성, 필드)과 로우(엔티티)로 이루어져 있고 서로 연관된 데이터들이 표처럼 구성되어 있다.

### JDBC(Java Database Connectivity) 프로그래밍 개념

- **JDBC(Java Database Connectivity)**

  자바 패키지의 일부로 자바 프로그램이 데이터 베이스와 연결되어 데이터를 주고 받을 수 있게 해 주는 프로그래밍 인터페이스이다. 자바 데이터베이스 프로그래밍 API라고 할 수 있다.

- **JDBC 드라이버**

  오라클 드라이버또는 MySQL 드라이버를 자바가 설치되어 있는 C:\Program Files\Java\jre1.8.0_XXX\lib\ext 폴더(%JAVA_HOME%/JRE/LIB/EXT 폴더)에 다음의 두 파일을 복사한다.

### JDBC프로그래밍 단계와 사용 클래스

1. **JDBC 드라이버 로드**

   ```java
   Class.forName("oracle.jdbc.driver.OracleDriver"); 
   ```

   `Class.forName()`을 이용하여 드라이버 클래스를 로딩한다.

2. **데이터베이스 연결**

   ```java
   String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
   conn = DriverManager.getConnection(url, "scott", "tiger");
   ```

   DriverManager 클래스의 static 메서드인 `getConnection()` 메서드를 호출해서, mysql에 연결하기 위한 커넥션 정보(url, user, password)를 입력한다.

3. **Statement 생성**

    ```java
    Statement stmt = conn.createStatement();
    ```

    SQL문을 수행할 객체를 생성한다. DB를 조회하거나 데이터 추가, 삭제, 수정 등을 다룬다. `Statement`는 SQL 처리 기본 객체이다.

4. **SQL문 전송**

    SQL문을 수행하고 결과를 전달받는다. SQL문의 `Statement` 객체의 `executeQuery()`, `executeUpdate()` 메소드를 이용, 데이터베이스로 전달해 처리한다.

5. **결과**

    select 문장은 테이블 형태의 결과를 반환한다. 그러므로 select 문장을 실행하기 위해 `Statement`의 메소드 `executeQuery()`를 사용한다. 메소드 `executeQuery()`는 질의 결과로 테이블 형태의 결과를 반환하는데, 이 반환형이 인터페이스 `ResultSet`이다. 

    객체 `Statement`의 메소드 `executeUpdate()`는 create 또는 drop, insert, delete, update와 같이 테이블의 내용을 변경하는 문장에 사용한다.

6. **결과를 받아 원하는 로직을 수행**

7. **연결해제**

    DB연결을 끊는다. 이때 처음 생성한 순서와 반대되는 순서로 닫아야한다.
