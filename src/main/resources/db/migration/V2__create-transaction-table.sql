CREATE TYPE transaction_type AS ENUM ('entry', 'expense');

CREATE TABLE transactions(
    id SERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    value DECIMAL(10,2) NOT NULL,
    date DATE NOT NULL,
    description VARCHAR(200) NOT NULL,
    category VARCHAR(100) NOT NULL,
    month_reference DATE NOT NULL,
    type transaction_type NOT NULL,
    user_id INTEGER NOT NULL REFERENCES users(id)
);

