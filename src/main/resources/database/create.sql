/* Создание таблиц */

DROP TABLE IF EXISTS tz_items;

CREATE TABLE tz_items (
    id SERIAL PRIMARY KEY,
    name TEXT,
    created DATE DEFAULT current_date;
);