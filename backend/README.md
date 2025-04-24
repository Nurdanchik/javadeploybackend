🔥 Spring Boot + Spring Security + JWT + PostgreSQL + React 🔥

📝 Описание

Этот проект представляет собой полное приложение на основе Spring Boot (бэкэнд) и React (фронтэнд), включающее:
•	Аутентификацию и авторизацию на основе JWT (JSON Web Token)
•	Хранение данных в базе данных PostgreSQL
•	Простое и гибкое управление проектами с использованием CRUD-операций

⸻

🗃️ Структура проекта

project-root
├── backend (внутри фронтенд)



⸻

💡 Подготовка к запуску

🔧 Вытаскиваем фронт и бэк из папки

Рекомендуется разделить папку с бэкендом и фронтендом для удобства разработки.
Сделайте две отдельные папки:

my-app (удалите)
├── backend(внутри есть и фронтенд)



⸻

💻 Настройка бэкенда (Spring Boot)

🔗 Зависимости

Проект построен с использованием следующих технологий:
•	Spring Boot 3.1.0
•	Spring Security
•	JWT (JSON Web Token)
•	PostgreSQL
•	Lombok
•	Maven

⚙️ Настройка базы данных PostgreSQL

В файле application.properties, находящемся по пути:

src/main/resources/application.properties

Укажите свои параметры подключения к базе данных:

spring.datasource.url=jdbc:postgresql://localhost:5432/mydatabase
spring.datasource.username=myuser
spring.datasource.password=mypassword

spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect

# JWT настройки
spring.security.jwt.secret=your-256-bit-secret
spring.security.jwt.expiration=86400000

🛠️ Сборка и запуск

1. Установите зависимости и соберите проект:

./mvnw clean install

2. Запуск проекта:

./mvnw spring-boot:run



⸻

🌐 Настройка фронтенда (React)

📂 Установка зависимостей

Перейдите в папку с фронтендом и выполните:

npm install

🚀 Запуск приложения:

npm start



⸻

🔥 Использование
1.	Перейдите по адресу:

http://localhost:3000


	2.	Зарегистрируйтесь или войдите в систему.
	3.	Управляйте проектами с помощью CRUD-интерфейса.

⸻

🚀 Разработка

Рекомендуется запускать бэкэнд и фронтэнд в отдельных терминалах, чтобы было удобно следить за логами и обновлениями.

⸻

📝 Дополнительно
•	Не забудьте настроить CORS для авторизации в бэкенде:

http.cors().and().csrf().disable();


	•	Настройте переменные окружения на продакшн-сервере.

⸻

🗑️ Очистка кэша Maven (в случае проблем)

./mvnw clean
./mvnw dependency:purge-local-repository



⸻

💬 Вопросы и поддержка

Если у вас возникли проблемы или вопросы, обращайтесь в раздел Issues на GitHub.

⸻

💪 Успехов в разработке!