package util;

import enums.Language;
import java.util.HashMap;
import java.util.Map;

public class Translator {

    private static Map<String, Map<Language, String>> dict = new HashMap<>();

    static {
        add("welcome", "Welcome", "Қош келдіңіз", "Добро пожаловать");
        add("login", "Login", "Кіру", "Войти");
        add("logout", "Logout", "Шығу", "Выйти");
        email_password();
        menu_items();
        actions();
    }

    private static void email_password() {
        add("email", "Email", "Электрондық пошта", "Эл. почта");
        add("password", "Password", "Құпия сөз", "Пароль");
        add("login_failed", "Login failed", "Кіру сәтсіз", "Ошибка входа");
    }

    private static void menu_items() {
        add("main_menu", "MAIN MENU", "БАСТЫ МӘЗІР", "ГЛАВНОЕ МЕНЮ");
        add("inbox", "Inbox", "Кіріс хабарлар", "Входящие");
        add("news", "News", "Жаңалықтар", "Новости");
        add("save_exit", "Save & exit", "Сақтау және шығу", "Сохранить и выйти");
        add("switch_lang", "Switch language", "Тілді ауыстыру", "Сменить язык");
    }

    private static void actions() {
        add("invalid", "Invalid", "Жарамсыз", "Неверно");
        add("no_courses", "No courses", "Курстар жоқ", "Нет курсов");
        add("choose", "Choose", "Таңдаңыз", "Выберите");
    }

    private static void add(String key, String en, String kz, String ru) {
        Map<Language, String> m = new HashMap<>();
        m.put(Language.EN, en);
        m.put(Language.KZ, kz);
        m.put(Language.RU, ru);
        dict.put(key, m);
    }

    public static String t(String key, Language lang) {
        Map<Language, String> m = dict.get(key);
        if (m == null) return key;
        return m.getOrDefault(lang, m.get(Language.EN));
    }
}
