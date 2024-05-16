## 1. Lombok?
- Lombok(롬복)
Java의 라이브러리로 반복되는 메서드를 Anntation을 사용해 자동으로 작성해주는 아주 편리한 라이브러리이다.
롬복 라이브러리는 APT를 통해 Annotation processsor로 컴파일 시점에서 수행된다.

  - APT (Annotation Processing Tool)
  컴파일 시간에 소스 코드에 있는 어노테이션 정보를 처리하고 분석하는 기능을 한다.
  APT는 주로 어노테이션 프로세서를 작성하고 실행하는데 사용된다.
  JDK8 이후부터는 별도로 사용하지 않고 표준 자바 컴파일러(API)가 수행한다.

  - 어노테이션 프로세서 (Annotation processor)
Java 컴파일 시점에 소스 코드에 있는 애노테이션 정보를 분석하고 처리하는 도구이다 이를통해 코드를 생성하거나 변경할 수 있다.

- 장점
코드 자동 생성을 통한 생산성 향상 및 유지보수성 향상

- 단점
Lombok을 처음 사용하는 경우 직관성이 떨어진다.
컴파일 시점에 코드를 생성하기 때문에 개발 환경에서 추가적인 설정이 필요하다.

<br>

## 2. 어노테이션 프로세서 동작
![](https://velog.velcdn.com/images/skywum/post/b2f33122-3c23-4b9b-8c5f-61e971fbf47a/image.png)

어노테이션을 작성하고 컴파일러를 실행하면 컴파일러가 소스 코드들 분석하면서 어노테이션 프로세서를 찾는다.
찾으면 어노테이션에 지정된 로직에 따라 소스 코드를 분석하고 변경하여 새로운 소스 코드를 생성하고,
이걸 어노테이션 프로세서가 더 이상 처리 할 어노테이션이 없어질 때 까지 반복하여 수행합니다.

<br>

## 3. 자주 사용하는 어노테이션
| Annotation | Mean |
| :------------------- | :---------------------------------------------------- |
| @NoArgsConstructor     | 매개 변수가 없는 기본 생성자를 생성 |
| @RequiredArgsConstructor | final 필드만 포함된 생성자를 생성 |
| @AllArgsConstructor | 모든 필드를 포함한 생성자를 생성 |
| @Getter              | Getter를 자동으로 생성 |
| @Setter              | Setter를 자동으로 생성 |
| @ToString            | toString 메소드를 자동으로 생성 |
| @EqualsAndHashCode  | equals, hashCode 메소드를 자동으로 생성 |
| @Data                | 여러 어노테이션 통합 |
| @NonNull             | null-check 로직을 자동으로 생성하여 null 값이 넘어온 경우 NullPointerException 발생 |


@Data는 @ToString, @EqualsAndHashCode, @Getter, @Setter, @RequiredArgsConstructor 의 어노테이션 기능을 함께 제공한다.

<br>

## 4. 간단 예제
간단하게 이름, 나이를 입력받는 클래스를 작성한다 하자.

<롬복 사용 전>
``` java
public class Lombok {
    String name;
    int age;

    public Lombok(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Lombok{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        Lombok lombok = new Lombok("Kim", 24);
        System.out.println("name = " + lombok.getName());
        System.out.println("age = " + lombok.getAge());
        System.out.println("lombok = " + lombok.toString());
    }
}
```
-------------
<롬복 사용> 
``` java
import lombok.*;

//@Getter
//@Setter
//@ToString
@Data
@AllArgsConstructor
public class Lombok {
    String name;
    int age;

    public static void main(String[] args) {
        Lombok lombok = new Lombok("Kim", 24);
        System.out.println("name = " + lombok.getName());
        System.out.println("age = " + lombok.getAge());
        System.out.println("lombok = " + lombok.toString());
    }
}
```
코드가 확연하게 줄어든것을 확인 할 수 있다.
위의 어노테이션도 @Data를 사용하면 두줄로 표현 가능하다.
