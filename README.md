Шаг 1. Спроектировать базу данных 
Установлена база  PostgreSQL. Создана одна таблица, которая хранит ID пользователя и текущий баланс пользователя. (База запущена на Docker)
С помощью Spring Boot организовано подключение к БД 
Создан контроллер который реализует 3-и метода getBalance, putMoneу, takeMoney вывод результата в Json.
getBalance Возвращает целое число
пример запроса:
метод GET
http://localhost:8080/getBalance/{id}

id целое положительное число от 1 - 2147483648

Вариант успешного ответа:
Баланс абонента: int

Вариант неуспешного ответа:
Ошибка -1 {Описание ошибки}


метод putMoneу:
POST
http://localhost:8080/putMoney

body
{
    "id":1,
    "balance":500
}

id целое положительное число от 1 - 2147483648
balance: целое положительное число от 1 - 2147483648

Вариант неуспешного ответа:
Ошибка -1 {Описание ошибки}

метод takeMoney:
POST
http://localhost:8080/takeMoney

body
{
    "id":1,
    "balance":500
}

id целое положительное число от 1 - 2147483648
balance: целое положительное число от 1 - 2147483648


![image](https://user-images.githubusercontent.com/33143840/167897656-e57c6a45-14a2-437d-969a-dd6b4d2490fb.png)

_____________________________________________________________
Этап 2
Создана таблица Operations в которой поле subscriber_id связано 
с таблицой subscribers, полем id
поле date заполняется датой добавления записи в таблицу автоматически.
type_operation, subscriber_id, sum_operation заполняется из запроса в Java

В контроллере добавлен метод который добавляет запись в новую таблицу
по каждой операции.

добавлен метод GetOperations
вида GET http://localhost:8081/getOperations/{id}/date&dateFrom=yyyy.mm.dd&dateTo=yyyy.mm.dd

где id = id пользователя
dateFrom, dateTo дата выборки

ToDo
доработать метод с незаполненными датами.
Восстановить БД, на новом ПК    
