/* Создание таблиц */

DROP TABLE IF EXISTS tz_items;
DROP SEQUENCE IF EXISTS tz_items_id_seq;

CREATE TABLE tz_items (
    id SERIAL PRIMARY KEY,
    name TEXT,
    description TEXT,
    created DATE DEFAULT current_date
);