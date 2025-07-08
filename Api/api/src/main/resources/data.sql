INSERT IGNORE INTO usuario (id, login, senha, role)
VALUES (
    1,
    'admin',
    '$2a$10$9hN.A6n0E1ZwQwOAGvBltOqNEPyA/nMCxpnYz9RZ2Gd5J3lCnR6MS', -- senha: admin123
    'ROLE_ADMIN'
);