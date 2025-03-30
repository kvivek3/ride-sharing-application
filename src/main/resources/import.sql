INSERT INTO users (id, username, password) VALUES (1, 'admin', '$2b$12$Flpt6lKeCxwpXPVdVA73R.8Co/pwncNgFHd3Su2bLE29zR/gFc9Q6');
INSERT INTO users (id, username, password) VALUES (2, 'driver1', '$2a$10$zR2V0W8z/Ng6yUqXZ5u0p.EcHztM7xvR6lTIt6le8K/mL9eVXGAUe');
INSERT INTO users (id, username, password) VALUES (3, 'rider1', '$2a$10$dsF3T8mQOvPfA0PQUzJFeul6kUK6L2DPVZ3B8Ttk1jFPE2sLdvyUi');
INSERT INTO users_roles (users_id, roles) VALUES (1, 'ADMIN');
INSERT INTO users_roles (users_id, roles) VALUES (2, 'DRIVER');
INSERT INTO users_roles (users_id, roles) VALUES (3, 'RIDER');
