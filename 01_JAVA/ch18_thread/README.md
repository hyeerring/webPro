## [18] Java Thread

**π‘νλ‘μΈμ€(Prosess)λ?**

μ€νκ°λ₯ν λ³΄μ‘°κΈ°μ΅μ₯μΉ(HDD, SSD)μ μλ νμΌμ νλ‘κ·Έλ¨μ΄λΌ λΆλ₯Έλ€. μ΄λ¬ν νλ‘κ·Έλ¨μ μ€ννκ² λλ©΄ μ΄ νλ‘κ·Έλ¨μ λ©λͺ¨λ¦¬μ μμ£Όνκ² λκ³  μ΄λ₯Ό νλ‘μΈμ€λΌ λΆλ₯Έλ€. νλ‘μΈμ€λ νλ‘κ·Έλ¨μ μ¬μ©λλ λ°μ΄ν°μ λ©λͺ¨λ¦¬ λ±μ μμ κ·Έλ¦¬κ³  μ€λ λλ‘ κ΅¬μ±λλ€.



**π‘μ€λ λλ?**

μ€λ λ(thread)λ νλ‘μΈμ€(process) λ΄μμ μ€μ λ‘ μμμ μννλ μ£Όμ²΄λ₯Ό μλ―Ένλ€. λͺ¨λ  νλ‘μΈμ€μλ ν κ° μ΄μμ μ€λ λκ° μ‘΄μ¬νμ¬ μμμ μννλ©° λ κ° μ΄μμ μ€λ λλ₯Ό κ°μ§λ νλ‘μΈμ€λ₯Ό λ©ν°μ€λ λ νλ‘μΈμ€(multi-threaded process)λΌκ³  νλ€.

μ€λ λλ λκ°μ§ ννλ‘ μ‘΄μ¬νλ€. νλλ nκ°μ μ€λ λκ° κ°μ²΄ νλλ₯Ό κ³΅μ νλ λ°©μμ΄κ³ , λ λ€λ₯Έ νλλ nκ°μ μ€λ λκ° κ°κ° κ°μ²΄ nκ°λ₯Ό μ¬μ©νλ λ°©μμ΄λ€.



### λ©ν°μ€λ λμ μ₯λ¨μ 

**λ©ν°μ€λ λμ μ₯μ **

- μμμ λ³΄λ€ ν¨μ¨μ μΌλ‘ μ¬μ©ν  μ μλ€.
- μ¬μ©μμ λν μλ΅μ±μ΄ ν₯μλλ€.
- μμμ΄ λΆλ¦¬λμ΄ μ½λκ° κ°κ²°ν΄μ§λ€.

**λ©ν°μ€λ λμ λ¨μ **

- λκΈ°ν(synchronization)μ μ£Όμν΄μΌ νλ€.
- κ΅μ°©μν(dead-lock)κ° λ°μνμ§ μλλ‘ μ£Όμν΄μΌ νλ€.
- κ° μ°λ λκ° ν¨μ¨μ μΌλ‘ κ³ λ₯΄κ² μ€νλ  μ μκ² ν΄μΌ νλ€.
- νλ‘κ·Έλλ°ν  λ κ³ λ €ν΄μΌ ν  μ¬ν­λ€μ΄ λ§λ€.



### μ€λ λμ μμ±κ³Ό μ€ν

μλ°μμ μ€λ λλ₯Ό μμ±νλ λ°©λ²μ λκ°μ§κ° μλ€.

1. **Runnable μΈν°νμ΄μ€λ₯Ό κ΅¬ννλ λ°©λ²**

    `java.lang.Runnable` μΈν°νμ΄μ€λ‘λΆν° `run()`λ©μλλ₯Ό κ΅¬ννμ¬ μμ±νλ€. `Runnable` μΈν°νμ΄μ€λ `run()` λ©μλ 1κ°λ§ κ°μ§λ ν¨μν μΈν°νμ΄μ€μ΄λ€.

```java
public class Test01 extends Thread{
    @Override
    public void run() {
		//μ€λ λ μ€νμ½λ
    }
}
```

- `Runnable` μΈν°νμ΄μ€λ₯Ό κ΅¬ννλ€κ³  ν΄μ λ°λ‘ μ€λ λκ° λμ§ μλλ€.

- `Thread class` λ₯Ό ν΅ν΄ μ€λ λκ° λ  μ μλ€.

-  κ°μ²΄ μ°Έμ‘°λ³μλ₯Ό μΈμκ°μΌλ‘ νλ `Thread` μμ±

  

2. **Thread ν΄λμ€λ₯Ό μμλ°λ λ°©λ²**

   `java.lang.Thread` ν΄λμ€λ₯Ό μμ(extends)λ°μμ `run()` λ©μλ μ€λ²λΌμ΄λ©

```java
public class Test01 implements Runnable {
    @Override
    public void run() {
		//μ€λ λ μ€νμ½λ
    }
}
```



### Synchronized λκΈ°ν

κ°μ²΄μ μ μΈλμ΄ μλ μΈμ€ν΄μ€ λ³μλ₯Ό μ€λ λμμ κ³΅μ νκ² λμ΄ μΈμ€ν΄μ€μ κ°μ μν₯μ λ―ΈμΉκ² λλ κ²½μ°λ₯Ό λλΉνμ¬ Javaμμλ `Synchronized`λΌλ ν€μλκ° μλ€.

`Synchronized`λ λ¨Όμ  μνλλ μ€λ λμ λͺ¨λ  μμμ΄ λλ  λκΉμ§ κΈ°λ€λ¦¬λλ‘ νλ μμ½μ΄μ΄λ€.



**π‘λκΈ°νλ?**

νλμ μμμ μ¬λ¬ νμ€ν¬κ° μ¬μ©νλ € ν  λ, ν μμ μμ νλμ νμ€ν¬λ§μ΄ μ¬μ©ν  μ μλλ‘ νλ κ².



**Synchronized μ¬μ© λ°©λ²**

1. **λ©μλμ Synchronized  μ€μ **

   λ©μλ μ΄λ¦ μμ Synchronized  ν€μλλ₯Ό μ¬μ©νλ©΄ λ©μλ μ μ²΄λ₯Ό μκ³μμ­μΌλ‘ μ€μ ν  μ μλ€.

```java
public synchronized void method(){
	...
}
```



2. **μ½λλΈλ­μ Synchronized μ€μ **

   λκΈ°νλ₯Ό λ§μ΄ μ¬μ©νκ² λλ©΄ ν¨μ¨μ΄ λ¨μ΄μ§κ² λλ―λ‘ κΌ­ νμν λΆλΆμλ§ λΈλ­μ μ§μ νμ¬ μκ³μμ­μΌλ‘ μ€μ ν  μ μλ€. 

```java
public void exampleMethod(){ 
    synchronized(this){
    	...
	}
}
```
