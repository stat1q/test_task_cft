## Инструкция по запуску (Windows, Linux, MacOS)

### Важно! 
Перед запуском должны быть установлены:
- Java JDK 17
- Gradle 7.6 (не ниже 7.3)

Запуск из терминала:
1. Клонируем репозиторий:  
   `git clone https://github.com/stat1q/test_task_cft.git`
2. Заходим в папку с проектом:  
   `cd test_task_cft`
3. Собираем проект с помощью Gradle:  
    `gradle build`
4. Запускаем программу:
   ```shell
   Примечание:
   Входные файлы должны лежать в директории test_task_cft\InputFiles.
   Выходной файл должен лежать в директории test_task_cft\OutputFiles.
   Параметры программы задаются при запуске через аргументы командной строки, по порядку:
   1. режим сортировки (-a или -d), необязательный, по умолчанию сортируем по возрастанию;
   2. тип данных (-s или -i), обязательный;
   3. имя выходного файла, обязательное;
   4. остальные параметры – имена входных файлов, не менее одного.
   ```
   Примеры запуска:  
   `java -jar build/libs/test_task_cft-1.0-SNAPSHOT.jar -a -s out.txt in1.txt in2.txt in3.txt in4.txt`  
   `java -jar build/libs/test_task_cft-1.0-SNAPSHOT.jar -i out in1.txt in2.txt in3.txt`