Установка/Настройка/Создание GWT-приложения
===========================================
1. `нужен инструмент Google Web Toolkit (GWT)`: [http://olex.openlogic.com/packages/gwt/2.7.0](http://olex.openlogic.com/packages/gwt/2.7.0) ( [http://www.gwtproject.org/download.html](http://www.gwtproject.org/download.html) )
   Скачали и распаковали его...
   Первоначально можно создать (Java Enterprice) 'Google Web Toolkit' непустое приложение типа 'Hello World'. При этом нужно указать где лежит библиотека gwt/2.7.0
   IDE сгенерит нам такое демо-приложение...
2. Дальше можно настроить порт на которм будет запускаться это GWT-приложение [http://stackoverflow.com/questions/19093363/how-to-add-program-arguments-in-to-intellij-idea-gwt-project](http://stackoverflow.com/questions/19093363/how-to-add-program-arguments-in-to-intellij-idea-gwt-project):
   В 'GWT Configuration', в поле 'Dev Mode parameters' прописать '-port 8889'
3. Такое GWT-приложения имеет клиентскую и серверную часть.
   С помощью инструмента Google Web Toolkit (GWT) из Java-кода автоматом генерится JavaScript (именно) для клиентской части.
   Обмен данными между клиентом и сервером происходит через объекты 'SOAP сервисы'.
   Поэтому существует конфигурационный документ-описания формы взаимодействия между клиентом и сервером - 'MyApplication...gwt.xml' - именно этим файлом запускается это GWT-приложение.
4. GWT-приложение деплоится/разворачивается и запускется также как и обычное Web-приложение - на сервере приожений (например: Tomcat).
   Но (в помощь) для удобства разрабочиков, инструмент 'Google App Engine SDK' имеет локальный сервер приложений 'Jetty'. Его ( [appengine-java-sdk-1.9.26.zip](https://storage.googleapis.com/appengine-sdks/featured/appengine-java-sdk-1.9.26.zip) ) можно скачать на [https://cloud.google.com/appengine/downloads?csw=1](https://cloud.google.com/appengine/downloads?csw=1)
   или же через инструмент 'maven' [http://mvnrepository.com/artifact/com.google.appengine/appengine-java-sdk/1.9.18](http://mvnrepository.com/artifact/com.google.appengine/appengine-java-sdk/1.9.18)
5. Здесь его базовые конфигурационный настройки:
   appengine-java-sdk-1.9.26/lib/jetty-base-sdk/
   appengine-java-sdk-1.9.26/lib/java-managed-vm/appengine-java-vmruntime/etc/jetty-http.xml >> '<Set name="port"><Property name="jetty.port" default="8080" /></Set>'
   Можно настроить порт на которм будет запускаться сервер приложений 'Jetty'. В 'Google AppEngine Dev Server', в поле 'Port' прописать '8082'
   По дефолту доступ к веб-админке этого сервера приложений 'Jetty': [http://localhost:8082/_ah/admin](http://localhost:8082/_ah/admin)
6. Запускаем это GWT-приложение.
   Оно будет заущено на локальном хосте ('Jetty') который мы предварительно настроили:
   В 'GWT Configuration', в поле 'Start page' прописать 'MySampleApplication2.html'
   (например: [http://127.0.0.1:8889/MySampleApplication2.html](http://127.0.0.1:8889/MySampleApplication2.html))
   
7. Как и любой друной сервлет (серверная часть веб-приложения), в GWT-приложении настраивается карта для сервлета/сервиса в 'web/WEB-INF/web.xml'.
   Собственно именно таким способом сервер пиложений и запускает сервлет/сервис GWT-приложения.
8. Но остальной механизм связки между клиентской и серверной частью веб-приложения генериться автоматом используя инструмент Google Web Toolkit (GWT):
   Для клиентской веб-страницы 'MyApplication...html' генериться JavaScript 'MyApplication...nocache.js', внутри которго лежит сконфигурированный AJAX для доступа к нашему веб-сервису (тот что прописан в карте для сервлета/сервиса в 'web/WEB-INF/web.xml')

Копирование simple (простого) GWT-проекта в (IDE) 'Intellij Idea'
=================================================================
0. Есть старый-рабочий проект: который имеет название 'MySampleApplication2' и определен рабочий пакет 'com.sample'
1. Создаем новый проект с нужным-новым названием в (IDE) 'Intellij Idea':
   File >> New Project
   >> Java Enterprise >> Google Web Toolkit (здесь ставим галочку) >> GWT SDK (path to GWT installation directory) >> Create sample application (здесь ставим галочку и вставляем/копируем старый-рабочий пакет: 'com.sample') >> Next
   >> Project name (название нового проекта 'MySampleApplication3') >> Project location (Select project file directory) >> Finish
2. Заменяем: теперь из-нутри ново-созданного проекта удаляем все исходники (кроме системных) И копируем сюда исходники со старого проекта (MySampleApplication2)
3. Заходим и правим в:
   Project Structure >> Project
   Project Structure >> Modules
   Project Structure >> Facets
4. Теперь заходим и правим в:
   Edit Confifurations >> GWT Confifuration

Клонирование simple (простого) GWT-проекта в (IDE) 'Intellij Idea' через 'GitHub'
=================================================================================
0. Исходники проекта уже находяться на 'GitHub' (в системе контроля версий: https://github.com/Home-GWT/MySampleApplication3.git) и имеет нужное название-проекта
1. Любыми средствами скачиваем этот проект в рабочую папку (получаем папку с исходниками проекта с уже правильным наименованием)
1.1. Если проект был скачан средствами (IDE) 'Intellij Idea' - тогда нужно: закрыть (IDE) 'Intellij Idea', зайти во внутрь этого проекта и удалить все системные файлы (оставить только исходники этого проекта, включая git-файлы)
2. Далее создаем новый (простой) GWT-проект с нужным-новым названием в (IDE) 'Intellij Idea':
   File >> New Project
   >> Java Enterprise >> Google Web Toolkit (здесь ставим галочку) >> GWT SDK (path to GWT installation directory) >> Create sample application (здесь ставим галочку и вставляем/копируем старый-рабочий пакет: 'com.sample') >> Next
   >> Project name (дублируем название нового проекта 'MySampleApplication3') >> Project location (Select project file directory) >> Finish >> New Project (и здесь главное ничего невыбирать..., просто закрываем-крестиком диалоговое окно)
2.1 Желательно чтобы последний проект, который открытый в (IDE) 'Intellij Idea', лежал-паралельно в той-же самой рабочей папке (тогда все пройдет гладко...)
3. Заменяем: теперь из-нутри ново-созданного проекта удаляем все исходники (кроме системных) И копируем сюда исходники со старого проекта (MySampleApplication2)
4. Заходим и правим в:
   Project Structure >> Project
   Project Structure >> Modules
   Project Structure >> Facets
5. Теперь заходим и правим в:
   Edit Confifurations >> GWT Confifuration


Установка (загрузка) GWT-модуля
===============================
* `Рабочай папка (1) GWT-компилятора`: /tmp/gwt-codeserver-6217901612642979489.tmp/com.sample.App/compile-1/war/Sample
* `профиль (1) GWT-модуля`: Sample.nocache.js


Установка (загрузка) GWT-модуля + Bootstrapping
===============================================
* `Рабочай папка (2) GWT-компилятора`: /tmp/gwt-codeserver-2804398483412014869.tmp/com.sample.App2/compile-2/war/Sample2
* `компиляция GWT-компилятором Java-кода в JavaScript-функции`: 89DF4A352C505EE9C849D17EB7913B5B.cache.js
* `компиляция GWT-компилятором callback(s)-класса в объекты данных для обмена между клиентом и сервером`: 57F32DF37F1C61755A24B87D7E9E66C3.gwt.rpc
* `ининициализация профиля (2) GWT-модуля (в режиме 'Web Mode')`: Sample2.nocache.js
* `ининициализация профиля (2) GWT-модуля в режиме 'Hosted Mode'`: Sample2.devmode.js


Создаем проект средствами мавена
================================
1. Создаем / Генерим проект с нуля средствами мавена ( [https://antonkirillov.wordpress.com/2011/03/22/creating-and-running-gwt-project-using-maven-and-intellij-idea-10/](https://antonkirillov.wordpress.com/2011/03/22/creating-and-running-gwt-project-using-maven-and-intellij-idea-10/) ):
   mvn -DarchetypeGroupId=org.codehaus.mojo -DarchetypeArtifactId=gwt-maven-plugin -DarchetypeVersion=2.2.0 -DgroupId=ru.scrumdev.sample -DartifactId=sample -Dversion=1.0 org.apache.maven.plugins:maven-archetype-plugin:generate
2. Результатом выполненения мавена получим:
[INFO] Using property: groupId = ru.scrumdev.sample
[INFO] Using property: artifactId = sample
[INFO] Using property: version = 1.0
[INFO] Using property: package = ru.scrumdev.sample
Define value for property 'module': : 
3. Вводим имя проекта: 'SampleApplication'
   Дальше мавен сгенерит дефолтный проект...
4. Настраиваем в IDE 'GWT configuration':
   Поле 'module' >> 'sample'
   Поле 'VM parameters' >> '-Xmx256m'
   остальные поля можно оставить по дефолту...
5. Запускаем проект средствами 'GWT Development Mode' [http://kiahu.com/tutorial/working-with-gwt-maven-and-intellij-idea/](http://kiahu.com/tutorial/working-with-gwt-maven-and-intellij-idea/)
   'gwt:i18n'
   'gwt:run'
6. Запуститься консоль 'Run Maven Build'
   Кнопка 'Copy to Clipboard' >> генерит/выводит URL-адресс под которым проект можно запустить в веб-браузере [http://127.0.0.1:8888/SampleApplication.html](http://127.0.0.1:8888/SampleApplication.html)
   И вводим URL-адресс проекта в веб-браузере...
