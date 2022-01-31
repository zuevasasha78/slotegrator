Тестовый проект для slotegrator.

Для запуска тестов на api в директории проекта нужно выполнить команду  
**gradle :apiTest:test**   
Отчет генерируется в папку apiTest/build/allure-results. Для просмотра необходимо чтобы был установлен allure server. Запускается командой allure serve путь_до_папки_с_отчетом

Для запуска тестов на Web на компьютере **должен был установлен Docker** для запуска браузера.
Для запуска тестов на Web в директории проекта нужно выполнить команду   
**gradle :webTest:cucumber**
Отчет можно посмотреть здесь slotegrator/webTest/build/reports/allure-report/index.html