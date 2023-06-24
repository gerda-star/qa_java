# qa_java
QA Java Project
## Оаписание

В проекте используется:
* Java 11
* maven 3.8.1
* junit 4.13.2
* mockito 3.12.4
* jacoco 0.8.7

## Запустить тесты проекта:
#### Все тесты
```mvn clean test ```

#### Запустить тесты Feline:
```mvn clean test -Dtest=FelineTest```

#### Запустить тесты Cat:
```mvn clean test -Dtest=CatTest```

#### Запустить тесты Lion:
```mvn clean -Dtest=LionPositiveTest,LionNegativeTest,LionParameterizedTest test```

