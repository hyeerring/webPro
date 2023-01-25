## [18] Java Thread

**💡프로세스(Prosess)란?**

실행가능한 보조기억장치(HDD, SSD)에 있는 파일을 프로그램이라 부른다. 이러한 프로그램을 실행하게 되면 이 프로그램은 메모리에 상주하게 되고 이를 프로세스라 부른다. 프로세스는 프로그램에 사용되는 데이터와 메모리 등의 자원 그리고 스레드로 구성된다.



**💡스레드란?**

스레드(thread)란 프로세스(process) 내에서 실제로 작업을 수행하는 주체를 의미한다. 모든 프로세스에는 한 개 이상의 스레드가 존재하여 작업을 수행하며 두 개 이상의 스레드를 가지는 프로세스를 멀티스레드 프로세스(multi-threaded process)라고 한다.

스레드는 두가지 형태로 존재한다. 하나는 n개의 스레드가 객체 하나를 공유하는 방식이고, 또 다른 하나는 n개의 스레드가 각각 객체 n개를 사용하는 방식이다.



### 멀티스레드의 장단점

**멀티스레드의 장점**

- 자원을 보다 효율적으로 사용할 수 있다.
- 사용자에 대한 응답성이 향상된다.
- 작업이 분리되어 코드가 간결해진다.

**멀티스레드의 단점**

- 동기화(synchronization)에 주의해야 한다.
- 교착상태(dead-lock)가 발생하지 않도록 주의해야 한다.
- 각 쓰레드가 효율적으로 고르게 실행될 수 있게 해야 한다.
- 프로그래밍할 때 고려해야 할 사항들이 많다.



### 스레드의 생성과 실행

자바에서 스레드를 생성하는 방법은 두가지가 있다.

1. **Runnable 인터페이스를 구현하는 방법**

    `java.lang.Runnable` 인터페이스로부터 `run()`메서드를 구현하여 생성한다. `Runnable` 인터페이스는 `run()` 메서드 1개만 가지는 함수형 인터페이스이다.

```java
public class Test01 extends Thread{
    @Override
    public void run() {
		//스레드 실행코드
    }
}
```

- `Runnable` 인터페이스를 구현한다고 해서 바로 스레드가 되지 않는다.

- `Thread class` 를 통해 스레드가 될 수 있다.

-  객체 참조변수를 인자값으로 하는 `Thread` 생성

  

2. **Thread 클래스를 상속받는 방법**

   `java.lang.Thread` 클래스를 상속(extends)받아서 `run()` 메서드 오버라이딩

```java
public class Test01 implements Runnable {
    @Override
    public void run() {
		//스레드 실행코드
    }
}
```



### Synchronized 동기화

객체에 선언되어 있는 인스턴스 변수를 스레드에서 공유하게 되어 인스턴스의 값에 영향을 미치게 되는 경우를 대비하여 Java에서는 `Synchronized`라는 키워드가 있다.

`Synchronized`는 먼저 수행되는 스레드의 모든 작업이 끝날 때까지 기다리도록 하는 예약어이다.



**💡동기화란?**

하나의 자원을 여러 태스크가 사용하려 할 때, 한 시점에서 하나의 태스크만이 사용할 수 있도록 하는 것.



**Synchronized 사용 방법**

1. **메소드에 Synchronized  설정**

   메소드 이름 앞에 Synchronized  키워드를 사용하면 메소드 전체를 임계영역으로 설정할 수 있다.

```java
public synchronized void method(){
	...
}
```



2. **코드블럭에 Synchronized 설정**

   동기화를 많이 사용하게 되면 효율이 떨어지게 되므로 꼭 필요한 부분에만 블럭을 지정하여 임계영역으로 설정할 수 있다. 

```java
public void exampleMethod(){ 
    synchronized(this){
    	...
	}
}
```
