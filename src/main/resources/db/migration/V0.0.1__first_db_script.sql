CREATE TABLE IF NOT EXISTS admins(
    id SERIAL PRIMARY KEY,
    email TEXT NOT NULL UNIQUE,
    name TEXT NOT NULL,
    surname TEXT NOT NULL,
    password TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS users(
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    surname TEXT NOT NULL,
    phone TEXT NOT NULL UNIQUE,
    email TEXT NOT NULL UNIQUE,
    address TEXT NOT NULL,
    verification BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS transporters(
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    surname TEXT NOT NULL,
    phone TEXT NOT NULL UNIQUE,
    email TEXT NOT NULL UNIQUE,
    address TEXT NOT NULL,
    car_licence BYTEA NOT NULL,
    car_details TEXT,
    unit_price DECIMAL NOT NULL,
    verification BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS ratings(
    id SERIAL PRIMARY KEY,
    score SMALLINT NOT NULL CHECK (score>=0 AND score<=10),
    comment TEXT,
    commenter_id INTEGER NOT NULL,
    commented_id INTEGER NOT NULL,
    CONSTRAINT fk_users FOREIGN KEY(commenter_id) REFERENCES users(id),
    CONSTRAINT fk_transporters FOREIGN KEY(commented_id) REFERENCES transporters(id)
);

CREATE TABLE IF NOT EXISTS publications(
    id SERIAL PRIMARY KEY,
    from_addr TEXT NOT NULL,
    to_addr TEXT NOT NULL,
    create_date DATE NOT NULL,
    cargo_type TEXT NOT NULL,
    total_price DECIMAL NOT NULL,
    transported_date DATE,
    user_id INTEGER NOT NULL,
    transporter_id INTEGER,
    CONSTRAINT fk_users FOREIGN KEY(user_id) REFERENCES users(id),
    CONSTRAINT fk_transporters FOREIGN KEY(transporter_id) REFERENCES transporters(id)
);